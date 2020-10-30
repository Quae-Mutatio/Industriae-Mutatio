package dev.quae.mods.industriae.setup;

import dev.quae.mods.industriae.IndustriaeMutatio;
import dev.quae.mods.industriae.setup.registers.IRegistryEnum;
import dev.quae.mods.industriae.storage.FluidTankType;
import dev.quae.mods.industriae.tileentity.InfiniteWaterSourceTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.tileentity.TileEntityType.Builder;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class IMTiles {

  public static final DeferredRegister<TileEntityType<?>> TILES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, IndustriaeMutatio.ID);

  static {
    for (IRegistryEnum<?>[] arr : Registrar.REGISTRY_ENUMS) {
      for (IRegistryEnum<?> val : arr) {
        val.registerTiles(TILES);
      }
    }

    for (FluidTankType value : FluidTankType.values()) {
      value.createTileEntity();
    }
  }

  public static final RegistryObject<TileEntityType<InfiniteWaterSourceTileEntity>> INFINITE_WATER_SOURCE = TILES.register("infinite_water_source", () -> Builder.create(InfiniteWaterSourceTileEntity::new, IMBlocks.INFINITE_WATER_SOURCE.get()).build(null));


}
