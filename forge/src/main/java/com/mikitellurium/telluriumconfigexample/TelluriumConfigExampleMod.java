package com.mikitellurium.telluriumconfigexample;

import com.mikitellurium.telluriumconfigexample.config.ExampleConfig;
import com.mojang.logging.LogUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(TelluriumConfigExampleMod.MOD_ID)
public class TelluriumConfigExampleMod {

    public static final String MOD_ID = "telluriumconfigexample";
    private static final Logger LOGGER = LogUtils.getLogger();

    public TelluriumConfigExampleMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // Build our config file
        ExampleConfig.buildConfig();
    }

    @SubscribeEvent
    public void onPlayerJoinWorld(EntityJoinLevelEvent event) {
        if (event.getEntity() instanceof ServerPlayer) {
            // Send a message on world join using the values specified in our config file
            event.getEntity().sendSystemMessage(Component.literal("Int config is: " + ExampleConfig.INT_CONFIG.getValue()));
            event.getEntity().sendSystemMessage(Component.literal("String config says: " + ExampleConfig.STRING_CONFIG.getValue()));
            event.getEntity().sendSystemMessage(Component.literal("Boolean config is: " + ExampleConfig.BOOLEAN_CONFIG.getValue()));
            event.getEntity().sendSystemMessage(Component.literal("Int ranged config is: " + ExampleConfig.INT_RANGED_CONFIG.getValue()));
            event.getEntity().sendSystemMessage(Component.literal("Double ranged config is: " + ExampleConfig.DOUBLE_RANGED_CONFIG.getValue()));
            event.getEntity().sendSystemMessage(Component.literal("Long ranged config is: " + ExampleConfig.LONG_RANGED_CONFIG.getValue()));
        }
    }

}
