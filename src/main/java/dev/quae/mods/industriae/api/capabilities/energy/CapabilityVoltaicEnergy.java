package dev.quae.mods.industriae.api.capabilities.energy;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.energy.CapabilityEnergy;

public class CapabilityVoltaicEnergy {

  private static final int DEFAULT_STORAGE_CAPACITY = 1000;

  @CapabilityInject(IVoltaicEnergyStorage.class)
  public static Capability<IVoltaicEnergyStorage> ENERGY = null;

  public static void register() {
    CapabilityManager.INSTANCE.register(IVoltaicEnergyStorage.class, new IStorage<IVoltaicEnergyStorage>() {
          @Override
          public INBT writeNBT(Capability<IVoltaicEnergyStorage> capability, IVoltaicEnergyStorage instance, Direction side) {
            CompoundNBT nbt = new CompoundNBT();
            nbt.putInt("voltage", instance.getVoltage().ordinal());
            nbt.putInt("energy", instance.getEnergyStored());
            return nbt;
          }

          @Override
          public void readNBT(Capability<IVoltaicEnergyStorage> capability, IVoltaicEnergyStorage instance, Direction side, INBT nbt) {
            if (!(instance instanceof VoltaicEnergyStorage)) {
              throw new IllegalArgumentException("Can not deserialize to an instance that isn't the default implementation");
            }
            CompoundNBT compoundNBT = (CompoundNBT) nbt;
            VoltaicEnergyStorage instanceV = (VoltaicEnergyStorage) instance;
            instanceV.setVoltage(Voltage.values()[compoundNBT.getInt("voltage")]);
            instanceV.setEnergyStored(compoundNBT.getInt("energy"));
          }
        },
        () -> new VoltaicEnergyStorage(Voltage.ULTRA_LOW, DEFAULT_STORAGE_CAPACITY)
    );
  }
}