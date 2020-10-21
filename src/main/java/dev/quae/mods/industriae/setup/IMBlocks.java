package dev.quae.mods.industriae.setup;

import static net.minecraft.block.AbstractBlock.Properties.create;

import dev.quae.mods.industriae.IndustriaeMutatio;
import dev.quae.mods.industriae.block.OreBlock;
import dev.quae.mods.industriae.material.IMaterialType;
import dev.quae.mods.industriae.material.Material;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class IMBlocks {

  static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, IndustriaeMutatio.ID);

  static {
    for (Material material : Material.values()) {
      if (material.hasOre()) {
        material.setOreBlock(registerOre(material));
      }
    }
  }

  public static RegistryObject<OreBlock> registerOre(IMaterialType metalType) {
    return BLOCKS.register(metalType.getOreName(), () -> new OreBlock(create(net.minecraft.block.material.Material.ROCK), metalType));
  }
}
