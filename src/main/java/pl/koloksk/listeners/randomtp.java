package pl.koloksk.listeners;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;
import pl.koloksk.main;
import pl.koloksk.utils.Border;

import java.util.Random;

public class randomtp implements Listener {
    @EventHandler
    public void onClick(PlayerInteractEvent e) {

        FileConfiguration config = main.getinstance().getConfig();
        Player p = e.getPlayer();
        Border border = new Border(new Vector(173.5, 1, 140.5), new Vector(-125.5, 255, -160.5));
        if (border.contains(e.getPlayer().getLocation())) {


            Block b1 = e.getClickedBlock().getLocation().add(1.0D, 0.0D, 0.0D).getBlock();
            Block b2 = e.getClickedBlock().getLocation().add(-1.0D, 0.0D, 0.0D).getBlock();
            Block b3 = e.getClickedBlock().getLocation().add(0.0D, 0.0D, 1.0D).getBlock();
            Block b4 = e.getClickedBlock().getLocation().add(0.0D, 0.0D, -1.0D).getBlock();
            Random r = new Random();
            double x = r.nextDouble() * config.getDouble("loc.max") - config.getDouble("loc.min");
            double z = r.nextDouble() * config.getDouble("loc.max") - config.getDouble("loc.min");
            Location loc = new Location(e.getPlayer().getWorld(), x, p.getWorld().getHighestBlockYAt((int) x, (int) z) + 2, z);
            if (e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getClickedBlock().getType() == Material.STONE_BUTTON && (b1.getType() == Material.SPONGE || b2.getType() == Material.SPONGE || b3.getType() == Material.SPONGE || b4.getType() == Material.SPONGE)) {
                p.teleport(loc);
                p.sendMessage(config.getString("message.teleportacja").replaceAll("&", ""));
                p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 200, 2));
                p.playSound(p.getLocation(), Sound.FIREWORK_TWINKLE2, 1.0F, 1.0F);

            }
        }

    }
}
