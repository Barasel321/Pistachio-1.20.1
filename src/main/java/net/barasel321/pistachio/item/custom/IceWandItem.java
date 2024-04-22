package net.barasel321.pistachio.item.custom;


import net.barasel321.pistachio.block.PistachioBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.*;
import net.minecraft.world.World;

import java.util.stream.Stream;

import static net.minecraft.util.math.MathHelper.abs;
import static net.minecraft.util.math.MathHelper.floor;

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

            double maxReach = 8;
            float tickDelta = 1.0F;
            boolean includeFluids = true;

            HitResult hit = client.cameraEntity.raycast(maxReach, tickDelta, includeFluids);

            world.setBlockState(new BlockPos(floorv(hit.getPos())),PistachioBlocks.DRY_ICE.getDefaultState());

            if (zCheck(user.getRotationClient())) {
                zWall(hit.getPos(), world);
            }
            else{
                xWall(hit.getPos(), world);
            }
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

    private static void wall(BlockPos pos, World world){
        if (world.getBlockState(pos).getBlock() == Blocks.AIR){
            world.setBlockState(pos, PistachioBlocks.DRY_ICE.getDefaultState());

        }
    }
    private static Vec3i floorv(Vec3d vec){
        return new Vec3i(floor(vec.getX()),floor(vec.getY()),floor(vec.getZ()));
    }

    private static boolean zCheck(Vec2f rotation){
        float a = abs(rotation.y);
        return  (a>=45 && a<=135);
    }

    private static void xWall(Vec3d pos,World world){
        world.setBlockState(new BlockPos(floorv(pos)),PistachioBlocks.DRY_ICE.getDefaultState());
        Box box = new Box(pos.getX()+3,pos.getY(),pos.getZ(),pos.getX()-3,pos.getY()+4,pos.getZ());
        BlockPos.stream(box).forEach(position -> wall(position,world));

    }

    private static void zWall(Vec3d pos,World world){
        world.setBlockState(new BlockPos(floorv(pos)),PistachioBlocks.DRY_ICE.getDefaultState());
        Box box = new Box(pos.getX(),pos.getY(),pos.getZ()+3,pos.getX(),pos.getY()+4,pos.getZ()-3);
        BlockPos.stream(box).forEach(position -> wall(position,world));

    }
}