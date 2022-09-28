package games.yinga.CustomCommands;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import games.yinga.CustomCommands.Listeners.CommandListener;

public class Main extends JavaPlugin {

    private static FileConfiguration config;

    @Override
    public void onEnable() {

        this.saveDefaultConfig();
        Main.config = this.getConfig();

        this.getServer().getPluginManager().registerEvents(new CommandListener(), this);

        this.getServer().getLogger().info("CustomCommands Enabled");
    }

    public static FileConfiguration getConfiguration() {
        return config;
    }
    
}
