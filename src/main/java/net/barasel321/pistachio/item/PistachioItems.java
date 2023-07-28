package net.barasel321.pistachio.item;

import net.barasel321.pistachio.Pistachio;
import net.barasel321.pistachio.item.custom.FireWandItem;
import net.barasel321.pistachio.item.custom.IceWandItem;
import net.barasel321.pistachio.item.custom.PhageSwordItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class PistachioItems {

        public static final Item TEST_ITEM = registerItem("test_item",new Item(new FabricItemSettings()));
        public static final Item FIRE_WAND = registerItem("fire_wand",new FireWandItem(new FabricItemSettings().maxCount(1)));
        public static final Item ICE_WAND = registerItem("ice_wand",new IceWandItem(new FabricItemSettings().maxCount(1)));

        public static final Item CAT_ITEM = registerItem("cat_item",new Item(new FabricItemSettings().food(
                new FoodComponent.Builder().hunger(10).saturationModifier(2f).meat().build()
        )));

        public static final Item PHAGE_SWORD = registerItem("phage_sword",new PhageSwordItem(ToolMaterials.IRON,0,-2.4f,new FabricItemSettings()));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(Pistachio.MOD_ID, name), item);
    }

    public static void registerModItems(){
        Pistachio.LOGGER.info("registering items");
    }
}
