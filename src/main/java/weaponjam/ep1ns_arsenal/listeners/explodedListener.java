package weaponjam.ep1ns_arsenal.listeners;

import org.bukkit.damage.DamageType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import weaponjam.ep1ns_arsenal.Ep1ns_Arsenal;

public class explodedListener implements Listener {

    @EventHandler
    public void onHitWearingPants(EntityDamageEvent ev)
    {
        if(ev.getEntity() instanceof Player)
        {
            Player p = (Player) ev.getEntity();
            if(p.getInventory().getLeggings() != null && p.getInventory().getLeggings().equals(Ep1ns_Arsenal.instance.jorts))
            {
                if(ev.getDamageSource().getDamageType().equals(DamageType.EXPLOSION) || ev.getDamageSource().getDamageType().equals(DamageType.PLAYER_EXPLOSION))
                {
                    if(ev.getDamageSource().getSourceLocation() != null)
                    {
                        int y1 = (int) ev.getDamageSource().getSourceLocation().getY();
                        int y2 = (int) ev.getEntity().getLocation().getY();
                        if(y1 == y2)
                        {
                            ev.setDamage(0.0);
                        }
                    }
                }
            }
        }
    }

}
