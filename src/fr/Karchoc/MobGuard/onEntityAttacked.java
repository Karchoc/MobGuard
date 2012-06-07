package fr.Karchoc.MobGuard;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.Location;
import org.bukkit.block.Dispenser;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

//This class is utile when a mob is attacked or killed by someone.

public class onEntityAttacked implements Listener {


	//This function write the coordonates of the victim and the guilty in a text file when a mob is attacked.

	@EventHandler
	public void AttackedMob(EntityDamageEvent Event) throws IOException{
                
                if (Event instanceof EntityDamageByEntityEvent){

                        EntityDamageByEntityEvent event = (EntityDamageByEntityEvent)Event;
                        Entity damager = event.getDamager();
                        Entity victim  = event.getEntity(); //Getting victim and damager as entity.
                        EntityType damagerType = damager.getType();
                        EntityType victimType = event.getEntityType();//Getting victim's and damager's entity type, but it still is an object
                        Location victimLocation = victim.getLocation();                
                        double victimLocationXDouble = victimLocation.getX();
                        double victimLocationYDouble = victimLocation.getY();
                        double victimLocationZDouble = victimLocation.getZ(); //Getting location of the victim

                        String damagerString = damager.toString(); //Getting EntityName to test if it is not an Ender Dragon          	
                        String victimTypeName = victimType.getName(); //To get victimType, who is an object, in a String
                        String damagerPlayerName;
                        String damagerTypeString = damagerType.getName();

                        if (!"CraftEnderDragon".equals(damagerString)){ //This if is there to avoid spamming of the log by EnderDragon damaging EnderDragon

                                if (damager instanceof Player){ //if the player attacked in close fight

                                        Player damagerPlayer = (Player) damager; 
                                        damagerPlayerName = damagerPlayer.getName();
                                        Writer.WriteFile(Time.getTime() + damagerPlayerName + " attacked a/an " + victimTypeName + " at: "+"X= " + victimLocationXDouble + ", Y = " + victimLocationYDouble + ", Z= " + victimLocationZDouble + "\r\n", "plugins\\MobGuard", "Attacks.txt");
                                }

                                if (damager instanceof Projectile){ //if the player attacked with an arrow or a splash potion

                                        Entity damagerShooter = ((Projectile) damager).getShooter();

                                        if (damagerShooter instanceof Player){ 

                                                Player damagerPlayer = (Player) damagerShooter; 
                                                damagerPlayerName = damagerPlayer.getName();
                                                Writer.WriteFile(Time.getTime() + damagerPlayerName + " attacked a/an " + victimTypeName + " with an " + damagerTypeString + " at: "+"X= " + victimLocationXDouble + ", Y = " + victimLocationYDouble + ", Z= " + victimLocationZDouble+ "\r\n", "plugins\\MobGuard", "Attacks.txt");
                                        }
                                        if (damagerShooter instanceof Dispenser){
                                                Location dispenserLocation = ((Dispenser)damagerShooter).getLocation();
                                                double dispenserLocationXDouble = dispenserLocation.getX();
                                                double dispenserLocationYDouble = dispenserLocation.getY();
                                                double dispenserLocationZDouble = dispenserLocation.getZ();
                                                Writer.WriteFile(Time.getTime()+"The dispenser at: "+"X= " + dispenserLocationXDouble + ", Y = " + dispenserLocationYDouble + ", Z= " + dispenserLocationZDouble+ " damaged a/an " + victimTypeName+ " at: "+"X= " + victimLocationXDouble + ", Y = " + victimLocationYDouble + ", Z= " + victimLocationZDouble+ "\r\n", "plugins\\MobGuard", "Attacks.txt");
                                        }
                                }
                        }
                }
                else{
                    
                        Entity victim  = Event.getEntity(); //Getting victim and damager as entity.
                        EntityType victimType = Event.getEntityType();//Getting victim's and damager's entity type, but it still is an object
                        Location victimLocation = victim.getLocation();                
                        double victimLocationXDouble = victimLocation.getX();
                        double victimLocationYDouble = victimLocation.getY();
                        double victimLocationZDouble = victimLocation.getZ(); //Getting location of the victim

                        String victimTypeName = victimType.getName(); //To get victimType, who is an object, in a String
                        EntityDamageEvent lastDamageCause = victim.getLastDamageCause();
                        DamageCause damageCause = lastDamageCause.getCause();
                        String damageCauseName = damageCause.name();
                        if (victim instanceof Player);
                        if ("FIRE_TICK".equals(damageCauseName));;
                        if ("FIRE".equals(damageCauseName));;
                        if ("LAVA".equals(damageCauseName));;
                        if ("PROJECTILE".equals(damageCauseName) && victimTypeName != null){
                                EntityDamageByEntityEvent event = (EntityDamageByEntityEvent)Event;
                                if (((Projectile)event.getDamager()).getShooter() instanceof Player);
                                if (((Projectile)event.getDamager()).getShooter() instanceof Dispenser);
                                else Writer.WriteFile(Time.getTime() +"A/An "+ victimTypeName + " was damaged by "+ damageCauseName +" at: "+"X= " + " at: "+"X= " + victimLocationXDouble + ", Y = " + victimLocationYDouble + ", Z= " + victimLocationZDouble+"\r\n", "plugins\\MobGuard", "Attacks.txt");
                        }
                        else{
                            if(!"FIRE_TICK".equals(damageCauseName)&& !"ENTITY_ATTACK".equals(damageCauseName) && !"FIRE".equals(damageCauseName)&& !"PROJECTILE".equals(damageCauseName) && !"LAVA".equals(damageCauseName) && victimTypeName != null)
                                Writer.WriteFile(Time.getTime() +"A/An "+ victimTypeName + " was damaged by "+ damageCauseName +" at: "+"X= " + " at: "+"X= " + victimLocationXDouble + ", Y = " + victimLocationYDouble + ", Z= " + victimLocationZDouble+"\r\n", "plugins\\MobGuard", "Attacks.txt");
                        }                           
                }
	}
}
