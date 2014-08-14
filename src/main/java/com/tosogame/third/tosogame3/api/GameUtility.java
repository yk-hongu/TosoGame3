/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tosogame.third.tosogame3.api;

import com.tosogame.third.tosogame3.api.event.GameStartEvent;
import com.tosogame.third.tosogame3.api.event.GameStopEvent;
import org.bukkit.Bukkit;

/**
 *
 * @author peko
 */
public class GameUtility {
    
    public void start(){
        Bukkit.getServer().getPluginManager().callEvent(new GameStartEvent());
    }
    
    public void stop(){
        Bukkit.getServer().getPluginManager().callEvent(new GameStopEvent());
    }
}
