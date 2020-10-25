package dev.quae.mods.industriae.setup;

import dev.quae.mods.industriae.IndustriaeMutatio;
import dev.quae.mods.industriae.block.AlloySmelterBlock;
import dev.quae.mods.industriae.block.ForgeHammerBlock;
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

  public static final RegistryObject<Block> LV_FORGE_HAMMER = BLOCKS.register("lv_forge_hammer", () -> new ForgeHammerBlock(SpeedTier.LV));
  public static final RegistryObject<Block> MV_FORGE_HAMMER = BLOCKS.register("mv_forge_hammer", () -> new ForgeHammerBlock(SpeedTier.MV));
  public static final RegistryObject<Block> HV_FORGE_HAMMER = BLOCKS.register("hv_forge_hammer", () -> new ForgeHammerBlock(SpeedTier.HV));
  public static final RegistryObject<Block> EV_FORGE_HAMMER = BLOCKS.register("ev_forge_hammer", () -> new ForgeHammerBlock(SpeedTier.EV));
  public static final RegistryObject<Block> IV_FORGE_HAMMER = BLOCKS.register("iv_forge_hammer", () -> new ForgeHammerBlock(SpeedTier.IV));
  public static final RegistryObject<Block> LUV_FORGE_HAMMER = BLOCKS.register("luv_forge_hammer", () -> new ForgeHammerBlock(SpeedTier.LUV));
  public static final RegistryObject<Block> ZPM_FORGE_HAMMER = BLOCKS.register("zpm_forge_hammer", () -> new ForgeHammerBlock(SpeedTier.ZPM));
  public static final RegistryObject<Block> UV_FORGE_HAMMER = BLOCKS.register("uv_forge_hammer", () -> new ForgeHammerBlock(SpeedTier.UV));
  public static final RegistryObject<Block> MAX_FORGE_HAMMER = BLOCKS.register("max_forge_hammer", () -> new ForgeHammerBlock(SpeedTier.MAX));

  public static final RegistryObject<Block> LV_ALLOY_SMELTER = BLOCKS.register("lv_alloy_smelter", () -> new AlloySmelterBlock(SpeedTier.LV));
  public static final RegistryObject<Block> MV_ALLOY_SMELTER = BLOCKS.register("mv_alloy_smelter", () -> new AlloySmelterBlock(SpeedTier.MV));
  public static final RegistryObject<Block> HV_ALLOY_SMELTER = BLOCKS.register("hv_alloy_smelter", () -> new AlloySmelterBlock(SpeedTier.HV));
  public static final RegistryObject<Block> EV_ALLOY_SMELTER = BLOCKS.register("ev_alloy_smelter", () -> new AlloySmelterBlock(SpeedTier.EV));
  public static final RegistryObject<Block> IV_ALLOY_SMELTER = BLOCKS.register("iv_alloy_smelter", () -> new AlloySmelterBlock(SpeedTier.IV));
  public static final RegistryObject<Block> LUV_ALLOY_SMELTER = BLOCKS.register("luv_alloy_smelter", () -> new AlloySmelterBlock(SpeedTier.LUV));
  public static final RegistryObject<Block> ZPM_ALLOY_SMELTER = BLOCKS.register("zpm_alloy_smelter", () -> new AlloySmelterBlock(SpeedTier.ZPM));
  public static final RegistryObject<Block> UV_ALLOY_SMELTER = BLOCKS.register("uv_alloy_smelter", () -> new AlloySmelterBlock(SpeedTier.UV));
  public static final RegistryObject<Block> MAX_ALLOY_SMELTER = BLOCKS.register("max_alloy_smelter", () -> new AlloySmelterBlock(SpeedTier.MAX));
}
