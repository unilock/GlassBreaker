package cc.unilock.glassbreaker.mixin;

import cc.unilock.glassbreaker.GlassBreaker;
import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.ref.LocalRef;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Objects;

@Mixin(Tool.class)
public class ToolMixin {
    @Inject(method = "getMiningSpeed", at = @At("HEAD"))
    private void getMiningSpeed(CallbackInfoReturnable<Float> cir, @Local(argsOnly = true) LocalRef<BlockState> state) {
        if (glassbreaker$isGlass(state.get())) {
            state.set(Blocks.STONE.defaultBlockState());
        }
    }

    @Inject(method = "isCorrectForDrops", at = @At("HEAD"))
    private void isCorrectForDrops(CallbackInfoReturnable<Float> cir, @Local(argsOnly = true) LocalRef<BlockState> state) {
        if (glassbreaker$isGlass(state.get())) {
            state.set(Blocks.STONE.defaultBlockState());
        }
    }

    @Unique
    private boolean glassbreaker$isGlass(BlockState state) {
        return state.getBlock().asItem().getDefaultInstance().is(GlassBreaker.GLASS_ITEMS) || Objects.equals(state.getSoundType(), SoundType.GLASS) || Objects.equals(state.instrument(), NoteBlockInstrument.HAT);
    }
}
