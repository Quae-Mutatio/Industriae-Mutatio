package dev.quae.mods.industriae.item;

import dev.quae.mods.industriae.IndustriaeMutatio;
import dev.quae.mods.industriae.helper.IMFluidStackHelper;
import dev.quae.mods.industriae.helper.KeyboardHelper;
import java.util.List;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;
import org.jetbrains.annotations.Nullable;

public class FluidTankItem extends Item {

  public FluidTankItem() {
    super(new Item.Properties().group(IndustriaeMutatio.MACHINES_TAB));
  }

  @Override
  public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
    if (!IMFluidStackHelper.isFluidContainer(stack)) {
      return;
    }

    if (KeyboardHelper.isHoldingShift()) {
      // TODO change to  real fluidstack value
      tooltip.add(new TranslationTextComponent("item.tooltip.fluidstoragetank").append(new StringTextComponent(stack.getCount() + "mb")));
    } else {
      tooltip.add(new TranslationTextComponent("item.tooltip.holdshiftformore"));
    }
    super.addInformation(stack, worldIn, tooltip, flagIn);
  }

  @Override
  public ItemStack getDefaultInstance() {
    return IMFluidStackHelper.getAsItemStack(IMFluidStackHelper.getAsFluidStack(new ItemStack(this)));
  }

  @Override
  public int getItemStackLimit(ItemStack stack) {
    return 1;
  }
}
