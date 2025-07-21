package org.wishtoday.egar;


import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(Constants.MOD_ID)
public class EnchantedGoldenAppleReborn {
    public EnchantedGoldenAppleReborn(IEventBus eventBus) {
        CommonClass.init();
    }
}
