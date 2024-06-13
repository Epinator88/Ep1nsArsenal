package weaponjam.ep1ns_arsenal.listeners;

import com.destroystokyo.paper.event.player.PlayerLaunchProjectileEvent;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;
import weaponjam.ep1ns_arsenal.Ep1ns_Arsenal;
import weaponjam.ep1ns_arsenal.tasks.*;

public class throwFakeListener implements Listener {

    private Location l;

    private Player p;

    @EventHandler
    public void onPlayerThrow(ProjectileLaunchEvent ev)
    {
        if(ev.getEntity().getShooter() instanceof Player)
        {
            p = (Player) ev.getEntity().getShooter();
            if(p.getInventory().getItemInMainHand().isSimilar(Ep1ns_Arsenal.instance.fakePearl))
            {
                ev.getEntity().getPersistentDataContainer().set(Ep1ns_Arsenal.instance.isfakePearl, PersistentDataType.BOOLEAN, true);
            }
        }
    }


    @EventHandler
    public void onLand(ProjectileHitEvent ev)
    {
        if(ev.getEntity().getPersistentDataContainer().has(Ep1ns_Arsenal.instance.isfakePearl, PersistentDataType.BOOLEAN))
        {
            Location l = p.getLocation();
            BukkitTask fakeBackTask = new fakeBackTask(l, p).runTaskLater(Ep1ns_Arsenal.instance, 30L);
        }
    }
}
