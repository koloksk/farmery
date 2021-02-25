package pl.koloksk;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import pl.koloksk.utils.ColorUtil;

import java.util.ArrayList;


public class Menu {
    public static Inventory effectmenu;
    public static ItemStack blank;
    public static ItemStack speed1;
    public static ItemStack speed2;
    public static ItemStack sila1;
    public static ItemStack sila2;
    public static ItemStack skok1;
    public static ItemStack skok2;
    public static ItemStack haste1;
    public static ItemStack haste2;

    static {
        Menu.blank = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
        ItemMeta meta = Menu.blank.getItemMeta();
        meta.setDisplayName(ColorUtil.fixColors("&2&5&9"));
        Menu.blank.setItemMeta(meta);
        Menu.speed1 = new ItemStack(Material.POTION, 1, (short) 8258);
        meta = Menu.speed1.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ColorUtil.fixColors(" &8» &cCzas trwania: &690s"));
        lore.add(ColorUtil.fixColors(" &8» &cKoszt: &664x EMERALD BLOKOW"));
        meta.setLore(lore);
        Menu.speed1.setItemMeta(meta);
        Menu.speed2 = new ItemStack(Material.POTION, 1, (short) 8226);
        meta = Menu.speed2.getItemMeta();
        lore = new ArrayList<>();
        lore.add(ColorUtil.fixColors(" &8» &cCzas trwania: &690s"));
        lore.add(ColorUtil.fixColors(" &8» &cKoszt: &6128x EMERALD BLOKOW"));
        meta.setLore(lore);
        Menu.speed2.setItemMeta(meta);
        Menu.sila1 = new ItemStack(Material.POTION, 1, (short) 8201);
        meta = Menu.sila1.getItemMeta();
        lore = new ArrayList<>();
        lore.add(ColorUtil.fixColors(" &8» &cCzas trwania: &690s"));
        lore.add(ColorUtil.fixColors(" &8» &cKoszt: &664x EMERALD BLOKOW"));
        meta.setLore(lore);
        Menu.sila1.setItemMeta(meta);

        Menu.sila2 = new ItemStack(Material.POTION, 1, (short) 8233);
        meta = Menu.sila2.getItemMeta();
        lore = new ArrayList<>();
        lore.add(ColorUtil.fixColors(" &8» &cCzas trwania: &690s"));
        lore.add(ColorUtil.fixColors(" &8» &cKoszt: &6192x EMERALD BLOKOW"));
        meta.setLore(lore);
        Menu.sila2.setItemMeta(meta);

        Menu.skok1 = new ItemStack(Material.LEATHER_BOOTS);
        LeatherArmorMeta meta2 = (LeatherArmorMeta) Menu.skok1.getItemMeta();
        meta2.setDisplayName(ColorUtil.fixColors("&9Wyskoki skok I"));
        lore = new ArrayList<>();
        meta2.setColor(Color.WHITE);
        lore.add(ColorUtil.fixColors(" &8» &cCzas trwania: &690s"));
        lore.add(ColorUtil.fixColors(" &8» &cKoszt: &664x EMERALD BLOKOW"));
        meta2.setLore(lore);
        Menu.skok1.setItemMeta(meta2);
        Menu.skok2 = new ItemStack(Material.LEATHER_BOOTS);
        meta2 = (LeatherArmorMeta) Menu.skok2.getItemMeta();
        meta2.setDisplayName(ColorUtil.fixColors("&9Wyskoki skok II"));
        meta2.setColor(Color.WHITE);
        lore = new ArrayList<>();
        lore.add(ColorUtil.fixColors(" &8» &cCzas trwania: &690s"));
        lore.add(ColorUtil.fixColors(" &8» &cKoszt: &6128x EMERALD BLOKOW"));
        meta2.setLore(lore);
        Menu.skok2.setItemMeta(meta2);
        Menu.haste1 = new ItemStack(Material.NAME_TAG);
        meta = Menu.haste1.getItemMeta();
        meta.setDisplayName(ColorUtil.fixColors("&9Szybkie kopanie I"));
        lore = new ArrayList<>();
        lore.add(ColorUtil.fixColors(" &8» &cCzas trwania: &690s"));
        lore.add(ColorUtil.fixColors(" &8» &cKoszt: &664x EMERALD BLOKOW"));
        meta.setLore(lore);
        Menu.haste1.setItemMeta(meta);
        Menu.haste2 = new ItemStack(Material.NAME_TAG);
        meta = Menu.haste2.getItemMeta();
        meta.setDisplayName(ColorUtil.fixColors("&9Szybkie kopanie II"));
        lore = new ArrayList<>();
        lore.add(ColorUtil.fixColors(" &8» &cCzas trwania: &690s"));
        lore.add(ColorUtil.fixColors(" &8» &cKoszt: &6128x EMERALD BLOKOW"));
        meta.setLore(lore);
        Menu.haste2.setItemMeta(meta);
    }

    public static void build() {
        Menu.effectmenu = Bukkit.createInventory(null, 36, ColorUtil.fixColors(" &8» &9Efekty"));
        final int i = -1;
        Menu.effectmenu.setItem(0, Menu.blank);
        Menu.effectmenu.setItem(1, Menu.blank);
        Menu.effectmenu.setItem(2, Menu.blank);
        Menu.effectmenu.setItem(3, Menu.blank);
        Menu.effectmenu.setItem(4, Menu.blank);
        Menu.effectmenu.setItem(5, Menu.blank);
        Menu.effectmenu.setItem(6, Menu.blank);
        Menu.effectmenu.setItem(7, Menu.blank);
        Menu.effectmenu.setItem(8, Menu.blank);
        Menu.effectmenu.setItem(9, Menu.blank);
        Menu.effectmenu.setItem(18, Menu.blank);
        Menu.effectmenu.setItem(10, Menu.speed1);
        Menu.effectmenu.setItem(19, Menu.speed2);
        Menu.effectmenu.setItem(11, Menu.blank);
        Menu.effectmenu.setItem(20, Menu.blank);
        Menu.effectmenu.setItem(12, Menu.sila1);
        Menu.effectmenu.setItem(21, Menu.sila2);
        Menu.effectmenu.setItem(13, Menu.blank);
        Menu.effectmenu.setItem(22, Menu.blank);
        Menu.effectmenu.setItem(14, Menu.blank);
        Menu.effectmenu.setItem(23, Menu.blank);
        Menu.effectmenu.setItem(15, Menu.skok1);
        Menu.effectmenu.setItem(24, Menu.skok2);
        Menu.effectmenu.setItem(16, Menu.haste1);
        Menu.effectmenu.setItem(25, Menu.haste2);
        Menu.effectmenu.setItem(17, Menu.blank);
        Menu.effectmenu.setItem(26, Menu.blank);
        Menu.effectmenu.setItem(27, Menu.blank);
        Menu.effectmenu.setItem(28, Menu.blank);
        Menu.effectmenu.setItem(29, Menu.blank);
        Menu.effectmenu.setItem(30, Menu.blank);
        Menu.effectmenu.setItem(31, Menu.blank);
        Menu.effectmenu.setItem(32, Menu.blank);
        Menu.effectmenu.setItem(33, Menu.blank);
        Menu.effectmenu.setItem(34, Menu.blank);
        Menu.effectmenu.setItem(35, Menu.blank);
    }
}
