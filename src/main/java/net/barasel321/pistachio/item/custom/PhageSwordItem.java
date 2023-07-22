package net.barasel321.pistachio.item.custom;

import net.barasel321.pistachio.effect.PistachioEffects;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class PhageSwordItem extends SwordItem {
    public PhageSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {

        StatusEffectInstance effect = target.getStatusEffect(PistachioEffects.PHAGE);
        int amplifier;

        if(effect == null){
            amplifier = 0;
        }else{
            amplifier = effect.getAmplifier();
        }

        target.addStatusEffect(new StatusEffectInstance(PistachioEffects.PHAGE,300,amplifier + 1));

        return super.postHit(stack,target,attacker);
    }
}
