package com.austin.nether_expanded;

import com.austin.nether_expanded.block.ModBlocks;
import com.austin.nether_expanded.block.entity.ModBlockEntities;
import com.austin.nether_expanded.effect.ModStatusEffects;
import com.austin.nether_expanded.enchantment.ModEnchantments;
import com.austin.nether_expanded.entity.BloodZombieEntity;
import com.austin.nether_expanded.entity.ModEntities;
import com.austin.nether_expanded.item.ModItems;
import com.austin.nether_expanded.potion.ModPotions;
import com.austin.nether_expanded.particle.ModParticleTypes;
import com.austin.nether_expanded.recipe.ModRecipes;
import com.austin.nether_expanded.client.render.block.ModBlockRenderer;
import com.austin.nether_expanded.world.gen.ModWorldGen;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NetherExpanded implements ModInitializer {

	public static final EntityType<BloodZombieEntity> BLOOD_ZOMBIE = Registry.register(
			Registry.ENTITY_TYPE,
			new Identifier(NetherExpanded.MOD_ID, "blood_zombie"),
			FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, BloodZombieEntity::new).dimensions(EntityDimensions.fixed(0.6f, 1.95f)).build()
	);

	public static final String MOD_ID = "nether_expanded";
	public static final Logger LOGGER = LoggerFactory.getLogger("nether_expanded");
	public static TagKey<Item> PIGLIN_SAFE_ARMOR = TagKey.of(Registry.ITEM_KEY, new Identifier(NetherExpanded.MOD_ID, "piglin_safe_armor"));

	@Override
	public void onInitialize() {
		FabricDefaultAttributeRegistry.register(BLOOD_ZOMBIE, BloodZombieEntity.createZombieAttributes());

		ModEntities.registerModEntities();
		ModWorldGen.generateModWorldGen();
		ModStatusEffects.registerModStatusEffects();
		ModEnchantments.registerModEnchantments();
		ModItems.registerModItems();
		ModPotions.registerModPotions();
		ModBlocks.registerModBlocks();
		ModBlockEntities.registerAllEntities();
		ModParticleTypes.registerModParticles();
		ModBlockRenderer.setRenderLayers();
		ModRecipes.register();
		LOGGER.info("i love you Andrew, rest in peace <3");


	}
}
