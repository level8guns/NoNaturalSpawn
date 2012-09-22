package me.JayzaSapphire;

import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.plugin.java.JavaPlugin;

public class NoNaturalSpawn extends JavaPlugin implements Listener {
	
	public void onEnable() {
		getConfig().options().copyDefaults(true);
		saveConfig();
		reloadConfig();
		
		getServer().getPluginManager().registerEvents(this, this);
	}

	@EventHandler
	public void onSpawn(CreatureSpawnEvent event) {
		World world = event.getLocation().getWorld();
		
		if (getConfig().getStringList("worlds").contains(world.getName().toLowerCase()) && event.getSpawnReason() == SpawnReason.NATURAL) {
			event.setCancelled(true);
		}
	}
}