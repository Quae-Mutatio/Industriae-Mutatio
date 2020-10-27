package dev.quae.mods.industriae.setup;

import dev.quae.mods.industriae.IndustriaeMutatio;
import dev.quae.mods.industriae.item.IMBlockItem;
import dev.quae.mods.industriae.item.IMCraftingItem;
import dev.quae.mods.industriae.machine.MachineType;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class IMItems {

  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, IndustriaeMutatio.ID);

  static {
    for (MachineType value : MachineType.values()) {
      value.createItems();
    }
  }

  // Crafting Items
  public static final RegistryObject<Item> WOOD_PULP = ITEMS.register("wood_pulp", IMCraftingItem::new);

  // Misc Block Items
  public static final RegistryObject<Item> INFINITE_WATER_SOURCE = ITEMS.register("infinite_water_source", () -> new IMBlockItem(IMBlocks.INFINITE_WATER_SOURCE, new Item.Properties().group(IndustriaeMutatio.CRAFTING_ITEMS_TAB)));
}
