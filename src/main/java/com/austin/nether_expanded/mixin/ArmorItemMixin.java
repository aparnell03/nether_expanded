package com.austin.nether_expanded.mixin;

import com.austin.nether_expanded.item.ModArmorMaterials;
import com.austin.nether_expanded.item.ModItems;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.*;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.UUID;

    @Mixin (ArmorItem.class)
    public abstract class ArmorItemMixin {

        @Shadow @Final private static UUID[] MODIFIERS;
        @Shadow @Final @Mutable private Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;
        @Shadow @Final protected float knockbackResistance;
        @Shadow public abstract @Nullable SoundEvent getEquipSound();

        @Inject(method = "<init>", at = @At(value = "RETURN"))
        private void constructor(ArmorMaterial material, EquipmentSlot slot, Item.Settings settings, CallbackInfo ci) {
            UUID uUID = MODIFIERS[slot.getEntitySlotId()];

            if (material != ArmorMaterials.NETHERITE && this.getEquipSound() != SoundEvents.ITEM_ARMOR_EQUIP_ELYTRA) {
                ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();

                this.attributeModifiers.forEach(builder::put);

                builder.put(
                        EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE,
                        new EntityAttributeModifier(uUID,
                                "Armor knockback resistance",
                                this.knockbackResistance,
                                EntityAttributeModifier.Operation.ADDITION
                        )
                );

                this.attributeModifiers = builder.build();
            }
        }

    }
