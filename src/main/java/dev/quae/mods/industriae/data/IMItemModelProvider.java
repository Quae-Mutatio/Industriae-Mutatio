package dev.quae.mods.industriae.data;

import dev.quae.mods.industriae.IndustriaeMutatio;
import dev.quae.mods.industriae.machine.MachineType;
import dev.quae.mods.industriae.machine.SpeedTier;
import dev.quae.mods.industriae.material.Material;
import dev.quae.mods.industriae.material.ProcessedMaterialVariant;
import dev.quae.mods.industriae.storage.FluidTankType;
import javax.annotation.Resource;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.ModelFile.UncheckedModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class IMItemModelProvider extends ItemModelProvider {

  public static final ResourceLocation DUST_BASE_TEXTURE = new ResourceLocation(IndustriaeMutatio.ID, "item/base_material/dust");
  public static final ResourceLocation DUST_SMALL_TEXTURE = new ResourceLocation(IndustriaeMutatio.ID, "item/base_material/small_dust");
  public static final ResourceLocation DUST_TINY_TEXTURE = new ResourceLocation(IndustriaeMutatio.ID, "item/base_material/tiny_dust");
  public static final ResourceLocation DUST_SPARKLE_TEXTURE = new ResourceLocation(IndustriaeMutatio.ID, "item/base_material/dust_sparkle");
  public static final ResourceLocation DUST_PURIFIED_TEXTURE = new ResourceLocation(IndustriaeMutatio.ID, "item/base_material/purified_dust");
  public static final ResourceLocation DUST_IMPURE_TEXTURE = new ResourceLocation(IndustriaeMutatio.ID, "item/base_material/impure_dust");
  public static final ResourceLocation DUST_BOTTOM_TEXTURE = new ResourceLocation(IndustriaeMutatio.ID, "item/base_material/dust_bottom");
  public static final ResourceLocation DUST_CENTRIFUGED_TEXTURE = new ResourceLocation(IndustriaeMutatio.ID, "item/base_material/centrifuged_dust");
  public static final ResourceLocation DUST_CENTRIFUGED_SMALL_TEXTURE = new ResourceLocation(IndustriaeMutatio.ID, "item/base_material/small_centrifuged_dust");
  public static final ResourceLocation DUST_CENTRIFUGED_TINY_TEXTURE = new ResourceLocation(IndustriaeMutatio.ID, "item/base_material/tiny_centrifuged_dust");
  public static final ResourceLocation CRUSHED_ORE_ROCK = new ResourceLocation(IndustriaeMutatio.ID, "item/base_material/crushed_ore_rock");
  public static final ResourceLocation SMALL_CRUSHED_ORE_ROCK = new ResourceLocation(IndustriaeMutatio.ID, "item/base_material/small_crushed_ore_rock");
  public static final ResourceLocation TINY_CRUSHED_ORE_ROCK = new ResourceLocation(IndustriaeMutatio.ID, "item/base_material/tiny_crushed_ore_rock");
  public static final ResourceLocation CRUSHED_ORE_MATERIAL = new ResourceLocation(IndustriaeMutatio.ID, "item/base_material/crushed_ore_material");
  public static final ResourceLocation SMALL_CRUSHED_ORE_MATERIAL = new ResourceLocation(IndustriaeMutatio.ID, "item/base_material/small_crushed_ore_material");
  public static final ResourceLocation TINY_CRUSHED_ORE_MATERIAL = new ResourceLocation(IndustriaeMutatio.ID, "item/base_material/tiny_crushed_ore_material");

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

    for (FluidTankType value : FluidTankType.values()) {
      this.getBuilder(value.getRegistryName()).parent(new UncheckedModelFile(new ResourceLocation(IndustriaeMutatio.ID, "block/" + value.getBlock().getRegistryName().getPath())));
    }

    for (Material value : Material.values()) {
      this.getBuilder(value.getVariant(ProcessedMaterialVariant.DUST).get().getRegistryName().toString()).parent(new UncheckedModelFile("builtin/generated")).texture("layer0", DUST_BASE_TEXTURE);
      this.getBuilder(value.getVariant(ProcessedMaterialVariant.SMALL_DUST).get().getRegistryName().toString()).parent(new UncheckedModelFile("builtin/generated")).texture("layer0", DUST_SMALL_TEXTURE);
      this.getBuilder(value.getVariant(ProcessedMaterialVariant.TINY_DUST).get().getRegistryName().toString()).parent(new UncheckedModelFile("builtin/generated")).texture("layer0", DUST_TINY_TEXTURE);
      this.getBuilder(value.getVariant(ProcessedMaterialVariant.CENTRIFUGED_DUST).get().getRegistryName().toString()).parent(new UncheckedModelFile("builtin/generated")).texture("layer0", DUST_CENTRIFUGED_TEXTURE);
      this.getBuilder(value.getVariant(ProcessedMaterialVariant.SMALL_CENTRIFUGED_DUST).get().getRegistryName().toString()).parent(new UncheckedModelFile("builtin/generated")).texture("layer0", DUST_CENTRIFUGED_SMALL_TEXTURE);
      this.getBuilder(value.getVariant(ProcessedMaterialVariant.TINY_CENTRIFUGED_DUST).get().getRegistryName().toString()).parent(new UncheckedModelFile("builtin/generated")).texture("layer0", DUST_CENTRIFUGED_TINY_TEXTURE);
      this.getBuilder(value.getVariant(ProcessedMaterialVariant.PURIFIED_DUST).get().getRegistryName().toString()).parent(new UncheckedModelFile("builtin/generated")).texture("layer0", DUST_BOTTOM_TEXTURE).texture("layer1", DUST_PURIFIED_TEXTURE);
      this.getBuilder(value.getVariant(ProcessedMaterialVariant.IMPURE_DUST).get().getRegistryName().toString()).parent(new UncheckedModelFile("builtin/generated")).texture("layer0", DUST_BOTTOM_TEXTURE).texture("layer1", DUST_IMPURE_TEXTURE);
      this.getBuilder(value.getVariant(ProcessedMaterialVariant.CRUSHED_ORE).get().getRegistryName().toString()).parent(new UncheckedModelFile("builtin/generated")).texture("layer0", CRUSHED_ORE_MATERIAL).texture("layer1", CRUSHED_ORE_ROCK);
      this.getBuilder(value.getVariant(ProcessedMaterialVariant.SMALL_CRUSHED_ORE).get().getRegistryName().toString()).parent(new UncheckedModelFile("builtin/generated")).texture("layer0", SMALL_CRUSHED_ORE_MATERIAL).texture("layer1", SMALL_CRUSHED_ORE_ROCK);
      this.getBuilder(value.getVariant(ProcessedMaterialVariant.TINY_CRUSHED_ORE).get().getRegistryName().toString()).parent(new UncheckedModelFile("builtin/generated")).texture("layer0", TINY_CRUSHED_ORE_ROCK).texture("layer1", TINY_CRUSHED_ORE_ROCK);
    }
  }
}
