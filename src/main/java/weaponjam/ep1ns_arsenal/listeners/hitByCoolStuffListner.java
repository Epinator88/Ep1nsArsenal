package weaponjam.ep1ns_arsenal.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;
import weaponjam.ep1ns_arsenal.Ep1ns_Arsenal;
import weaponjam.ep1ns_arsenal.tasks.launchTask;

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
                            Entity x = ev.getEntity().getWorld().spawnEntity(ev.getEntity().getLocation(), EntityType.PRIMED_TNT);
                            TNTPrimed y = (TNTPrimed) x;
                            p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 4, 2));
                            y.setFuseTicks(0);
                            p.getPersistentDataContainer().set(Ep1ns_Arsenal.instance.axeTimer, PersistentDataType.INTEGER, 100);
                        } else {
                            int z = p.getPersistentDataContainer().get(Ep1ns_Arsenal.instance.axeTimer, PersistentDataType.INTEGER);
                            p.sendMessage("On Cooldown! " + (z / 10) + "." + (z % 10));
                        }
                    }
                }

                if (ev.getDamager().getPersistentDataContainer().has(Ep1ns_Arsenal.instance.specialArrow, PersistentDataType.BOOLEAN)) {
                    BukkitTask launchTask = new launchTask(e).runTaskLater(Ep1ns_Arsenal.instance, 2L);
                }
            }
        }
        else {
            if(ev.getEntity() instanceof LivingEntity) {
                LivingEntity l = (LivingEntity) ev.getEntity();
                if (ev.getDamager() instanceof Player) {
                    Player p = (Player) ev.getDamager();
                    if (p.getInventory().getItemInMainHand().equals(Ep1ns_Arsenal.instance.doubleaxe)) {
                        if (p.getPersistentDataContainer().get(Ep1ns_Arsenal.instance.axeTimer, PersistentDataType.INTEGER) <= 0) {
                            Entity x = ev.getEntity().getWorld().spawnEntity(ev.getEntity().getLocation(), EntityType.PRIMED_TNT);
                            TNTPrimed y = (TNTPrimed) x;
                            p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 4, 2));
                            y.setFuseTicks(0);
                            p.getPersistentDataContainer().set(Ep1ns_Arsenal.instance.axeTimer, PersistentDataType.INTEGER, 100);
                        } else {
                            int z = p.getPersistentDataContainer().get(Ep1ns_Arsenal.instance.axeTimer, PersistentDataType.INTEGER);
                            p.sendMessage("On Cooldown! " + (z / 10) + "." + (z % 10));
                        }
                    }
                }

                if (ev.getDamager().getPersistentDataContainer().has(Ep1ns_Arsenal.instance.specialArrow, PersistentDataType.BOOLEAN)) {
                    BukkitTask launchTask = new launchTask(l).runTaskLater(Ep1ns_Arsenal.instance, 2L);
                }
            }
        }
    }
}
