package ch.fantasticgame28.jes.mixin;

import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(SwordItem.class)
public class SwordChanges {
    @Redirect(method = "getAttackDamage", at = @At(value = "FIELD", target = "Lnet/minecraft/item/SwordItem;attackDamage:F", opcode = Opcodes.GETFIELD))
    private float damageModifier(SwordItem instance) {
        return instance.getMaterial() == ToolMaterials.WOOD ? 4.0f : 0.0f;
    }
}
