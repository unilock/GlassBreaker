package cc.unilock.glassbreaker.mixin;

import cc.unilock.glassbreaker.GlassBreaker;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.enums.Instrument;
import net.minecraft.item.MiningToolItem;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.BlockSoundGroup;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Objects;

@Mixin(MiningToolItem.class)
public class MixinMiningToolItem {
    @Redirect(method = "getMiningSpeedMultiplier", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isIn(Lnet/minecraft/registry/tag/TagKey;)Z"))
    private boolean getMiningSpeedMultiplier(BlockState instance, TagKey<Block> tagKey) {
        return glassbreaker$tagCheck(instance, tagKey);
    }

    @Redirect(method = "isSuitableFor", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isIn(Lnet/minecraft/registry/tag/TagKey;)Z", ordinal = 3))
    private boolean isSuitableFor(BlockState instance, TagKey<Block> tagKey) {
        return glassbreaker$tagCheck(instance, tagKey);
    }

    @Unique
    private static boolean glassbreaker$tagCheck(BlockState state, TagKey<Block> tag) {
        return state.isIn(tag) || Objects.equals(tag, BlockTags.PICKAXE_MINEABLE) && (state.getBlock().asItem().getDefaultStack().isIn(GlassBreaker.GLASS_ITEMS) || Objects.equals(state.getSoundGroup(), BlockSoundGroup.GLASS) || Objects.equals(state.getInstrument(), Instrument.HAT));
    }
}
