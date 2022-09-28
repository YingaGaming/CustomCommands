package games.yinga.CustomCommands.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import games.yinga.CustomCommands.Main;

public class CommandListener implements Listener {

    @EventHandler(priority = EventPriority.LOWEST)
    public void onCommand(PlayerCommandPreprocessEvent event) {
        FileConfiguration config = Main.getConfiguration();

        config.getConfigurationSection("commands").getKeys(false).forEach(key -> { // Loop over every configured command
            if (event.getMessage().toLowerCase().split(" ")[0].equals("/" + key)) { // Check if entered command matches command in config
                event.setCancelled(true); // Prevent the default action
                config.getStringList("commands." + key).forEach(message -> { // Loop over every response line
                    event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', message)); // Send line to player
                });
                
            }
        });

    }
    
}
