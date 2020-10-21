package dev.quae.mods.industriae.setup;

import dev.quae.mods.industriae.IndustriaeMutatio;
import dev.quae.mods.industriae.tileentity.LVMaceratorTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class IMTiles {

  public static final DeferredRegister<TileEntityType<?>> TILES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, IndustriaeMutatio.ID);

  public static final RegistryObject<TileEntityType<LVMaceratorTileEntity>> LV_MACERATOR = TILES.register("lv_macerator", () -> TileEntityType.Builder.create(LVMaceratorTileEntity::new, IMBlocks.LV_MACERATOR.get()).build(null));
}
