package com.duckelekuuk.mcsnake.commands;

import com.duckelekuuk.mcsnake.managers.ConsoleManager;
import com.duckelekuuk.mcsnake.models.Console;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SnakeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("§cCommand can only be executed by a player");
            return true;
        }

        Player player = (Player) commandSender;

        Console console = new Console(player);
        ConsoleManager.registerConsole(console);

        console.open();

        return true;
    }
}
