package weaponjam.ep1ns_arsenal.listeners;

import com.destroystokyo.paper.event.player.PlayerLaunchProjectileEvent;
import org.bukkit.entity.Player;
import org.bukkit.entity.Trident;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.persistence.PersistentDataType;
import weaponjam.ep1ns_arsenal.Ep1ns_Arsenal;

public class tridentGotchaListener implements Listener {

    private Player p;

    @EventHandler
    public void onTridentThrow(ProjectileLaunchEvent ev)
    {
        if(ev.getEntity().getShooter() instanceof Player) {
            Player j = (Player) ev.getEntity().getShooter();
            if (j.getInventory().getItemInMainHand().equals(Ep1ns_Arsenal.instance.trident)) {
                ev.getEntity().getPersistentDataContainer().set(Ep1ns_Arsenal.instance.funnyTrident, PersistentDataType.BOOLEAN, true);
                p = j;
            }
        }
    }

    @EventHandler
    public void onTridentHit(EntityDamageByEntityEvent ev)
    {
        if(ev.getDamager() instanceof Trident) {
            if (ev.getDamager().getPersistentDataContainer().get(Ep1ns_Arsenal.instance.funnyTrident, PersistentDataType.BOOLEAN)) {
                ev.getEntity().teleport(p);
            }
        }
    }

}
