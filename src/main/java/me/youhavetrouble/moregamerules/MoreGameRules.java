package me.youhavetrouble.moregamerules;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoreGameRules implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("MoreGameRules");

	@Override
	public void onInitialize() {
		ExtraGameRule.init();
		LOGGER.info("Finished loading up!");
	}
}
