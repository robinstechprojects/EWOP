package de.froznmine.ewop;

import java.io.File;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	private static File welten = new File("plugins/ewop/worlds.yml");
	private static List<String> dontUse, dontBuild, dontBreak;

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
		saveResource("worlds.yml", false);
		FileConfiguration weltenCfg = YamlConfiguration.loadConfiguration(welten);
		
		Bukkit.getPluginManager().addPermission(new Permission("ewop.use", "The permission to use things everywhere."));
		Bukkit.getPluginManager().addPermission(new Permission("ewop.break", "The permission to break things everywhere."));
		Bukkit.getPluginManager().addPermission(new Permission("ewop.build", "The permission to build things everywhere."));
		
		dontUse = weltenCfg.getStringList("dontUse");
		dontBuild = weltenCfg.getStringList("dontBuild");
		dontBreak = weltenCfg.getStringList("dontBreak");
		
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