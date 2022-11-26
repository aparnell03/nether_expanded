package com.austin.nether_expanded.world.gen;

import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.structure.Structure;

public interface ModStructureTags {
    TagKey<Structure> FORTRESS = of("fortress");


    private static TagKey<Structure> of(String id) {
        return TagKey.of(Registry.STRUCTURE_KEY, new Identifier(id));
    }
}
