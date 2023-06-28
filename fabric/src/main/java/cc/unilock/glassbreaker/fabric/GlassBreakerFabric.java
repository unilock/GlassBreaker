package cc.unilock.glassbreaker.fabric;

import cc.unilock.glassbreaker.GlassBreaker;
import net.fabricmc.api.ModInitializer;

public class GlassBreakerFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        GlassBreaker.init();
    }
}
