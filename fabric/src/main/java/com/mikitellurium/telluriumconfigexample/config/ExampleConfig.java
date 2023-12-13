package com.mikitellurium.telluriumconfigexample.config;

import com.mikitellurium.telluriumconfigexample.TelluriumConfigExampleMod;
import com.mikitellurium.telluriumconfigexample.api.TelluriumConfig;

public class ExampleConfig {
    // Create a new config builder
    public static TelluriumConfig CONFIG = new TelluriumConfig(TelluriumConfigExampleMod.MOD_ID);

    // Create some configs
    public static TelluriumConfig.ConfigEntry<Integer> INT_CONFIG;
    public static TelluriumConfig.ConfigEntry<String> STRING_CONFIG;
    public static TelluriumConfig.ConfigEntry<Boolean> BOOLEAN_CONFIG;
    public static TelluriumConfig.RangedConfigEntry<Integer> INT_RANGED_CONFIG;
    public static TelluriumConfig.RangedConfigEntry<Double> DOUBLE_RANGED_CONFIG;
    public static TelluriumConfig.RangedConfigEntry<Long> LONG_RANGED_CONFIG;
    public static TelluriumConfig.ConfigEntry<String> MULTIPLE_COMMENTS_CONFIG;

    // This will be called on mod init
    public static void buildConfig() {
        // Add comments to the file that will be written at the top
        CONFIG.comment("TelluriumConfig Example")
                .comment("")
                .comment("This is an example on how to use the TelluriumConfig class");

        // Define the configs, the comment is optional
        INT_CONFIG = CONFIG.entryBuilder()
                .define("intConfig", 20);

        STRING_CONFIG = CONFIG.entryBuilder()
                .define("stringConfig", "Hello Minecraft!");

        BOOLEAN_CONFIG = CONFIG.entryBuilder()
                .comment("Is this true or false?")
                .define("booleanConfig", true);

        INT_RANGED_CONFIG = CONFIG.entryBuilder()
                .comment("This integer is always inside this range")
                .defineInRange("intRangedConfig", 5, 15, 10);

        DOUBLE_RANGED_CONFIG = CONFIG.entryBuilder()
                .comment("This double is always inside this range")
                .defineInRange("doubleRangedConfig", 1.0D, 2.0D, 1.2D);

        LONG_RANGED_CONFIG = CONFIG.entryBuilder()
                .comment("This long is always inside this range")
                .defineInRange("longRangedConfig", 10000L, 100000L, 25000L);

        MULTIPLE_COMMENTS_CONFIG = CONFIG.entryBuilder()
                .comment("This entry has multiple comments.")
                .comment("Here is another one.")
                .comment("And a third.")
                .define("multipleCommentsEntry", "I have more than one comment line");

        // Build our config file, always do this for last
        CONFIG.build();
    }

}
