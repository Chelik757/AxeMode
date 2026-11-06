package com.cheloviymode.axe;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = 
            DeferredRegister.createItems(AxeMod.MOD_ID);

    // --- СЕКИРА ---
    public static final DeferredItem<AxeItem> AXE = ITEMS.registerItem(
            "great_axe",
            props -> new AxeItem(
                    Tiers.IRON,
                    new Item.Properties().attributes(
                            AxeItem.createAttributes(Tiers.IRON, 10.0f, -3.2f)
                    )
            )
    );

    // --- ПЛАТИНОВЫЙ СЛИТОК ---
    public static final DeferredItem<Item> PLATINUM_INGOT = ITEMS.registerItem(
            "platinum_ingot",
            props -> new Item(new Item.Properties())
    );

    // --- ПРЕДМЕТ ДЛЯ ПЛАТИНОВОЙ РУДЫ ---
    public static final DeferredItem<BlockItem> PLATINUM_ORE_ITEM = ITEMS.registerSimpleBlockItem(
            "platinum_ore", 
            ModBlocks.PLATINUM_ORE
    );
}
