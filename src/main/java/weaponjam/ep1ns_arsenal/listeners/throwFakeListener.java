package weaponjam.ep1ns_arsenal.listeners;

import com.destroystokyo.paper.event.player.PlayerLaunchProjectileEvent;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.util.Vector;
import weaponjam.ep1ns_arsenal.Ep1ns_Arsenal;

public class throwFakeListener implements Listener {

    @EventHandler
    public void onPlayerThrow(ProjectileLaunchEvent ev)
    {
        if(ev.getEntity().getShooter() instanceof Player)
        {
            Player p = (Player) ev.getEntity().getShooter();
            if(p.getInventory().getItemInMainHand().isSimilar(Ep1ns_Arsenal.instance.fakePearl))
            {
                Entity x = ev.getEntity().getWorld().spawnEntity(ev.getLocation(), EntityType.ENDER_PEARL);
                x.setVelocity(ev.getEntity().getVelocity());
                p.playSound(p, Sound.ENTITY_ENDER_PEARL_THROW, 0.175F, 0.5F);
                int b = p.getInventory().getItemInMainHand().getAmount();
                p.getInventory().getItemInMainHand().setAmount(b - 1);
                ev.getEntity().remove();
            }
        }
    }
}
