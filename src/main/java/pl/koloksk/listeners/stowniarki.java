package pl.koloksk.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import pl.koloksk.main;

public class stowniarki implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onBreak(BlockBreakEvent e) {


        Block blok = e.getBlock();
        final Location loc = e.getBlock().getLocation();
        final Location loc1 = new Location(blok.getWorld(), blok.getX(), blok.getY() - 1.0D, blok.getZ());
        if (blok.getType() == Material.STONE) {
            if(loc1.getBlock().getType() == Material.ENDER_STONE) {
                Bukkit.getScheduler().runTaskLater(main.getinstance(), new Runnable() {
                    public void run() {
                        if (loc1.getBlock().getType() == Material.ENDER_STONE)
                            loc.getBlock().setType(Material.STONE);
                    }
                }, 20);
            }
        }



    }
}
