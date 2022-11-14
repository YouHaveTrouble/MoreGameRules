package me.youhavetrouble.moregamerules;

import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.GameRules;

public class ExtraGameRule {

    public static GameRules.Key<GameRules.BooleanRule> MAGMA_BLOCK_DAMAGE;
    public static GameRules.Key<GameRules.IntRule> LIGHTNING_ROD_RANGE;
    public static GameRules.Key<GameRules.IntRule> ELYTRA_DAMAGE_PER_SECOND;
    public static GameRules.Key<GameRules.IntRule> ELYTRA_DAMAGE_FROM_FIREWORK_BOOST;
    public static GameRules.Key<GameRules.IntRule> ELYTRA_DAMAGE_FROM_RIPTIDE_BOOST;

    public static GameRules.Key<GameRules.BooleanRule> PLAYER_CRITS;

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
        ELYTRA_DAMAGE_PER_SECOND = GameRuleRegistry.register(
                "elytraDamagePerSecond",
                GameRules.Category.MISC,
                GameRuleFactory.createIntRule(1, 0, Integer.MAX_VALUE)
        );
        ELYTRA_DAMAGE_FROM_FIREWORK_BOOST = GameRuleRegistry.register(
                "elytraDamageFromFirework",
                GameRules.Category.MISC,
                GameRuleFactory.createIntRule(0, 0, Integer.MAX_VALUE)
        );
        ELYTRA_DAMAGE_FROM_RIPTIDE_BOOST = GameRuleRegistry.register(
                "elytraDamageFromRiptideTrident",
                GameRules.Category.MISC,
                GameRuleFactory.createIntRule(0, 0, Integer.MAX_VALUE)
        );
        PLAYER_CRITS = GameRuleRegistry.register(
                "playerCrits",
                GameRules.Category.PLAYER,
                GameRuleFactory.createBooleanRule(true)
        );
    }

}
