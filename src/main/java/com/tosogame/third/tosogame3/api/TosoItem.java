/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tosogame.third.tosogame3.api;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scoreboard.Team;

/**
 *
 * @author peko
 */
public interface TosoItem {
    
    List<Team> list = new ArrayList();
    Player player = null;
    ItemStack item = new ItemStack(Material.AIR);
    
    public ItemStack item();
    
    public void itemEvent(Player player);
    
    public List<Team> team();
    
    
}
