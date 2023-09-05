package cc.unilock.glassbreaker;

import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class GlassBreaker {
    public static final String MOD_ID = "glassbreaker";
    public static final TagKey<Item> GLASS_ITEMS = TagKey.of(Registry.ITEM_KEY, new Identifier(MOD_ID, "glass_items"));

    public static void init() {
    }
}
