package net.xminttea.cab.mixins;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.xminttea.cab.Config;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.emoniph.witchery.common.ExtendedPlayer;
import com.emoniph.witchery.common.Shapeshift;

@Mixin(Shapeshift.class)
public class MixinWitcheryShapeshift {

    @Shadow
    public boolean isWolfAnimalForm(ExtendedPlayer playerEx) {
        return false;
    }

    @Inject(method = "updateChargeDamage", at = @At("HEAD"), cancellable = true, remap = false)
    private void onUpdateChargeDamage(LivingHurtEvent event, EntityPlayer player, ExtendedPlayer playerEx,
        CallbackInfo ci) {
        if (isWolfAnimalForm(playerEx) && player.getHeldItem() != null) {
            event.ammount *= Config.werewolfDamageMultiplier;
            ci.cancel();
        }
    }

}
