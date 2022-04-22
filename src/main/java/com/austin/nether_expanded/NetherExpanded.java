package com.austin.nether_expanded;

import com.austin.nether_expanded.block.ModBlocks;
import com.austin.nether_expanded.block.entity.ModBlockEntities;
import com.austin.nether_expanded.effect.ModStatusEffects;
import com.austin.nether_expanded.enchantment.ModEnchantments;
import com.austin.nether_expanded.item.ModItems;
import com.austin.nether_expanded.potion.ModPotions;
import com.austin.nether_expanded.particle.ModParticleTypes;
import com.austin.nether_expanded.recipe.ModRecipes;
import com.austin.nether_expanded.util.ModRender;
import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NetherExpanded implements ModInitializer {


	public static final String MOD_ID = "nether_expanded";
	public static final Logger LOGGER = LoggerFactory.getLogger("nether_expanded");
	public static TagKey<Item> PIGLIN_SAFE_ARMOR = TagKey.of(Registry.ITEM_KEY, new Identifier(NetherExpanded.MOD_ID, "piglin_safe_armor"));

	@Override
	public void onInitialize() {

		ModStatusEffects.registerModStatusEffects();
		ModEnchantments.registerModEnchantments();
		ModItems.registerModItems();
		ModPotions.registerModPotions();
		ModBlocks.registerModBlocks();
		ModBlockEntities.registerAllEntities();
		ModParticleTypes.registerModParticles();
		ModRender.setRenderLayers();
		ModRecipes.register();
		LOGGER.info("i'm so tired");
	}
}
