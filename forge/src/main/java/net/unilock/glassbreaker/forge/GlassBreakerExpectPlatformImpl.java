package net.unilock.glassbreaker.forge;

import net.minecraftforge.fml.loading.FMLPaths;
import net.unilock.glassbreaker.GlassBreakerExpectPlatform;

import java.nio.file.Path;

public class GlassBreakerExpectPlatformImpl {
    /**
     * This is our actual method to {@link GlassBreakerExpectPlatform#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FMLPaths.CONFIGDIR.get();
    }
}
