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

}
