/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tosogame.third.tosogame3.api;

import org.bukkit.EntityEffect;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

/**
 *
 * @author peko
 */
public class PlayerTouchByHunterEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private Player toso;
    private Player hunter;
    private boolean cancell;
    private EntityDamageEvent event;

    public PlayerTouchByHunterEvent(EntityDamageByEntityEvent event) {
        this.event = event;
        this.toso = (Player)event.getEntity();
        this.hunter = (Player)event.getDamager();
    }

    public Player getTosoPlayer() {
        return toso;
    }

    public Player getHunterPlayer() {
        return hunter;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public boolean isCancelled() {
        return cancell;
    }

    public void setCancelled(boolean cancel) {
        this.cancell = cancel;
    }

}
