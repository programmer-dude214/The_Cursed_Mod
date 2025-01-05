package the.cursed.mod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import the.cursed.mod.TheCursedMod;
import the.cursed.mod.item.custom.DiamonderItem;

public class ModItems {
    public static final Item CURSED_ITEM = registerItem("cursed_item", new Item(new Item.Settings()));

    public static final Item DIAMONDER = registerItem("Diamonder", new DiamonderItem(new Item.Settings().maxDamage(9999)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TheCursedMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        TheCursedMod.LOGGER.info("Registering Mod Items for " + TheCursedMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(CURSED_ITEM);
        });
    }
}