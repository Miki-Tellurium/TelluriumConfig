package com.mikitellurium.telluriumconfigexample;

import com.mikitellurium.telluriumconfigexample.config.ExampleConfig;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TelluriumConfigExampleMod implements ModInitializer {

	public static final String MOD_ID = "telluriumconfigexample";

	public static final Logger LOGGER = LoggerFactory.getLogger("telluriumconfigexample");

	@Override
	public void onInitialize() {
		// Build our config file
		ExampleConfig.buildConfig();

		ServerEntityEvents.ENTITY_LOAD.register(this::onWorldPlayerJoin);
	}

	private void onWorldPlayerJoin(Entity entity, ServerLevel world) {
		if (entity instanceof ServerPlayer) {
			// Send a message on world join using the values specified in our config file
			entity.sendSystemMessage(Component.literal("Int config is: " + ExampleConfig.INT_CONFIG.getValue()));
			entity.sendSystemMessage(Component.literal("String config says: " + ExampleConfig.STRING_CONFIG.getValue()));
			entity.sendSystemMessage(Component.literal("Boolean config is: " + ExampleConfig.BOOLEAN_CONFIG.getValue()));
			entity.sendSystemMessage(Component.literal("Int ranged config is: " + ExampleConfig.INT_RANGED_CONFIG.getValue()));
			entity.sendSystemMessage(Component.literal("Double ranged config is: " + ExampleConfig.DOUBLE_RANGED_CONFIG.getValue()));
			entity.sendSystemMessage(Component.literal("Long ranged config is: " + ExampleConfig.LONG_RANGED_CONFIG.getValue()));
		}
	}

}