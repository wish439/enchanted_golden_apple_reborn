package org.wishtoday.egar.mixin;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;


@Mixin(Consumables.class)
public abstract class ConsumablesMixin {
    @Shadow
    @Final
    @Mutable
    public static Consumable ENCHANTED_GOLDEN_APPLE;

    @Shadow
    public static Consumable.Builder defaultFood() {
        return null;
    }

    @SuppressWarnings("DataFlowIssue")
    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void onClinit(CallbackInfo ci) {
        ENCHANTED_GOLDEN_APPLE = defaultFood()
                .onConsume(
                        new ApplyStatusEffectsConsumeEffect(List.of(
                                        new MobEffectInstance(MobEffects.REGENERATION, 20 * 60, 4)
                                        , new MobEffectInstance(MobEffects.RESISTANCE, 6000, 0)
                                        , new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000, 0)
                                        , new MobEffectInstance(MobEffects.ABSORPTION, 2400, 3))))
                .build();
    }
}
