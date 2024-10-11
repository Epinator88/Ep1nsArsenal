package weaponjam.ep1ns_arsenal.listeners;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.util.Vector;
import weaponjam.ep1ns_arsenal.Ep1ns_Arsenal;

public class repulseListener implements Listener {

    @EventHandler
    public void OnShiftPress(PlayerToggleSneakEvent ev)
    {
        if(ev.getPlayer().getInventory().getBoots() != null) {
            if (ev.getPlayer().getInventory().getBoots().equals(Ep1ns_Arsenal.instance.boots)) {
                if(ev.getPlayer().isSneaking()) {
                    if (ev.getPlayer().getPersistentDataContainer().get(Ep1ns_Arsenal.instance.jumpTimer, PersistentDataType.INTEGER) <= 0) {
                        Vector vel = ev.getPlayer().getVelocity();
                        Vector x = vel.clone();
                        x.setY(1.5);
                        ev.getPlayer().setVelocity(x);
                        if(ev.getPlayer().getInventory().getHelmet().equals(Ep1ns_Arsenal.instance.helm) && ev.getPlayer().getInventory().getHelmet() != null)
                        {
                            Location loc = ev.getPlayer().getLocation();
                            for(int i = 0; i < 7; i++)
                            {
                                Location l = loc.add(0, i, 0);
                                Player pl = l.getNearbyLivingEntities(1.8).stream().filter(LivingEntity -> LivingEntity instanceof Player).map(LivingEntity -> (Player) LivingEntity).findFirst().orElse(null);
                                if(pl != null) {
                                    Vector vel2 = pl.getVelocity();
                                    vel2.setY(15);
                                    pl.setVelocity(vel2);
                                }
                            }
                        }
                        ev.getPlayer().getPersistentDataContainer().set(Ep1ns_Arsenal.instance.jumpTimer, PersistentDataType.INTEGER, 30);
                        ev.getPlayer().playSound(ev.getPlayer(), Sound.ENTITY_FIREWORK_ROCKET_LAUNCH, 0.5F, 1F);
                    } else {
                        int z = ev.getPlayer().getPersistentDataContainer().get(Ep1ns_Arsenal.instance.jumpTimer, PersistentDataType.INTEGER);
                        ev.getPlayer().sendMessage("On Cooldown! " + (z / 10) + "." + (z % 10));
                    }
                }
            }
        }
    }
}
