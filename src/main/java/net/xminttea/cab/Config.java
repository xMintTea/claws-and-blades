package net.xminttea.cab;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class Config {

    public static float werewolfDamageMultiplier = 1.0f;

    public static void synchronizeConfiguration(File configFile) {
        Configuration configuration = new Configuration(configFile);

        werewolfDamageMultiplier = configuration.getFloat(
            "werewolfDamageMultiplier",
            Configuration.CATEGORY_GENERAL,
            werewolfDamageMultiplier,
            0.0f,
            Float.MAX_VALUE,
            "");

        if (configuration.hasChanged()) {
            configuration.save();
        }
    }
}
