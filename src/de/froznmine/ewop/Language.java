package de.froznmine.ewop;

import java.io.File;
import java.util.HashMap;
import java.util.Set;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Language {
	private static File file;
	private static FileConfiguration config;
	private static Main plugin;
	private static HashMap<String, String> language = new HashMap<String, String>();

	public static void setup(Main main) {
		plugin = main;
		file = new File("plugins/EWOP/" + plugin.configCfg.get("language") + ".yml");
			
		config = YamlConfiguration.loadConfiguration(file);
		
		Set<String> keys = config.getConfigurationSection("").getKeys(false);
		for (String key : keys) {
			String text = config.getString(key);
			text = text.replaceAll("<version>", "EWOP " + plugin.getDescription().getVersion());
			language.put(key, text);
		}
	}
	
	public static String get(String key) {
		return language.get(key);
	}
	
}
