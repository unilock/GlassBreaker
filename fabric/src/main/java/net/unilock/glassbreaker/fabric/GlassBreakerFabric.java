package net.unilock.glassbreaker.fabric;

import net.fabricmc.api.ModInitializer;
import net.unilock.glassbreaker.fabriclike.GlassBreakerFabricLike;

public class GlassBreakerFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        GlassBreakerFabricLike.init();
    }
}
