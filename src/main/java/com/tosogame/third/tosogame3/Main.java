/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tosogame.third.tosogame3;

import com.tosogame.third.tosogame3.listener.PlayerEventListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class Main extends JavaPlugin implements Listener {

    public static Scoreboard score;
    public static List<Team> toso = new ArrayList();
    public static List<Team> hunter = new ArrayList();
    public static List<Team> jail = new ArrayList();

    @Override
    public void onEnable() {
        saveDefaultConfig();
        regEvents();
        config();
    }

    @Override
    public void onDisable() {
        getLogger().info("The TosoGame3 plugin has been unloaded!");
    }

    private void regEvents() {
        PlayerEventListener playerEventListener = new PlayerEventListener(this);
    }

    private void config() {

        Utility ut = new Utility();
        ut.copyTextFile("team.txt");

        File nfir = new File("plugins\\TosoGame3\\book");
        File booktxt = new File("plugins\\TosoGame3\\book\\book.txt");
        if (!nfir.exists()) {
            nfir.mkdir();
            if (!booktxt.exists()) {
                try {
                    booktxt.createNewFile();
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

//        score = getServer().getScoreboardManager().getMainScoreboard();
//        if (score.getTeam("toso") == null) {
//            toso.add(score.registerNewTeam("toso"));
//        }
//        if (score.getTeam("hunter") == null) {
//            hunter.add(score.registerNewTeam("hunter"));
//        }
//        if (score.getTeam("jail") == null) {
//            jail.add(score.registerNewTeam("jail"));
//        }
    }

    private boolean checkColor(String cname) {
        switch (cname) {
            case "aqua":
            case "black":
            case "blue":
            case "dark_aqua":
            case "dark_blue":
            case "dark_gray":
            case "dark_purple":
            case "dark_red":
            case "gold":
            case "gray":
            case "green":
            case "light_purple":
            case "red":
            case "white":
            case "yellow":
                return true;
            default:
                return false;

        }
    }
}
