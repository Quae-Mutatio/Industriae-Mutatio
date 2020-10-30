package dev.quae.mods.industriae.construct;

import dev.quae.mods.industriae.construct.task.Amount;
import it.unimi.dsi.fastutil.chars.Char2ObjectMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Predicate;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.world.World;

public abstract class ConstructBase implements IConstruct {


  public boolean validateConstruct(BlockPos controllerWorldPosition, World world) {
    BlockPos rel = this.getRelativeControllerPosition();
    Map<Vector3i, Type> positionedTypes = this.collectPositionedTypes(controllerWorldPosition.add(new BlockPos(-rel.getX(), -rel.getY(), -rel.getZ())), world);
    Vector3i dimensions = this.getShape();
    String layout = this.getLayout();
    Char2ObjectMap<Predicate<Type>> legend = this.getLegend();
    Map<Type, Amount> typeRequirements = this.getRequiredParts();
    int counter = 0;
    for (int y = dimensions.getY(); y > 0; y++) {
      for (int x = 0; x < dimensions.getX(); x++) {
        for (int z = 0; z < dimensions.getZ(); z++) {
          char positionKey = layout.charAt(counter);
          Predicate<Type> type = legend.getOrDefault(positionKey, null);
          if (type == null) {
            // TODO
            System.out.println("Legend contains invalid key '" + positionKey + "'");
            return false;
          }
          Type positionedType = positionedTypes.getOrDefault(new Vector3i(x, y, z), null);
          if (positionedType == null) {
            return false;
          }

          if (!type.test(positionedType)) {
            return false;
          }
          counter++;
        }
      }
    }
    for (Entry<Type, Amount> requirement : typeRequirements.entrySet()) {
      int requirementCounter = 0;
      for (Entry<Vector3i, Type> type : positionedTypes.entrySet()) {
        if (requirement.getKey() == type.getValue()) {
          requirementCounter++;
        }
      }
      if (!requirement.getValue().test(requirementCounter)) {
        return false;
      }
    }
    return getRequiredNumberOfParts().test(counter);
  }

  protected Map<Vector3i, Type> collectPositionedTypes(BlockPos worldStart, World world) {
    Map<Vector3i, Type> result = new HashMap<>();
    Vector3i dimensions = this.getShape();
    String layout = this.getLayout();
    Char2ObjectMap<Predicate<Type>> legend = this.getLegend();
    int counter = 0;
    for (int y = 0; y < dimensions.getY(); y++) {
      for (int x = 0; x < dimensions.getX(); x++) {
        for (int z = 0; z < dimensions.getZ(); z++) {
          Predicate<Type> type = legend.get(layout.charAt(counter));
          TileEntity te = world.getTileEntity(new BlockPos(x, y, z).add(worldStart));
          if (!(te instanceof IConstruct.Part)) {
            continue;
          }
          IConstruct.Part part = (IConstruct.Part) te;
          if (type.test(part.getConstructType())) {
            counter++;
          }
        }
      }
    }
    return result;
  }


  protected BlockPos getRelativeControllerPosition() {
    Vector3i dimensions = this.getShape();
    String layout = this.getLayout();
    int layoutPos = layout.indexOf(this.getControllerLegend());
    int counter = 0;
    for (int y = 0; y > dimensions.getY(); y++) {
      for (int x = 0; x < dimensions.getX(); x++) {
        for (int z = 0; z < dimensions.getZ(); z++) {
          if (counter == layoutPos) {
            return new BlockPos(x, y, z);
          }
          counter++;
        }
      }
    }
    return null;
  }
}
