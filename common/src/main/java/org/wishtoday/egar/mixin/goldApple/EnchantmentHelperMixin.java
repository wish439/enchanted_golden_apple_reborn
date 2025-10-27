package org.wishtoday.egar.mixin.goldApple;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EnchantmentHelper.class)
public class EnchantmentHelperMixin {
    @ModifyExpressionValue(method = "getAvailableEnchantmentResults"
            , at = @At(value = "INVOKE"
            , target = "Lnet/minecraft/world/item/ItemStack;is(Lnet/minecraft/world/item/Item;)Z"))
    private static boolean getPossibleEntries(boolean original, @Local(argsOnly = true) ItemStack stack) {
        return stack.is(Items.BOOK) || stack.is(Items.GOLDEN_APPLE);
    }
    @ModifyExpressionValue(method = "getEnchantmentCost", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/Item;getEnchantmentValue()I"))
    private static int getEnchantmentValue(int original, @Local Item item) {
        return item.getEnchantmentValue();
    }
    @Redirect(method = "getAvailableEnchantmentResults", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;is(Lnet/minecraft/world/item/Item;)Z"))
    private static boolean onGet(ItemStack instance, Item item) {
        return instance.is(Items.GOLDEN_APPLE) || instance.is(Items.BOOK);
    }
}
