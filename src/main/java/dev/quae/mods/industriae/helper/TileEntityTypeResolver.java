package dev.quae.mods.industriae.helper;

import dev.quae.mods.industriae.setup.IMTiles;
import dev.quae.mods.industriae.tileentity.SpeedTier;
import net.minecraft.tileentity.TileEntityType;

public class TileEntityTypeResolver {
  public static TileEntityType<?> resolveMacerator(SpeedTier tier){
    switch (tier) {
      case MV:
        return IMTiles.MV_MACERATOR.get();
      case HV:
        return IMTiles.HV_MACERATOR.get();
      case EV:
        return IMTiles.EV_MACERATOR.get();
      case IV:
        return IMTiles.IV_MACERATOR.get();
      case LUV:
        return IMTiles.LuV_MACERATOR.get();
      case ZPM:
        return IMTiles.ZPM_MACERATOR.get();
      case UV:
        return IMTiles.UV_MACERATOR.get();
      case MAX:
        return IMTiles.MAX_MACERATOR.get();
      default:
        return IMTiles.LV_MACERATOR.get();
    }
  }

  public static TileEntityType<?> resolveForgeHammer(SpeedTier tier) {
    switch (tier) {
      case MV:
        return IMTiles.MV_FORGE_HAMMER.get();
      case HV:
        return IMTiles.HV_FORGE_HAMMER.get();
      case EV:
        return IMTiles.EV_FORGE_HAMMER.get();
      case IV:
        return IMTiles.IV_FORGE_HAMMER.get();
      case LUV:
        return IMTiles.LuV_FORGE_HAMMER.get();
      case ZPM:
        return IMTiles.ZPM_FORGE_HAMMER.get();
      case UV:
        return IMTiles.UV_FORGE_HAMMER.get();
      case MAX:
        return IMTiles.MAX_FORGE_HAMMER.get();
      default:
        return IMTiles.LV_FORGE_HAMMER.get();
    }
  }

  public static TileEntityType<?> resolveAlloySmelter(SpeedTier tier) {
    switch (tier) {
      case MV:
        return IMTiles.MV_ALLOY_SMELTER.get();
      case HV:
        return IMTiles.HV_ALLOY_SMELTER.get();
      case EV:
        return IMTiles.EV_ALLOY_SMELTER.get();
      case IV:
        return IMTiles.IV_ALLOY_SMELTER.get();
      case LUV:
        return IMTiles.LUV_ALLOY_SMELTER.get();
      case ZPM:
        return IMTiles.ZPM_ALLOY_SMELTER.get();
      case UV:
        return IMTiles.UV_ALLOY_SMELTER.get();
      case MAX:
        return IMTiles.MAX_ALLOY_SMELTER.get();
      default:
        return IMTiles.LV_ALLOY_SMELTER.get();
    }
  }
}
