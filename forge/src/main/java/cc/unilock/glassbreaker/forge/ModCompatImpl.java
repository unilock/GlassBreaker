package cc.unilock.glassbreaker.forge;

import cc.unilock.glassbreaker.forge.compat.TetraCompat;
import net.minecraft.item.Item;
import net.minecraftforge.fml.ModList;

public class ModCompatImpl {
    public static boolean isSuitableTool(Item item) {
        if (ModList.get().isLoaded("tetra")) {
            return TetraCompat.isSuitableTool(item);
        }

        return true;
    }
}
