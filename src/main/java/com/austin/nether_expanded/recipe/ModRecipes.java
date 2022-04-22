package com.austin.nether_expanded.recipe;

import com.austin.nether_expanded.NetherExpanded;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModRecipes {
    public static void register() {
        Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(NetherExpanded.MOD_ID, ForgeRecipe.Serializer.ID),
                ForgeRecipe.Serializer.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, new Identifier(NetherExpanded.MOD_ID, ForgeRecipe.Type.ID),
                ForgeRecipe.Type.INSTANCE);
    }
}
