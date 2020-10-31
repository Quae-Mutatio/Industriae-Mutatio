package dev.quae.mods.industriae.setup;

import dev.quae.mods.industriae.IndustriaeMutatio;
import dev.quae.mods.industriae.block.OreBlock;
import dev.quae.mods.industriae.material.Ore;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import dev.quae.mods.industriae.item.IMBlockItem;
import dev.quae.mods.industriae.item.IMCraftingItem;
import dev.quae.mods.industriae.machine.MachineType;
import dev.quae.mods.industriae.storage.FluidTankType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class IMItems {
  
  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, IndustriaeMutatio.ID);

  static {
    for (Ore ore : Ore.values()) {
      ore.setOreItem(registerOre(ore, ore.getOreBlock()));
    }
    
    for (MachineType value : MachineType.values()) {
      value.createItems();
    }

    for (FluidTankType value : FluidTankType.values()) {
      value.createItem();
    }
  }

  private static RegistryObject<BlockItem> registerOre(Ore ore, RegistryObject<OreBlock> blockObj) {
    return ITEMS.register(ore.getName(), blockObj.lazyMap(b -> new BlockItem(b, create())));
  }

  private static Properties create() {
    return new Item.Properties();
  }

  // Crafting Items
  public static final RegistryObject<Item> WOOD_PULP = ITEMS.register("wood_pulp", IMCraftingItem::new);

  // Misc Block Items
  public static final RegistryObject<Item> INFINITE_WATER_SOURCE = ITEMS.register("infinite_water_source", () -> new IMBlockItem(IMBlocks.INFINITE_WATER_SOURCE, new Item.Properties().group(IndustriaeMutatio.CRAFTING_ITEMS_TAB)));
}
