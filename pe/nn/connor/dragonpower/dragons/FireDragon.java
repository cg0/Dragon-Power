package pe.nn.connor.dragonpower.dragons;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class FireDragon implements Dragon{

	@Override
	public void onJump(Player player, PlayerMoveEvent e) {
		if(player.isSneaking()){
			//Shift-jump = flight 
			Vector vector = player.getLocation().getDirection().multiply(4);
			player.setVelocity(vector);
		}
	}

	@Override
	public void onClick(Player player, PlayerInteractEvent e) {
		if(player.isSneaking()){
			if(e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK){
				//Shift-Click = Fireball
				player.getWorld().spawnEntity(player.getLocation(), EntityType.FIREBALL); //This doesn't work well
			}
			
		}
	}

	@Override
	public void onFall(Player player, EntityDamageEvent e) {
		e.setDamage(0.5); // 1/4 of a heart
	}

}
