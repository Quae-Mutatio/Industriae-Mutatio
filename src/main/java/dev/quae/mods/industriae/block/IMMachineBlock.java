package dev.quae.mods.industriae.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class IMMachineBlock extends IMDirectionalBlock {

  protected IMMachineBlock() {
    super(AbstractBlock.Properties.create(Material.IRON)
        .hardnessAndResistance(5.f, 6.f)
        .harvestTool(ToolType.PICKAXE)
        .harvestLevel(3)
        .sound(SoundType.METAL));
  }
}
