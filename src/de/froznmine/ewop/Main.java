package de.froznmine.ewop;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	private static List<String> dontUse, dontBuild, dontBreak;
	private static HashMap<String, String> language = new HashMap<String, String>();

	private File configFile;
	public FileConfiguration configCfg;
	
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
		boolean cfgNeu = false, langNeu = false, problems = false;
		
		configFile = new File("plugins/EWOP/config.yml");
		
		if (!configFile.exists()) {
			cfgNeu = true;
			saveDefaultConfig();
		}	
		
		configCfg = YamlConfiguration.loadConfiguration(configFile);
		
		File langFile = new File("plugins/EWOP/" + configCfg.get("language") + ".yml");
		
		if (!langFile.exists()) {
			langNeu = true;
			saveResource(configCfg.get("language") + ".yml", false);
		}

		Language.setup(this);
		
		Bukkit.getPluginManager().addPermission(new Permission("ewop.use", "The permission to use things everywhere."));
		Bukkit.getPluginManager().addPermission(new Permission("ewop.break", "The permission to break things everywhere."));
		Bukkit.getPluginManager().addPermission(new Permission("ewop.build", "The permission to build things everywhere."));
		
		dontUse = configCfg.getStringList("dontUse");
		dontBuild = configCfg.getStringList("dontBuild");
		dontBreak = configCfg.getStringList("dontBreak");
		
		Commands executor = new Commands(this);
		
		getCommand("nouse").setExecutor(executor);
		getCommand("nobuild").setExecutor(executor);
		getCommand("nobreak").setExecutor(executor);
		
		Bukkit.getServer().getPluginManager().registerEvents(new EventListener(), this);
		if (cfgNeu) System.out.println("[EWOP] " + language.get("configFileCreated"));
		if (langNeu) System.out.println("[EWOP] " + language.get("languageFileCreated"));
		if (!problems) System.out.println("[EWOP] " + language.get("loadNoProblems"));
		
	}
	
	public byte blockUse(String world) {
		if (!dontUse.contains(world)) {
			World w = Bukkit.getWorld(world);
			if (w != null) {
				dontUse.add(world);
				return 1;
			}
			else {
				return -1;
			}
		}
		return 0;
	}
	
	public byte blockBuild(String world) {
		if (!dontBuild.contains(world)) {
			World w = Bukkit.getWorld(world);
			if (w != null) {
				dontBuild.add(world);
				return 1;
			}
			else {
				return -1;
			}
		}
		return 0;
	}

	public byte blockBreak(String world) {
		if (!dontBreak.contains(world)) {
			World w = Bukkit.getWorld(world);
			if (w != null) {
				dontBreak.add(world);
				return 1;
			}
			else {
				return -1;
			}
		}
		return 0;
	}
	
	public byte allowUse(String world) {
		if (dontUse.contains(world)) {
			World w = Bukkit.getWorld(world);
			if (w != null) {
				dontUse.remove(world);
				return 1;
			}
			else {
				return -1;
			}
		}
		return 0;
	}
	
	public byte allowBuild(String world) {
		if (dontBuild.contains(world)) {
			World w = Bukkit.getWorld(world);
			if (w != null) {
				dontBuild.remove(world);
				return 1;
			}
			else {
				return -1;
			}
		}
		return 0;
	}

	public byte allowBreak(String world) {
		if (dontBreak.contains(world)) {
			World w = Bukkit.getWorld(world);
			if (w != null) {
				dontBreak.remove(world);
				return 1;
			}
			else {
				return -1;
			}
		}
		return 0;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		return false;
	}
	
	@Override
	public void onDisable() { 
		
	}
}