package org.wishtoday.egar.mixin.goldApple;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(EnchantmentHelper.class)
public class EnchantmentHelperMixin {
    @ModifyExpressionValue(method = "getAvailableEnchantmentResults"
            , at = @At(value = "INVOKE"
            , target = "Lnet/minecraft/world/item/ItemStack;is(Lnet/minecraft/world/item/Item;)Z"))
    private static boolean getPossibleEntries(boolean original, @Local(argsOnly = true) ItemStack stack) {
        System.out.println("EnchantmentHelper.getPossibleEntries() called");
        return stack.is(Items.BOOK) || stack.is(Items.GOLDEN_APPLE);
    }
    @ModifyExpressionValue(method = "getEnchantmentCost", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/Item;getEnchantmentValue()I"))
    private static int getEnchantmentValue(int original, @Local Item item) {
        System.out.println("EnchantmentHelper.getEnchantmentValue() called");
        return item.getEnchantmentValue();
    }
}
