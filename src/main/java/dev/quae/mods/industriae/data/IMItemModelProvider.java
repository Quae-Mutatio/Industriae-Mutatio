package dev.quae.mods.industriae.data;

import dev.quae.mods.industriae.IndustriaeMutatio;
import dev.quae.mods.industriae.machine.MachineType;
import dev.quae.mods.industriae.machine.SpeedTier;
import javax.annotation.Resource;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class IMItemModelProvider extends ItemModelProvider {

  public IMItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
    super(generator, IndustriaeMutatio.ID, existingFileHelper);
  }

  @Override
  protected void registerModels() {
    for (MachineType value : MachineType.values()) {
      for (SpeedTier speedTier : SpeedTier.values()) {
        this.getBuilder(value.getRegistryName(speedTier)).parent(new ModelFile.UncheckedModelFile(new ResourceLocation(IndustriaeMutatio.ID, "block/" + value.getBlock(speedTier).getRegistryName().getPath())));
      }
    }
  }
}
