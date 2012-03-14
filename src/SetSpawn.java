package net.tornwall.setspawn;

import java.util.logging.Logger;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;


public class SetSpawn extends JavaPlugin {
    Logger log;
    
    @Override
    public void onEnable() {
	log = this.getLogger();
	log.info("SetSpawn plugin enabled.");
    }

    @Override
    public void onDisable() {
	log.info("SetSpawn plugin disabled.");
    }

    @Override
    public boolean onCommand(CommandSender sender,
			     Command cmd,
			     String commandLabel,
			     String[] args) 
    {
	if(cmd.getName().equalsIgnoreCase("setspawn")) {
	    if(!(sender instanceof Player)) {
		sender.sendMessage("Not available from the console.");
	    } else {
		Player player = (Player)sender;
		Location loc = player.getLocation();
		if(player.getWorld().setSpawnLocation(loc.getBlockX(),
						      loc.getBlockY(),
						      loc.getBlockZ())) {
		    sender.sendMessage("Spawn location successfully set.");
		} else {
		    sender.sendMessage("Spawn location couldn't be set.");
		}
	    }
	    return true;
	}
	// We really ought not to get here.
	log.warning(String.format("SetSpawn: Unknown command name '%s'!",
			       cmd.getName()));
	return false;
    }
}
