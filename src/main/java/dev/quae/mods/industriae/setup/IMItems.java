package dev.quae.mods.industriae.setup;

import dev.quae.mods.industriae.IndustriaeMutatio;
import dev.quae.mods.industriae.block.OreBlock;
import dev.quae.mods.industriae.material.Ore;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class IMItems {

  static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, IndustriaeMutatio.ID);

  static {
    for (Ore ore : Ore.values()) {
      ore.setOreItem(registerOre(ore, ore.getOreBlock()));
    }
  }

  private static RegistryObject<BlockItem> registerOre(Ore ore, RegistryObject<OreBlock> blockObj) {
    return ITEMS.register(ore.getName(), blockObj.lazyMap(b -> new BlockItem(b, create())));
  }

  private static Properties create() {
    return new Item.Properties();
  }
}
