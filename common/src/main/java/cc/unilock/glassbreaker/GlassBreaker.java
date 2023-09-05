package cc.unilock.glassbreaker;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class GlassBreaker {
    public static final String MOD_ID = "glassbreaker";
    public static final TagKey<Item> GLASS_ITEMS = TagKey.of(RegistryKeys.ITEM, Identifier.of(MOD_ID, "glass_items"));

    public static void init() {
    }
}
