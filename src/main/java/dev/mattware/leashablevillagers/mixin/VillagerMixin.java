package dev.mattware.leashablevillagers.mixin;

import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MerchantEntity.class)
public class VillagerMixin {
    @Inject(method = "canBeLeashedBy", at = @At("HEAD"), cancellable = true)
    private void beLeashed(PlayerEntity player, @NotNull CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(true);
    }
}
