package me.AdamStark.Pearl;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;


public class Pearl extends JavaPlugin {
    
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "This is for players only!");
            return true;
        }
        
        Player p = (Player) sender;
        
        if (cmd.getName().equalsIgnoreCase("pearl")) {
            if (args.length == 0) {
                p.sendMessage(ChatColor.RED + "Please specify a player");
                return true;
            }
            Player target = Bukkit.getServer().getPlayer(args[0]);
            if (target == null) {
                p.sendMessage(ChatColor.RED + "Couldn't find player: " + args[0] + "on the server!");
                return true;
            }
            p.teleport(target.getLocation());
            return true;
        }
        return true;
    }
}
