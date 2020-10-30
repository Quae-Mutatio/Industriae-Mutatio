package dev.quae.mods.industriae.data;

import dev.quae.mods.industriae.IndustriaeMutatio;
import dev.quae.mods.industriae.setup.registers.MachineType;
import dev.quae.mods.industriae.setup.registers.SpeedTier;
import dev.quae.mods.industriae.storage.FluidTankType;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class IMBlockStateProvider extends BlockStateProvider {

  public IMBlockStateProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
    super(generator, IndustriaeMutatio.ID, existingFileHelper);
  }

  protected void registerStatesAndModels() {
    for (MachineType value : MachineType.values()) {
      for (SpeedTier speedTier : SpeedTier.values()) {
        ResourceLocation front = new ResourceLocation(IndustriaeMutatio.ID, value.getRegistryName(speedTier));
        ResourceLocation sides = new ResourceLocation(IndustriaeMutatio.ID, "block/machine/" + speedTier.getName());
        this.simpleBlock(value.getBlock(speedTier), this.models().cube(value.getRegistryName(speedTier), sides, sides, sides, sides, sides, sides));
      }
    }

    for (FluidTankType value : FluidTankType.values()) {
      ResourceLocation sides = new ResourceLocation(IndustriaeMutatio.ID, "block/drum/" + value.getRegistryName());
      this.simpleBlock(value.getBlock(), this.models().cubeAll(value.getRegistryName(), sides));
    }

    for (SpeedTier value : SpeedTier.values()) {
      value.registerBlockState(this);
    }
  }
}
