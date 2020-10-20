package dev.quae.mods.industriae;

import dev.quae.mods.industriae.setup.Registrar;
import net.minecraftforge.fml.common.Mod;

@Mod(IndustriaeMutatio.ID)
public class IndustriaeMutatio {

  public static final String ID = "industriaemutatio";

  public IndustriaeMutatio() {
    Registrar.onConstruct();
  }
}
