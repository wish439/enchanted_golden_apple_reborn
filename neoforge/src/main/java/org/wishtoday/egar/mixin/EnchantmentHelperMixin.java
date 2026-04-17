package org.wishtoday.egar.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.function.Predicate;

@Mixin(EnchantmentHelper.class)
public class EnchantmentHelperMixin {
    @ModifyExpressionValue(method = "getAvailableEnchantmentResults", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;is(Ljava/lang/Object;)Z"))
    private static boolean getPossibleEntries(boolean original, @Local(argsOnly = true) ItemStack stack) {
        return stack.is(Items.BOOK) || stack.is(Items.GOLDEN_APPLE);
    }
    @Redirect(method = "getAvailableEnchantmentResults", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;is(Ljava/lang/Object;)Z"))
    private static boolean onGet(ItemStack instance, Object object) {
        return instance.is(Items.GOLDEN_APPLE) || instance.is(Items.BOOK);
    }
    @ModifyArg(method = "getAvailableEnchantmentResults", at = @At(value = "INVOKE", target = "Ljava/util/stream/Stream;filter(Ljava/util/function/Predicate;)Ljava/util/stream/Stream;"), index = 0)
    private static Predicate<? super Holder<@NotNull Enchantment>> on(Predicate<? super Holder<Enchantment>> predicate, @Local(argsOnly = true) ItemStack stack) {
        return holder -> stack.isPrimaryItemFor(holder) || stack.getItem() == Items.GOLDEN_APPLE;
    }
}
