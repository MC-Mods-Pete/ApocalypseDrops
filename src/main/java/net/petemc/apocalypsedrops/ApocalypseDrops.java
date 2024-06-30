package net.petemc.apocalypsedrops;

import net.fabricmc.api.ModInitializer;

import net.petemc.apocalypsedrops.config.ApocalypseDropsConfig;
import net.petemc.apocalypsedrops.util.ApocalypseDropsLootTableModifiers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApocalypseDrops implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "apocalypsedrops";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing Apocalypse Drops Mod");
		ApocalypseDropsConfig.init();
		ApocalypseDropsLootTableModifiers.modifyLootTables();
	}
}