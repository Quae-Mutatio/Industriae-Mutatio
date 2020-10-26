package dev.quae.mods.industriae.helper;

import dev.quae.mods.industriae.setup.IMTiles;
import dev.quae.mods.industriae.tileentity.IMTieredProcessingMachineTileEntity;
import dev.quae.mods.industriae.tileentity.SpeedTier;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;

public class IMTieredRegistryResolver {

  public static TileEntityType<?> resolveTile(SpeedTier tier, Map<String, RegistryObject<TileEntityType<? extends IMTieredProcessingMachineTileEntity>>> tieredTiles) {
    if (tieredTiles.containsKey(tier.getName())) {
      return tieredTiles.get(tier.getName()).get();
    }
    return null;
  }

  public static Block resolveBlock(SpeedTier tier, Map<String, RegistryObject<Block>> tieredBlocks) {
    if (tieredBlocks.containsKey(tier.getName())) {
      return tieredBlocks.get(tier.getName()).get();
    }
    return null;
  }

  public static Item resolveItem(SpeedTier tier, Map<String, RegistryObject<Item>> tieredItems) {
    if (tieredItems.containsKey(tier.getName())) {
      return tieredItems.get(tier.getName()).get();
    }
    return null;
  }
}
