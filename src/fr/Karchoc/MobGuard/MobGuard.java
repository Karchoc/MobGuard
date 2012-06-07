package fr.Karchoc.MobGuard;

import java.io.IOException;
import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

public class MobGuard extends JavaPlugin{
	Logger log = Logger.getLogger("Minecraft");
	
	public void onDisable(){
		log.info("MobGuard say you Good Bye!");
	}
	public void onEnable(){
		log.info("MobGuard say you Hello!");
		log.info("MobGuard is watching yours animals.");
		getServer().getPluginManager().registerEvents(new onEntityAttacked(), this);
                getServer().getPluginManager().registerEvents(new onEntityKilled(), this);
	}

}