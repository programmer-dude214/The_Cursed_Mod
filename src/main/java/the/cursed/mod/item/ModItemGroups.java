package the.cursed.mod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import the.cursed.mod.TheCursedMod;
import the.cursed.mod.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup CURSED_MOD_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TheCursedMod.MOD_ID, "cursed_mod"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.CURSED_ITEM))
                    .displayName(Text.translatable("itemgroup.the-cursed-mod.cursed_mod"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.CURSED_ITEM);
                        entries.add(ModBlocks.CURSED_BLOCK);
                        entries.add(ModBlocks.CURSED_ITEM_ORE);
                        entries.add(ModBlocks.CURSED_ITEM_DEEPSLATE_ORE);

                        entries.add(ModItems.DIAMONDER);
                    }).build());

    public static void registerItemGroups() {
        TheCursedMod.LOGGER.info("Registering Item Groups for " + TheCursedMod.MOD_ID);
    }
}
