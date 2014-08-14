/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tosogame.third.tosogame3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author peko
 */
public class Utility {

    public void copyTextFile(String name) {
        try {
            File file = new File("plugins/TosoGame3/" + name);
            if (!file.exists()) {
                URL sw = this.getClass().getClassLoader().getResource(name);
                InputStream s = sw.openConnection().getInputStream();
                if (s != null) {
                    BufferedReader read = new BufferedReader(new InputStreamReader(s, "UTF-8"));
                    BufferedWriter wr = new BufferedWriter(new FileWriter("plugins/TosoGame3/" + name));
                    String st;
                    while ((st = read.readLine()) != null) {
                        wr.write(st);
                        wr.newLine();
                    }
                    wr.flush();
                    wr.close();
                    read.close();
                    s.close();
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List readTextFile(String name) {
        List<String> list = new ArrayList();
        FileSystem fs = FileSystems.getDefault();
        Path path = fs.getPath("plugins/TosoGame3/" + name);
        if (Files.exists(path, LinkOption.NOFOLLOW_LINKS)) {
            try {
                for(String s : Files.readAllLines(path, Charset.forName(System.getProperty("file.encoding")))){
                    if(!s.equalsIgnoreCase("") && !s.equalsIgnoreCase("　")){
                        if(!s.substring(0, 1).equalsIgnoreCase("#")){
                            list.add(s);
                        }
                    }
                }
            } catch (IOException e) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return list;
    }
}
