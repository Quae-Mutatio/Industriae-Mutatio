package dev.quae.mods.industriae.helper;

import dev.quae.mods.industriae.data.recipe.IMCustomMachineRecipeBuilder;
import dev.quae.mods.industriae.setup.IMTiles;
import dev.quae.mods.industriae.tileentity.IMTieredProcessingMachineTileEntity;
import dev.quae.mods.industriae.tileentity.SpeedTier;
import net.minecraft.tileentity.TileEntityType;

public class TileEntityTypeResolver {

  public static TileEntityType<?> resolveMacerator(SpeedTier tier) {
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

  public static TileEntityType<?> resolveWireMill(SpeedTier tier) {
    switch (tier) {
      case MV:
        return IMTiles.MV_WIREMILL.get();
      case HV:
        return IMTiles.HV_WIREMILL.get();
      case EV:
        return IMTiles.EV_WIREMILL.get();
      case IV:
        return IMTiles.IV_WIREMILL.get();
      case LUV:
        return IMTiles.LUV_WIREMILL.get();
      case ZPM:
        return IMTiles.ZPM_WIREMILL.get();
      case UV:
        return IMTiles.UV_WIREMILL.get();
      case MAX:
        return IMTiles.MAX_WIREMILL.get();
      default:
        return IMTiles.LV_WIREMILL.get();
    }
  }

  public static TileEntityType<?> resolveUnPackager(SpeedTier tier) {
    switch (tier) {
      case MV:
        return IMTiles.MV_UNPACKAGER.get();
      case HV:
        return IMTiles.HV_UNPACKAGER.get();
      case EV:
        return IMTiles.EV_UNPACKAGER.get();
      case IV:
        return IMTiles.IV_UNPACKAGER.get();
      case LUV:
        return IMTiles.LUV_UNPACKAGER.get();
      case ZPM:
        return IMTiles.ZPM_UNPACKAGER.get();
      case UV:
        return IMTiles.UV_UNPACKAGER.get();
      case MAX:
        return IMTiles.MAX_UNPACKAGER.get();
      default:
        return IMTiles.LV_UNPACKAGER.get();
    }
  }

  public static TileEntityType<?> resolvePackager(SpeedTier tier) {
    switch (tier) {
      case MV:
        return IMTiles.MV_PACKAGER.get();
      case HV:
        return IMTiles.HV_PACKAGER.get();
      case EV:
        return IMTiles.EV_PACKAGER.get();
      case IV:
        return IMTiles.IV_PACKAGER.get();
      case LUV:
        return IMTiles.LUV_PACKAGER.get();
      case ZPM:
        return IMTiles.ZPM_PACKAGER.get();
      case UV:
        return IMTiles.UV_PACKAGER.get();
      case MAX:
        return IMTiles.MAX_PACKAGER.get();
      default:
        return IMTiles.LV_PACKAGER.get();
    }
  }

  public static TileEntityType<?> resolveThermalCentrifuge(SpeedTier tier) {
    switch (tier) {
      case MV:
        return IMTiles.MV_THERMAL_CENTRIFUGE.get();
      case HV:
        return IMTiles.HV_THERMAL_CENTRIFUGE.get();
      case EV:
        return IMTiles.EV_THERMAL_CENTRIFUGE.get();
      case IV:
        return IMTiles.IV_THERMAL_CENTRIFUGE.get();
      case LUV:
        return IMTiles.LUV_THERMAL_CENTRIFUGE.get();
      case ZPM:
        return IMTiles.ZPM_THERMAL_CENTRIFUGE.get();
      case UV:
        return IMTiles.UV_THERMAL_CENTRIFUGE.get();
      case MAX:
        return IMTiles.MAX_THERMAL_CENTRIFUGE.get();
      default:
        return IMTiles.LV_THERMAL_CENTRIFUGE.get();
    }

  }
}
