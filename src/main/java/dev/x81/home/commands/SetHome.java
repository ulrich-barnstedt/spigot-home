package dev.x81.home.commands;

import dev.x81.home.Home;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import java.util.UUID;

public class SetHome implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return true;
        Player player = (Player) sender;

        UUID id = player.getUniqueId();
        Location at = player.getLocation();

        Home.running.getConfig().set("homes." + id, at);
        Home.running.saveConfig();

        sender.sendMessage(ChatColor.ITALIC + "" + ChatColor.GRAY + "Successfully set home.");
        return true;
    }
}
