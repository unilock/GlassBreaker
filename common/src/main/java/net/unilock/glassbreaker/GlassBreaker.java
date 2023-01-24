package net.unilock.glassbreaker;

public class GlassBreaker {
    public static final String MOD_ID = "glassbreaker";
    public static void init() {
        System.out.println(GlassBreakerExpectPlatform.getConfigDirectory().toAbsolutePath().normalize().toString());
    }
}
