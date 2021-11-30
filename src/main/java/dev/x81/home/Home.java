package dev.x81.home;

import dev.x81.home.commands.HomeOf;
import dev.x81.home.commands.SetHome;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class Home extends JavaPlugin {
    public FileConfiguration config;
    public static JavaPlugin running;

    @Override
    public void onEnable() {
        running = this;
        config = getConfig();

        setupConfig();
        registerCommands();
    }

    public void setupConfig () {
        config.addDefault("test", true);
        config.options().copyDefaults(true);
        saveConfig();
    }

    public void registerCommands () {
        this.getCommand("sethome").setExecutor(new SetHome());
        this.getCommand("home").setExecutor(new dev.x81.home.commands.Home());
        this.getCommand("homeof").setExecutor(new HomeOf());
    }

    @Override
    public void onDisable() {}
}
