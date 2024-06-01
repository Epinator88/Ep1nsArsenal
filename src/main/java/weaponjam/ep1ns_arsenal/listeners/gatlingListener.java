package weaponjam.ep1ns_arsenal.listeners;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;
import weaponjam.ep1ns_arsenal.Ep1ns_Arsenal;

public class gatlingListener implements Listener {

    @EventHandler
    public void onGatlingShoot(PlayerInteractEvent ev)
    {
        if(ev.getAction().equals(Action.LEFT_CLICK_AIR))
        {
            if(!ev.getPlayer().getInventory().getItemInMainHand().isEmpty()) {
                if (ev.getItem().equals(Ep1ns_Arsenal.instance.gatlingBow)) {
                    if (ev.getPlayer().getInventory().first(Material.ARROW) != -1) {
                        Arrow x = (Arrow) ev.getPlayer().getWorld().spawnEntity(ev.getPlayer().getEyeLocation(), EntityType.ARROW);
                        Vector v = ev.getPlayer().getEyeLocation().getDirection();
                        v.multiply(3);
                        x.setShooter(ev.getPlayer());
                        x.setVelocity(v);
                        x.setDamage(2);
                        x.setHasBeenShot(true);
                        x.setCritical(true);
                        ev.getPlayer().playSound(ev.getPlayer(), Sound.ENTITY_ARROW_SHOOT, 0.65F, 0.4F);
                        int index = ev.getPlayer().getInventory().first(Material.ARROW);
                        int num = ev.getPlayer().getInventory().getItem(index).getAmount();
                        ev.getPlayer().getInventory().setItem(index, new ItemStack(Material.ARROW, num - 1));
                    }
                }
            }
        }
    }
}
