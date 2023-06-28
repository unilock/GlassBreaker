package cc.unilock.glassbreaker.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.item.*;
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
    private final Class<? extends Item> miningToolItem = this.asItem().getClass();

    @Inject(method = "getMiningSpeedMultiplier", at = @At("HEAD"), cancellable = true)
    private void glassbreaker$getMiningSpeedMultiplier(ItemStack stack, BlockState state, CallbackInfoReturnable<Float> cir) {
        if (glassbreaker$isGlass(state) && (miningToolItem.equals(PickaxeItem.class) || miningToolItem.equals(AxeItem.class))) {
            cir.setReturnValue(this.miningSpeed);
        }
    }

    @Inject(method = "isSuitableFor", at = @At("HEAD"), cancellable = true)
    private void glassbreaker$isSuitableFor(BlockState state, CallbackInfoReturnable<Boolean> cir) {
        if (glassbreaker$isGlass(state) && (miningToolItem.equals(PickaxeItem.class) || miningToolItem.equals(AxeItem.class))) {
            cir.setReturnValue(true);
        }
    }

    private static boolean glassbreaker$isGlass(BlockState state) {
        return state.getMaterial().equals(Material.GLASS);
    }

    /*
     * TODO: optimize this?
     *  currently, it's likely very wasteful when mining any block that ISN'T glass
     *  (though i'm not sure how one would fix that)
     *
    private static boolean glassbreaker$isGlassByTag(BlockState state) {
        if (
            // - fallbacks (loader-agnostic)
                state.getSoundGroup().equals(BlockSoundGroup.GLASS)
                || state.getInstrument().equals(Instrument.HAT)
                // - block tags
                // common tags
                || state.isIn(TagKey.of(RegistryKeys.BLOCK, Identifier.of("c", "glass")))
                || state.isIn(TagKey.of(RegistryKeys.BLOCK, Identifier.of("c", "glass_blocks")))
                // forge tags
                || state.isIn(TagKey.of(RegistryKeys.BLOCK, Identifier.of("forge", "glass")))
                || state.isIn(TagKey.of(RegistryKeys.BLOCK, Identifier.of("forge", "glass_panes")))
        ) {
            return true;
        }

        // the below conditional is separate so we can store the default stack
        // instead of having to get() it each time
        ItemStack stateStack = state.getBlock().asItem().getDefaultStack();

        return  // - item tags
                // common tags
                stateStack.isIn(TagKey.of(RegistryKeys.ITEM, Identifier.of("c", "glass")))
                || stateStack.isIn(TagKey.of(RegistryKeys.ITEM, Identifier.of("c", "glass_blocks")))
                || stateStack.isIn(TagKey.of(RegistryKeys.ITEM, Identifier.of("c", "glass_pane")))
                || stateStack.isIn(TagKey.of(RegistryKeys.ITEM, Identifier.of("c", "glass_panes")))
                // forge tags
                || stateStack.isIn(TagKey.of(RegistryKeys.ITEM, Identifier.of("forge", "glass")))
                || stateStack.isIn(TagKey.of(RegistryKeys.ITEM, Identifier.of("forge", "glass_panes")));
    }
     */
}
