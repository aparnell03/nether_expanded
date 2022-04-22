package com.austin.nether_expanded.loot.condition;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.loot.condition.*;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.context.LootContextParameter;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.JsonSerializer;

import java.util.Set;

public class SoulRendLootCondition implements LootCondition {
    static final SoulRendLootCondition INSTANCE = new SoulRendLootCondition();
    private SoulRendLootCondition() {
    }

    public LootConditionType getType() {
        return ModLootConditionTypes.SOUL_REND;
    }

    public Set<LootContextParameter<?>> getRequiredParameters() {
        return ImmutableSet.of(LootContextParameters.KILLER_ENTITY);
    }

    public boolean test(LootContext lootContext) {
        Entity entity = lootContext.get(LootContextParameters.KILLER_ENTITY);
        int i = 0;
        if (entity instanceof LivingEntity) {
            i = EnchantmentHelper.getLooting((LivingEntity)entity);
        }
        return lootContext.hasParameter(LootContextParameters.KILLER_ENTITY);
    }

    public static Builder builder() {
        return () -> {
            return INSTANCE;
        };
    }

    public static class Serializer implements JsonSerializer<SoulRendLootCondition> {
        public Serializer() {
        }

        public void toJson(JsonObject jsonObject, SoulRendLootCondition soulRendLootCondition, JsonSerializationContext jsonSerializationContext) {
        }

        public SoulRendLootCondition fromJson(JsonObject jsonObject, JsonDeserializationContext jsonDeserializationContext) {
            return SoulRendLootCondition.INSTANCE;
        }
    }
}
