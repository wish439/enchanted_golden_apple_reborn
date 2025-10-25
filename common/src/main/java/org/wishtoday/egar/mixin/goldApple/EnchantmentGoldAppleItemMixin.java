package org.wishtoday.egar.mixin.goldApple;


import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public class EnchantmentGoldAppleItemMixin {
    @Inject(method = "isEnchantable",at = @At("HEAD"), cancellable = true)
    private void isEnchantable(ItemStack stack
            , CallbackInfoReturnable<Boolean> cir) {
        if (stack.getItem() == Items.GOLDEN_APPLE) cir.setReturnValue(stack.getCount() == 1);
    }
    @Inject(method = "getEnchantmentValue", at = @At("HEAD"), cancellable = true)
    private void getEnchantability(CallbackInfoReturnable<Integer> cir) {
        Item item = (Item) (Object) this;
        if (item == Items.GOLDEN_APPLE) {
            cir.setReturnValue(1);
        }
    }
}
