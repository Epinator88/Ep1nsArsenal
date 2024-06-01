package weaponjam.ep1ns_arsenal.listeners;

import com.destroystokyo.paper.event.player.PlayerReadyArrowEvent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import weaponjam.ep1ns_arsenal.Ep1ns_Arsenal;

public class shootSpecialArrowListener implements Listener {

    @EventHandler
    public void ShootBowSpecialEvent (EntityShootBowEvent ev)
    {
        if(ev.getEntity() instanceof Player) {
            Player p = (Player) ev.getEntity();
            if(p.getInventory().getItemInMainHand().equals(Ep1ns_Arsenal.instance.bow))
            {
                ev.getProjectile().setGravity(false);
                ev.getProjectile().getPersistentDataContainer().set(Ep1ns_Arsenal.instance.specialArrow, PersistentDataType.BOOLEAN, true);
            }
        }
    }

    @EventHandler
    public void ShootingBowEvent (PlayerInteractEvent ev)
    {
        if(ev.getAction().equals(Action.RIGHT_CLICK_AIR)) {
            if (ev.getPlayer().getInventory().getItemInMainHand().equals(Ep1ns_Arsenal.instance.bow)) {
                ev.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 30, 120));
            }
        }
    }
}
