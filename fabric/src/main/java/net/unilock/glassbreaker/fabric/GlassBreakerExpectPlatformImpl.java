package net.unilock.glassbreaker.fabric;

import net.fabricmc.loader.api.FabricLoader;
import net.unilock.glassbreaker.GlassBreakerExpectPlatform;

import java.nio.file.Path;

public class GlassBreakerExpectPlatformImpl {
    /**
     * This is our actual method to {@link GlassBreakerExpectPlatform#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FabricLoader.getInstance().getConfigDir();
    }
}
