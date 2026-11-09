package com.cheloviymode.axe;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.RegisterCommandsEvent;

public class ModCommands {

    // Подписываемся на событие регистрации команд
    @SubscribeEvent
    public static void onRegisterCommands(RegisterCommandsEvent event) {
        CommandDispatcher<CommandSourceStack> dispatcher = event.getDispatcher();

        // Регистрируем команду "cheloviy"
        dispatcher.register(
            Commands.literal("huy")
                .executes(context -> {
                    // Отправляем сообщение тому, кто ввел команду
                    context.getSource().sendSuccess(
                        () -> Component.literal("Не матерись сука!"), 
                        false
                    );
                    return 1; // Возвращаем 1 при успехе
                })
        );
    }
}