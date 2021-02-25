package pl.koloksk.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class TntListener implements Listener {
    @EventHandler(priority = EventPriority.LOW)
    public void ontnt(EntityExplodeEvent e){
        if(e.isCancelled()){ return;}
        if ( e.getEntity().getLocation().getY() >= 50){
            e.setCancelled(true);
        }

        if( e.getEntity().getType() == EntityType.PRIMED_TNT && e.getEntity().getLocation().getBlock().getType() == Material.STATIONARY_WATER){
            if(!e.isCancelled()) {
                e.getEntity().getLocation().getBlock().setType(Material.STONE);
                Bukkit.getWorld("world").createExplosion(e.getEntity().getLocation(), 5);
            }
        }
    }
}
