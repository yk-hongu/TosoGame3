/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tosogame.third.tosogame3.api;

import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.scoreboard.Team;

/**
 *
 * @author peko
 */
public class RegisterItem implements Listener {

    TosoItem itemClass;
    List<Team> team;
    ItemStack item;
    final int i = 0;

    public void registerItem(Plugin plugin, TosoItem itemClass) {
        Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
        this.itemClass = itemClass;
        team = itemClass.team();
        item = itemClass.item();
    }

    @EventHandler
    public void itemEvent(PlayerInteractEvent event) {
        if (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            Player player = event.getPlayer();
            if (player.getItemInHand().getType().equals(item.getType())) {
                for (Team tm : team) {
                    if (tm.hasPlayer(player)) {
                        itemClass.itemEvent(player);
                    }
                }
            }
        }
    }

}
