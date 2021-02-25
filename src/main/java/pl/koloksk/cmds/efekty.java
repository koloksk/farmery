package pl.koloksk.cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.koloksk.Menu;

public class efekty implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("efekty")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("# Ta komenda jest dla graczy!");
                return false;
            }
            Player p = (Player)sender;
            p.openInventory(Menu.effectmenu);
        }
        return false;
    }
}
