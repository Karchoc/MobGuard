/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.Karchoc.MobGuard;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.Location;
import org.bukkit.block.Dispenser;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityDeathEvent;

/**
 *
 * @author Karchoc
 */
public class onEntityKilled implements Listener{
    
    Writer wr =  new Writer();
    
    @EventHandler
    public void KilledMob(EntityDeathEvent event) throws IOException{
        LivingEntity dead = event.getEntity();
        LivingEntity killer = dead.getKiller();
        
        EntityType deadType = dead.getType();
        String deadTypeName = deadType.getName();
        
        Location deadLocation = dead.getLocation();                
	double deadLocationXDouble = deadLocation.getX();
	double deadLocationYDouble = deadLocation.getY();
        double deadLocationZDouble = deadLocation.getZ(); //Getting location of the victim
        EntityDamageEvent lastDamageCause = dead.getLastDamageCause();
        DamageCause damageCause = lastDamageCause.getCause();
        
        //("La victime est: "+ deadTypeName);
                
        if (killer instanceof Player){
            Player killerPlayer = (Player)killer;
            String killerPlayerName = killerPlayer.getName();
            Writer.WriteFile(Time.getTime()+"The player "+ killerPlayerName + " killed a/an " + deadTypeName+ " at: "+"X= " + deadLocationXDouble + ", Y = " + deadLocationYDouble + ", Z= " + deadLocationZDouble+ "\r\n", "plugins\\MobGuard", "Attacks.txt");
        }
        if (killer instanceof Projectile){
            
            Entity killerShooter = ((Projectile)killer).getShooter();
            
            if (killerShooter instanceof Player){
                
                String killerPlayerName = ((Player)killerShooter).getName();
                Writer.WriteFile(Time.getTime()+"The player "+ killerPlayerName + " killed a/an " + deadTypeName+ " at: "+"X= " + deadLocationXDouble + ", Y = " + deadLocationYDouble + ", Z= " + deadLocationZDouble+ "\r\n", "plugins\\MobGuard", "Attacks.txt");
            }
            if (killerShooter instanceof Dispenser){
                Location dispenserLocation = ((Dispenser)killerShooter).getLocation();
                double dispenserLocationXDouble = dispenserLocation.getX();
                double dispenserLocationYDouble = dispenserLocation.getY();
                double dispenserLocationZDouble = dispenserLocation.getZ();
                Writer.WriteFile(Time.getTime()+"The dispenser at: "+"X= " + dispenserLocationXDouble + ", Y = " + dispenserLocationYDouble + ", Z= " + dispenserLocationZDouble+ " killed a/an " + deadTypeName+ " at: "+"X= " + deadLocationXDouble + ", Y = " + deadLocationYDouble + ", Z= " + deadLocationZDouble+ "\r\n", "plugins\\MobGuard", "Attacks.txt");
            }
        }
        else{
            String damageCauseName = damageCause.name();
            if ("ENTITY_ATTACK".equals(damageCauseName)){
                if (killer instanceof Player);
                else
                    Writer.WriteFile(Time.getTime() +"A/An "+ deadTypeName + " was killed by "+ damageCauseName +" at: "+"X= " + " at: "+"X= " + deadLocationXDouble + ", Y = " + deadLocationYDouble + ", Z= " + deadLocationZDouble+"\r\n", "plugins\\MobGuard", "Attacks.txt");
            }
            if (dead instanceof Player);
            if ("PROJECTILE".equals(damageCauseName)){
               if (killer instanceof Projectile){
                   if (((Projectile)killer).getShooter() instanceof Player);
                   if (((Projectile)killer).getShooter() instanceof Dispenser);
                   else
                       Writer.WriteFile(Time.getTime() +"A/An "+ deadTypeName + " was killed by "+ damageCauseName +" at: "+"X= " + " at: "+"X= " + deadLocationXDouble + ", Y = " + deadLocationYDouble + ", Z= " + deadLocationZDouble+"\r\n", "plugins\\MobGuard", "Attacks.txt");
               }
            }
            else
                if(!"FIRE_TICK".equals(damageCauseName)&& !"ENTITY_ATTACK".equals(damageCauseName) && !"FIRE".equals(damageCauseName)&& !"PROJECTILE".equals(damageCauseName))
                     Writer.WriteFile(Time.getTime() +"A/An "+ deadTypeName + " was killed by "+ damageCauseName +" at: "+"X= " + " at: "+"X= " + deadLocationXDouble + ", Y = " + deadLocationYDouble + ", Z= " + deadLocationZDouble+"\r\n", "plugins\\MobGuard", "Attacks.txt");
        }
    }
}
