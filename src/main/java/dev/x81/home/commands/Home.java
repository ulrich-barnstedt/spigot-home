package dev.x81.home.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class Home implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return true;
        Player player = (Player) sender;

        UUID id = player.getUniqueId();

        //if (!config.properties.containsKey(id)) {
        //    sender.sendMessage(ChatColor.RED + "You do not have a home.");
        //    return true;
        //}

        return true;
    }
}
