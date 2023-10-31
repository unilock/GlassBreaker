package cc.unilock.glassbreaker.forge.compat;

import net.minecraft.item.Item;
import se.mickelus.tetra.items.modular.ModularItem;

public class TetraCompat {
    public static boolean isSuitableTool(Item item) {
        if (item instanceof ModularItem tetraItem && tetraItem.canPerformAction(item.getDefaultStack()));
    }
}
