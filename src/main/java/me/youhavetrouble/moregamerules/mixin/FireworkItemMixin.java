package me.youhavetrouble.moregamerules.mixin;

import me.youhavetrouble.moregamerules.ExtraGameRule;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FireworkRocketItem.class)
public class FireworkItemMixin {

    @Inject(method = "use", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/projectile/FireworkRocketEntity;<init>(Lnet/minecraft/world/World;Lnet/minecraft/item/ItemStack;Lnet/minecraft/entity/LivingEntity;)V", shift = At.Shift.AFTER))
    private void injected(World world, PlayerEntity user, Hand hand, CallbackInfoReturnable<TypedActionResult<ItemStack>> cir) {
        ItemStack chestItem = user.getEquippedStack(EquipmentSlot.CHEST);
        int damage = user.world.getGameRules().getInt(ExtraGameRule.ELYTRA_DAMAGE_FROM_FIREWORK_BOOST);
        if (!chestItem.isOf(Items.ELYTRA) || damage == 0) return;
        if (chestItem.getDamage() + damage >= chestItem.getMaxDamage() ) {
            chestItem.setDamage(chestItem.getMaxDamage()-1);
        } else {
            chestItem.damage(damage, (LivingEntity)user, ((player) -> player.sendEquipmentBreakStatus(EquipmentSlot.CHEST)));
        }
    }

}
