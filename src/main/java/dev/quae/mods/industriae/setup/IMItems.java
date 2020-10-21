package dev.quae.mods.industriae.setup;

import dev.quae.mods.industriae.IndustriaeMutatio;
import dev.quae.mods.industriae.block.OreBlock;
import dev.quae.mods.industriae.material.IMaterialType;
import dev.quae.mods.industriae.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class IMItems {

  static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, IndustriaeMutatio.ID);

  static {
    for (Material material : Material.values()) {
      if (material.hasOre()) {
        material.setOreItem(registerOre(material, material.getOreBlock()));
      }
    }
  }

  private static RegistryObject<BlockItem> registerOre(IMaterialType type, RegistryObject<OreBlock> blockObj) {
    return ITEMS.register(type.getOreName(), blockObj.lazyMap(b -> new BlockItem(b, create())));
  }

  private static Properties create() {
    return new Item.Properties();
  }
}
