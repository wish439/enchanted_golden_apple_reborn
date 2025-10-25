package org.wishtoday.egar.mixin.goldApple;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.function.Function;

@Mixin(Items.class)
public abstract class ItemsMixin {

    @Shadow
    public static Item registerItem(ResourceKey<Item> key, Function<Item.Properties, Item> factory, Item.Properties properties) {
        return null;
    }

    @Shadow
    private static ResourceKey<Item> vanillaItemId(String name) {
        return null;
    }

    @Inject(method = "registerItem(Ljava/lang/String;Lnet/minecraft/world/item/Item$Properties;)Lnet/minecraft/world/item/Item;", at = @At("HEAD"), cancellable = true)
    private static void onRegisterItem(String name, Item.Properties properties, CallbackInfoReturnable<Item> cir) {
        if (!"golden_apple".equals(name)) return;
        cir.setReturnValue(registerItem(vanillaItemId(name), Item::new, properties.enchantable(1)));
    }
}
