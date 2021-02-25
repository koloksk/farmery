package pl.koloksk.listeners;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;
import pl.koloksk.main;

public class rzucaki implements Listener {
    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        if (e.getItemInHand() == null)
            return;
        if (e.getBlock().getType().equals(Material.TNT)) {
            if (e.getItemInHand().getItemMeta().getDisplayName() == null)
                return;
            if (e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equals("TNT")) {
                e.setCancelled(true);
                p.sendTitle("", "TNT musisz rzucic!");
            }
        }
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        FileConfiguration config = main.getinstance().getConfig();
        Player p = e.getPlayer();
        if (e.getMaterial() == Material.TNT && e.getItem().getItemMeta().getDisplayName() != null)
            if (e.getItem().getItemMeta().getDisplayName().equals(config.getString("Rzucaki.nazwa").replaceAll("&", ""))) {
                if (e.getAction() == Action.RIGHT_CLICK_AIR) {
                    p.getLocation().setY(p.getLocation().getY() + 1.0D);
                    Entity entity;
                    entity = p.getWorld().spawn(p.getLocation(), TNTPrimed.class);
                    entity.setVelocity(
                            p.getLocation().getDirection().multiply(config.getInt("Rzucaki.szybkosc")));
                    if (p.getItemInHand().getAmount() > 1) {
                        p.getItemInHand().setAmount(p.getItemInHand().getAmount() - 1);
                    } else {
                        p.setItemInHand(null);
                    }

                } else {
                    e.setCancelled(true);
                }
            }
    }
    @EventHandler
    public void craftevent(PrepareItemCraftEvent e){
        if(e.getInventory().getMatrix().length < 9){
            return;
        }
        checkCraft(new ItemStack(Material.TNT, 64),e.getInventory(), new ItemStack(Material.TNT, 64));
    }

    public void checkCraft(ItemStack result, CraftingInventory inv, ItemStack ingredients){
        ItemStack[] matrix = inv.getMatrix();
        for(int i = 0; i < 9; i++){
                if(matrix[i] == null || !matrix[i].equals(ingredients)){
                    return;
                }
            }
        inv.setResult(result);

    }

}

