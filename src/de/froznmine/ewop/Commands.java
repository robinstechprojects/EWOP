package de.froznmine.ewop;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {
	private Main plugin;
	public Commands(Main main) {
		plugin = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("nouse")) {
			if (args.length == 0) {
				if (sender instanceof Player) {
					Player p = (Player) sender;
					String world = p.getWorld().getName();
					
					if (Main.blockUse(world)) { // if added
						
					}
					else { // if world doesnt exist on server or already in list
						
					}
				}
				else {
					sender.sendMessage(""/*TODO Welt als console benötigt*/);
					return true;
				}
			}
		}
		return false;
	}

}
