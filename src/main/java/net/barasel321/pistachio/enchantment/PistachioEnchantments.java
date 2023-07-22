package net.barasel321.pistachio.enchantment;

import net.barasel321.pistachio.Pistachio;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class PistachioEnchantments {

    public static final Enchantment PHAGEPHILIC = registerEnchantment("phagephilic",new PhagephilicEnchantment(Enchantment.Rarity.VERY_RARE,
            EnchantmentTarget.WEAPON, new EquipmentSlot[] {EquipmentSlot.MAINHAND}));


    private static Enchantment registerEnchantment(String name, Enchantment enchantment){
        return Registry.register(Registries.ENCHANTMENT, new Identifier(Pistachio.MOD_ID, name), enchantment);
    }
    public static void registerEnchantments(){
        Pistachio.LOGGER.info("registering paintings");
    }
}
