package net.barasel321.pistachio.item;

import net.barasel321.pistachio.Pistachio;
import net.barasel321.pistachio.block.PistachioBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class PistachioItemGroups {

    public static final ItemGroup PISTACHIO_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Pistachio.MOD_ID, "pistachio"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.pistachio"))
                    .icon(() -> new ItemStack(PistachioItems.TEST_ITEM)).entries((displayContext, entries) -> {

                        entries.add(PistachioItems.TEST_ITEM);
                        entries.add(PistachioItems.FIRE_WAND);

                        entries.add(PistachioBlocks.TEST_BLOCK);
                        entries.add(PistachioBlocks.TOFU_BLOCK);
                    }).build());

    public static void registerItemGroups(){
        Pistachio.LOGGER.info("registering item groups");

    }
}
