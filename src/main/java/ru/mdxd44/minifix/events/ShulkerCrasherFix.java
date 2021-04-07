package ru.mdxd44.minifix.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseEvent;

public class ShulkerCrasherFix implements Listener {
    @EventHandler
    public void onBlockDispense(BlockDispenseEvent e) {
        if (e.getBlock().getLocation().getBlockY() >= 253 && e.getItem().getType().name().endsWith("SHULKER_BOX")) {
            Bukkit.getLogger().severe(ChatColor.WHITE + "Кто-то попытался крашнуть сервер способом выбрасывания шалкера на максимальной высоте!");
            e.setCancelled(true);
        } else if (e.getBlock().getLocation().getBlockY() <= 3 && e.getItem().getType().name().endsWith("SHULKER_BOX")) {
            Bukkit.getLogger().severe(ChatColor.WHITE + "Кто-то попытался крашнуть сервер способом выбрасывания шалкера на максимальной высоте!");
            e.setCancelled(true);
        }
    }
}
