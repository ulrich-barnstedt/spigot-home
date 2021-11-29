package dev.x81.home.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class HomeOf implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return true;
        if (args.length == 0) return false;
        Player player = (Player) sender;
        OfflinePlayer target = Bukkit.getOfflinePlayer(args[0]);

        if (target == null) {
            player.sendMessage(ChatColor.RED + "This player could not be found.");
            return true;
        }

        UUID targetId = target.getUniqueId();

        if (!dev.x81.home.Home.running.getConfig().contains("homes." + targetId)) {
            sender.sendMessage(ChatColor.RED + "This player does not have a home.");
            return true;
        }

        Location tpTo = dev.x81.home.Home.running.getConfig().getObject("homes." + targetId, Location.class);
        player.teleport(tpTo);
        sender.sendMessage(ChatColor.ITALIC + "" + ChatColor.GRAY + "Teleported you to the players home.");

        return true;
    }
}
