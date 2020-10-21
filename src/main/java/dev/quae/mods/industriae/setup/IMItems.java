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

  // Machine Block Items
  public static final RegistryObject<Item> LV_MACERATOR = ITEMS.register("lv_macerator", () -> new IMBlockItem(IMBlocks.LV_MACERATOR, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> MV_MACERATOR = ITEMS.register("mv_macerator", () -> new IMBlockItem(IMBlocks.MV_MACERATOR, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> HV_MACERATOR = ITEMS.register("hv_macerator", () -> new IMBlockItem(IMBlocks.HV_MACERATOR, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> EV_MACERATOR = ITEMS.register("ev_macerator", () -> new IMBlockItem(IMBlocks.EV_MACERATOR, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> IV_MACERATOR = ITEMS.register("iv_macerator", () -> new IMBlockItem(IMBlocks.IV_MACERATOR, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> LUV_MACERATOR = ITEMS.register("luv_macerator", () -> new IMBlockItem(IMBlocks.LUV_MACERATOR, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> ZPM_MACERATOR = ITEMS.register("zpm_macerator", () -> new IMBlockItem(IMBlocks.ZPM_MACERATOR, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> UV_MACERATOR = ITEMS.register("uv_macerator", () -> new IMBlockItem(IMBlocks.UV_MACERATOR, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> MAX_MACERATOR = ITEMS.register("max_macerator", () -> new IMBlockItem(IMBlocks.MAX_MACERATOR, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));

  // Crafting Items
  public static final RegistryObject<Item> WOOD_PULP = ITEMS.register("wood_pulp", IMCraftingItem::new);
}
