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

  public static final RegistryObject<Item> LV_WIREMILL = ITEMS.register("lv_wiremill", () -> new IMBlockItem(IMBlocks.LV_WIREMILL, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> MV_WIREMILL = ITEMS.register("mv_wiremill", () -> new IMBlockItem(IMBlocks.MV_WIREMILL, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> HV_WIREMILL = ITEMS.register("hv_wiremill", () -> new IMBlockItem(IMBlocks.HV_WIREMILL, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> EV_WIREMILL = ITEMS.register("ev_wiremill", () -> new IMBlockItem(IMBlocks.EV_WIREMILL, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> IV_WIREMILL = ITEMS.register("iv_wiremill", () -> new IMBlockItem(IMBlocks.IV_WIREMILL, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> LUV_WIREMILL = ITEMS.register("luv_wiremill", () -> new IMBlockItem(IMBlocks.LUV_WIREMILL, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> ZPM_WIREMILL = ITEMS.register("zpm_wiremill", () -> new IMBlockItem(IMBlocks.ZPM_WIREMILL, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> UV_WIREMILL = ITEMS.register("uv_wiremill", () -> new IMBlockItem(IMBlocks.UV_WIREMILL, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> MAX_WIREMILL = ITEMS.register("max_wiremill", () -> new IMBlockItem(IMBlocks.MAX_WIREMILL, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));

  public static final RegistryObject<Item> LV_UNPACKAGER = ITEMS.register("lv_unpackager", () -> new IMBlockItem(IMBlocks.LV_UNPACKAGER, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> MV_UNPACKAGER = ITEMS.register("mv_unpackager", () -> new IMBlockItem(IMBlocks.MV_UNPACKAGER, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> HV_UNPACKAGER = ITEMS.register("hv_unpackager", () -> new IMBlockItem(IMBlocks.HV_UNPACKAGER, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> EV_UNPACKAGER = ITEMS.register("ev_unpackager", () -> new IMBlockItem(IMBlocks.EV_UNPACKAGER, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> IV_UNPACKAGER = ITEMS.register("iv_unpackager", () -> new IMBlockItem(IMBlocks.IV_UNPACKAGER, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> LUV_UNPACKAGER = ITEMS.register("luv_unpackager", () -> new IMBlockItem(IMBlocks.LUV_UNPACKAGER, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> ZPM_UNPACKAGER = ITEMS.register("zpm_unpackager", () -> new IMBlockItem(IMBlocks.ZPM_UNPACKAGER, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> UV_UNPACKAGER = ITEMS.register("uv_unpackager", () -> new IMBlockItem(IMBlocks.UV_UNPACKAGER, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> MAX_UNPACKAGER = ITEMS.register("max_unpackager", () -> new IMBlockItem(IMBlocks.MAX_UNPACKAGER, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));

  public static final RegistryObject<Item> LV_PACKAGER = ITEMS.register("lv_packager", () -> new IMBlockItem(IMBlocks.LV_PACKAGER, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> MV_PACKAGER = ITEMS.register("mv_packager", () -> new IMBlockItem(IMBlocks.MV_PACKAGER, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> HV_PACKAGER = ITEMS.register("hv_packager", () -> new IMBlockItem(IMBlocks.HV_PACKAGER, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> EV_PACKAGER = ITEMS.register("ev_packager", () -> new IMBlockItem(IMBlocks.EV_PACKAGER, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> IV_PACKAGER = ITEMS.register("iv_packager", () -> new IMBlockItem(IMBlocks.IV_PACKAGER, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> LUV_PACKAGER = ITEMS.register("luv_packager", () -> new IMBlockItem(IMBlocks.LUV_PACKAGER, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> ZPM_PACKAGER = ITEMS.register("zpm_packager", () -> new IMBlockItem(IMBlocks.ZPM_PACKAGER, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> UV_PACKAGER = ITEMS.register("uv_packager", () -> new IMBlockItem(IMBlocks.UV_PACKAGER, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> MAX_PACKAGER = ITEMS.register("max_packager", () -> new IMBlockItem(IMBlocks.MAX_PACKAGER, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));

  public static final RegistryObject<Item> LV_THERMAL_CENTRIFUGE = ITEMS.register("lv_thermal_centrifuge", () -> new IMBlockItem(IMBlocks.LV_THERMAL_CENTRIFUGE, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> MV_THERMAL_CENTRIFUGE = ITEMS.register("mv_thermal_centrifuge", () -> new IMBlockItem(IMBlocks.MV_THERMAL_CENTRIFUGE, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> HV_THERMAL_CENTRIFUGE = ITEMS.register("hv_thermal_centrifuge", () -> new IMBlockItem(IMBlocks.HV_THERMAL_CENTRIFUGE, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> EV_THERMAL_CENTRIFUGE = ITEMS.register("ev_thermal_centrifuge", () -> new IMBlockItem(IMBlocks.EV_THERMAL_CENTRIFUGE, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> IV_THERMAL_CENTRIFUGE = ITEMS.register("iv_thermal_centrifuge", () -> new IMBlockItem(IMBlocks.IV_THERMAL_CENTRIFUGE, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> LUV_THERMAL_CENTRIFUGE = ITEMS.register("luv_thermal_centrifuge", () -> new IMBlockItem(IMBlocks.LUV_THERMAL_CENTRIFUGE, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> ZPM_THERMAL_CENTRIFUGE = ITEMS.register("zpm_thermal_centrifuge", () -> new IMBlockItem(IMBlocks.ZPM_THERMAL_CENTRIFUGE, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> UV_THERMAL_CENTRIFUGE = ITEMS.register("uv_thermal_centrifuge", () -> new IMBlockItem(IMBlocks.UV_THERMAL_CENTRIFUGE, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> MAX_THERMAL_CENTRIFUGE = ITEMS.register("max_thermal_centrifuge", () -> new IMBlockItem(IMBlocks.MAX_THERMAL_CENTRIFUGE, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));

  public static final RegistryObject<Item> LV_ORE_WASHING_PLANT = ITEMS.register("lv_ore_washing_plant", () -> new IMBlockItem(IMBlocks.LV_ORE_WASHING_PLANT, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> MV_ORE_WASHING_PLANT = ITEMS.register("mv_ore_washing_plant", () -> new IMBlockItem(IMBlocks.MV_ORE_WASHING_PLANT, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> HV_ORE_WASHING_PLANT = ITEMS.register("hv_ore_washing_plant", () -> new IMBlockItem(IMBlocks.HV_ORE_WASHING_PLANT, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> EV_ORE_WASHING_PLANT = ITEMS.register("ev_ore_washing_plant", () -> new IMBlockItem(IMBlocks.EV_ORE_WASHING_PLANT, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> IV_ORE_WASHING_PLANT = ITEMS.register("iv_ore_washing_plant", () -> new IMBlockItem(IMBlocks.IV_ORE_WASHING_PLANT, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> LUV_ORE_WASHING_PLANT = ITEMS.register("luv_ore_washing_plant", () -> new IMBlockItem(IMBlocks.LUV_ORE_WASHING_PLANT, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> ZPM_ORE_WASHING_PLANT = ITEMS.register("zpm_ore_washing_plant", () -> new IMBlockItem(IMBlocks.ZPM_ORE_WASHING_PLANT, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> UV_ORE_WASHING_PLANT = ITEMS.register("uv_ore_washing_plant", () -> new IMBlockItem(IMBlocks.UV_ORE_WASHING_PLANT, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> MAX_ORE_WASHING_PLANT = ITEMS.register("max_ore_washing_plant", () -> new IMBlockItem(IMBlocks.MAX_THERMAL_CENTRIFUGE, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));

  public static final RegistryObject<Item> LV_PRECISION_ENGRAVING_MACHINE = ITEMS.register("lv_precision_engraving_machine", () -> new IMBlockItem(IMBlocks.LV_PRECISION_ENGRAVING_MACHINE, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> MV_PRECISION_ENGRAVING_MACHINE = ITEMS.register("mv_precision_engraving_machine", () -> new IMBlockItem(IMBlocks.MV_PRECISION_ENGRAVING_MACHINE, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> HV_PRECISION_ENGRAVING_MACHINE = ITEMS.register("hv_precision_engraving_machine", () -> new IMBlockItem(IMBlocks.HV_PRECISION_ENGRAVING_MACHINE, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> EV_PRECISION_ENGRAVING_MACHINE = ITEMS.register("ev_precision_engraving_machine", () -> new IMBlockItem(IMBlocks.EV_PRECISION_ENGRAVING_MACHINE, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> IV_PRECISION_ENGRAVING_MACHINE = ITEMS.register("iv_precision_engraving_machine", () -> new IMBlockItem(IMBlocks.IV_PRECISION_ENGRAVING_MACHINE, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> LUV_PRECISION_ENGRAVING_MACHINE = ITEMS.register("luv_precision_engraving_machine", () -> new IMBlockItem(IMBlocks.LUV_PRECISION_ENGRAVING_MACHINE, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> ZPM_PRECISION_ENGRAVING_MACHINE = ITEMS.register("zpm_precision_engraving_machine", () -> new IMBlockItem(IMBlocks.ZPM_PRECISION_ENGRAVING_MACHINE, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> UV_PRECISION_ENGRAVING_MACHINE = ITEMS.register("uv_precision_engraving_machine", () -> new IMBlockItem(IMBlocks.UV_PRECISION_ENGRAVING_MACHINE, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));
  public static final RegistryObject<Item> MAX_PRECISION_ENGRAVING_MACHINE = ITEMS.register("max_precision_engraving_machine", () -> new IMBlockItem(IMBlocks.MAX_THERMAL_CENTRIFUGE, new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));


  // Crafting Items
  public static final RegistryObject<Item> WOOD_PULP = ITEMS.register("wood_pulp", IMCraftingItem::new);

  // Misc Block Items
  public static final RegistryObject<Item> INFINITE_WATER_SOURCE = ITEMS.register("infinite_water_source", () -> new IMBlockItem(IMBlocks.INFINITE_WATER_SOURCE, new Item.Properties().group(IndustriaeMutatio.CRAFTING_ITEMS_TAB)));
}
