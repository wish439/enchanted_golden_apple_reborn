package org.wishtoday.egar.mixin.goldApple;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {
    @Shadow public abstract Item getItem();

    @Inject(method = "isEnchantable", at = @At("HEAD"), cancellable = true)
    private void isEnchantable(CallbackInfoReturnable<Boolean> cir) {
        if (this.getItem() == Items.GOLDEN_APPLE) cir.setReturnValue(true);
    }
}
