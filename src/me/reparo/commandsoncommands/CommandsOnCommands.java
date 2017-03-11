package me.reparo.commandsoncommands;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.reparo.commandsoncommands.utilities.COCConfig;
import me.reparo.commandsoncommands.utilities.CommandEvent;

public class CommandsOnCommands extends JavaPlugin {
	
	public static CommandsOnCommands coc;

	
	public void onEnable() {
		coc = this;
		Bukkit.getServer().getPluginManager().registerEvents(new CommandEvent(), this);
		getCommand("cocconfig").setExecutor(new COCConfig());
		saveDefaultConfig();
	}

}