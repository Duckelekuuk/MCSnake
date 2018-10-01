package com.duckelekuuk.mcsnake.managers;

import com.duckelekuuk.mcsnake.models.Console;
import lombok.Getter;
import org.bukkit.entity.Player;

import java.util.*;

@Getter
public class ConsoleManager {

    private static Map<UUID, Console> consoles = new HashMap<>();

    public static Console getConsole(Player p) {
        return consoles.get(p.getUniqueId());
    }

    public static void registerConsole(Console console) {
        consoles.put(console.getPlayer().getUniqueId(), console);
    }

    public static void removeConsole(Player p) {
        Console console = consoles.remove(p.getUniqueId());
        if (console.getTimer() != null) console.getTimer().cancel();
        if (console.getGameOverTimer() != null) console.getGameOverTimer().cancel();
    }
}
