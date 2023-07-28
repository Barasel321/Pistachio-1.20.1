package net.barasel321.pistachio.block.custom;

import net.barasel321.pistachio.effect.PistachioEffects;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoulFireBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

import java.util.List;

public class PhageFireBlock extends SoulFireBlock {
    public PhageFireBlock(Settings settings) {
        super(settings);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockPos blockPos = pos.down();
        return world.getBlockState(blockPos).isSideSolidFullSquare(world, blockPos, Direction.UP) || this.areBlocksAroundFlammable(world, pos);
    }

    private boolean areBlocksAroundFlammable(BlockView world, BlockPos pos) {
        for (Direction direction : Direction.values()) {
            if (!this.isFlammable(world.getBlockState(pos.offset(direction)))) continue;
            return true;
        }
        return false;
    }
/*
    public void applyPhage(BlockState state, World world, BlockPos pos){
        List<Entity> list = world.getOtherEntities(null, blockState.getOutlineShape(world, pos).getBoundingBox().offset(pos));
        if (!list.isEmpty()) {
            for (Entity entity : list) {
                if (entity instanceof LivingEntity) {
                    LivingEntity livingEntity = (LivingEntity) entity;

                    StatusEffectInstance effect = livingEntity.getStatusEffect(PistachioEffects.PHAGE);
                    int amplifier;

                    if (effect == null) {
                        amplifier = 0;
                    } else {
                        amplifier = effect.getAmplifier();
                    }

                    livingEntity.addStatusEffect(new StatusEffectInstance(PistachioEffects.PHAGE, 60, amplifier + 1));
                }
            }
        }
        if (world.getBlockTickScheduler(pos)) {
            world.scheduleBlockTick(new BlockPos(pos), this, 10);
        }
    }
*/
    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {

        if (entity instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity) entity;
            if (livingEntity.hurtTime == 9 && !livingEntity.hasStatusEffect(StatusEffects.FIRE_RESISTANCE)) {

                StatusEffectInstance effect = livingEntity.getStatusEffect(PistachioEffects.PHAGE);
                int amplifier;

                if (effect == null) {
                    amplifier = 0;
                } else {
                    amplifier = effect.getAmplifier();
                }

                livingEntity.addStatusEffect(new StatusEffectInstance(PistachioEffects.PHAGE, 60, amplifier + 1));
            }
        }

        super.onEntityCollision(state, world, pos, entity);
    }


}
