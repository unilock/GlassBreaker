package cc.unilock.glassbreaker;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class GlassBreaker {
    public static final String MOD_ID = "glassbreaker";
    public static final TagKey<Item> GLASS_ITEMS = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MOD_ID, "glass_items"));
}
