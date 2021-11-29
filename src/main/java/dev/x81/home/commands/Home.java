package dev.x81.home.commands;

import dev.x81.home.ConfigLoader;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Map;
import java.util.UUID;

public class Home implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return true;
        Player player = (Player) sender;

        UUID id = player.getUniqueId();
        ConfigLoader config = ConfigLoader.getInstance();

        if (!config.properties.containsKey(id)) {
            sender.sendMessage(ChatColor.RED + "You do not have a home.");
            return true;
        }

        //Location to = new Location(config.properties.getProperty(String.valueOf(id)));
        //player.teleport(Location.deserialize()

        return true;
    }
}
