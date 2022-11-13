package me.youhavetrouble.moregamerules.mixin;

import me.youhavetrouble.moregamerules.ExtraGameRule;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.MagmaBlock;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MagmaBlock.class)
public class MagmaBlockMixin extends Block {

	public MagmaBlockMixin(Settings settings) {
		super(settings);
	}

	@Inject(at = @At("HEAD"), method = "onSteppedOn", cancellable = true)
	private void injectedOnSteppedOn(World world, BlockPos pos, BlockState state, Entity entity, CallbackInfo info) {
		if (!world.getGameRules().getBoolean(ExtraGameRule.MAGMA_BLOCK_DAMAGE)) info.cancel();
	}
}
