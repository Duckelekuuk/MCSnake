package com.duckelekuuk.mcsnake;

import com.duckelekuuk.mcsnake.commands.SnakeCommand;
import com.duckelekuuk.mcsnake.listeners.InventoryClickListeners;
import com.duckelekuuk.mcsnake.listeners.InventoryCloseListener;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public final class MCSnake extends JavaPlugin {

    @Getter
    private static MCSnake plugin;

    @Override
    public void onEnable() {
        plugin = this;
        getServer().getPluginManager().registerEvents(new InventoryClickListeners(), this);
        getServer().getPluginManager().registerEvents(new InventoryCloseListener(), this);
        getCommand("snake").setExecutor(new SnakeCommand());
    }
}
