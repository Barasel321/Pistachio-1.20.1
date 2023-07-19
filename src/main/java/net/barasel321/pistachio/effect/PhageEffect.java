package net.barasel321.pistachio.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class PhageEffect extends StatusEffect {
    public PhageEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {

        if (entity.getHealth() > (20 - 2*amplifier)){
            entity.damage(entity.getDamageSources().generic(),entity.getHealth()-(20 - 2*amplifier));
        }
        super.onApplied(entity, attributes, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}