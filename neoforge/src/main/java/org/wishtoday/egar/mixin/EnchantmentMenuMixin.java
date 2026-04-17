package org.wishtoday.egar.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.world.inventory.EnchantmentMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(EnchantmentMenu.class)
public class EnchantmentMenuMixin {
    @ModifyExpressionValue(method = "getEnchantmentList", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;is(Ljava/lang/Object;)Z"))
    private boolean onEnchantmentList(boolean original, @Local(argsOnly = true) ItemStack stack) {
        return stack.is(Items.BOOK) || stack.is(Items.GOLDEN_APPLE);
    }
}
