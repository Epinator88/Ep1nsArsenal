package weaponjam.ep1ns_arsenal.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitTask;
import weaponjam.ep1ns_arsenal.Ep1ns_Arsenal;
import weaponjam.ep1ns_arsenal.tasks.*;

public class shouldSetAblazeListener implements Listener {

    @EventHandler
    public void onHit(EntityDamageByEntityEvent ev) {
        if(ev.getEntity() instanceof Player) {
            Player p = (Player) ev.getEntity();
            if(p.getInventory().getHelmet().equals(Ep1ns_Arsenal.instance.helm)) {
                if (p.getHealth() <= 6.0) {
                    BukkitTask helmProcTask = new helmProcTask(p).runTaskTimer(Ep1ns_Arsenal.instance, 0, 60);
                }
            }
        }
    }
}
