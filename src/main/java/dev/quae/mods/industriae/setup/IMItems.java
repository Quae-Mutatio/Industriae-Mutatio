package dev.quae.mods.industriae.setup;

import dev.quae.mods.industriae.IndustriaeMutatio;
import dev.quae.mods.industriae.helper.IMTieredRegistryResolver;
import dev.quae.mods.industriae.item.IMBlockItem;
import dev.quae.mods.industriae.item.IMCraftingItem;
import dev.quae.mods.industriae.tileentity.SpeedTier;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class IMItems {

  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, IndustriaeMutatio.ID);

  // Machine Block Items
  public static final Map<String, RegistryObject<Item>> MACERATOR = registerTiers("macerator", tier -> () -> new BlockItem(IMTieredRegistryResolver.resolveBlock(tier, IMBlocks.MACERATOR), new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));

  public static final Map<String, RegistryObject<Item>> FORGE_HAMMER = registerTiers("forge_hammer", tier -> () -> new BlockItem(IMTieredRegistryResolver.resolveBlock(tier, IMBlocks.FORGE_HAMMER), new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));

  public static final Map<String, RegistryObject<Item>> ALLOY_SMELTER = registerTiers("alloy_smelter", tier -> () -> new BlockItem(IMTieredRegistryResolver.resolveBlock(tier, IMBlocks.ALLOY_SMELTER), new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));

  public static final Map<String, RegistryObject<Item>> WIREMILL = registerTiers("wiremill", tier -> () -> new BlockItem(IMTieredRegistryResolver.resolveBlock(tier, IMBlocks.WIREMILL), new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));

  public static final Map<String, RegistryObject<Item>> UNPACKAGER = registerTiers("unpackager", tier -> () -> new BlockItem(IMTieredRegistryResolver.resolveBlock(tier, IMBlocks.UNPACKAGER), new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));

  public static final Map<String, RegistryObject<Item>> PACKAGER = registerTiers("packager", tier -> () -> new BlockItem(IMTieredRegistryResolver.resolveBlock(tier, IMBlocks.PACKAGER), new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));

  public static final Map<String, RegistryObject<Item>> THERMAL_CENTRIFUGE = registerTiers("thermal_centrifuge", tier -> () -> new BlockItem(IMTieredRegistryResolver.resolveBlock(tier, IMBlocks.THERMAL_CENTRIFUGE), new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));

  public static final Map<String, RegistryObject<Item>> ORE_WASHING_PLANT = registerTiers("ore_washing_plant", tier -> () -> new BlockItem(IMTieredRegistryResolver.resolveBlock(tier, IMBlocks.ORE_WASHING_PLANT), new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));

  public static final Map<String, RegistryObject<Item>> PRECISION_ENGRAVING_MACHINE = registerTiers("precision_engraving_machine", tier -> () -> new BlockItem(IMTieredRegistryResolver.resolveBlock(tier, IMBlocks.PRECISION_ENGRAVING_MACHINE), new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));

  public static final Map<String, RegistryObject<Item>> SIFTER = registerTiers("sifter", tier -> () -> new BlockItem(IMTieredRegistryResolver.resolveBlock(tier, IMBlocks.SIFTER), new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));

  public static final Map<String, RegistryObject<Item>> AUTOCLAVE = registerTiers("autoclave", tier -> () -> new BlockItem(IMTieredRegistryResolver.resolveBlock(tier, IMBlocks.AUTOCLAVE), new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));

  public static final Map<String, RegistryObject<Item>> MIXER = registerTiers("mixer", tier -> () -> new BlockItem(IMTieredRegistryResolver.resolveBlock(tier, IMBlocks.MIXER), new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB)));

  private static Map<String, RegistryObject<Item>> registerTiers(String registrySuffix, Function<SpeedTier, Supplier<Item>> itemFunction) {
    LinkedHashMap<String, RegistryObject<Item>> map = new LinkedHashMap<>();
    for (SpeedTier speedTier : SpeedTier.getAll()) {
      map.put(speedTier.getName(), ITEMS.register(speedTier.getName() + "_" + registrySuffix, itemFunction.apply(speedTier)));
    }
    return map;
  }

  // Crafting Items
  public static final RegistryObject<Item> WOOD_PULP = ITEMS.register("wood_pulp", IMCraftingItem::new);

  // Misc Block Items
  public static final RegistryObject<Item> INFINITE_WATER_SOURCE = ITEMS.register("infinite_water_source", () -> new IMBlockItem(IMBlocks.INFINITE_WATER_SOURCE, new Item.Properties().group(IndustriaeMutatio.CRAFTING_ITEMS_TAB)));
}
