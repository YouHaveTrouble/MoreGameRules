package me.youhavetrouble.moregamerules;

import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.GameRules;

public class ExtraGameRule {

    public static GameRules.Key<GameRules.BooleanRule> MAGMA_BLOCK_DAMAGE;
    public static GameRules.Key<GameRules.IntRule> LIGHTNING_ROD_RANGE;

    protected static void init() {
        MAGMA_BLOCK_DAMAGE = GameRuleRegistry.register(
                "magmaBlockDamage",
                GameRules.Category.MISC,
                GameRuleFactory.createBooleanRule(true)
        );
        LIGHTNING_ROD_RANGE = GameRuleRegistry.register(
                "lightningRodRange",
                GameRules.Category.MISC,
                GameRuleFactory.createIntRule(128, 0, Integer.MAX_VALUE)
        );
    }

}
