package me.youhavetrouble.moregamerules.mixin;

import me.youhavetrouble.moregamerules.ExtraGameRule;
import net.minecraft.entity.player.PlayerEntity;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {

    @Redirect(method = "attack", at = @At(value = "FIELD", target = "Lnet/minecraft/entity/player/PlayerEntity;fallDistance:F", opcode = Opcodes.GETFIELD))
    private float injected(PlayerEntity instance) {
        if (instance.world.getGameRules().getBoolean(ExtraGameRule.PLAYER_CRITS)) {
            return instance.fallDistance;
        }
        return 0f;
    }

}
