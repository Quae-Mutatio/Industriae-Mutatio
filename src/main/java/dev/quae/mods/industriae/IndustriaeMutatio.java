package dev.quae.mods.industriae;

import dev.quae.mods.industriae.event.WorldGenEvents;
import dev.quae.mods.industriae.setup.Registrar;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import dev.quae.mods.industriae.machine.MachineType;
import dev.quae.mods.industriae.setup.IMItems;
import dev.quae.mods.industriae.setup.Registrar;
import dev.quae.mods.industriae.machine.SpeedTier;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
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

  public IndustriaeMutatio() {
    Registrar.onConstruct();
    final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
    bus.addListener(this::onSetup);
  }

  private void onSetup(final FMLCommonSetupEvent event) {
    event.enqueueWork(() -> MinecraftForge.EVENT_BUS.register(WorldGenEvents.class));
  }
}
