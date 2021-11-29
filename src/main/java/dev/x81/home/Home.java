package dev.x81.home;

import dev.x81.home.commands.SetHome;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class Home extends JavaPlugin {
    public FileConfiguration config = getConfig();
    public static JavaPlugin running;

    @Override
    public void onEnable() {
        running = this;

        config.addDefault("test", true);
        config.options().copyDefaults(true);
        saveConfig();

        this.getCommand("sethome").setExecutor(new SetHome());
    }

    @Override
    public void onDisable() {

    }
}
