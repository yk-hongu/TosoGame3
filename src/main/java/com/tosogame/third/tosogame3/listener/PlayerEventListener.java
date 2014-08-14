/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tosogame.third.tosogame3.listener;

import com.tosogame.third.tosogame3.api.event.GameStartEvent;
import com.tosogame.third.tosogame3.api.event.PlayerTouchByHunterEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

/**
 *
 * @author peko
 */
public class PlayerEventListener implements Listener {

    public PlayerEventListener(Plugin plugin) {
        Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
    }
    
    @EventHandler
    public void onPVP(EntityDamageByEntityEvent event) {
        Entity at = event.getDamager();
        Entity df = event.getEntity();
        if (at instanceof Player && df instanceof Player) {
            Player att = (Player) at;
            Player def = (Player) df;
            String a_team = att.getScoreboard().getPlayerTeam(att).getName();
            String d_team = def.getScoreboard().getPlayerTeam(def).getName();
            if (a_team.equalsIgnoreCase("hunter") && d_team.equalsIgnoreCase("toso")) {
                event.setDamage(0);
                PlayerTouchByHunterEvent ev = new PlayerTouchByHunterEvent(event);
                Bukkit.getServer().getPluginManager().callEvent(new PlayerTouchByHunterEvent(event));
                if(ev.isCancelled()){
                    event.setCancelled(true);
                }else{
                    
                }
            } else if (a_team.equalsIgnoreCase(d_team)) {
                event.setCancelled(true);
            } else if (a_team.equalsIgnoreCase("toso") && d_team.equalsIgnoreCase("hunter")) {
                event.setCancelled(true);
            }
        }
    }
    
    @EventHandler
    public void t32(PlayerJoinEvent event){
//        TosoPlayer tp = new TosoPlayer();
//        tp.joinTosoGame(event.getPlayer());
        Bukkit.broadcastMessage(""+event.getPlayer().getUniqueId());
//        Bukkit.getServer().getPluginManager().callEvent(new PlayerTouchByHunterEvent(event));
    }
    
    @EventHandler
    public void t1(GameStartEvent event){
        
    }
}
