package weaponjam.ep1ns_arsenal.listeners;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.ThrownPotion;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

public class potPunchListener implements Listener {

    int dist = 4;

    @EventHandler
    public void onPotPunch(PlayerInteractEvent ev)
    {
        if(ev.getAction().equals(Action.LEFT_CLICK_AIR)) {
            Vector v = ev.getPlayer().getEyeLocation().getDirection();
            for (int i = 0; i < dist; i++) {
                Projectile pot = ev.getPlayer().getWorld().getNearbyEntities(ev.getPlayer().getLocation().add(v.getX() * i, v.getY() * i, v.getZ() * i), 1, 1, 1).stream().filter(entity -> entity instanceof Projectile).map(entity -> (Projectile) entity).findFirst().orElse(null);
                if (pot instanceof ThrownPotion) {
                    pot.setVelocity(ev.getPlayer().getEyeLocation().getDirection().multiply(0.5));
                }
            }
        }
    }

}
