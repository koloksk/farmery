package pl.koloksk.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.potion.PotionEffectType;
import pl.koloksk.Menu;
import pl.koloksk.utils.giveeffect;

public class listeners implements Listener {
    @EventHandler
    public void onInvClick(InventoryClickEvent e) {
        if (e.getSlotType().equals(InventoryType.SlotType.OUTSIDE))
            return;
        e.getCurrentItem();
        if (e.getInventory().getTitle().equals(Menu.effectmenu.getTitle())) {
            e.setCancelled(true);
            Player p = (Player) e.getWhoClicked();
            if (e.getCurrentItem().equals(Menu.speed1)) {
                giveeffect.giveeffect(p, PotionEffectType.SPEED, 90, 1, 64);
                return;
            }
            if (e.getCurrentItem().equals(Menu.speed2)) {
                giveeffect.giveeffect(p, PotionEffectType.SPEED, 90, 2, 128);
                return;
            }
            if (e.getCurrentItem().equals(Menu.sila1)) {
                giveeffect.giveeffect(p, PotionEffectType.INCREASE_DAMAGE, 90, 1, 32);
                return;
            }

            if (e.getCurrentItem().equals(Menu.sila2)) {
                giveeffect.giveeffect(p, PotionEffectType.INCREASE_DAMAGE, 90, 2, 192);
                return;
            }


            if (e.getCurrentItem().equals(Menu.skok1)) {
                giveeffect.giveeffect(p, PotionEffectType.JUMP, 90, 1, 64);
                return;
            }
            if (e.getCurrentItem().equals(Menu.skok2)) {
                giveeffect.giveeffect(p, PotionEffectType.JUMP, 90, 2, 128);
                return;
            }
            if (e.getCurrentItem().equals(Menu.haste1)) {
                giveeffect.giveeffect(p, PotionEffectType.FAST_DIGGING, 90, 1, 64);
                return;
            }
            if (e.getCurrentItem().equals(Menu.haste2))
                giveeffect.giveeffect(p, PotionEffectType.FAST_DIGGING, 90, 2, 128);
        }
    }

/*    @EventHandler
    public void onPlayerPrepareCrafting(PrepareItemCraftEvent e) {
            // this is our custom item - make sure all three ingredients are found
            int items = 0;
            for (ItemStack item : e.getInventory().getMatrix()) {
                if (item != null && item.getType() == Material.TNT && item.getAmount() == 64) {
                    items++;
                }
            }
            if (items == 9) {
                ItemStack tnt1 = new ItemStack(Material.TNT);
                ItemMeta tnt2 = tnt1.getItemMeta();
                tnt2.setDisplayName("§cRzucane TNT");
                tnt2.setLore(Arrays.asList("rzucane tnt"));
                tnt1.setItemMeta(tnt2);
                e.getInventory().setResult(tnt1);

            }


    }*/
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
    @EventHandler
    public void deathevent(PlayerDeathEvent e){
        e.setDeathMessage(null);
    }
}

