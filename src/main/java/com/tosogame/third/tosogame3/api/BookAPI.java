/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tosogame.third.tosogame3.api;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

/**
 *
 * @author peko
 */
public class BookAPI {

    /**
     * 「逃走中」というタイトルの本に対してページを追加できます。<br>
     * 汎用性をあげるために、権限による分別はしていません。（この本を持っている人のみが対象。逃走者以外でも可）
     *     
* @param msg ミッション告知用の本「逃走中」に追加するページ内容
     */
    public void writeBook(String msg) {
        for (Player player : Bukkit.getServer().getOnlinePlayers()) {
            for (ItemStack item : player.getInventory().getContents()) {
                if (item != null) {
                    if (item.getType().equals(Material.WRITTEN_BOOK)) {
                        BookMeta meta = (BookMeta) item.getItemMeta();
                        if (meta.getTitle().equals("逃走中")) {
                            meta.addPage(msg);
                            item.setItemMeta(meta);
                        }
                    }
                }
            }
        }
    }

    /**
     * ミッション告知用の本の内容をすべて削除します。
     */
    public void clearBook() {
        for (Player player : Bukkit.getServer().getOnlinePlayers()) {
            for (ItemStack item : player.getInventory().getContents()) {
                if (item == null) {
                    return;
                }
                if (item.getType().equals(Material.WRITTEN_BOOK)) {
                    BookMeta meta = (BookMeta) item.getItemMeta();
                    if (meta.getTitle().equals("逃走中")) {
                        List<String> list = new ArrayList<String>();
                        meta.setPages(list);
                        item.setItemMeta(meta);
                    }
                }
            }
        }
    }

    /**
     * テキストファイルから本用に最適化された文章を得ることが出来ます。<br>
     * ファイル中で使用できるタグに関しては、外部ファイルなどを参考にしてください。
     *     
* @param filename TosoGame2/book/ の中に存在するテキストファイル名を指定してください。
     * @return 指定したファイルの中身が空、もしくはファイルがない場合にnullを返します。
     */
    public String getMsg(String filename) {
        FileSystem fs = FileSystems.getDefault();
        Path path = fs.getPath("plugins/TosoGame3/book/" + filename + ".txt");
        if (Files.exists(path, LinkOption.NOFOLLOW_LINKS)) {
            try {
                List<String> list = Files.readAllLines(path, Charset.forName(System.getProperty("file.encoding")));
                String msg = replaceAll(list);
                return msg;
            } catch (IOException e) {
// TODO 自動生成された catch ブロック
                e.printStackTrace();
            }
        }
        return null;
    }

    private String replaceAll(List<String> list) {
        StringBuilder builder = new StringBuilder();
        for (String s : list) {
            StringBuilder sb = new StringBuilder(s);
            replace(sb, "<b>", "" + ChatColor.BOLD + "");
            replace(sb, "<i>", "" + ChatColor.ITALIC + "");
            replace(sb, "<magic>", "" + ChatColor.MAGIC + "");
            replace(sb, "<s>", "" + ChatColor.STRIKETHROUGH + "");
            replace(sb, "<u>", "" + ChatColor.UNDERLINE + "");
            replace(sb, "<aqua>", "" + ChatColor.RESET + "");
            replace(sb, "<black>", "" + ChatColor.BLACK + "");
            replace(sb, "<blue>", "" + ChatColor.BLUE + "");
            replace(sb, "<dark_aqua>", "" + ChatColor.DARK_AQUA + "");
            replace(sb, "<dark_blue>", "" + ChatColor.DARK_BLUE + "");
            replace(sb, "<dark_gray>", "" + ChatColor.DARK_GRAY + "");
            replace(sb, "<dark_purple>", "" + ChatColor.DARK_PURPLE + "");
            replace(sb, "<dark_red>", "" + ChatColor.DARK_RED + "");
            replace(sb, "<gold>", "" + ChatColor.GOLD + "");
            replace(sb, "<gray>", "" + ChatColor.GRAY + "");
            replace(sb, "<green>", "" + ChatColor.GREEN + "");
            replace(sb, "<light_purple>", "" + ChatColor.LIGHT_PURPLE + "");
            replace(sb, "<red>", "" + ChatColor.RED + "");
            replace(sb, "<white>", "" + ChatColor.WHITE + "");
            replace(sb, "<yellow>", "" + ChatColor.YELLOW + "");
            sb.append("\n");
            builder.append(new String(sb));
        }
        String msg = new String(builder);
        return msg;
    }

    private void replace(StringBuilder sb, String from, String to) {
        int index = sb.indexOf(from);
        while (index != -1) {
            sb.replace(index, index + from.length(), to);
            index += to.length();
            index = sb.indexOf(from, index);
        }
    }

}
