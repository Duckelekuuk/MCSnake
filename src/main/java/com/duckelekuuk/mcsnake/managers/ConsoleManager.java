package com.duckelekuuk.mcsnake.managers;

import com.duckelekuuk.mcsnake.models.Console;
import lombok.Getter;
import lombok.experimental.UtilityClass;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Getter
@UtilityClass
public class ConsoleManager {

    private static final Map<UUID, Console> consoles = new HashMap<>();

    public static Console getConsole(Player player) {
        return consoles.get(player.getUniqueId());
    }

    public static void registerConsole(Console console) {
        consoles.put(console.getPlayer().getUniqueId(), console);
    }

    public static void removeConsole(Player player) {
        Console console = consoles.remove(player.getUniqueId());
        if (console.getTimer() != null) console.getTimer().cancel();
        if (console.getGameOverTimer() != null) console.getGameOverTimer().cancel();
    }
}
