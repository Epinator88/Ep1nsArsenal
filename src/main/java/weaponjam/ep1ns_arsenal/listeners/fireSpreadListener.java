package weaponjam.ep1ns_arsenal.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class fireSpreadListener implements Listener {

    @EventHandler
    public void onHitOnFire(EntityDamageByEntityEvent ev) {
        if(ev.getDamager().getFireTicks() > 0) {
            ev.getEntity().setFireTicks(40);
            ev.setDamage(ev.getDamage() * 1.3);
        }
    }
}
