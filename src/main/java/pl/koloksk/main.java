package pl.koloksk;

import net.dzikoysk.funnyguilds.FunnyGuilds;
import net.dzikoysk.funnyguilds.basic.guild.Guild;
import net.dzikoysk.funnyguilds.basic.guild.GuildUtils;
import net.dzikoysk.funnyguilds.event.guild.ally.GuildBreakAllyEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;
import pl.koloksk.cmds.changeslots;
import pl.koloksk.cmds.efekty;
import pl.koloksk.cmds.pomoc;
import pl.koloksk.listeners.*;
import pl.koloksk.utils.Border;

public final class main extends JavaPlugin implements Listener {

    public static main instance;
    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        kopaczfos();
        boyfarmer();
        sandfarmer();

        Bukkit.getPluginManager().registerEvents(this, this);
        Bukkit.getPluginManager().registerEvents(new menuListeners(), this);
        Bukkit.getPluginManager().registerEvents(new stowniarki(), this);
        Bukkit.getPluginManager().registerEvents(new rzucaki(), this);
        //Bukkit.getPluginManager().registerEvents(new antynogi(), this);
        //Bukkit.getPluginManager().registerEvents(new randomtp(), this);
        Bukkit.getPluginManager().registerEvents(new joinquit(), this);


        this.getCommand("efekty").setExecutor(new efekty());
        this.getCommand("pomoc").setExecutor(new pomoc());
        this.getCommand("changeslots").setExecutor(new changeslots());
        Menu.build();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public void kopaczfos(){
        ItemStack item = new ItemStack(Material.STONE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§8§l>> §7§lKopaczFosy §8§l<<");
        item.setItemMeta(meta);

        ShapedRecipe recipe = new ShapedRecipe(item);
        recipe.shape(" P ", "PSP", " P ");
        recipe.setIngredient('P', Material.DIAMOND_PICKAXE);
        recipe.setIngredient('S', Material.GOLDEN_APPLE);
        Bukkit.addRecipe(recipe);
    }
    public void boyfarmer(){
        ItemStack item = new ItemStack(Material.OBSIDIAN);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§1§l>> §9§lBoyFarmer §1§l<<");
        item.setItemMeta(meta);

        ShapedRecipe recipe = new ShapedRecipe(item);
        recipe.shape("PPP", "PSP", "PPP");
        recipe.setIngredient('P', Material.OBSIDIAN);
        recipe.setIngredient('S', Material.DIAMOND_BLOCK);
        Bukkit.addRecipe(recipe);
    }
    public void sandfarmer(){
        ItemStack item = new ItemStack(Material.SANDSTONE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§6§l>> §e§lSandFarmer §6§l<<");
        item.setItemMeta(meta);

        ShapedRecipe recipe = new ShapedRecipe(item);
        recipe.shape("PPP", "PSP", "PPP");
        recipe.setIngredient('P', Material.SAND);
        recipe.setIngredient('S', Material.DIAMOND_BLOCK);
        Bukkit.addRecipe(recipe);
    }

    @EventHandler
    public void blockp(BlockPlaceEvent e){
/*        Border border = new Border(new Vector(173.5, 1, 140.5), new Vector(-125.5, 255, -160.5));
        if (border.contains(e.getPlayer().getLocation()) && !e.getPlayer().isOp()) {
            e.setCancelled(true);
            return;
        }*/
        if(e.isCancelled()){return;}
                    if (e.getBlock().getType() == Material.CHEST && e.getBlock().getY() > 50) {
                        e.setCancelled(true);

                    }
                    if (e.getBlock().getType() == Material.TNT && e.getBlock().getY() > 50) {
                        e.setCancelled(true);

                    }

                    if (e.getItemInHand().hasItemMeta() && e.getItemInHand().getItemMeta().getDisplayName().equals("§6§l>> §e§lSandFarmer §6§l<<")) {
                        for(Guild i:GuildUtils.getGuilds()) {
                            if (i.getRegion().isIn(e.getBlock().getLocation())) {
                                e.getBlock().setType(Material.SAND);
                                for (int a = 3; a < e.getBlock().getY(); a++) {
                                    Block b = Bukkit.getWorld("world").getBlockAt(e.getBlock().getX(), a, e.getBlock().getZ());
                                    if (b.getType() != Material.BEDROCK) {
                                        b.setType(Material.SAND);
                                    }
                                }
                            } else {e.setCancelled(true);}
                        }

                    }
                    if (e.getItemInHand().hasItemMeta() && e.getItemInHand().getItemMeta().getDisplayName().equals("§1§l>> §9§lBoyFarmer §1§l<<")) {
                        for(Guild i:GuildUtils.getGuilds()) {
                            if (i.getRegion().isIn(e.getBlock().getLocation())) {
                                for (int a = 3; a < e.getBlock().getY(); a++) {
                                    Block b = Bukkit.getWorld("world").getBlockAt(e.getBlock().getX(), a, e.getBlock().getZ());
                                    if (b.getType() != Material.BEDROCK) {
                                        b.setType(Material.OBSIDIAN);
                                    }
                                }
                            } else {e.setCancelled(true);}
                        }
                    }
                    if (e.getItemInHand().hasItemMeta() && e.getItemInHand().getItemMeta().getDisplayName().equals("§8§l>> §7§lKopaczFosy §8§l<<")) {
                        for(Guild i:GuildUtils.getGuilds()) {
                            if (i.getRegion().isIn(e.getBlock().getLocation())) {
                                e.getBlock().setType(Material.AIR);
                                for (int a = 3; a < e.getBlock().getY(); a++) {
                                    Block b = Bukkit.getWorld("world").getBlockAt(e.getBlock().getX(), a, e.getBlock().getZ());
                                    if (b.getType() != Material.BEDROCK) {
                                        b.setType(Material.AIR);
                                    }
                                }
                            } else {e.setCancelled(true);}
                        }
                    }




    }
    public static main getinstance(){
        return instance;
    }


}
