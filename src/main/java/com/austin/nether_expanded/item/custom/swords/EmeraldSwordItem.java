package com.austin.nether_expanded.item.custom.swords;

import com.austin.nether_expanded.effect.ModStatusEffects;
import com.austin.nether_expanded.item.ModItems;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;

import java.util.Random;

public class EmeraldSwordItem extends SwordItem {

    public EmeraldSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        randomItems(target, attacker);
        return super.postHit(stack, target, attacker);
    }

    public static void randomItems(LivingEntity target, LivingEntity attacker){
        Random rand = new Random();
        int rand1 = rand.nextInt(11);
        if (attacker instanceof PlayerEntity) {
            ((PlayerEntity) attacker).addExperience(rand1);
        }

        int rand2 = rand.nextInt(3);
        int rand3 = rand.nextInt(15);
        int rand4 = rand.nextInt(24);

        if (rand2 == 0) {
            ItemEntity itemEntity = EntityType.ITEM.create(target.getWorld());
            BlockPos blockPos = target.getBlockPos();
            itemEntity.setStack(new ItemStack(Items.GOLD_NUGGET));
            itemEntity.refreshPositionAndAngles((double) blockPos.getX() + 0.5, (double) blockPos.getY() + 0.05, (double) blockPos.getZ() + 0.5, 0.0f, 0.0f);
            target.getWorld().spawnEntity(itemEntity);
            for (ServerPlayerEntity serverPlayerEntity : target.getWorld().getNonSpectatingEntities(ServerPlayerEntity.class, itemEntity.getBoundingBox().expand(5.0))) {
                Criteria.SUMMONED_ENTITY.trigger(serverPlayerEntity, itemEntity);
            }
        }
        if (rand2 == 1) {
            ItemEntity itemEntity = EntityType.ITEM.create(target.getWorld());
            BlockPos blockPos = target.getBlockPos();
            itemEntity.setStack(new ItemStack(Items.IRON_NUGGET));
            itemEntity.refreshPositionAndAngles((double) blockPos.getX() + 0.5, (double) blockPos.getY() + 0.05, (double) blockPos.getZ() + 0.5, 0.0f, 0.0f);
            target.getWorld().spawnEntity(itemEntity);
            for (ServerPlayerEntity serverPlayerEntity : target.getWorld().getNonSpectatingEntities(ServerPlayerEntity.class, itemEntity.getBoundingBox().expand(5.0))) {
                Criteria.SUMMONED_ENTITY.trigger(serverPlayerEntity, itemEntity);
            }
        }
        if (rand2 == 2) {
            ItemEntity itemEntity = EntityType.ITEM.create(target.getWorld());
            BlockPos blockPos = target.getBlockPos();
            itemEntity.setStack(new ItemStack(ModItems.COPPER_NUGGET));
            itemEntity.refreshPositionAndAngles((double) blockPos.getX() + 0.5, (double) blockPos.getY() + 0.05, (double) blockPos.getZ() + 0.5, 0.0f, 0.0f);
            target.getWorld().spawnEntity(itemEntity);
            for (ServerPlayerEntity serverPlayerEntity : target.getWorld().getNonSpectatingEntities(ServerPlayerEntity.class, itemEntity.getBoundingBox().expand(5.0))) {
                Criteria.SUMMONED_ENTITY.trigger(serverPlayerEntity, itemEntity);
            }
        }
        if(rand4 == 0){
            if (rand3 == 0) {
                ItemEntity itemEntity = EntityType.ITEM.create(target.getWorld());
                BlockPos blockPos = target.getBlockPos();
                itemEntity.setStack(new ItemStack(Items.GOLD_INGOT));
                itemEntity.refreshPositionAndAngles((double) blockPos.getX() + 0.5, (double) blockPos.getY() + 0.05, (double) blockPos.getZ() + 0.5, 0.0f, 0.0f);
                target.getWorld().spawnEntity(itemEntity);
                for (ServerPlayerEntity serverPlayerEntity : target.getWorld().getNonSpectatingEntities(ServerPlayerEntity.class, itemEntity.getBoundingBox().expand(5.0))) {
                    Criteria.SUMMONED_ENTITY.trigger(serverPlayerEntity, itemEntity);
                }
            }
            if (rand3 == 1) {
                ItemEntity itemEntity = EntityType.ITEM.create(target.getWorld());
                BlockPos blockPos = target.getBlockPos();
                itemEntity.setStack(new ItemStack(ModItems.MYSTICAL_POWDER));
                itemEntity.refreshPositionAndAngles((double) blockPos.getX() + 0.5, (double) blockPos.getY() + 0.05, (double) blockPos.getZ() + 0.5, 0.0f, 0.0f);
                target.getWorld().spawnEntity(itemEntity);
                for (ServerPlayerEntity serverPlayerEntity : target.getWorld().getNonSpectatingEntities(ServerPlayerEntity.class, itemEntity.getBoundingBox().expand(5.0))) {
                    Criteria.SUMMONED_ENTITY.trigger(serverPlayerEntity, itemEntity);
                }
            }
            if (rand3 == 2) {
                ItemEntity itemEntity = EntityType.ITEM.create(target.getWorld());
                BlockPos blockPos = target.getBlockPos();
                itemEntity.setStack(new ItemStack(ModItems.QUARTZ_CRYSTAL));
                itemEntity.refreshPositionAndAngles((double) blockPos.getX() + 0.5, (double) blockPos.getY() + 0.05, (double) blockPos.getZ() + 0.5, 0.0f, 0.0f);
                target.getWorld().spawnEntity(itemEntity);
                for (ServerPlayerEntity serverPlayerEntity : target.getWorld().getNonSpectatingEntities(ServerPlayerEntity.class, itemEntity.getBoundingBox().expand(5.0))) {
                    Criteria.SUMMONED_ENTITY.trigger(serverPlayerEntity, itemEntity);
                }
            }
            if (rand3 == 3) {
                ItemEntity itemEntity = EntityType.ITEM.create(target.getWorld());
                BlockPos blockPos = target.getBlockPos();
                itemEntity.setStack(new ItemStack(Items.NETHERITE_SCRAP));
                itemEntity.refreshPositionAndAngles((double) blockPos.getX() + 0.5, (double) blockPos.getY() + 0.05, (double) blockPos.getZ() + 0.5, 0.0f, 0.0f);
                target.getWorld().spawnEntity(itemEntity);
                for (ServerPlayerEntity serverPlayerEntity : target.getWorld().getNonSpectatingEntities(ServerPlayerEntity.class, itemEntity.getBoundingBox().expand(5.0))) {
                    Criteria.SUMMONED_ENTITY.trigger(serverPlayerEntity, itemEntity);
                }
            }
            if (rand3 == 4) {
                ItemEntity itemEntity = EntityType.ITEM.create(target.getWorld());
                BlockPos blockPos = target.getBlockPos();
                itemEntity.setStack(new ItemStack(ModItems.RUBY));
                itemEntity.refreshPositionAndAngles((double) blockPos.getX() + 0.5, (double) blockPos.getY() + 0.05, (double) blockPos.getZ() + 0.5, 0.0f, 0.0f);
                target.getWorld().spawnEntity(itemEntity);
                for (ServerPlayerEntity serverPlayerEntity : target.getWorld().getNonSpectatingEntities(ServerPlayerEntity.class, itemEntity.getBoundingBox().expand(5.0))) {
                    Criteria.SUMMONED_ENTITY.trigger(serverPlayerEntity, itemEntity);
                }
            }
            if (rand3 == 5) {
                ItemEntity itemEntity = EntityType.ITEM.create(target.getWorld());
                BlockPos blockPos = target.getBlockPos();
                itemEntity.setStack(new ItemStack(ModItems.GILDED_NETHERITE_INGOT));
                itemEntity.refreshPositionAndAngles((double) blockPos.getX() + 0.5, (double) blockPos.getY() + 0.05, (double) blockPos.getZ() + 0.5, 0.0f, 0.0f);
                target.getWorld().spawnEntity(itemEntity);
                for (ServerPlayerEntity serverPlayerEntity : target.getWorld().getNonSpectatingEntities(ServerPlayerEntity.class, itemEntity.getBoundingBox().expand(5.0))) {
                    Criteria.SUMMONED_ENTITY.trigger(serverPlayerEntity, itemEntity);
                }
            }
            if (rand3 == 6) {
                ItemEntity itemEntity = EntityType.ITEM.create(target.getWorld());
                BlockPos blockPos = target.getBlockPos();
                itemEntity.setStack(new ItemStack(ModItems.STEEL_INGOT));
                itemEntity.refreshPositionAndAngles((double) blockPos.getX() + 0.5, (double) blockPos.getY() + 0.05, (double) blockPos.getZ() + 0.5, 0.0f, 0.0f);
                target.getWorld().spawnEntity(itemEntity);
                for (ServerPlayerEntity serverPlayerEntity : target.getWorld().getNonSpectatingEntities(ServerPlayerEntity.class, itemEntity.getBoundingBox().expand(5.0))) {
                    Criteria.SUMMONED_ENTITY.trigger(serverPlayerEntity, itemEntity);
                }
            }
            if (rand3 == 7) {
                ItemEntity itemEntity = EntityType.ITEM.create(target.getWorld());
                BlockPos blockPos = target.getBlockPos();
                itemEntity.setStack(new ItemStack(ModItems.BRONZE_INGOT));
                itemEntity.refreshPositionAndAngles((double) blockPos.getX() + 0.5, (double) blockPos.getY() + 0.05, (double) blockPos.getZ() + 0.5, 0.0f, 0.0f);
                target.getWorld().spawnEntity(itemEntity);
                for (ServerPlayerEntity serverPlayerEntity : target.getWorld().getNonSpectatingEntities(ServerPlayerEntity.class, itemEntity.getBoundingBox().expand(5.0))) {
                    Criteria.SUMMONED_ENTITY.trigger(serverPlayerEntity, itemEntity);
                }
            }
            if (rand3 == 8) {
                ItemEntity itemEntity = EntityType.ITEM.create(target.getWorld());
                BlockPos blockPos = target.getBlockPos();
                itemEntity.setStack(new ItemStack(ModItems.CRIMSONITE_INGOT));
                itemEntity.refreshPositionAndAngles((double) blockPos.getX() + 0.5, (double) blockPos.getY() + 0.05, (double) blockPos.getZ() + 0.5, 0.0f, 0.0f);
                target.getWorld().spawnEntity(itemEntity);
                for (ServerPlayerEntity serverPlayerEntity : target.getWorld().getNonSpectatingEntities(ServerPlayerEntity.class, itemEntity.getBoundingBox().expand(5.0))) {
                    Criteria.SUMMONED_ENTITY.trigger(serverPlayerEntity, itemEntity);
                }
            }
            if (rand3 == 9) {
                ItemEntity itemEntity = EntityType.ITEM.create(target.getWorld());
                BlockPos blockPos = target.getBlockPos();
                itemEntity.setStack(new ItemStack(Items.AMETHYST_SHARD));
                itemEntity.refreshPositionAndAngles((double) blockPos.getX() + 0.5, (double) blockPos.getY() + 0.05, (double) blockPos.getZ() + 0.5, 0.0f, 0.0f);
                target.getWorld().spawnEntity(itemEntity);
                for (ServerPlayerEntity serverPlayerEntity : target.getWorld().getNonSpectatingEntities(ServerPlayerEntity.class, itemEntity.getBoundingBox().expand(5.0))) {
                    Criteria.SUMMONED_ENTITY.trigger(serverPlayerEntity, itemEntity);
                }
            }
            if (rand3 == 10) {
                ItemEntity itemEntity = EntityType.ITEM.create(target.getWorld());
                BlockPos blockPos = target.getBlockPos();
                itemEntity.setStack(new ItemStack(Items.QUARTZ));
                itemEntity.refreshPositionAndAngles((double) blockPos.getX() + 0.5, (double) blockPos.getY() + 0.05, (double) blockPos.getZ() + 0.5, 0.0f, 0.0f);
                target.getWorld().spawnEntity(itemEntity);
                for (ServerPlayerEntity serverPlayerEntity : target.getWorld().getNonSpectatingEntities(ServerPlayerEntity.class, itemEntity.getBoundingBox().expand(5.0))) {
                    Criteria.SUMMONED_ENTITY.trigger(serverPlayerEntity, itemEntity);
                }
            }
            if (rand3 == 11) {
                ItemEntity itemEntity = EntityType.ITEM.create(target.getWorld());
                BlockPos blockPos = target.getBlockPos();
                itemEntity.setStack(new ItemStack(Items.LAPIS_LAZULI));
                itemEntity.refreshPositionAndAngles((double) blockPos.getX() + 0.5, (double) blockPos.getY() + 0.05, (double) blockPos.getZ() + 0.5, 0.0f, 0.0f);
                target.getWorld().spawnEntity(itemEntity);
                for (ServerPlayerEntity serverPlayerEntity : target.getWorld().getNonSpectatingEntities(ServerPlayerEntity.class, itemEntity.getBoundingBox().expand(5.0))) {
                    Criteria.SUMMONED_ENTITY.trigger(serverPlayerEntity, itemEntity);
                }
            }
            if (rand3 == 12) {
                ItemEntity itemEntity = EntityType.ITEM.create(target.getWorld());
                BlockPos blockPos = target.getBlockPos();
                itemEntity.setStack(new ItemStack(Items.COAL));
                itemEntity.refreshPositionAndAngles((double) blockPos.getX() + 0.5, (double) blockPos.getY() + 0.05, (double) blockPos.getZ() + 0.5, 0.0f, 0.0f);
                target.getWorld().spawnEntity(itemEntity);
                for (ServerPlayerEntity serverPlayerEntity : target.getWorld().getNonSpectatingEntities(ServerPlayerEntity.class, itemEntity.getBoundingBox().expand(5.0))) {
                    Criteria.SUMMONED_ENTITY.trigger(serverPlayerEntity, itemEntity);
                }
            }
            if (rand3 == 13) {
                ItemEntity itemEntity = EntityType.ITEM.create(target.getWorld());
                BlockPos blockPos = target.getBlockPos();
                itemEntity.setStack(new ItemStack(Items.EMERALD));
                itemEntity.refreshPositionAndAngles((double) blockPos.getX() + 0.5, (double) blockPos.getY() + 0.05, (double) blockPos.getZ() + 0.5, 0.0f, 0.0f);
                target.getWorld().spawnEntity(itemEntity);
                for (ServerPlayerEntity serverPlayerEntity : target.getWorld().getNonSpectatingEntities(ServerPlayerEntity.class, itemEntity.getBoundingBox().expand(5.0))) {
                    Criteria.SUMMONED_ENTITY.trigger(serverPlayerEntity, itemEntity);
                }
            }
            if (rand3 == 14) {
                ItemEntity itemEntity = EntityType.ITEM.create(target.getWorld());
                BlockPos blockPos = target.getBlockPos();
                itemEntity.setStack(new ItemStack(Items.DIAMOND));
                itemEntity.refreshPositionAndAngles((double) blockPos.getX() + 0.5, (double) blockPos.getY() + 0.05, (double) blockPos.getZ() + 0.5, 0.0f, 0.0f);
                target.getWorld().spawnEntity(itemEntity);
                for (ServerPlayerEntity serverPlayerEntity : target.getWorld().getNonSpectatingEntities(ServerPlayerEntity.class, itemEntity.getBoundingBox().expand(5.0))) {
                    Criteria.SUMMONED_ENTITY.trigger(serverPlayerEntity, itemEntity);
                }
            }
            if (rand3 == 15) {
                ItemEntity itemEntity = EntityType.ITEM.create(target.getWorld());
                BlockPos blockPos = target.getBlockPos();
                itemEntity.setStack(new ItemStack(Items.COPPER_INGOT));
                itemEntity.refreshPositionAndAngles((double) blockPos.getX() + 0.5, (double) blockPos.getY() + 0.05, (double) blockPos.getZ() + 0.5, 0.0f, 0.0f);
                target.getWorld().spawnEntity(itemEntity);
                for (ServerPlayerEntity serverPlayerEntity : target.getWorld().getNonSpectatingEntities(ServerPlayerEntity.class, itemEntity.getBoundingBox().expand(5.0))) {
                    Criteria.SUMMONED_ENTITY.trigger(serverPlayerEntity, itemEntity);
                }
            }
            if (rand3 == 16) {
                ItemEntity itemEntity = EntityType.ITEM.create(target.getWorld());
                BlockPos blockPos = target.getBlockPos();
                itemEntity.setStack(new ItemStack(Items.IRON_INGOT));
                itemEntity.refreshPositionAndAngles((double) blockPos.getX() + 0.5, (double) blockPos.getY() + 0.05, (double) blockPos.getZ() + 0.5, 0.0f, 0.0f);
                target.getWorld().spawnEntity(itemEntity);
                for (ServerPlayerEntity serverPlayerEntity : target.getWorld().getNonSpectatingEntities(ServerPlayerEntity.class, itemEntity.getBoundingBox().expand(5.0))) {
                    Criteria.SUMMONED_ENTITY.trigger(serverPlayerEntity, itemEntity);
                }
            }
        }
    }
}
