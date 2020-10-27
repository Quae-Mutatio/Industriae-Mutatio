package dev.quae.mods.industriae.setup;

import static net.minecraft.block.AbstractBlock.Properties.create;

import dev.quae.mods.industriae.IndustriaeMutatio;
import dev.quae.mods.industriae.block.OreBlock;
import dev.quae.mods.industriae.material.Ore;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class IMBlocks {

  static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, IndustriaeMutatio.ID);

  static {
    for (Ore ore : Ore.values()) {
      ore.setOreBlock(registerOre(ore));
    }
  }

  public static RegistryObject<OreBlock> registerOre(Ore ore) {
    return BLOCKS.register(ore.getName(), () -> new OreBlock(create(net.minecraft.block.material.Material.ROCK), ore));
  }
}
