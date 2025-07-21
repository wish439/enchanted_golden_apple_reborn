package org.wishtoday.egar;

import org.wishtoday.egar.platform.Services;

public class CommonClass {
    public static void init() {
        if (Services.PLATFORM.isModLoaded("enchanted_golden_apple_reborn")) {
            Constants.LOG.info("Hello to enchanted_golden_apple_reborn");
        }
    }
}
