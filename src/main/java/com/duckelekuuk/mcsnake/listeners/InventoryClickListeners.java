package com.duckelekuuk.mcsnake.listeners;

import com.duckelekuuk.mcsnake.managers.ConsoleManager;
import com.duckelekuuk.mcsnake.models.Button;
import com.duckelekuuk.mcsnake.models.Console;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListeners implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (!(e.getWhoClicked() instanceof Player)) return;

        Player player = (Player) e.getWhoClicked();
        Console console = ConsoleManager.getConsole(player);

        if (console == null) return;
        if (!console.getInventory().getViewers().contains(player)) return;

        e.setCancelled(true);
        e.setResult(Event.Result.DENY);

        if (console.isGameOver()) return;

        Button pressed = Button.getButton(e.getCurrentItem());

        if (pressed == null) return;
        console.onClick(pressed);
    }
}
