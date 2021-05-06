package ru.mdxd44.fix;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import ru.mdxd44.fix.events.ShulkerCrasherFix;

public class ShulkerFix extends JavaPlugin {
    public static FileConfiguration config;

    public void onEnable() {
        getLogger().info("Listener was started successfully.");
        getServer().getPluginManager().registerEvents(new ShulkerCrasherFix(), this);
        saveDefaultConfig();
        config = getConfig();
    }

    public void onDisable() {
        getLogger().info("Listener was deactivated successfully.");
    }
}
