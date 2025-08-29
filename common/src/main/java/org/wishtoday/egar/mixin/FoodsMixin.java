package org.wishtoday.egar.mixin;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Foods.class)
public class FoodsMixin {
    @Mutable
    @Shadow @Final public static FoodProperties ENCHANTED_GOLDEN_APPLE;

    @Inject(method = "<clinit>",at = @At("TAIL"))
    private static void onClinit(CallbackInfo ci) {

        ENCHANTED_GOLDEN_APPLE = new FoodProperties.Builder()
                .nutrition(4)
                .saturationMod(1.2F)
                .effect(new MobEffectInstance(MobEffects.REGENERATION, 20 * 60, 4), 1.0F)
                .effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000, 0), 1.0F)
                .effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000, 0), 1.0F)
                .effect(new MobEffectInstance(MobEffects.ABSORPTION, 2400, 3), 1.0F)
                .alwaysEat()
                .build();
    }
}
