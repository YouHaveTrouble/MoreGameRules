package me.youhavetrouble.moregamerules.mixin;

import me.youhavetrouble.moregamerules.ExtraGameRule;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(ServerWorld.class)
public class ServerWorldMixin {

    @ModifyArg(method = "getLightningRodPos", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/poi/PointOfInterestStorage;getNearestPosition(Ljava/util/function/Predicate;Ljava/util/function/Predicate;Lnet/minecraft/util/math/BlockPos;ILnet/minecraft/world/poi/PointOfInterestStorage$OccupationStatus;)Ljava/util/Optional;"), index = 3)
    private int injectedGetLightningRodPos(int range) {
        ServerWorld serverWorld = (ServerWorld)(Object) this;
        return serverWorld.getGameRules().getInt(ExtraGameRule.LIGHTNING_ROD_RANGE);
    }

}
