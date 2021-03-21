/*package pl.koloksk.listeners;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import pl.koloksk.main;

public class antynogi implements Listener {
    @EventHandler
    public void interractevent(PlayerInteractEvent e) {
        if (e.getItem().hasItemMeta() && e.getItem().getItemMeta().getDisplayName().equals(main.getinstance().getConfig().getString("antynogi.name"))) {
            Player p = e.getPlayer();
            for (Entity p1 : p.getNearbyEntities(p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ())) {
                if (e instanceof Player) {
                    if (p.getLocation().distance(p1.getLocation()) <= 5.0D) {
                        p.getInventory().remove(e.getItem());
                        p.teleport(p1);
                        break;
                    }
                }
            }
        }
    }
}*/
