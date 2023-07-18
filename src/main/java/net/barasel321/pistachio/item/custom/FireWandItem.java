package net.barasel321.pistachio.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.SmallFireballEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.concurrent.TimeUnit;

public class FireWandItem extends Item {

    public FireWandItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient()) {

            SmallFireballEntity fireball = new SmallFireballEntity(world, user, 0, 0, 0);
            fireball.setVelocity(user, user.getPitch(), user.getYaw(), 0.0f, 1.5f, 1.0f);
            fireball.setPosition(fireball.getX(), user.getBodyY(0.5) + 0.5, user.getZ());
            world.spawnEntity(fireball);



            user.getItemCooldownManager().set(this,40);
        }
            return super.use(world, user, hand);
    }
}
