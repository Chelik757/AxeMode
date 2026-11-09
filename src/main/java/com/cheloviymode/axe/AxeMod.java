package com.cheloviymode.axe;

import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge; // <-- Добавлен импорт
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

@Mod(AxeMod.MOD_ID)
public class AxeMod {
    public static final String MOD_ID = "cheloviymode";

    public AxeMod(IEventBus modEventBus) {
        // Регистрируем блоки и предметы
        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);

        // Добавляем предметы в креативные вкладки
        modEventBus.addListener(this::addCreative);

        // Регистрируем команды на игровой шине событий
        NeoForge.EVENT_BUS.register(ModCommands.class); 
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        // Добавляем секиру во вкладку "Инструменты и утилиты"
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.AXE);
        }
        
        // Добавляем платиновый слиток во вкладку "Ингредиенты"
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.PLATINUM_INGOT);
        }

        // Добавляем платиновую руду во вкладку "Природные блоки"
        if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(ModItems.PLATINUM_ORE_ITEM);
        }
    }
}
