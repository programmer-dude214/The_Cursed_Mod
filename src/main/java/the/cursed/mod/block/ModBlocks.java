package the.cursed.mod.block;

import net.minecraft.block.Block;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import the.cursed.mod.TheCursedMod;
import net.minecraft.item.ItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;

public class ModBlocks {
    public static final Block CURSED_BLOCK = registerBlock("cursed_block",
            new Block(AbstractBlock.Settings.create().strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.ANVIL)));

    public static final Block CURSED_ITEM_ORE = registerBlock("cursed_item_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(0, 10),
                    AbstractBlock.Settings.create().strength(3f).requiresTool()));

    public static final Block CURSED_ITEM_DEEPSLATE_ORE = registerBlock("cursed_item_deepslate_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(1, 11),
                    AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));

    // Register the block
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK,  Identifier.of(TheCursedMod.MOD_ID, name), block);
    }

    // Register the BlockItem for the block
    private static void registerBlockItem(String name, Block block) {
        BlockItem blockItem = new BlockItem(block, new Item.Settings());
        Registry.register(Registries.ITEM,  Identifier.of(TheCursedMod.MOD_ID, name), blockItem);
    }

    // Register the block into the item group
    public static void registerModBlocks() {
        TheCursedMod.LOGGER.info("Registering Mod Blocks for " + TheCursedMod.MOD_ID);

        // Register the block to the building blocks item group
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.CURSED_BLOCK);
        });
    }
}
