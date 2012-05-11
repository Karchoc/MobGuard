package fr.Karchoc.TPB;

import java.io.IOException;
import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

public class TPB extends JavaPlugin{
	Logger log = Logger.getLogger("Minecraft");
	
	public void onDisable(){
		log.info("Bon bah salut!");
	}
	public void onEnable(){
		log.info("Yo!");
		log.info("Le plugin est chargé!");
		getServer().getPluginManager().registerEvents(new TPBVacheTuee(), this);
		try {
			Writer.WriteFile("Test", "plugins\\MobGuard", "TPB.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}