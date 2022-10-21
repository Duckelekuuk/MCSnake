package com.duckelekuuk.mcsnake.models;

import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class GameOverScreen {

    // Spells out game over
    private static final String[] LAYOUT = new String[]{
            "**********************************************",
            "**####*####*#***#*####**####*#***#*####*###***",
            "**#****#**#*##*##*#*****#**#*#***#*#****#**#**",
            "**#*##*####*#*#*#*####**#**#*##*##*####*###***",
            "**#**#*#**#*#***#*#*****#**#**#*#**#****#**#**",
            "**####*#**#*#***#*####**####**###**####*#**#**",
    };

    // Total length to scroll, including the empty space
    public static final int SCROLL_LENGTH = LAYOUT[0].length() - 9;

    // Get offset of rows of layout to display
    public static List<String> getSubLayout(int start) {
        return Arrays.stream(LAYOUT).map(string -> string.substring(start, start+9)).collect(Collectors.toList());
    }
}
