package cc.unilock.glassbreaker.mixin;

import cc.unilock.glassbreaker.GlassBreaker;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

import java.util.Objects;

@Mixin(DiggerItem.class)
public class DiggerItemMixin {
    @WrapOperation(method = "getDestroySpeed", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;is(Lnet/minecraft/tags/TagKey;)Z"))
    private boolean getMiningSpeedMultiplier(BlockState instance, TagKey<Block> tagKey, Operation<Boolean> original) {
        return glassbreaker$tagCheck(instance, tagKey, original);
    }

    @WrapOperation(method = "isCorrectToolForDrops", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;is(Lnet/minecraft/tags/TagKey;)Z", ordinal = 3))
    private boolean isSuitableFor(BlockState instance, TagKey<Block> tagKey, Operation<Boolean> original) {
        return glassbreaker$tagCheck(instance, tagKey, original);
    }

    @Unique
    private static boolean glassbreaker$tagCheck(BlockState state, TagKey<Block> tag, Operation<Boolean> original) {
        return original.call(state, tag) || Objects.equals(tag, BlockTags.MINEABLE_WITH_PICKAXE) && (state.getBlock().asItem().getDefaultInstance().is(GlassBreaker.GLASS_ITEMS) || Objects.equals(state.getSoundType(), SoundType.GLASS) || Objects.equals(state.instrument(), NoteBlockInstrument.HAT));
    }
}
