package ch.fantasticgame28.jes.mixin;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.*;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.item.Item;

@Mixin(SwordItem.class)
public class SwordChanges extends ToolItem {
    @Mutable
    @Final
    @Shadow
    private
    Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;

    public SwordChanges(ToolMaterial material, Settings settings) {
        super(material, settings);
    }


    @Inject(method = "<init>", at = @At("TAIL"))
    private void changeDamage(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Item.Settings settings, CallbackInfo ci) {
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "Weapon modifier", 0.0, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID, "Weapon modifier", -2.4f, EntityAttributeModifier.Operation.ADDITION));
        this.attributeModifiers = builder.build();
    }
}
