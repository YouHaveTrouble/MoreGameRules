package me.youhavetrouble.moregamerules;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.GameRules;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoreGameRules implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("moregamerules");

	public static GameRules.Key<GameRules.BooleanRule> MAGMA_BLOCK_DAMAGE;

	@Override
	public void onInitialize() {

		MAGMA_BLOCK_DAMAGE = GameRuleRegistry.register(
				"magmaBlockDamage",
				GameRules.Category.MISC,
				GameRuleFactory.createBooleanRule(true)
		);

		LOGGER.info("Finished loading up!");
	}
}
