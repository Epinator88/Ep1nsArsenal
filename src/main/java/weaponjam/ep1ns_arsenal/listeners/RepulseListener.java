package weaponjam.ep1ns_arsenal.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;
import weaponjam.ep1ns_arsenal.Ep1ns_Arsenal;

public class RepulseListener implements Listener {

    @EventHandler
    public void OnShiftPress(PlayerToggleSneakEvent ev)
    {
        if(ev.getPlayer().getInventory().getBoots() != null) {
            if (ev.getPlayer().getInventory().getBoots().equals(Ep1ns_Arsenal.instance.boots)) {
                if(ev.getPlayer().isSneaking()) {
                    if (ev.getPlayer().getPersistentDataContainer().get(Ep1ns_Arsenal.instance.jumpTimer, PersistentDataType.INTEGER) <= 0) {
                        Vector vel = ev.getPlayer().getVelocity();
                        Vector x = vel.clone();
                        x.setY(1.5);
                        ev.getPlayer().setVelocity(x);
                        ev.getPlayer().getPersistentDataContainer().set(Ep1ns_Arsenal.instance.jumpTimer, PersistentDataType.INTEGER, 30);
                        ev.getPlayer().playSound(ev.getPlayer(), Sound.ENTITY_FIREWORK_ROCKET_LAUNCH, 0.5F, 1F);
                    } else {
                        int z = ev.getPlayer().getPersistentDataContainer().get(Ep1ns_Arsenal.instance.jumpTimer, PersistentDataType.INTEGER);
                        ev.getPlayer().sendMessage("On Cooldown! " + (z / 10) + "." + (z % 10));
                    }
                }
            }
        }
    }
}
