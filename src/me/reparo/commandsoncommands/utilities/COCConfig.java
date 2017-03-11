package me.reparo.commandsoncommands.utilities;

import java.util.Arrays;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.reparo.commandsoncommands.CommandsOnCommands;

public class COCConfig implements CommandExecutor {
	
	 
	public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
		
		if(cmd.getName().equalsIgnoreCase("cocconfig")) {
			if(args.length == 1 && s.isOp()) {
				Util.getConfig().set("Commands." + args[0] + ".Required permissions", "essentials.help");
				Util.getConfig().set("Commands." + args[0] + ".Command executioner", "sender");
				Util.getConfig().set("Commands." + args[0] + ".Commands to execute", Arrays.asList("broadcast %sendername"));
				CommandsOnCommands.coc.saveDefaultConfig();
				CommandsOnCommands.coc.reloadConfig();
			}
		}
		
		
		
		return true;
	}
	
}