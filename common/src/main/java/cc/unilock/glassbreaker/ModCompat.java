package cc.unilock.glassbreaker;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.item.Item;

public class ModCompat {
    @ExpectPlatform
    public static boolean isSuitableTool(Item item) {
        throw new AssertionError();
    }
}
