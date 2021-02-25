package pl.koloksk.utils;

import org.bukkit.ChatColor;

public class ColorUtil {
    public static String fixColors(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }
}
