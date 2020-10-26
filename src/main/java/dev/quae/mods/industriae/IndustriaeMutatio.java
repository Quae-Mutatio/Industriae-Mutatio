package dev.quae.mods.industriae;

import dev.quae.mods.industriae.helper.IMTieredRegistryResolver;
import dev.quae.mods.industriae.setup.IMBlocks;
import dev.quae.mods.industriae.setup.IMItems;
import dev.quae.mods.industriae.setup.Registrar;
import dev.quae.mods.industriae.tileentity.SpeedTier;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;

@Mod(IndustriaeMutatio.ID)
public class IndustriaeMutatio {

  public static final String ID = "industriaemutatio";

  public static final ItemGroup MACHINES_TAB = new ItemGroup("industriaemutatio_machines") {
    @Override
    public ItemStack createIcon() {
      return new ItemStack(IMTieredRegistryResolver.resolveItem(SpeedTier.MAX, IMItems.ALLOY_SMELTER), 1);
    }
  };
  public static final ItemGroup CRAFTING_ITEMS_TAB = new ItemGroup("industriaemutatio_crafting_items") {
    @Override
    public ItemStack createIcon() {
      return new ItemStack(IMTieredRegistryResolver.resolveItem(SpeedTier.MAX, IMItems.ALLOY_SMELTER), 1);
    }
  };

  public IndustriaeMutatio() {
    Registrar.onConstruct();
  }
}
