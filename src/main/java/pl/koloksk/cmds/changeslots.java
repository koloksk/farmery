package pl.koloksk.cmds;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import pl.koloksk.main;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.logging.Level;

public class changeslots implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("changeslots.admin")) {
            sender.sendMessage(getConfigString("NoPermission"));
            return true;
        }
        if (args.length == 0) {
            sender.sendMessage(getConfigString("NoArgument"));
            return true;
        }
        try {
            changeSlots(Integer.parseInt(args[0]));
            sender.sendMessage(getConfigString("Success").replace("%n", args[0]));
        } catch (NumberFormatException e) {
            sender.sendMessage(getConfigString("NoNumber"));
        } catch (ReflectiveOperationException e) {
            sender.sendMessage(getConfigString("Error"));
            Bukkit.getLogger().log(Level.SEVERE, "An error occurred while updating max players", e);
        }
        return true;
    }


    private String getConfigString(String key) {
        return ChatColor.translateAlternateColorCodes('&', main.getinstance().getConfig().getString(key));
    }

    private void changeSlots(int slots) throws ReflectiveOperationException {
        Method serverGetHandle = Bukkit.getServer().getClass().getDeclaredMethod("getHandle");

        Object playerList = serverGetHandle.invoke(Bukkit.getServer());
        Field maxPlayersField = playerList.getClass().getSuperclass().getDeclaredField("maxPlayers");

        maxPlayersField.setAccessible(true);
        maxPlayersField.set(playerList, slots);
    }

}
