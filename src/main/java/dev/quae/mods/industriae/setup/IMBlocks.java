package dev.quae.mods.industriae.setup;

import dev.quae.mods.industriae.IndustriaeMutatio;
import dev.quae.mods.industriae.block.MaceratorBlock;
import dev.quae.mods.industriae.tileentity.SpeedTier;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class IMBlocks {

  public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, IndustriaeMutatio.ID);

  // Machine Blocks
  public static final RegistryObject<Block> LV_MACERATOR = BLOCKS.register("lv_macerator", () -> new MaceratorBlock(SpeedTier.LV));
  public static final RegistryObject<Block> MV_MACERATOR = BLOCKS.register("mv_macerator", () -> new MaceratorBlock(SpeedTier.MV));
  public static final RegistryObject<Block> HV_MACERATOR = BLOCKS.register("hv_macerator", () -> new MaceratorBlock(SpeedTier.HV));
  public static final RegistryObject<Block> EV_MACERATOR = BLOCKS.register("ev_macerator", () -> new MaceratorBlock(SpeedTier.EV));
  public static final RegistryObject<Block> IV_MACERATOR = BLOCKS.register("iv_macerator", () -> new MaceratorBlock(SpeedTier.IV));
  public static final RegistryObject<Block> LUV_MACERATOR = BLOCKS.register("luv_macerator", () -> new MaceratorBlock(SpeedTier.LUV));
  public static final RegistryObject<Block> ZPM_MACERATOR = BLOCKS.register("zpm_macerator", () -> new MaceratorBlock(SpeedTier.ZPM));
  public static final RegistryObject<Block> UV_MACERATOR = BLOCKS.register("uv_macerator", () -> new MaceratorBlock(SpeedTier.UV));
  public static final RegistryObject<Block> MAX_MACERATOR = BLOCKS.register("max_macerator", () -> new MaceratorBlock(SpeedTier.MAX));
}
