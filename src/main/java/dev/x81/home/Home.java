package dev.x81.home;

import dev.x81.home.commands.SetHome;
import org.bukkit.plugin.java.JavaPlugin;

public final class Home extends JavaPlugin {
    @Override
    public void onEnable() {
        ConfigLoader.getInstance().read();

        this.getCommand("sethome").setExecutor(new SetHome());
    }

    @Override
    public void onDisable() {

    }
}
