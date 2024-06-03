package weaponjam.ep1ns_arsenal.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;
import weaponjam.ep1ns_arsenal.Ep1ns_Arsenal;

public class hitByCoolStuffListner implements Listener {

    @EventHandler
    public void onPlayerHit(EntityDamageByEntityEvent ev) {
        if (ev.getEntity() instanceof Player) {
            Player e = (Player) ev.getEntity();
            if(Ep1ns_Arsenal.isShieldDown(e)) {
                if (ev.getDamager() instanceof Player) {
                    Player p = (Player) ev.getDamager();
                    if (p.getInventory().getItemInMainHand().equals(Ep1ns_Arsenal.instance.doubleaxe)) {
                        if (p.getPersistentDataContainer().get(Ep1ns_Arsenal.instance.axeTimer, PersistentDataType.INTEGER) <= 0) {
                            Entity x = Bukkit.getWorld("world").spawnEntity(ev.getEntity().getLocation(), EntityType.PRIMED_TNT);
                            TNTPrimed y = (TNTPrimed) x;
                            p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 4, 2));
                            y.setFuseTicks(0);
                            p.getPersistentDataContainer().set(Ep1ns_Arsenal.instance.axeTimer, PersistentDataType.INTEGER, 50);
                        } else {
                            int z = p.getPersistentDataContainer().get(Ep1ns_Arsenal.instance.axeTimer, PersistentDataType.INTEGER);
                            p.sendMessage("On Cooldown! " + (z / 10) + "." + (z % 10));
                        }
                    }
                }

                if (ev.getDamager().getPersistentDataContainer().has(Ep1ns_Arsenal.instance.specialArrow, PersistentDataType.BOOLEAN)) {
                    Vector vel2 = new Vector(0, 5, 0);
                    Location l = e.getLocation();
                    Location l2 = l.clone().add(0, 1, 0);
                    e.teleport(l2);
                    ev.getEntity().setVelocity(vel2);
                }
            }
        }
        else {
            if (ev.getDamager() instanceof Player) {
                Player p = (Player) ev.getDamager();
                if (p.getInventory().getItemInMainHand().equals(Ep1ns_Arsenal.instance.doubleaxe)) {
                    if (p.getPersistentDataContainer().get(Ep1ns_Arsenal.instance.axeTimer, PersistentDataType.INTEGER) <= 0) {
                        Entity x = Bukkit.getWorld("world").spawnEntity(ev.getEntity().getLocation(), EntityType.PRIMED_TNT);
                        TNTPrimed y = (TNTPrimed) x;
                        p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 4, 127));
                        y.setFuseTicks(0);
                        p.getPersistentDataContainer().set(Ep1ns_Arsenal.instance.axeTimer, PersistentDataType.INTEGER, 50);
                    } else {
                        int z = p.getPersistentDataContainer().get(Ep1ns_Arsenal.instance.axeTimer, PersistentDataType.INTEGER);
                        p.sendMessage("On Cooldown! " + (z / 10) + "." + (z % 10));
                    }
                }
            }

            if (ev.getDamager().getPersistentDataContainer().has(Ep1ns_Arsenal.instance.specialArrow, PersistentDataType.BOOLEAN)) {
                Vector vel2 = new Vector(0, 5, 0);
                ev.getEntity().setVelocity(vel2);
            }
        }
    }
}
