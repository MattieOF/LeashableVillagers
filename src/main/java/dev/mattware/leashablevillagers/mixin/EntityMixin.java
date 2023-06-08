package dev.mattware.leashablevillagers.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.MobEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MobEntity.class)
public class EntityMixin {
    @Inject(method = "attachLeash", at = @At("TAIL"))
    private void onLeashed(Entity entity, boolean sendPacket, CallbackInfo ci) {

    }
}
