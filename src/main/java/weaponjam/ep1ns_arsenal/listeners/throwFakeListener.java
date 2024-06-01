package weaponjam.ep1ns_arsenal.listeners;

import com.destroystokyo.paper.event.player.PlayerLaunchProjectileEvent;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Snowball;
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
    public void onPlayerThrow(PlayerLaunchProjectileEvent ev)
    {
        if(ev.getPlayer().getInventory().getItemInMainHand().equals(Ep1ns_Arsenal.instance.fakePearl))
        {
            ev.setShouldConsume(true);
            Vector v = ev.getProjectile().getVelocity();
            Location l = ev.getProjectile().getLocation();
            Entity pearl = ev.getPlayer().getWorld().spawnEntity(l, EntityType.ENDER_PEARL);
            pearl.setVelocity(v);
            ev.getPlayer().playSound(ev.getPlayer(), Sound.ENTITY_ENDER_PEARL_THROW, 0.175F, 0.5F);
            ev.getProjectile().remove();
            int b = ev.getItemStack().getAmount();
            ev.getItemStack().setAmount(b - 1);
        }
    }
}
