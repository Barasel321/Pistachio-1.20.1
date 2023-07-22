package net.barasel321.pistachio.util;

import net.minecraft.nbt.NbtCompound;

public class PistachioAbilityData {

    public static void setAbility(IEntityDataSaver player,int num){
        NbtCompound nbt = player.getPersistentData();
        nbt.putInt("ability", num);

    }
}
