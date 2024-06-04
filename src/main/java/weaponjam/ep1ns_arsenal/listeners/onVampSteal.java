package weaponjam.ep1ns_arsenal.listeners;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import weaponjam.ep1ns_arsenal.Ep1ns_Arsenal;

public class onVampSteal implements Listener {

    @EventHandler
    public void onHitPlayer(EntityDamageByEntityEvent ev)
    {
        if(ev.getDamager() instanceof Player)
        {
            Player p = (Player) ev.getDamager();
            if(ev.getEntity() instanceof Player) {
                Player l = (Player) ev.getEntity();
                if(Ep1ns_Arsenal.isShieldDown(l)) {
                    p.getPersistentDataContainer().set(Ep1ns_Arsenal.instance.storedHealth, PersistentDataType.DOUBLE, (p.getPersistentDataContainer().get(Ep1ns_Arsenal.instance.storedHealth, PersistentDataType.DOUBLE) + ev.getFinalDamage()));
                    if (l.getHealth() <= ev.getDamage()) {
                        if(p.getInventory().getItemInMainHand() != null && p.getInventory().getItemInMainHand().equals(Ep1ns_Arsenal.instance.vampSword)) {
                            double toHeal = ev.getDamager().getPersistentDataContainer().get(Ep1ns_Arsenal.instance.storedHealth, PersistentDataType.DOUBLE);
                            toHeal *= 0.9;
                            double health = p.getHealth();
                            double nowHealth = health + toHeal;
                            if (nowHealth >= 20.0) {
                                nowHealth -= 20.0;
                                int absAmnt = (int) nowHealth / 4;
                                p.setHealth(20.0);
                                if (p.hasPotionEffect(PotionEffectType.ABSORPTION)) {
                                    absAmnt += p.getPotionEffect(PotionEffectType.ABSORPTION).getAmplifier();
                                }
                                p.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 2400, absAmnt));
                            } else {
                                p.setHealth(nowHealth);
                            }
                            p.getPersistentDataContainer().set(Ep1ns_Arsenal.instance.storedHealth, PersistentDataType.DOUBLE, 0.0);
                        }
                    }
                }
                else {
                    p.getPersistentDataContainer().set(Ep1ns_Arsenal.instance.storedHealth, PersistentDataType.DOUBLE, (p.getPersistentDataContainer().get(Ep1ns_Arsenal.instance.storedHealth, PersistentDataType.DOUBLE) * 0.8));
                }
            }
            else {
                if (ev.getEntity() instanceof LivingEntity) {
                    if(p.getInventory().getItemInMainHand().equals(Ep1ns_Arsenal.instance.vampSword)) {
                        LivingEntity l = (LivingEntity) ev.getEntity();
                        p.getPersistentDataContainer().set(Ep1ns_Arsenal.instance.storedHealth, PersistentDataType.DOUBLE, (p.getPersistentDataContainer().get(Ep1ns_Arsenal.instance.storedHealth, PersistentDataType.DOUBLE) + ev.getFinalDamage()));
                        if (l.getHealth() <= ev.getDamage()) {
                            if(p.getInventory().getItemInMainHand() != null && p.getInventory().getItemInMainHand().equals(Ep1ns_Arsenal.instance.vampSword)) {
                                double toHeal = ev.getDamager().getPersistentDataContainer().get(Ep1ns_Arsenal.instance.storedHealth, PersistentDataType.DOUBLE);
                                toHeal *= 0.1;
                            /*
                            THIS IS VERY IMPORTANT.
                            THIS VALUE ABOVE IS WHAT THE HEALTH STOLEN WITH THE VAMPIRISM SWORD IS MULTIPLIED BY WHEN YOU KILL A MOB.
                            IT IS 10% OF THE HEALTH STORED IN THE SWORD ALTOGETHER.
                            KILL A MOB AT YOUR OWN RISK, YOU LOSE 90% OF YOUR HEALTH.
                             */
                                double health = p.getHealth();
                                double nowHealth = health + toHeal;
                                if (nowHealth >= 20.0) {
                                    nowHealth -= 20.0;
                                    int absAmnt = (int) nowHealth / 4;
                                    p.setHealth(20.0);
                                    if (p.hasPotionEffect(PotionEffectType.ABSORPTION)) {
                                        absAmnt += p.getPotionEffect(PotionEffectType.ABSORPTION).getAmplifier();
                                    }
                                    p.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 1200, absAmnt));
                                } else {
                                    p.setHealth(nowHealth);
                                }
                                p.getPersistentDataContainer().set(Ep1ns_Arsenal.instance.storedHealth, PersistentDataType.DOUBLE, 0.0);
                            }
                        }
                    }
                }
            }
        }
    }
}
