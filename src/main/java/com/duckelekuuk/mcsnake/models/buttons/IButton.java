package com.duckelekuuk.mcsnake.models.buttons;

import com.duckelekuuk.mcsnake.models.Console;
import org.bukkit.inventory.ItemStack;

public interface IButton {

    int getX();
    int getY();

    ItemStack getItem(boolean active);

    boolean canBePressed(Console console);
    void press(Console console);
    void unPress(Console console);
}
