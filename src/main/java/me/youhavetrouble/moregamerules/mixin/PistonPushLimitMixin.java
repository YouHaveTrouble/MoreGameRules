package me.youhavetrouble.moregamerules.mixin;

import me.youhavetrouble.moregamerules.ExtraGameRule;
import net.minecraft.block.piston.PistonHandler;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

import java.lang.reflect.Field;

@Mixin(PistonHandler.class)
public class PistonPushLimitMixin {

    @ModifyConstant(method = "tryMove", constant = @Constant(intValue = 12))
    private int injectedPushLimit(int range) throws NoSuchFieldException, IllegalAccessException {
        PistonHandler pistonHandler = (PistonHandler)(Object) this;

        // Get the associated world
        Field worldField = PistonHandler.class.getDeclaredField("world");
        worldField.setAccessible(true);
        World world = (World) worldField.get(pistonHandler);

        return world.getGameRules().getInt(ExtraGameRule.PISTON_PUSH_LIMIT);
    }

}
