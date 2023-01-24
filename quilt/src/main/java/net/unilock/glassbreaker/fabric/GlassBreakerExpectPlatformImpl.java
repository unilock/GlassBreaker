package net.unilock.glassbreaker.fabric;

import net.unilock.glassbreaker.GlassBreakerExpectPlatform;
import org.quiltmc.loader.api.QuiltLoader;

import java.nio.file.Path;

public class GlassBreakerExpectPlatformImpl {
    /**
     * This is our actual method to {@link GlassBreakerExpectPlatform#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return QuiltLoader.getConfigDir();
    }
}
