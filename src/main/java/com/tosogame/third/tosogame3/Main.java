/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tosogame.third.tosogame3;

import com.tosogame.third.tosogame3.api.PlayerTouchByHunterEvent;
import com.tosogame.third.tosogame3.api.RegisterItem;
import com.tosogame.third.tosogame3.listener.PlayerEventListener;
import java.util.ResourceBundle;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

/**
 *
 * @author ja731j
 */
public class Main extends JavaPlugin implements Listener {

    public static Scoreboard score;
    public static Team toso;
    public static Team hunter;
    public static Team jail;
    
    @Override
    public void onEnable() {
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        PlayerEventListener playerEventListener = new PlayerEventListener(this);
        getServer().getPluginManager().registerEvents(this, this);
        RegisterItem items = new RegisterItem();
//        config();
        getServer().broadcastMessage(""+ResourceBundle.getBundle("test").getString("test"));
    }

    @Override
    public void onDisable() {
        getLogger().info("The TosoGame3 plugin has been unloaded!");
    }

    private void config(){
//        score = getServer().getScoreboardManager().getMainScoreboard();
//        if(score.getTeam("toso") != null){
//            toso = score.registerNewTeam("toso");
//        }
//        toso = score.registerNewTeam("toso");
//        hunter = score.registerNewTeam("hunter");
//        jail = score.registerNewTeam("jail");
//        hunter.setPrefix(""+ChatColor.RED);
//        jail.setPrefix(""+ChatColor.BLACK);
    }
    

    @EventHandler
    public void test(PlayerTouchByHunterEvent event) {
        
    }
}






























