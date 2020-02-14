package xyz.acrylicstyle.chm;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class CustomHelpMessage extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent e) {
        if (e.getMessage().startsWith("/help")) {
            e.setCancelled(true);
            this.getConfig().getStringList("messages").forEach(s -> e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', s)));
        }
    }
}
