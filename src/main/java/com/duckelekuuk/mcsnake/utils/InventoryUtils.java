package com.duckelekuuk.mcsnake.utils;

import lombok.experimental.UtilityClass;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

@UtilityClass
public class InventoryUtils {

    public static int getLocation(int x, int y) {
        return (9 * y) + x;
    }

    public static int[] getCoordinates(int location) {
        int[] returnData = new int[2];
        returnData[0] = location % 9;
        returnData[1] = location / 9;
        return returnData;
    }

    public static void fillEmpty(Inventory inventory, Material material, int data) {
        ItemStack itemStack = ItemStackBuilder.of(material).durability(data).displayName(" ").build();
        fillEmpty(inventory, itemStack);
    }

    public static void fillEmpty(Inventory inventory, ItemStack itemStack) {
        int max = inventory.getType().equals(InventoryType.PLAYER) ? 36 : inventory.getSize();

        for (int i = inventory.getType().equals(InventoryType.PLAYER) ? 9 : 0; i < max; i++) {
            if (inventory.getItem(i) != null) continue;

            inventory.setItem(i, itemStack);
        }
    }
}