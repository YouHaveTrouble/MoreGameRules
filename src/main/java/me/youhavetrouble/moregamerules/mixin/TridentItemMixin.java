package me.youhavetrouble.moregamerules.mixin;

import me.youhavetrouble.moregamerules.ExtraGameRule;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.TridentItem;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TridentItem.class)
public class TridentItemMixin {

    @Inject(method = "onStoppedUsing", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;addVelocity(DDD)V", shift = At.Shift.BEFORE))
    private void injected(ItemStack stack, World world, LivingEntity user, int remainingUseTicks, CallbackInfo ci) {
        ItemStack chestItem = user.getEquippedStack(EquipmentSlot.CHEST);
        int damage = user.world.getGameRules().getInt(ExtraGameRule.ELYTRA_DAMAGE_FROM_RIPTIDE_BOOST);
        if (!chestItem.isOf(Items.ELYTRA) || damage == 0) return;
        if (chestItem.getDamage() + damage >= chestItem.getMaxDamage() ) {
            chestItem.setDamage(chestItem.getMaxDamage()-1);
        } else {
            chestItem.damage(damage, user, ((player) -> player.sendEquipmentBreakStatus(EquipmentSlot.CHEST)));
        }
    }

}
