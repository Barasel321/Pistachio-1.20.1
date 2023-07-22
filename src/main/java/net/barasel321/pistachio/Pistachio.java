package net.barasel321.pistachio;

import net.barasel321.pistachio.block.PistachioBlocks;
import net.barasel321.pistachio.effect.PistachioEffects;
import net.barasel321.pistachio.enchantment.PistachioEnchantments;
import net.barasel321.pistachio.item.PistachioItemGroups;
import net.barasel321.pistachio.item.PistachioItems;
import net.barasel321.pistachio.networking.PistachioMessages;
import net.barasel321.pistachio.painting.PistachioPaintings;
import net.barasel321.pistachio.util.PistachioLootTableModifiers;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Pistachio implements ModInitializer {

	public static final String MOD_ID = "pistachio";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		PistachioItems.registerModItems();
		PistachioItemGroups.registerItemGroups();
		PistachioBlocks.registerModBlocks();
		PistachioPaintings.registerPaintings();
		PistachioEffects.registerEffects();
		PistachioEnchantments.registerEnchantments();

		PistachioLootTableModifiers.modifyLootTables();

		PistachioMessages.registerC2SPackets();

	}
}