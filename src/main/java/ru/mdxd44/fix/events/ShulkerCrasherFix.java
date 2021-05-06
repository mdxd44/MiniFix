package ru.mdxd44.fix.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseEvent;
import ru.mdxd44.fix.ShulkerFix;

public class ShulkerCrasherFix implements Listener {
    @EventHandler
    public void onBlockDispense(BlockDispenseEvent e) {
        if (e.getBlock().getLocation().getBlockY() >= 253 && e.getItem().getType().name().endsWith("SHULKER_BOX")) {
            String posX = String.valueOf(e.getBlock().getLocation().getBlockX());
            String posY = String.valueOf(e.getBlock().getLocation().getBlockY());
            String posZ = String.valueOf(e.getBlock().getLocation().getBlockZ());
            String getMsg = ShulkerFix.config.getString("notifyMsg").replace("&", "§").replace("{X}", posX).replace("{Y}", posY).replace("{Z}", posZ);
            e.setCancelled(true);
            Bukkit.getConsoleSender().sendMessage(getMsg);
            for (Player p : Bukkit.getOnlinePlayers()) {
                if (!p.hasPermission("shulkerfix.notify")) continue;
                p.sendMessage(getMsg);
            }
        } else if (e.getBlock().getLocation().getBlockY() <= 4 && e.getItem().getType().name().endsWith("SHULKER_BOX")) {
            String posX = String.valueOf(e.getBlock().getLocation().getBlockX());
            String posY = String.valueOf(e.getBlock().getLocation().getBlockY());
            String posZ = String.valueOf(e.getBlock().getLocation().getBlockZ());
            String getMsg = ShulkerFix.config.getString("notifyMsg").replace("&", "§").replace("{X}", posX).replace("{Y}", posY).replace("{Z}", posZ);
            e.setCancelled(true);
            Bukkit.getConsoleSender().sendMessage(getMsg);
            for (Player p : Bukkit.getOnlinePlayers()) {
                if (!p.hasPermission("shulkerfix.notify")) continue;
                p.sendMessage(getMsg);
            }
        }
    }
}
