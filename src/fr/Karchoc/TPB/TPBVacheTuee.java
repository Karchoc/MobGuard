package fr.Karchoc.TPB;

import org.bukkit.Location;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;

public class TPBVacheTuee implements Listener {
	
	@EventHandler
	public void MortVache(EntityDamageByEntityEvent event){
		
		Entity damager = event.getDamager();
		Entity victim  = event.getEntity();
		Location victimLocation = victim.getLocation();
		double victimLocationXDouble = victimLocation.getX();
		double victimLocationYDouble = victimLocation.getY();
		double victimLocationZDouble = victimLocation.getZ();
		
		EntityType victimType = event.getEntityType();
		// Récupération de l'entité qui cause les dommages et du type de l'entité endommagée
		
		String damagerString = damager.toString();
		String victimTypeString = victimType.toString();
		// Transformation de l'entité qui cause les dommages et du type de l'entité endommagée en String
		
		if (damagerString != "CraftEnderDragon"){
			
			System.out.println("Le coupable ou l'arme est:" + damagerString);
			System.out.println("La victime est: "+ victimTypeString);
			System.out.println("La victime fut attaquée à: "+"X= " + victimLocationXDouble + ", Y = " + victimLocationYDouble + ", Z= " + victimLocationZDouble);
			
			if (damagerString == "CraftArrow"){
				LivingEntity damagerPlayer = ((Arrow) damager).getShooter();
				String damagerPlayerString = damagerPlayer.toString();
				
				System.out.println("L'agresseur est" + damagerPlayerString);
			}
			
		}
	}
	
	@EventHandler
	public void MortMob (EntityDeathEvent event){
		
		Entity damager = event.getEntity().getKiller();
		Entity victim  = event.getEntity();
		Location victimLocation = victim.getLocation();
		double victimLocationXDouble = victimLocation.getX();
		double victimLocationYDouble = victimLocation.getY();
		double victimLocationZDouble = victimLocation.getZ();
		
		EntityType victimType = event.getEntityType();
		// Récupération de l'entité qui cause les dommages et du type de l'entité endommagée
		
		String damagerString = damager.toString();
		String victimTypeString = victimType.toString();
		// Transformation de l'entité qui cause les dommages et du type de l'entité endommagée en String
		
		if (damagerString != "CraftEnderDragon"){
			
			System.out.println("\n Le coupable ou l'arme est:" + damagerString);
			System.out.println("La victime est: "+ victimTypeString);
			System.out.println("La victime est morte à: "+"X= " + victimLocationXDouble + ", Y = " + victimLocationYDouble + ", Z= " + victimLocationZDouble);
			
			if (damagerString == "CraftArrow"){
				LivingEntity damagerPlayer = ((Arrow) damager).getShooter();
				String damagerPlayerString = damagerPlayer.toString();
				
				System.out.println("Le meurtrier est: " + damagerPlayerString);
			}
		}
				
	}

}
