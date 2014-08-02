/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tosogame.third.tosogame3.api;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scoreboard.Team;

/**
 *
 * @author peko
 */
public interface TosoItem {
    
    Player player = null;
    
    public ItemStack item();
    
    public void itemEvent(Player player);
    
    public Team team(); 
    
    
}
