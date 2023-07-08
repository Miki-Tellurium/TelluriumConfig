package com.mikitellurium.telluriumconfigexample.config;

import com.mikitellurium.telluriumconfigexample.TelluriumConfigExampleMod;
import com.mikitellurium.telluriumconfigexample.api.TelluriumConfig;

import java.io.IOException;

public class ExampleConfig {
    // Create a new config builder
    public static TelluriumConfig.Builder CONFIG = new TelluriumConfig.Builder(TelluriumConfigExampleMod.MOD_ID);

    // Create some configs
    public static TelluriumConfig.ConfigEntry<Integer> INT_CONFIG;
    public static TelluriumConfig.ConfigEntry<String> STRING_CONFIG;
    public static TelluriumConfig.ConfigEntry<Boolean> BOOLEAN_CONFIG;
    public static TelluriumConfig.RangedConfigEntry<Integer> INT_RANGED_CONFIG;
    public static TelluriumConfig.RangedConfigEntry<Double> DOUBLE_RANGED_CONFIG;
    public static TelluriumConfig.RangedConfigEntry<Long> LONG_RANGED_CONFIG;

    // This will be called on mod init
    public static void buildConfig() {
        // Add comments to the file that will be written at the top
        CONFIG.comment("TelluriumConfig Example")
                .comment("")
                .comment("This is an example on how to use the TelluriumConfig class");

        // Define the configs, the comment is optional
        INT_CONFIG = CONFIG.define("intConfig", 20);

        STRING_CONFIG = CONFIG.define("stringConfig", "Hello Minecraft!");

        BOOLEAN_CONFIG = CONFIG.define("booleanConfig", true)
                .comment("Is this true or false?");

        INT_RANGED_CONFIG = CONFIG.defineInRange("intRangedConfig", 5, 15, 10)
                .comment("This integer is always inside this range");

        DOUBLE_RANGED_CONFIG = CONFIG.defineInRange("doubleRangedConfig", 1.0D, 2.0D, 1.2D)
                .comment("This double is always inside this range");

        LONG_RANGED_CONFIG = CONFIG.defineInRange("longRangedConfig", 10000L, 100000L, 25000L)
                .comment("This long is always inside this range");

        // Build our config file, always do this for last
        CONFIG.build();
    }

}
