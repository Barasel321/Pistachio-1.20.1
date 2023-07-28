package net.barasel321.pistachio.block;

import net.barasel321.pistachio.Pistachio;
import net.barasel321.pistachio.block.custom.DryIceBlock;
import net.barasel321.pistachio.block.custom.PhageFireBlock;
import net.barasel321.pistachio.block.custom.TofuBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class PistachioBlocks {

    public static final Block TEST_BLOCK = registerBlock("test_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

    public static final Block TOFU_BLOCK = registerBlock("tofu_block",
            new TofuBlock(FabricBlockSettings.copyOf(Blocks.HAY_BLOCK).strength(0.2f)));

    public static final Block PHAGE_FIRE = registerBlock("phage_fire",
            new PhageFireBlock(FabricBlockSettings.copyOf(Blocks.FIRE).mapColor(MapColor.PALE_PURPLE)));

    public static final Block DRY_ICE = registerBlock("dry_ice",
            new DryIceBlock(FabricBlockSettings.copyOf(Blocks.FROSTED_ICE).mapColor(MapColor.TERRACOTTA_GRAY)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Pistachio.MOD_ID,name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(Pistachio.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks(){
        Pistachio.LOGGER.info("registering blocks");
    }
}
