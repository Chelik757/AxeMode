package com.cheloviymode.axe;

import net.minecraft.network.chat.Component;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.ServerChatEvent;

import java.util.List;
import java.util.Map;

public class ChatHandler {

    // Словарь обычных ответов
    private static final Map<String, String> RESPONSES = Map.of(
            "привет", "Привет, рад видеть тебя в мире!",
            "привет, как дела", "Привет! Всё просто замечательно",
            "как дела", "Всё отлично, спасибо, что спросил!",
            "дай ресов", "Я пока что не умею выдавать ресурсы игрокам",
            "пока", "До встречи, путник!",
            "как ты разговариваешь?", "Код мне дал способности коммуникации с игроками!",
            "кто ты?", "Я — мод AxeMode."
    );

    // Список оскорблений по национальному/расовому признаку
    private static final List<String> RACIST_WORDS = List.of(
            "хохол", "чурка", "жид", "ниггер", "хач", "узкоглазый", "москаль"
    );

    // Список обычного мата
    private static final List<String> BAD_WORDS = List.of(
            "сука", "блять", "хуй", "пизда", "ебать"
    );

    @SubscribeEvent
    public static void onChat(ServerChatEvent event) {
        String message = event.getRawText().trim().toLowerCase();

        // 1. СНАЧАЛА проверяем на оскорбления наций (это важнее)
        for (String racistWord : RACIST_WORDS) {
            if (message.contains(racistWord)) {
                event.getPlayer().sendSystemMessage(
                    Component.literal("Я категорически против оскорблений по национальным/расовым признакам!")
                );
                return; 
            }
        }

        // 2. Затем проверяем на обычный мат
        for (String badWord : BAD_WORDS) {
            if (message.contains(badWord)) {
                event.getPlayer().sendSystemMessage(
                    Component.literal("Я категорически против абсцентной лексики!")
                );
                return; 
            }
        }

        // 3. Если ничего плохого нет, проверяем обычные ответы
        if (RESPONSES.containsKey(message)) {
            event.getPlayer().sendSystemMessage(
                Component.literal(RESPONSES.get(message))
            );
        }
    }
}