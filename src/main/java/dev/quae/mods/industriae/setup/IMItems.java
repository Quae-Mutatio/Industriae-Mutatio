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

  public static final RegistryObject<Item> LV_FORGE_HAMMER = ITEMS.register("lv_forge_hammer", () -> new IMBlockItem(IMBlocks.LV_FORGE_HAMMER, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> MV_FORGE_HAMMER = ITEMS.register("mv_forge_hammer", () -> new IMBlockItem(IMBlocks.MV_FORGE_HAMMER, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> HV_FORGE_HAMMER = ITEMS.register("hv_forge_hammer", () -> new IMBlockItem(IMBlocks.HV_FORGE_HAMMER, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> EV_FORGE_HAMMER = ITEMS.register("ev_forge_hammer", () -> new IMBlockItem(IMBlocks.EV_FORGE_HAMMER, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> IV_FORGE_HAMMER = ITEMS.register("iv_forge_hammer", () -> new IMBlockItem(IMBlocks.IV_FORGE_HAMMER, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> LUV_FORGE_HAMMER = ITEMS.register("luv_forge_hammer", () -> new IMBlockItem(IMBlocks.LUV_FORGE_HAMMER, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> ZPM_FORGE_HAMMER = ITEMS.register("zpm_forge_hammer", () -> new IMBlockItem(IMBlocks.ZPM_FORGE_HAMMER, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> UV_FORGE_HAMMER = ITEMS.register("uv_forge_hammer", () -> new IMBlockItem(IMBlocks.UV_FORGE_HAMMER, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> MAX_FORGE_HAMMER = ITEMS.register("max_forge_hammer", () -> new IMBlockItem(IMBlocks.MAX_FORGE_HAMMER, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));

  public static final RegistryObject<Item> LV_ALLOY_SMELTER = ITEMS.register("lv_alloy_smelter", () -> new IMBlockItem(IMBlocks.LV_ALLOY_SMELTER, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> MV_ALLOY_SMELTER = ITEMS.register("mv_alloy_smelter", () -> new IMBlockItem(IMBlocks.MV_ALLOY_SMELTER, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> HV_ALLOY_SMELTER = ITEMS.register("hv_alloy_smelter", () -> new IMBlockItem(IMBlocks.HV_ALLOY_SMELTER, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> EV_ALLOY_SMELTER = ITEMS.register("ev_alloy_smelter", () -> new IMBlockItem(IMBlocks.EV_ALLOY_SMELTER, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> IV_ALLOY_SMELTER = ITEMS.register("iv_alloy_smelter", () -> new IMBlockItem(IMBlocks.IV_ALLOY_SMELTER, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> LUV_ALLOY_SMELTER = ITEMS.register("luv_alloy_smelter", () -> new IMBlockItem(IMBlocks.LUV_ALLOY_SMELTER, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> ZPM_ALLOY_SMELTER = ITEMS.register("zpm_alloy_smelter", () -> new IMBlockItem(IMBlocks.ZPM_ALLOY_SMELTER, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> UV_ALLOY_SMELTER = ITEMS.register("uv_alloy_smelter", () -> new IMBlockItem(IMBlocks.UV_ALLOY_SMELTER, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> MAX_ALLOY_SMELTER = ITEMS.register("max_alloy_smelter", () -> new IMBlockItem(IMBlocks.MAX_ALLOY_SMELTER, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));

  // Crafting Items
  public static final RegistryObject<Item> WOOD_PULP = ITEMS.register("wood_pulp", IMCraftingItem::new);
}
