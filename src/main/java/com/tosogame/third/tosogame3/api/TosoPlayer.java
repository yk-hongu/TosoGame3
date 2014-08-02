/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tosogame.third.tosogame3.api;

import com.tosogame.third.tosogame3.Main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;

/**
 *
 * @author peko
 */
public class TosoPlayer{

    public void joinTosoGame(Player player) {
        player.setScoreboard(Main.score);
    }

    public void setTeam(Player player, TosoTeam team) {
        Main.jail.removePlayer(player);
        Main.toso.removePlayer(player);
        Main.hunter.removePlayer(player);
        if (team == TosoTeam.hunter) {
//            player.setPlayerListName(ChatColor.RED + player.getDisplayName());
            Main.hunter.addPlayer(player);
        } else if (team == TosoTeam.jail) {
//            player.setPlayerListName(ChatColor.BLACK + player.getDisplayName());
            Main.jail.addPlayer(player);
        } else if (team == TosoTeam.toso) {
//            player.setPlayerListName(ChatColor.WHITE + player.getDisplayName());
            Main.toso.addPlayer(player);
        }
        player.sendMessage("a");
    }

    public enum TosoTeam {
        toso,
        hunter,
        jail
    }

}
