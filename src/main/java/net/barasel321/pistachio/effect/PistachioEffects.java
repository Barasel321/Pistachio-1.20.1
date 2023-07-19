package net.barasel321.pistachio.effect;

import net.barasel321.pistachio.Pistachio;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class PistachioEffects {
    public static StatusEffect STUN, PHAGE;

    public static StatusEffect registerStatusEffect(String name, StatusEffect effect ) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(Pistachio.MOD_ID, name), effect);
    }

    public static void registerEffects(){
        STUN = registerStatusEffect("stun",new StunEffect(StatusEffectCategory.HARMFUL, 13612079));
        PHAGE = registerStatusEffect("phage",new PhageEffect(StatusEffectCategory.HARMFUL, 13612079)).addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH, "7104DE2E-7CE8-4031-940E-514C1F160895", -2.0f, EntityAttributeModifier.Operation.ADDITION);
        Pistachio.LOGGER.info("registering effects");
    }
}