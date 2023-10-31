package cc.unilock.glassbreaker.mixin;

import cc.unilock.glassbreaker.GlassBreaker;
import cc.unilock.glassbreaker.ModCompat;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.PickaxeItem;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MiningToolItem.class)
public class MixinMiningToolItem extends Item {
    public MixinMiningToolItem(Settings settings) {
        super(settings);
    }

    @Shadow
    @Final
    protected float miningSpeed;

    @Unique
    private final Class<? extends Item> glassbreaker$miningToolItem = this.asItem().getClass();

    @Inject(method = "getMiningSpeedMultiplier", at = @At("HEAD"), cancellable = true)
    private void getMiningSpeedMultiplier(ItemStack stack, BlockState state, CallbackInfoReturnable<Float> cir) {
        if (glassbreaker$isGlass(state) && glassbreaker$miningToolItem.equals(PickaxeItem.class)) {
            cir.setReturnValue(this.miningSpeed);
        }
    }

    // TODO: need to get the MiningToolItem's actual ItemStack passed from this mixin somehow?
    //       or maybe mix into whatever checks if a block is in a particular tag... uh oh
    @Inject(method = "isSuitableFor", at = @At("HEAD"), cancellable = true)
    private void isSuitableFor(BlockState state, CallbackInfoReturnable<Boolean> cir) {
        if (glassbreaker$isGlass(state) && (glassbreaker$miningToolItem.equals(PickaxeItem.class) || ModCompat.isSuitableTool(this))) {
            cir.setReturnValue(true);
        }
    }

    @Unique
    private static boolean glassbreaker$isGlass(BlockState state) {
        return state.getBlock().asItem().getDefaultStack().isIn(GlassBreaker.GLASS_ITEMS)
                || state.getMaterial().equals(Material.GLASS);
    }
}
