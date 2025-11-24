package org.wishtoday.egar.mixin.goldApple;

import net.minecraft.util.RandomSource;
import net.minecraft.world.inventory.EnchantmentMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(EnchantmentMenu.class)
public class EnchantmentMenuMixin {
    @Shadow
    @Final
    private RandomSource random;

    @Inject(method = "getEnchantmentList", at = @At(value = "RETURN"), cancellable = true)
    private void onEnchantmentList(ItemStack stack, int enchantSlot, int level, CallbackInfoReturnable<List<EnchantmentInstance>> cir) {
        List<EnchantmentInstance> list = cir.getReturnValue();
        if (stack.is(Items.GOLDEN_APPLE) && list.size() > 1) {
            list.remove(this.random.nextInt(list.size()));
        }
        cir.setReturnValue(list);
    }
}
