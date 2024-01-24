package de.loci2021.reportsystem.util;

import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Config {
    public static File file;
    public static Configuration config;

    public Config() {
        File dir = new File("./plugins/ReportSystem");
        if (!dir.exists()) {
            dir.mkdirs();
        }

        file = new File(dir, "config.yml");
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static Boolean contains(String path){
        return config.contains(path);
    }
    public static void set(String path, Object value){
        config.set(path, value);
        try {
            ConfigurationProvider.getProvider(YamlConfiguration.class).save(config, file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static Object get(String path){
        if (!contains(path)) {
            return null;
        }
        return config.get(path);
    }
}