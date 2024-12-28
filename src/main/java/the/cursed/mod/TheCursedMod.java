package the.cursed.mod;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import the.cursed.mod.item.ModItemGroups;
import the.cursed.mod.item.ModItems;
import the.cursed.mod.block.ModBlocks;

public class TheCursedMod implements ModInitializer {
	public static final String MOD_ID = "the-cursed-mod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();


		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		LOGGER.info("The Cursed Mod has been initialized!");
	}
}
