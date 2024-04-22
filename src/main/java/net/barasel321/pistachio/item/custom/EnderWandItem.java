package net.barasel321.pistachio.item.custom;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class EnderWandItem extends Item {

    public EnderWandItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) {
            if (user.isSneaking()){
                randomTP(world,user);
            }
            else {
                controlledTP(world,user);
            }
        }
        return super.use(world, user, hand);
    }

    private void randomTP(World world, PlayerEntity user){

        double d = user.getX();
        double e = user.getY();
        double f = user.getZ();
        for (int i = 0; i < 16; ++i) {
            double g = user.getX() + (user.getRandom().nextDouble() - 0.5) * 32.0;
            double h = MathHelper.clamp(user.getY() + (double)(user.getRandom().nextInt(16) - 8), world.getBottomY(), (world.getBottomY() + ((ServerWorld)world).getLogicalHeight() - 1));
            double j = user.getZ() + (user.getRandom().nextDouble() - 0.5) * 32.0;
            if (user.hasVehicle()) {
                user.stopRiding();
            }
            Vec3d vec3d = user.getPos();
            if (!user.teleport(g, h, j, true)) continue;
            world.emitGameEvent(GameEvent.TELEPORT, vec3d, GameEvent.Emitter.of(user));
            SoundEvent soundEvent = SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT;
            world.playSound(null, d, e, f, soundEvent, SoundCategory.PLAYERS, 1.0f, 1.0f);
            user.playSound(soundEvent, 1.0f, 1.0f);
            break;
        }
        user.getItemCooldownManager().set(this, 199);
    }

    private void controlledTP(World world, PlayerEntity user){

        MinecraftClient client = MinecraftClient.getInstance();
        double maxReach = 10; //The farthest target the cameraEntity can detect
        float tickDelta = 1.0F; //Used for tracking animation progress; no tracking is 1.0F
        boolean includeFluids = true; //Whether to detect fluids as blocks

        HitResult hit = client.cameraEntity.raycast(maxReach, tickDelta, includeFluids);

        world.emitGameEvent(GameEvent.TELEPORT, user.getPos(), GameEvent.Emitter.of(user));

        double x = hit.getPos().getX();
        double y = hit.getPos().getY();
        double z = hit.getPos().getZ();

        user.teleport(x,y,z,true);



        SoundEvent soundEvent = SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT;
        world.playSound(null, x, y, z, soundEvent, SoundCategory.PLAYERS, 1.0f, 1.0f);
        user.playSound(soundEvent, 1.0f, 1.0f);

        user.getItemCooldownManager().set(this, 450);
    }
}
