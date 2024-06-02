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
            if(p.getInventory().getItemInMainHand().equals(Ep1ns_Arsenal.instance.fakePearl))
            {
                ev.getEntity().setShooter(null);
            }
        }
    }
}
