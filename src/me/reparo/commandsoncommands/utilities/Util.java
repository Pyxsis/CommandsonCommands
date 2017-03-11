package me.reparo.commandsoncommands.utilities;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import me.reparo.commandsoncommands.CommandsOnCommands;

public class Util {
	
	public static String colour(String s) {
		return ChatColor.translateAlternateColorCodes('&', s);
	}
	
	static FileConfiguration getConfig() {
		return CommandsOnCommands.coc.getConfig();
	}
	
	
	static List<String> commandsToExecute(String command) {
		if (getConfig().getStringList("Commands." + command + ".Commands to execute") == null) {
			return null;
		} else {
			return getConfig().getStringList("Commands." + command + ".Commands to execute");
		} 
		
	}

	static String permissionRequired(String command) {
		if(getConfig().getString("Commands." + command + ".Required permission") == null) {
			return "";
		} else {
			return getConfig().getString("Commands." + command + ".Required permission");
		}
	}
	
	static CommandSender whoExecutesCommands(Player sender, String command) {
		if(getConfig().getString("Commands." + command + ".Command executioner").equalsIgnoreCase("sender")) {
			return sender;
		} else {
			return Bukkit.getConsoleSender();
		}
	}
	
	public static void executeCommands(Player sender, String cmd) {
		if(cmd.contains(" ")) {
			cmd = (cmd.split(" "))[0];
		}
		if(commandsToExecute(cmd) == null) { return; }
		if(sender.hasPermission(permissionRequired(cmd))) {
			List<String> cte = commandsToExecute(cmd);
			for(String command : cte) {
				command = command
						.replace("%sendername", sender.getName())
						.replace("%senderdisplayname",sender.getDisplayName())
						.replace("%senderlocation", sender.getLocation().toString());
				Bukkit.getServer().dispatchCommand(whoExecutesCommands(sender, cmd), command);
			}
		}
	}
	
}
