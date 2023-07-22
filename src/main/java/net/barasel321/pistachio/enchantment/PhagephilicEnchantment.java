package net.barasel321.pistachio.enchantment;

import net.barasel321.pistachio.effect.PistachioEffects;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;

public class PhagephilicEnchantment extends Enchantment {
    protected PhagephilicEnchantment(Rarity weight, EnchantmentTarget target, EquipmentSlot[] slotTypes) {
        super(weight, target, slotTypes);
    }

    @Override
    public boolean isAvailableForEnchantedBookOffer() {
        return false;
    }
    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (!user.getWorld().isClient()) {
            if (target instanceof LivingEntity) {
                LivingEntity livingEntity = (LivingEntity) target;

                StatusEffectInstance effect = livingEntity.getStatusEffect(PistachioEffects.PHAGE);
                int amplifier;

                if (effect == null) {
                    amplifier = 0;
                } else {
                    amplifier = effect.getAmplifier();
                }

                livingEntity.addStatusEffect(new StatusEffectInstance(PistachioEffects.PHAGE, 60, amplifier + level));
            }
        }
    }

    @Override
    public int getMaxLevel(){
        return 3;
    }

}
