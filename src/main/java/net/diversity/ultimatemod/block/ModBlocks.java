package net.diversity.ultimatemod.block;

import net.diversity.ultimatemod.UltimateMod;
import net.diversity.ultimatemod.item.ModItems;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;


public class ModBlocks {

    // Method to add Blocks in the "Building Blocks" tab in Creative Mode.
    private static void addItemsToBuildingBlocksTabItemGroup(FabricItemGroupEntries entries){
        entries.addAfter(Blocks.NETHERITE_BLOCK, RUBY_BLOCK);
        entries.add(RAW_RUBY_BLOCK);
    }

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(UltimateMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM, new Identifier(UltimateMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks(){
        UltimateMod.LOGGER.info("Registering ModBlocks for " + UltimateMod.MOD_ID);
        //Connect modifyEntriesEvent to addItemsToBuildingBlocksTabItemGroup method
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(ModBlocks::addItemsToBuildingBlocksTabItemGroup);
    }

    // Block declaration
    public static final Block RUBY_BLOCK =
            registerBlock("ruby_block", new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block RAW_RUBY_BLOCK =
            registerBlock("raw_ruby_block", new Block(FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK)));
    public static final Block RUBY_ORE =
            registerBlock("ruby_ore", new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),FabricBlockSettings.copyOf(Blocks.STONE).strength(2.0f)));
    public static final Block DEEPSLATE_RUBY_ORE =
            registerBlock("deepslate_ruby_ore", new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),FabricBlockSettings.copyOf(Blocks.DEEPSLATE).strength(4.0f)));
    public static final Block NETHER_RUBY_ORE =
            registerBlock("nether_ruby_ore", new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),FabricBlockSettings.copyOf(Blocks.NETHERRACK).strength(3.0f)));
    public static final Block END_STONE_RUBY_ORE =
            registerBlock("end_stone_ruby_ore", new ExperienceDroppingBlock(UniformIntProvider.create(4, 7),FabricBlockSettings.copyOf(Blocks.END_STONE).strength(3.0f)));
}
