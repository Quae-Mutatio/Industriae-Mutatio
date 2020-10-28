package dev.quae.mods.industriae.client.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import dev.quae.mods.industriae.IndustriaeMutatio;
import dev.quae.mods.industriae.container.IMTieredMachineContainer;
import dev.quae.mods.industriae.tileentity.IMTieredProcessingMachineTileEntity;
import java.util.stream.Collectors;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class IMTieredMachineContainerScreen extends ContainerScreen<IMTieredMachineContainer> {


  private static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation(IndustriaeMutatio.ID, "textures/gui/gui_large.png");
  private static final ResourceLocation SLOTS_TEXTURE_ATLAS = new ResourceLocation(IndustriaeMutatio.ID, "textures/gui/slot_parts.png");

  public IMTieredMachineContainerScreen(IMTieredMachineContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
    super(screenContainer, inv, titleIn);
    playerInventoryTitleY = screenContainer.playerInvY - 11;
    titleY = screenContainer.titleY - 11;
    xSize = 175;
    ySize = 221;
  }

  @Override
  protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int mouseX, int mouseY) {
    RenderSystem.color4f(1.f, 1.f, 1.f, 1.f);
    this.minecraft.getTextureManager().bindTexture(BACKGROUND_TEXTURE);
    int x = (this.width - this.getXSize()) / 2;
    int y = (this.height - this.getYSize()) / 2;
    this.blit(matrixStack, x, y, 0, 0, 175, 221);
    this.minecraft.getTextureManager().bindTexture(SLOTS_TEXTURE_ATLAS);
    for (Slot inventorySlot : this.container.inventorySlots.stream().filter(z -> z.inventory instanceof IMTieredProcessingMachineTileEntity).collect(Collectors.toList())) {
      this.blit(matrixStack, x + inventorySlot.xPos - 1, y + inventorySlot.yPos - 1, 0, 26, 18, 18);
    }
  }

  @Override
  public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
    this.renderBackground(matrixStack);
    super.render(matrixStack, mouseX, mouseY, partialTicks);
    this.renderHoveredTooltip(matrixStack, mouseX, mouseY);
  }
}
