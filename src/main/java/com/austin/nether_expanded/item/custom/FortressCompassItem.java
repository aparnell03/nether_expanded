package com.austin.nether_expanded.item.custom;

import com.austin.nether_expanded.worldgen.ModConfiguredStructureFeatureTags;
import com.mojang.logging.LogUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtHelper;
import net.minecraft.nbt.NbtOps;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.poi.PointOfInterestType;
import org.slf4j.Logger;

import java.util.Optional;


public class FortressCompassItem extends Item {
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final String FORTRESS_POS_KEY = "FortressPos";
    public static final String FORTRESS_DIMENSION_KEY = "FortressDimension";
    public static final String FORTRESS_TRACKED_KEY = "FortressTracked";

    public FortressCompassItem(Settings settings) {
        super(settings);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return false;
    }

    public static boolean hasFortress(ItemStack stack) {
        NbtCompound nbtCompound = stack.getNbt();
        return nbtCompound != null && (nbtCompound.contains(FORTRESS_DIMENSION_KEY) || nbtCompound.contains(FORTRESS_POS_KEY));
    }

    public static Optional<RegistryKey<World>> getFortressDimension(NbtCompound nbt) {
        return World.CODEC.parse(NbtOps.INSTANCE, nbt.get(FORTRESS_DIMENSION_KEY)).result();
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (world.isClient) {
            return;
        }
        if (CompassItem.hasLodestone(stack)) {
            BlockPos blockPos;
            NbtCompound nbtCompound = stack.getOrCreateNbt();
            if (nbtCompound.contains(FORTRESS_TRACKED_KEY) && !nbtCompound.getBoolean(FORTRESS_TRACKED_KEY)) {
                return;
            }
            Optional<RegistryKey<World>> optional = CompassItem.getLodestoneDimension(nbtCompound);
            if (optional.isPresent() && optional.get() == world.getRegistryKey() && nbtCompound.contains(FORTRESS_POS_KEY) && (!world.isInBuildLimit(blockPos = NbtHelper.toBlockPos(nbtCompound.getCompound(FORTRESS_POS_KEY))) || !((ServerWorld)world).getPointOfInterestStorage().hasTypeAt(PointOfInterestType.LODESTONE, blockPos))) {
                nbtCompound.remove(FORTRESS_POS_KEY);
            }
        }
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ServerWorld serverWorld;
        BlockPos blockPos;
        ItemStack itemStack = user.getStackInHand(hand);
            user.setCurrentHand(hand);
        if (world instanceof ServerWorld && (blockPos = (serverWorld = (ServerWorld)world).locateStructure(ModConfiguredStructureFeatureTags.FORTRESS, user.getBlockPos(), 100, false)) != null) {
                world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ITEM_LODESTONE_COMPASS_LOCK, SoundCategory.NEUTRAL, 0.5f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
                this.writeNbt(world.getRegistryKey(), blockPos, itemStack.getOrCreateNbt());
                return TypedActionResult.success(itemStack);
        }
        return TypedActionResult.fail(itemStack);
    }
    private void writeNbt(RegistryKey<World> worldKey, BlockPos pos, NbtCompound nbt) {
        nbt.put(FORTRESS_POS_KEY, NbtHelper.fromBlockPos(pos));
        World.CODEC.encodeStart(NbtOps.INSTANCE, worldKey).resultOrPartial(LOGGER::error).ifPresent(nbtElement -> nbt.put(FORTRESS_DIMENSION_KEY, (NbtElement)nbtElement));
        nbt.putBoolean(FORTRESS_TRACKED_KEY, true);
    }

    @Override
    public String getTranslationKey(ItemStack stack) {
        return CompassItem.hasLodestone(stack) ? "item.nether_expanded.fortress_compass" : super.getTranslationKey(stack);
    }
}


