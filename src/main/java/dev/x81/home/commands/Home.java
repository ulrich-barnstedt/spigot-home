package dev.x81.home.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
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

        if (!dev.x81.home.Home.running.getConfig().contains("homes." + id)) {
            sender.sendMessage(ChatColor.RED + "You do not have a home.");
            return true;
        }

        Location target = dev.x81.home.Home.running.getConfig().getObject("homes." + id, Location.class);
        player.teleport(target);
        sender.sendMessage(ChatColor.ITALIC + "" + ChatColor.GRAY + "Teleported you to your home.");

        return true;
    }
}
