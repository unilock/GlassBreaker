package cc.unilock.glassbreaker.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MiningToolItem;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MiningToolItem.class)
public class MixinMiningToolItem {
    @Shadow
    @Final
    protected float miningSpeed;

    @Inject(at = @At("HEAD"), method = "getMiningSpeedMultiplier(Lnet/minecraft/item/ItemStack;Lnet/minecraft/block/BlockState;)F", cancellable = true)
    private void miningSpeedGlass(ItemStack stack, BlockState state, CallbackInfoReturnable<Float> cir) {
        if (state.getMaterial().equals(Material.GLASS)) {
            cir.setReturnValue(this.miningSpeed);
        }
    }

    @Inject(at = @At("HEAD"), method = "isSuitableFor(Lnet/minecraft/block/BlockState;)Z", cancellable = true)
    private void suitableForGlass(BlockState state, CallbackInfoReturnable<Boolean> cir) {
        if (state.getMaterial().equals(Material.GLASS)) {
            cir.setReturnValue(true);
        }
    }
}
