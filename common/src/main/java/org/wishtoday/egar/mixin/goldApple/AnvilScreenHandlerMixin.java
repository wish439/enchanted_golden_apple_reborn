package org.wishtoday.egar.mixin.goldApple;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AnvilMenu.class)
public abstract class AnvilScreenHandlerMixin extends ItemCombinerMenu {
    @Final
    @Shadow
    private DataSlot cost;

    public AnvilScreenHandlerMixin(@Nullable MenuType<?> pType, int pContainerId, Inventory pPlayerInventory, ContainerLevelAccess pAccess) {
        super(pType, pContainerId, pPlayerInventory, pAccess);
    }


    @Inject(method = "createResult", at = @At(value = "RETURN"), cancellable = true)
    private void onUpdateResult(CallbackInfo ci) {
        ItemStack stack = this.inputSlots.getItem(0);
        ItemStack stack1 = this.inputSlots.getItem(1);
        if (stack.getItem() == Items.GOLDEN_APPLE && stack1.getItem() == Items.ENCHANTED_BOOK) {
            this.resultSlots.setItem(0, new ItemStack(Items.ENCHANTED_GOLDEN_APPLE, stack.getCount()));
            this.cost.set(1);
            this.broadcastChanges();
            ci.cancel();
        }
    }
}