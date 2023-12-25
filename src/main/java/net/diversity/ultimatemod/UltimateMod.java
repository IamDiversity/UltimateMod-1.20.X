package net.diversity.ultimatemod;

import net.diversity.ultimatemod.block.ModBlocks;
import net.diversity.ultimatemod.item.ModItemGroups;
import net.diversity.ultimatemod.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UltimateMod implements ModInitializer {
	public static final String MOD_ID = "ultimatemod";
    public static final Logger LOGGER = LoggerFactory.getLogger("ultimatemod");

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}