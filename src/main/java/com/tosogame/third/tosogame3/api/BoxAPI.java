/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tosogame.third.tosogame3.api;

import com.tosogame.third.tosogame3.Main;

/**
 *
 * @author peko
 */
public class BoxAPI {

    public void t(){
        Main p = new Main();
    }
//    /**
//     * ハンターボックスを作ります
//     *
//     * @param boxname 設置したいハンターボックス
//     * @param loc ハンターボックスの座標
//     */
//    public void setBox(String boxname, Location loc) {
//        final Main PL = Main();
//        PL.getConfig().set("HunterBox.list." + boxname + ".world", loc.getWorld().getName());
//        PL.getConfig().set("HunterBox.list." + boxname + ".x", loc.getX());
//        PL.getConfig().set("HunterBox.list." + boxname + ".y", loc.getY());
//        PL.getConfig().set("HunterBox.list." + boxname + ".z", loc.getZ());
//        PL.getConfig().set("HunterBox.list." + boxname + ".flag", false);
//        PL.saveConfig();
//    }
//
//    /**
//     *
//     * @param boxname 削除したいハンターボックス
//     */
//    public void removeBox(String boxname) {
//        final Tosogame2 PL = Tosogame2.plugin;
//        if (PL.getConfig().contains("HunterBox.list." + boxname)) {
//            PL.getConfig().set("HunterBox.list." + boxname, null);
//            PL.saveConfig();
//        }
//    }
//
//    /**
//     * 既にハンターボックスが開放されている場合は機能しません
//     *
//     * @param boxname 開放したいハンターボックス
//     */
//    public void openBox(String boxname) {
//        final Tosogame2 PL = Tosogame2.plugin;
//        if (PL.getConfig().getBoolean("HunterBox.list." + boxname + ".flag") == false) {
//            Location loc = new Location(
//                    Bukkit.getServer().getWorld(PL.getConfig().getString("HunterBox.list." + boxname + ".world")),
//                    PL.getConfig().getDouble("HunterBox.list." + boxname + ".x"),
//                    PL.getConfig().getDouble("HunterBox.list." + boxname + ".y"),
//                    PL.getConfig().getDouble("HunterBox.list." + boxname + ".z")
//            );
//            PL.getConfig().set("HunterBox.list." + boxname + ".flag", true);
//            PL.saveConfig();
//            loc.getWorld().createExplosion(loc, 0);
//            loc.getBlock().setType(Material.AIR);
//        }
//    }
//
//    /**
//     * ハンターボックスが開放されているかどうかを切り替えることが出来ます。<br>
//     * true : 開放されている<br>
//     * false : 開放されていない<br>
//     *
//     * @param boxname ハンターボックス
//     * @param flag true/false
//     */
//    public void flagBox(String boxname, boolean flag) {
//        final Tosogame2 PL = Tosogame2.plugin;
//        PL.getConfig().set("HunterBox.list." + boxname + ".flag", flag);
//        PL.saveConfig();
//    }
//
//    /**
//     * ハンターボックスの位置へテレポートします。
//     *
//     * @param boxname ハンターボックス
//     * @param player テレポートさせたいプレイヤー
//     */
//    public void tpBox(String boxname, Player player) {
//        final Tosogame2 PL = Tosogame2.plugin;
//        Location loc = new Location(
//                Bukkit.getServer().getWorld(PL.getConfig().getString("HunterBox.list." + boxname + ".world")),
//                PL.getConfig().getDouble("HunterBox.list." + boxname + ".x"),
//                PL.getConfig().getDouble("HunterBox.list." + boxname + ".y"),
//                PL.getConfig().getDouble("HunterBox.list." + boxname + ".z")
//        );
//        player.teleport(loc);
//    }
//
//    /**
//     * ハンターボックスのリストを表示します。
//     *
//     * @param player ハンターボックスリストを表示させるプレイヤー
//     */
//    public void listBox(Player player) {
//        final Tosogame2 PL = Tosogame2.plugin;
//        if (PL.getConfig().contains("HunterBox.list.")) {
//            player.sendMessage("[ TosoGame ] ハンターボックスリスト");
//            for (String name : PL.getConfig().getConfigurationSection("HunterBox.list.").getKeys(false)) {
//                player.sendMessage("[ " + name + " ] world: " + PL.getConfig().getString("HunterBox.list." + name + ".world")
//                        + " x: " + PL.getConfig().getDouble("HunterBox.list." + name + ".x")
//                        + " y: " + PL.getConfig().getDouble("HunterBox.list." + name + ".y")
//                        + " z: " + PL.getConfig().getDouble("HunterBox.list." + name + ".z")
//                        + " flag: " + PL.getConfig().getBoolean("HunterBox.list." + name + ".flag")
//                );
//            }
//        }
//    }
//
//    /**
//     * ハンターボックスの位置を返します。
//     *
//     * @param boxname ハンターボックス
//     * @return loc ハンターボックスの位置
//     */
//    public Location BoxLocation(String boxname) {
//        final Tosogame2 PL = Tosogame2.plugin;
//        Location loc = new Location(
//                Bukkit.getServer().getWorld(PL.getConfig().getString("HunterBox.list." + boxname + ".world")),
//                PL.getConfig().getDouble("HunterBox.list." + boxname + ".x"),
//                PL.getConfig().getDouble("HunterBox.list." + boxname + ".y"),
//                PL.getConfig().getDouble("HunterBox.list." + boxname + ".z")
//        );
//        return loc;
//    }
}
