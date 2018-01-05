package deathdrop;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Sheep;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class deathdrop extends JavaPlugin implements Listener{
	
	public void onEnable(){
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
	}

	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent pd){
		pd.setDroppedExp(1);
		pd.getDrops().clear();
		pd.getDrops().add(new ItemStack(Material.DIAMOND,10));
	}
	
	@EventHandler
	public void onEntityDeath(EntityDeathEvent ed){
		if(ed.getEntity() instanceof Sheep){
			ed.getEntity().getWorld().dropItem(ed.getEntity().getLocation(),new ItemStack(Material.SHEARS , 1));
			
		}
	}
}
