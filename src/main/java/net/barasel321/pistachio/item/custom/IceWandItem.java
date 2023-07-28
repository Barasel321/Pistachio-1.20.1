package net.barasel321.pistachio.item.custom;


import net.barasel321.pistachio.block.PistachioBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.SmallFireballEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockStateRaycastContext;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;

import java.util.stream.Stream;

public class IceWandItem extends Item {

    public IceWandItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient()) {

            Stream<BlockPos> sources = getWaterSources(world,user);

            sources.forEach(pos -> freeze(pos,world));

            MinecraftClient client = MinecraftClient.getInstance();
            HitResult hit = client.crosshairTarget;



            user.getItemCooldownManager().set(this, 40);
        }
        return super.use(world, user, hand);
    }


    public static Stream<BlockPos> getWaterSources(World world, PlayerEntity user) {
            return BlockPos.stream(user.getBoundingBox().expand(3));
    }

    private static void freeze(BlockPos pos, World world){
        if (world.getBlockState(pos).getBlock() == Blocks.WATER){
            world.setBlockState(pos, PistachioBlocks.DRY_ICE.getDefaultState());

        }
    }

}