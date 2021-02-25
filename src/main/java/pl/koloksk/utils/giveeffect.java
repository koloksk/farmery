package pl.koloksk.utils;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class giveeffect {
    public static void giveeffect(Player p, PotionEffectType et, int duration, int level, int amount) {
        if (!p.getInventory().contains(Material.EMERALD_BLOCK, amount)) {
            p.sendMessage(ColorUtil.fixColors(" &8&cNie posiadasz wystarczajacej ilosci emeraldow!"));
            return;
        }
        if (p.hasPotionEffect(et)) {
            p.sendMessage(ColorUtil.fixColors(" &8&cMasz juz ten efekt!"));
            return;
        }
        p.getInventory().removeItem(new ItemStack(Material.EMERALD_BLOCK, amount));
        p.addPotionEffect(new PotionEffect(et, duration * 20, level - 1));
        p.sendMessage(ColorUtil.fixColors(" &8&6Zakupiles efekt: &c" + et.getName()));
    }
}

