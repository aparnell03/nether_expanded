package com.austin.nether_expanded.loot.condition;

import net.minecraft.loot.condition.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonSerializer;
import net.minecraft.util.JsonSerializing;
import net.minecraft.util.registry.Registry;

import java.util.function.Predicate;

public class ModLootConditionTypes {
    public static final LootConditionType SOUL_REND = ModLootConditionTypes.register("soul_rend", new SoulRendLootCondition.Serializer());


    private static LootConditionType register(String id, JsonSerializer<? extends LootCondition> serializer) {
        return Registry.register(Registry.LOOT_CONDITION_TYPE, new Identifier(id), new LootConditionType(serializer));
    }

    public static Object createGsonSerializer() {
        return JsonSerializing.createSerializerBuilder(Registry.LOOT_CONDITION_TYPE, "condition", "condition", LootCondition::getType).build();
    }

    public static <T> Predicate<T> joinAnd(Predicate<T>[] predicates2) {
        switch (predicates2.length) {
            case 0: {
                return predicates -> true;
            }
            case 1: {
                return predicates2[0];
            }
            case 2: {
                return predicates2[0].and(predicates2[1]);
            }
        }
        return operand -> {
            for (Predicate predicate : predicates2) {
                if (predicate.test(operand)) continue;
                return false;
            }
            return true;
        };
    }

    public static <T> Predicate<T> joinOr(Predicate<T>[] predicates2) {
        switch (predicates2.length) {
            case 0: {
                return predicates -> false;
            }
            case 1: {
                return predicates2[0];
            }
            case 2: {
                return predicates2[0].or(predicates2[1]);
            }
        }
        return operand -> {
            for (Predicate predicate : predicates2) {
                if (!predicate.test(operand)) continue;
                return true;
            }
            return false;
        };
    }
}
