package xyz.acrylicstyle.chm;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.acrylicstyle.tomeito_core.providers.ConfigProvider;
import xyz.acrylicstyle.tomeito_core.utils.Log;

public class CustomHelpMessage extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        Log.info("Enabled CustomHelpMessage");
    }

    @EventHandler
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent e) {
        if (e.getMessage().startsWith("/help")) {
            e.setCancelled(true);
            ConfigProvider config = ConfigProvider.initWithoutException("./plugins/CustomHelpMessage/config.yml");
            config.getStringList("messages").forEach(s -> e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', s)));
        }
    }
}
