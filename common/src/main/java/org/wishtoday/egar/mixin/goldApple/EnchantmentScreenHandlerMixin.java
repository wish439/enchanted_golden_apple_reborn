package org.wishtoday.egar.mixin.goldApple;


import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.EnchantmentMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EnchantmentMenu.class)
public class EnchantmentScreenHandlerMixin {
    @Shadow
    @Final
    private Container enchantSlots;

    @Inject(method = "clickMenuButton", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/inventory/ContainerLevelAccess;execute(Ljava/util/function/BiConsumer;)V", shift = At.Shift.AFTER))
    private void onButtonClick(Player pPlayer, int pId, CallbackInfoReturnable<Boolean> cir) {
        ItemStack stack = this.enchantSlots.getItem(0);
        if (!stack.is(Items.GOLDEN_APPLE)) return;
        this.enchantSlots.setItem(0, Items.ENCHANTED_GOLDEN_APPLE.getDefaultInstance());
    }
}
