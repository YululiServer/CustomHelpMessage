package xyz.acrylicstyle.chm;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class CustomHelpMessage extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        List<String> list = this.getConfig().getStringList("joinMessage");
        if (list == null || list.size() == 0) return;
        list.forEach(s -> e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', s)));
    }

    @EventHandler
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent e) {
        if (e.getMessage().startsWith("/help")) {
            e.setCancelled(true);
            List<String> list = this.getConfig().getStringList("messages");
            if (list == null || list.size() == 0) return;
            list.forEach(s -> e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', s)));
        }
    }
}
