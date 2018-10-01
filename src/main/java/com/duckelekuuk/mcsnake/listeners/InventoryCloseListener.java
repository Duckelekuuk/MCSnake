package com.duckelekuuk.mcsnake.listeners;

import com.duckelekuuk.mcsnake.managers.ConsoleManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class InventoryCloseListener implements Listener {

    @EventHandler
    public void onClose(InventoryCloseEvent e) {
        if (!(e.getPlayer() instanceof Player)) return;
        Player player = (Player) e.getPlayer();

        if (ConsoleManager.getConsole(player) == null) return;

        ConsoleManager.removeConsole(player);

        e.getPlayer().getInventory().clear();
    }
}
