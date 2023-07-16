package net.barasel321.pistachio.item;

import net.barasel321.pistachio.Pistachio;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class PistachioItems {

        public static final Item TEST_ITEM = registerItem("test_item",new Item(new FabricItemSettings()));


    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(Pistachio.MOD_ID, name), item);
    }

    public static void registerModItems(){
        Pistachio.LOGGER.info("registering items");
    }
}
