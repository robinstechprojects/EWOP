package de.froznmine.ewop;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	private static File configFile = new File("plugins/EWOP/config.yml");
	private static List<String> dontUse, dontBuild, dontBreak;
	private static HashMap<String, String> language = new HashMap<String, String>();

	public static boolean canUseIn(Player p, String name) {
		if (dontUse.contains(name) && !p.hasPermission("ewop.use")) return false;
		return true;
	}
	
	public static boolean canBreakIn(Player p, String name) {
		if (dontBreak.contains(name) && !p.hasPermission("ewop.break")) return false;
		return true;
	}
	
	public static boolean canBuildIn(Player p, String name) {
		if (dontBuild.contains(name) && !p.hasPermission("ewop.build")) return false;
		return true;
	}
	
	@Override
	public void onEnable() { 
		if (!configFile.exists()) saveDefaultConfig();
		FileConfiguration configCfg = YamlConfiguration.loadConfiguration(configFile);
		
		Bukkit.getPluginManager().addPermission(new Permission("ewop.use", "The permission to use things everywhere."));
		Bukkit.getPluginManager().addPermission(new Permission("ewop.break", "The permission to break things everywhere."));
		Bukkit.getPluginManager().addPermission(new Permission("ewop.build", "The permission to build things everywhere."));
		
		dontUse = configCfg.getStringList("dontUse");
		dontBuild = configCfg.getStringList("dontBuild");
		dontBreak = configCfg.getStringList("dontBreak");
		
		//Unused
		FileConfiguration langCfg = YamlConfiguration.loadConfiguration(new File("plugins/EWOP.jar/" + configCfg.get("language") + ".yml"));
		
		Set<String> keys = langCfg.getConfigurationSection("").getKeys(false);
		for (String key : keys) {
			language.put(key, langCfg.getString(key));
		}
		//Unused end
		
		System.out.println("[EWOP] EWOP " + this.getDescription().getVersion() + " loaded without any problems!");
		Bukkit.getServer().getPluginManager().registerEvents(new EventListener(), this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		return false;
	}
	@Override
	public void onDisable() { 
	
	}
}