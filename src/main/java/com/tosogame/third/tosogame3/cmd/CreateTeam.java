/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tosogame.third.tosogame3.cmd;

import com.tosogame.third.tosogame3.Utility;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 *
 * @author peko
 */
public class CreateTeam implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        return true;
    }

    private void createTeam() {
        Utility ut = new Utility();
        List<String> list = ut.readTextFile("team.txt");
        Pattern pt = Pattern.compile("([a-z]+)\\s:\\s([a-z1-9]+)\\s:\\s([a-z]+)");
        for (String s : list) {
            Matcher mt = pt.matcher(s);
            if (mt.find()) {
                String team = mt.group(1);
                switch (team) {
                    case "toso":
                    case "hunter":
                    case "jail":
                    case "admin":
                        break;
                    default:
                        //error
                        break;
                }
            }
        }
    }
}
