package dev.quae.mods.industriae.setup;

import dev.quae.mods.industriae.IndustriaeMutatio;
import dev.quae.mods.industriae.item.IMBlockItem;
import dev.quae.mods.industriae.item.IMCraftingItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class IMItems {

  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, IndustriaeMutatio.ID);

  public static final RegistryObject<Item> LV_MACERATOR = ITEMS.register("lv_macerator", () -> new IMBlockItem(IMBlocks.LV_MACERATOR, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> WOOD_PULP = ITEMS.register("wood_pulp", IMCraftingItem::new);
}
