package fr.Karchoc.MobGuard;

import java.io.IOException;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

//This class is utile when a mob is attacked or killed by someone.

public class onEntityAttacked implements Listener {	

	//This function write the coordonates of the victim and the guilty in a text file when a mob is attacked.
	
	@EventHandler
	public void AttackedMob(EntityDamageByEntityEvent event) throws IOException{


		Entity damager = event.getDamager();
		Entity victim  = event.getEntity(); //Getting victim and damager as entity.
                EntityType damagerType = damager.getType();
		EntityType victimType = event.getEntityType();//Getting victim's and damager's entity type, but it still is an object
		Location victimLocation = victim.getLocation();                
		double victimLocationXDouble = victimLocation.getX();
		double victimLocationYDouble = victimLocation.getY();
		double victimLocationZDouble = victimLocation.getZ(); //Getting location of the victim

		String damagerString = damager.toString(); //Getting EntityName to test if it is not an Ender Dragon          	
		String victimTypeString = victimType.toString(); //To get victimType, who is an object, in a String
                String damagerPlayerName;
                String damagerTypeString = damagerType.getName();

		if (!"CraftEnderDragon".equals(damagerString)){ //This if is there to avoid spamming of the log by EnderDragon damaging EnderDragon

			if (damager instanceof Player){ //if the player attacked in close fight

				Player damagerPlayer = (Player) damager; 
				damagerPlayerName = damagerPlayer.getName();
                                Writer.WriteFile(Time.getTime() + damagerPlayerName + " attacked a/an " + victimTypeString + " at: "+"X= " + victimLocationXDouble + ", Y = " + victimLocationYDouble + ", Z= " + victimLocationZDouble + "\r\n", "plugins\\MobGuard", "Attacks.txt");
			}

			if (damager instanceof Projectile){ //if the player attacked with an arrow or a splash potion
                            
				LivingEntity damagerShooter = ((Projectile) damager).getShooter();

				if (damagerShooter instanceof Player){ 

					Player damagerPlayer = (Player) damagerShooter; 
					damagerPlayerName = damagerPlayer.getName();

					Writer.WriteFile(Time.getTime() + damagerPlayerName + " attacked a/an " + victimTypeString + " with an " + damagerTypeString + " at: "+"X= " + victimLocationXDouble + ", Y = " + victimLocationYDouble + ", Z= " + victimLocationZDouble+ "\r\n", "plugins\\MobGuard", "Attacks.txt");
				}
			}			
		}
	}

}
