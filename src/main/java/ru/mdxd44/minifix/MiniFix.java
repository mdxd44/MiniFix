package ru.mdxd44.minifix;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import ru.mdxd44.minifix.events.ShulkerCrasherFix;

public class MiniFix extends JavaPlugin {
    public void onEnable() {
        Bukkit.getLogger().info(ChatColor.WHITE + "Слушатель шалкеров " + ChatColor.GREEN + "успешно" + ChatColor.WHITE + " активирован.");
        this.getServer().getPluginManager().registerEvents(new ShulkerCrasherFix(), this);
        Bukkit.getLogger().info(ChatColor.WHITE + "Слушатель пакетов книги рецептов " + ChatColor.GREEN + "успешно" + ChatColor.WHITE + " активирован.");
        ProtocolManager protocolManager = ProtocolLibrary.getProtocolManager();
        protocolManager.addPacketListener(new PacketAdapter(this, ListenerPriority.NORMAL, new PacketType[]{PacketType.Play.Client.AUTO_RECIPE}){

            public void onPacketReceiving(PacketEvent event) {
                if (event.getPacketType() == PacketType.Play.Client.AUTO_RECIPE) {
                    event.setCancelled(true);
                }
            }
        });
    }

    public void onDisable() {
        this.getLogger().info("Плагин деактивирован.");
    }
}