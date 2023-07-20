package net.barasel321.pistachio.util;

import net.barasel321.pistachio.item.PistachioItems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.util.Identifier;

public class PistachioLootTableModifiers {
    public static final Identifier CAT_ID = new Identifier("minecraft", "entities/cat");

    public static void modifyLootTables() {

        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            // Let's only modify built-in loot tables and leave data pack loot tables untouched by checking the source.
            // We also check that the loot table ID is equal to the ID we want.
            if (source.isBuiltin() && CAT_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .with(ItemEntry.builder(PistachioItems.CAT_ITEM));
                tableBuilder.pool(poolBuilder);
            }
        });
    }
}
