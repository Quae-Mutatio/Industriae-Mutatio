package dev.quae.mods.industriae.client.gui.util;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.fluid.Fluid;
import net.minecraft.inventory.container.PlayerContainer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.FluidStack;

public class FluidRenderer {

  public static final FluidRenderer INSTANCE = new FluidRenderer(1000, 16, 16, 16);
  private static final int TEX_WIDTH = 16;
  private static final int TEX_HEIGHT = 16;

  private int capacity;
  private final int width;
  private final int height;
  private final int minHeight;

  public FluidRenderer(int capacity, int width, int height, int minHeight) {
    this.capacity = capacity;
    this.width = width;
    this.height = height;
    this.minHeight = minHeight;
  }

  public void render(MatrixStack matrixStack, final int xPosition, final int yPosition, FluidStack stack) {
    RenderSystem.enableBlend();
    RenderSystem.enableAlphaTest();

    drawFluid(matrixStack, xPosition, yPosition, stack);

    RenderSystem.color4f(1, 1, 1, 1);

    RenderSystem.disableAlphaTest();
    RenderSystem.disableBlend();
  }

  private void drawFluid(MatrixStack matrixStack, int xPosition, int yPosition, FluidStack stack) {
    if (stack == null) {
      return;
    }
    Fluid fluid = stack.getFluid();
    if (fluid == null) {
      return;
    }

    TextureAtlasSprite fluidStillSprite = getStillFluidSprite(stack);

    FluidAttributes attributes = fluid.getAttributes();
    int fluidColor = attributes.getColor(stack);

    int amount = stack.getAmount();
    int scaledAmount = (amount * height) / capacity;
    if (amount > 0 && scaledAmount < minHeight) {
      scaledAmount = minHeight;
    }
    if (scaledAmount > height) {
      scaledAmount = height;
    }

    drawTiledSprite(matrixStack, xPosition, yPosition, width, height, fluidColor, scaledAmount, fluidStillSprite);
  }

  private void drawTiledSprite(MatrixStack matrixStack, int xPosition, int yPosition, int width, int height, int color, int scaledAmount, TextureAtlasSprite sprite) {
    Minecraft minecraft = Minecraft.getInstance();
    minecraft.getTextureManager().bindTexture(PlayerContainer.LOCATION_BLOCKS_TEXTURE);
    Matrix4f matrix = matrixStack.getLast().getMatrix();
    setGLColorFromInt(color);

    final int xTileCount = width / TEX_WIDTH;
    final int xRemainder = height - (xTileCount * TEX_WIDTH);
    final int yTileCount = scaledAmount / TEX_HEIGHT;
    final int yRemainder = scaledAmount - (yTileCount * TEX_HEIGHT);

    final int yStart = yPosition + height;

    for (int xTile = 0; xTile <= xTileCount; xTile++) {
      for (int yTile = 0; yTile <= yTileCount; yTile++) {
        int w = (xTile == xTileCount) ? xRemainder : TEX_WIDTH;
        int h = (yTile == yTileCount) ? yRemainder : TEX_HEIGHT;
        int x = xPosition + (xTile * TEX_WIDTH);
        int y = yStart - ((yTile + 1) * TEX_HEIGHT);
        if (w > 0 && h > 0) {
          int maskTop = TEX_HEIGHT - h;
          int maskRight = TEX_WIDTH - w;

          drawTextureWithMasking(matrix, x, y, sprite, maskTop, maskRight, 100);
        }
      }
    }
  }

  private void drawTextureWithMasking(Matrix4f matrix, int x, int y, TextureAtlasSprite sprite, int maskTop, int maskRight, int z) {
    float uMin = sprite.getMinU();
    float uMax = sprite.getMaxU();
    float vMin = sprite.getMinV();
    float vMax = sprite.getMaxV();
    uMax = uMax - (maskRight / 16F * (uMax - uMin));
    vMax = vMax - (maskTop / 16F * (vMax - vMin));

    Tessellator tessellator = Tessellator.getInstance();
    BufferBuilder bufferBuilder = tessellator.getBuffer();
    bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
    bufferBuilder.pos(matrix, x, y + 16, z).tex(uMin, vMax).endVertex();
    bufferBuilder.pos(matrix, x + 16 - maskRight, y + 16, z).tex(uMax, vMax).endVertex();
    bufferBuilder.pos(matrix, x + 16 - maskRight, y + maskTop, z).tex(uMax, vMin).endVertex();
    bufferBuilder.pos(matrix, x, y + maskTop, z).tex(uMin, vMin).endVertex();
    tessellator.draw();
  }

  private static void setGLColorFromInt(int color) {
    float red = (color >> 16 & 0xFF) / 255.0F;
    float green = (color >> 8 & 0xFF) / 255.0F;
    float blue = (color & 0xFF) / 255.0F;
    float alpha = ((color >> 24) & 0xFF) / 255F;

    RenderSystem.color4f(red, green, blue, alpha);
  }

  private TextureAtlasSprite getStillFluidSprite(FluidStack stack) {
    Minecraft minecraft = Minecraft.getInstance();
    Fluid fluid = stack.getFluid();
    FluidAttributes attributes = fluid.getAttributes();
    ResourceLocation fluidStill = attributes.getStillTexture(stack);
    return minecraft.getAtlasSpriteGetter(PlayerContainer.LOCATION_BLOCKS_TEXTURE).apply(fluidStill);
  }
}
