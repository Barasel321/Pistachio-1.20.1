package net.barasel321.pistachio;

import net.barasel321.pistachio.block.PistachioBlocks;
import net.barasel321.pistachio.item.PistachioItemGroups;
import net.barasel321.pistachio.item.PistachioItems;
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
	}
}