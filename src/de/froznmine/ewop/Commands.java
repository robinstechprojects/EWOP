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
		if (cmd.getName().equalsIgnoreCase("blockuse")) {
			return blockUse(sender, args);
		}

		if (cmd.getName().equalsIgnoreCase("blockbuild")) {
			return blockBuild(sender, args);
		}

		if (cmd.getName().equalsIgnoreCase("blockbreak")) {
			return blockBreak(sender, args);
		}

		if (cmd.getName().equalsIgnoreCase("allowuse")) {
			return allowUse(sender, args);
		}

		if (cmd.getName().equalsIgnoreCase("allowbuild")) {
			return allowBuild(sender, args);
		}
		
		if (cmd.getName().equalsIgnoreCase("allowbreak")) {
			return allowBreak(sender, args);
		}
		return false;
	}

	private boolean blockUse(CommandSender sender, String[] args) {
		if (args.length == 0) { // if no world committed
			if (sender instanceof Player) {
				Player p = (Player) sender;
				String world = p.getWorld().getName();
				String message;
				switch (plugin.blockUse(world)) {
				case 1:	
					message = Language.get("commandWorldBlockUseSuccess");
					message.replace("<world>", world);
					message.replace("<version>", "");
					p.sendMessage(message); // erfolgreich blockiert
					return true;
				case 0:
					message = Language.get("commandWorldBlockUseFailedAlready");
					message.replace("<world>", world);
					message.replace("<version>", "");
					p.sendMessage(message); // bereits blockiert. /allowuse zum reaktivieren
					return true;
				case -1:
					message = Language.get("commandWorldBlockUseFailedNoWorld");
					message.replace("<world>", world);
					message.replace("<version>", "");
					p.sendMessage(message); // welt existiert nicht
					return true;
				}
			}
			else {
				String message = Language.get("commandWorldBlockUseFailedWorldMissing");
				message.replace("<world>", "");
				message.replace("<version>", "");
				sender.sendMessage(message); // Welt als console benötigt
				return true;
			}
		}
		
		if (args.length == 1) {
			String world = args[0];
			String message;
			switch (plugin.blockUse(world)) {
			case 1:	
				message = Language.get("commandWorldBlockUseSuccess");
				message.replace("<world>", world);
				message.replace("<version>", "");
				sender.sendMessage(message); // erfolgreich blockiert
				return true;
			case 0:
				message = Language.get("commandWorldBlockUseFailedAlready");
				message.replace("<world>", world);
				message.replace("<version>", "");
				sender.sendMessage(message); // bereits blockiert. /allowuse zum reaktivieren
				return true;
			case -1:
				message = Language.get("commandWorldBlockUseFailedNoWorld");
				message.replace("<world>", world);
				message.replace("<version>", "");
				sender.sendMessage(message); // welt existiert nicht
				return true;
			}
		}
		return false;
	}

	private boolean blockBuild(CommandSender sender, String[] args) {
		if (args.length == 0) { // if no world committed
			if (sender instanceof Player) {
				Player p = (Player) sender;
				String world = p.getWorld().getName();
				String message;
				
				switch (plugin.blockBuild(world)) {
				case 1:	
					message = Language.get("commandWorldBlockBuildSuccess");
					message.replace("<world>", world);
					message.replace("<version>", "");
					p.sendMessage(message); // erfolgreich blockiert
					return true;
				case 0:
					message = Language.get("commandWorldBlockBuildFailedAlready");
					message.replace("<world>", world);
					message.replace("<version>", "");
					p.sendMessage(message); // bereits blockiert. /allowuse zum reaktivieren
					return true;
				case -1:
					message = Language.get("commandWorldBlockBuildFailedNoWorld");
					message.replace("<world>", world);
					message.replace("<version>", "");
					p.sendMessage(message); // welt existiert nicht
					return true;
				}
			}
			else {
				String message = Language.get("commandWorldBlockBuildFailedWorldMissing");
				message.replace("<world>", "");
				message.replace("<version>", "");
				sender.sendMessage(message); // Welt als console benötigt
				return true;
			}
		}
		if (args.length == 1) {
			String world = args[0];
			String message;
			switch (plugin.blockBuild(world)) {
			case 1:	
				message = Language.get("commandWorldBlockBuildSuccess");
				message.replace("<world>", world);
				message.replace("<version>", "");
				sender.sendMessage(message); // erfolgreich blockiert
				return true;
			case 0:
				message = Language.get("commandWorldBlockBuildFailedAlready");
				message.replace("<world>", world);
				message.replace("<version>", "");
				sender.sendMessage(message); // bereits blockiert. /allowuse zum reaktivieren
				return true;
			case -1:
				message = Language.get("commandWorldBlockBuildFailedNoWorld");
				message.replace("<world>", world);
				message.replace("<version>", "");
				sender.sendMessage(message); // welt existiert nicht
				return true;
			}
		}
		return false;
	}

	private boolean blockBreak(CommandSender sender, String[] args) {
		if (args.length == 0) { // if no world committed
			if (sender instanceof Player) {
				Player p = (Player) sender;
				String world = p.getWorld().getName();
				String message;
				switch (plugin.blockBreak(world)) {// if added
				case 1:	
					message = Language.get("commandWorldBlockBreakSuccess");
					message.replace("<world>", world);
					message.replace("<version>", "");
					p.sendMessage(message); // erfolgreich blockiert
					return true;
				case 0:
					message = Language.get("commandWorldBlockBreakFailedAlready");
					message.replace("<world>", world);
					message.replace("<version>", "");
					p.sendMessage(message); // bereits blockiert. /allowuse zum reaktivieren
					return true;
				case -1:
					message = Language.get("commandWorldBlockBreakFailedNoWorld");
					message.replace("<world>", world);
					message.replace("<version>", "");
					p.sendMessage(message); // welt existiert nicht
					return true;
				}
			}
			else {
				String message = Language.get("commandWorldBlockBreakFailedWorldMissing");
				message.replace("<world>", "");
				message.replace("<version>", "");
				sender.sendMessage(message); // Welt als console benötigt
				return true;
			}
		}
		if (args.length == 1) {
			String world = args[0];
			String message;
			
			switch (plugin.blockBreak(world)) {// if added
			case 1:	
				message = Language.get("commandWorldBlockBreakSuccess");
				message.replace("<world>", world);
				message.replace("<version>", "");
				sender.sendMessage(message); // erfolgreich blockiert
				return true;
			case 0:
				message = Language.get("commandWorldBlockBreakFailedAlready");
				message.replace("<world>", world);
				message.replace("<version>", "");
				sender.sendMessage(message); // bereits blockiert. /allowuse zum reaktivieren
				return true;
			case -1:
				message = Language.get("commandWorldBlockBreakFailedNoWorld");
				message.replace("<world>", world);
				message.replace("<version>", "");
				sender.sendMessage(message); // welt existiert nicht
				return true;
			}
		}
		return false;
	}

	private boolean allowUse(CommandSender sender, String[] args) {
		if (args.length == 0) { // if no world committed
			if (sender instanceof Player) {
				Player p = (Player) sender;
				String world = p.getWorld().getName();
				
				switch (plugin.allowUse(world)) {// if added
				case 1:	
					p.sendMessage(""); // ADD erfolgreich blockiert
					return true;
				case 0:
					p.sendMessage(""); // ADD bereits blockiert. /allowuse zum reaktivieren
					return true;
				case -1:
					p.sendMessage(""); // ADD welt existiert nicht
					return true;
				}
			}
			else {
				sender.sendMessage("");// ADD Welt als console benötigt
				return true;
			}
		}
		if (args.length == 1) {
			String world = args[0];
			
			switch (plugin.allowUse(world)) {// if added
			case 1:	
				sender.sendMessage(""); // ADD erfolgreich blockiert
				return true;
			case 0:
				sender.sendMessage(""); // ADD bereits blockiert. /allowuse zum reaktivieren
				return true;
			case -1:
				sender.sendMessage(""); // ADD welt existiert nicht
				return true;
			}
		}
		return false;
	}

	private boolean allowBuild(CommandSender sender, String[] args) {
		if (args.length == 0) { // if no world committed
			if (sender instanceof Player) {
				Player p = (Player) sender;
				String world = p.getWorld().getName();
				
				switch (plugin.allowBuild(world)) {// if added
				case 1:	
					p.sendMessage(""); // ADD erfolgreich blockiert
					return true;
				case 0:
					p.sendMessage(""); // ADD bereits blockiert. /allowuse zum reaktivieren
					return true;
				case -1:
					p.sendMessage(""); // ADD welt existiert nicht
					return true;
				}
			}
			else {
				sender.sendMessage("");// ADD Welt als console benötigt
				return true;
			}
		}
		if (args.length == 1) {
			String world = args[0];
			
			switch (plugin.allowBuild(world)) {// if added
			case 1:	
				sender.sendMessage(""); // ADD erfolgreich blockiert
				return true;
			case 0:
				sender.sendMessage(""); // ADD bereits blockiert. /allowuse zum reaktivieren
				return true;
			case -1:
				sender.sendMessage(""); // ADD welt existiert nicht
				return true;
			}
		}
		return false;
	}

	private boolean allowBreak(CommandSender sender, String[] args) {
		if (args.length == 0) { // if no world committed
			if (sender instanceof Player) {
				Player p = (Player) sender;
				String world = p.getWorld().getName();
				
				switch (plugin.allowBreak(world)) {// if added
				case 1:	
					p.sendMessage(""); // ADD erfolgreich blockiert
					return true;
				case 0:
					p.sendMessage(""); // ADD bereits blockiert. /allowuse zum reaktivieren
					return true;
				case -1:
					p.sendMessage(""); // ADD welt existiert nicht
					return true;
				}
			}
			else {
				sender.sendMessage("");// ADD Welt als console benötigt
				return true;
			}
		}
		if (args.length == 1) {
			String world = args[0];
			
			switch (plugin.allowBreak(world)) {// if added
			case 1:	
				sender.sendMessage(""); // ADD erfolgreich blockiert
				return true;
			case 0:
				sender.sendMessage(""); // ADD bereits blockiert. /allowuse zum reaktivieren
				return true;
			case -1:
				sender.sendMessage(""); // ADD welt existiert nicht
				return true;
			}
		}
		return false;
	}

}
