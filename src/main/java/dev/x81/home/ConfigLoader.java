package dev.x81.home;

import org.bukkit.Bukkit;
import java.io.*;
import java.util.Properties;
import java.util.logging.Level;

public class ConfigLoader {
    private ConfigLoader() {}
    private static ConfigLoader INSTANCE;

    public static ConfigLoader getInstance () {
        if (INSTANCE == null) {
            INSTANCE = new ConfigLoader();
        }
        return INSTANCE;
    }

    public Properties properties;

    public void read() {
        this.properties = new Properties();
        try {
            properties.load(new FileInputStream(InternalConfig.PROP_PATH));
        } catch (IOException e) {
            Bukkit.getLogger().log(Level.WARNING, "Error reading file. Might not have been created yet. Attempting to write now. (" + e.getMessage() + ")");
            new File(InternalConfig.PROP_FOLDER).mkdirs();
            this.write();
        }
    }

    public void write() {
        try {
            properties.store(new FileOutputStream(InternalConfig.PROP_PATH), null);
        } catch (IOException e) {
            Bukkit.getLogger().log(Level.WARNING, "Error writing to file. (" + e.getMessage() + ")");
        }
    }
}
