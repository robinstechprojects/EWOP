package de.froznmine.ewop;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class EventListener implements Listener {
	Player pe = event.getPlayer();
	@EventHandler(priority = EventPriority.NORMAL)
	private void onBuild(BlockPlaceEvent  e) {
		if (!Main.canBuildIn(e.getPlayer(), e.getPlayer().getWorld().getName())) e.setCancelled(true);
		pe.sendMessage("Du kannst hier nicht bauen");
	}
	
	@EventHandler(priority = EventPriority.NORMAL)
	private void onBreak(BlockDamageEvent  e) {
		if (!Main.canBreakIn(e.getPlayer(), e.getPlayer().getWorld().getName())) e.setCancelled(true);
	}
	
	@EventHandler(priority = EventPriority.NORMAL)
	private void onUse(PlayerInteractEvent  e) {
		if(!Main.canUseIn(e.getPlayer(), e.getPlayer().getWorld().getName())) e.setCancelled(true);
	}
	
	@EventHandler(priority = EventPriority.NORMAL)
	private void onInteract(PlayerInteractEvent  e) {
		if(!Main.canUseIn(e.getPlayer(), e.getPlayer().getWorld().getName())) e.setCancelled(true);
	}
}
