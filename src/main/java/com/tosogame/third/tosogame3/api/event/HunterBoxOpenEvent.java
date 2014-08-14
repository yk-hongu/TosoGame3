/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tosogame.third.tosogame3.api.event;

import org.bukkit.Location;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 *
 * @author peko
 */
public class HunterBoxOpenEvent extends Event{

    private static final HandlerList handlers = new HandlerList();

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
    
    public Location getLocation(){
        return null;
    }
    
    public String getName(){
        return null;
    }
    
    public boolean isOpened(){
        return false;
    }
}
