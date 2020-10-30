package dev.quae.mods.industriae;

import dev.quae.mods.industriae.client.colours.IMFirstLayerColouredItemColor;
import dev.quae.mods.industriae.event.WorldGenEvents;
import dev.quae.mods.industriae.item.IMFirstLayerColouredItem;
import dev.quae.mods.industriae.material.Material;
import dev.quae.mods.industriae.material.ProcessedMaterialVariant;
import dev.quae.mods.industriae.setup.IMItems;
import dev.quae.mods.industriae.setup.Registrar;
import dev.quae.mods.industriae.setup.registers.MachineType;
import dev.quae.mods.industriae.setup.registers.SpeedTier;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(IndustriaeMutatio.ID)
public class IndustriaeMutatio {

  public static final String ID = "industriaemutatio";

  public static final ItemGroup MACHINES_TAB = new ItemGroup("industriaemutatio_machines") {
    @Override
    public ItemStack createIcon() {
      return new ItemStack(MachineType.ALLOY_SMELTER.getBlock(SpeedTier.MAX), 1);
    }
  };
  public static final ItemGroup CRAFTING_ITEMS_TAB = new ItemGroup("industriaemutatio_crafting_items") {
    @Override
    public ItemStack createIcon() {
      return new ItemStack(IMItems.WOOD_PULP.get(), 1);
    }
  };
  public static final ItemGroup CRUSHED_ORES_TAB = new ItemGroup("industriaemutatio_crushed_ores") {
    @Override
    public ItemStack createIcon() {
      return new ItemStack(Material.TIN.getVariant(ProcessedMaterialVariant.CRUSHED_ORE).get(), 1);
    }
  };
  public static final ItemGroup SMALL_CRUSHED_ORES_TAB = new ItemGroup("industriaemutatio_small_crushed_ores") {
    @Override
    public ItemStack createIcon() {
      return new ItemStack(Material.TIN.getVariant(ProcessedMaterialVariant.SMALL_CRUSHED_ORE).get(), 1);
    }
  };
  public static final ItemGroup TINY_CRUSHED_ORES_TAB = new ItemGroup("industriaemutatio_tiny_crushed_ores") {
    @Override
    public ItemStack createIcon() {
      return new ItemStack(Material.TIN.getVariant(ProcessedMaterialVariant.TINY_CRUSHED_ORE).get(), 1);
    }
  };
  public static final ItemGroup DUST_ORES_TAB = new ItemGroup("industriaemutatio_ore_dusts") {
    @Override
    public ItemStack createIcon() {
      return new ItemStack(Material.TIN.getVariant(ProcessedMaterialVariant.DUST).get(), 1);
    }
  };
  public static final ItemGroup SMALL_DUST_ORES_TAB = new ItemGroup("industriaemutatio_small_ore_dusts") {
    @Override
    public ItemStack createIcon() {
      return new ItemStack(Material.TIN.getVariant(ProcessedMaterialVariant.SMALL_DUST).get(), 1);
    }
  };
  public static final ItemGroup TINY_DUST_ORES_TAB = new ItemGroup("industriaemutatio_tiny_ore_dusts") {
    @Override
    public ItemStack createIcon() {
      return new ItemStack(Material.TIN.getVariant(ProcessedMaterialVariant.TINY_DUST).get(), 1);
    }
  };
  public static final ItemGroup CENTRIFUGED_ORES_TAB = new ItemGroup("industriaemutatio_centrifuged_ores") {
    @Override
    public ItemStack createIcon() {
      return new ItemStack(Material.TIN.getVariant(ProcessedMaterialVariant.CENTRIFUGED_DUST).get(), 1);
    }
  };
  public static final ItemGroup SMALL_CENTRIFUGED_ORES_TAB = new ItemGroup("industriaemutatio_small_centrifuged_ores") {
    @Override
    public ItemStack createIcon() {
      return new ItemStack(Material.TIN.getVariant(ProcessedMaterialVariant.SMALL_CENTRIFUGED_DUST).get(), 1);
    }
  };
  public static final ItemGroup TINY_CENTRIFUGED_ORES_TAB = new ItemGroup("industriaemutatio_tiny_centrifuged_ores") {
    @Override
    public ItemStack createIcon() {
      return new ItemStack(Material.TIN.getVariant(ProcessedMaterialVariant.TINY_CENTRIFUGED_DUST).get(), 1);
    }
  };
  public static final ItemGroup PURE_DUST_ORES_TAB = new ItemGroup("industriaemutatio_pure_ore_dusts") {
    @Override
    public ItemStack createIcon() {
      return new ItemStack(Material.TIN.getVariant(ProcessedMaterialVariant.PURIFIED_DUST).get(), 1);
    }
  };
  public static final ItemGroup IMPURE_DUST_ORES_TAB = new ItemGroup("industriaemutatio_impure_ore_dusts") {
    @Override
    public ItemStack createIcon() {
      return new ItemStack(Material.TIN.getVariant(ProcessedMaterialVariant.IMPURE_DUST).get(), 1);
    }
  };

  public IndustriaeMutatio() {
    Registrar.onConstruct();
    final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
    bus.addListener(this::onSetup);
    bus.addListener(this::clientSetup);
  }

  private void clientSetup(FMLClientSetupEvent event) {
    event.getMinecraftSupplier().get().getItemColors().register(new IMFirstLayerColouredItemColor(), IMFirstLayerColouredItem.getDusts().toArray(new IMFirstLayerColouredItem[0]));
  }

  private void onSetup(final FMLCommonSetupEvent event) {
    event.enqueueWork(() -> MinecraftForge.EVENT_BUS.register(WorldGenEvents.class));
  }
}
