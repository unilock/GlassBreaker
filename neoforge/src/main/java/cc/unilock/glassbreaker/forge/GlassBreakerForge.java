package cc.unilock.glassbreaker.forge;

import cc.unilock.glassbreaker.GlassBreaker;
import net.minecraftforge.fml.common.Mod;

@Mod(GlassBreaker.MOD_ID)
public class GlassBreakerForge {
    public GlassBreakerForge() {
        GlassBreaker.init();
    }
}
