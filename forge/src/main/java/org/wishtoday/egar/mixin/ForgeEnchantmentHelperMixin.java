package org.wishtoday.egar.mixin;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EnchantmentHelper.class)
public abstract class ForgeEnchantmentHelperMixin {

    /*@WrapOperation(method = "getAvailableEnchantmentResults", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;is(Lnet/minecraft/world/item/Item;)Z"))
    private static boolean getAvailableEnchantmentResults(ItemStack instance
            , Item item
            , Operation<Boolean> original) {
        if (instance.is(Items.GOLDEN_APPLE)) return true;
        else return original.call(instance, item);
    }*/

    /*@Redirect(method = "getAvailableEnchantmentResults", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;is(Lnet/minecraft/world/item/Item;)Z"))
    private static boolean onGet(ItemStack instance, Item item) {
    
        *//*List<EnchantmentInstance> list = Lists.newArrayList();
        boolean flag = stack.is(Items.BOOK) || stack.is(Items.GOLDEN_APPLE);
        for (Enchantment enchantment : BuiltInRegistries.ENCHANTMENT) {
            if (((!enchantment.isTreasureOnly() || allowTreasure) && enchantment.isDiscoverable() && (enchantment.canApplyAtEnchantingTable(stack) || flag && enchantment.isAllowedOnBooks())) || stack.is(Items.GOLDEN_APPLE)) {
                for (int i = enchantment.getMaxLevel(); i > enchantment.getMinLevel() - 1; --i) {
                    if (level >= enchantment.getMinCost(i) && level <= enchantment.getMaxCost(i)) {
                        list.add(new EnchantmentInstance(enchantment, i));
                        break;
                    }
                }
            }
        }
        cir.setReturnValue(list);*//*
        return instance.is(Items.GOLDEN_APPLE) || instance.is(Items.BOOK);
    }*/
}
