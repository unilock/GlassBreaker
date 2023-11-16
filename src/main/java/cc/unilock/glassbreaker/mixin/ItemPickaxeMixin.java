package cc.unilock.glassbreaker.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Objects;
import java.util.Set;

@Mixin(ItemPickaxe.class)
public class ItemPickaxeMixin extends ItemTool {
    protected ItemPickaxeMixin(float p_i45333_1_, ToolMaterial p_i45333_2_, Set<Block> p_i45333_3_) {
        super(p_i45333_1_, p_i45333_2_, p_i45333_3_);
    }

    @Inject(method = "func_150897_b", at = @At("RETURN"), cancellable = true)
    private void isSuitableFor(Block block, CallbackInfoReturnable<Boolean> cir) {
        if (Objects.equals(block.getMaterial(), Material.glass)) {
            cir.setReturnValue(true);
        }
    }

    @Inject(method = "func_150893_a", at = @At("RETURN"), cancellable = true)
    private void getMiningSpeedMultiplier(ItemStack stack, Block block, CallbackInfoReturnable<Float> cir) {
        if (Objects.equals(block.getMaterial(), Material.glass)) {
            cir.setReturnValue(this.efficiencyOnProperMaterial);
        }
    }
}
