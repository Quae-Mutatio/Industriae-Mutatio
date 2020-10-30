package dev.quae.mods.industriae.tileentity;

import dev.quae.mods.industriae.construct.IConstruct;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConstructControllerTileEntity extends TileEntity implements ITickableTileEntity {

  private static final Logger LOGGER = LogManager.getLogger();

  private final IConstruct construct;

  public ConstructControllerTileEntity(TileEntityType<?> tileEntityTypeIn, IConstruct construct) {
    super(tileEntityTypeIn);
    this.construct = construct;
  }

  @Override
  public void tick() {
    if (world.isRemote()) {
      return;
    }
    LOGGER.info("Valid structure? {}", construct.validateConstruct(pos, this.world));
  }
}
