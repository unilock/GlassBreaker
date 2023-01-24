package net.unilock.glassbreaker.quilt;

import net.unilock.glassbreaker.fabriclike.GlassBreakerFabricLike;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;

public class GlassBreakerQuilt implements ModInitializer {
    @Override
    public void onInitialize(ModContainer mod) {
        GlassBreakerFabricLike.init();
    }
}
