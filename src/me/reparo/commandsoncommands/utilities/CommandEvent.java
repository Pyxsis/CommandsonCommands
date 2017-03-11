package me.reparo.commandsoncommands.utilities;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandEvent implements Listener {

	@EventHandler
	public void commandProcess(PlayerCommandPreprocessEvent e) {
		Util.executeCommands(e.getPlayer(), e.getMessage());
	}
	
	
	
}
