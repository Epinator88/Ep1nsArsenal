package weaponjam.ep1ns_arsenal.listeners;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import weaponjam.ep1ns_arsenal.Ep1ns_Arsenal;

public class parryListener implements Listener {

    @EventHandler
    public void onShieldUp(PlayerInteractEvent ev)
    {
        if(ev.getAction().isRightClick())
        {
            if(ev.getPlayer().getInventory().getItemInOffHand().getType().equals(Material.SHIELD))
            {
                if(ev.getPlayer().getInventory().getItemInMainHand() != null)
                {
                    if (ev.getPlayer().getPersistentDataContainer().get(Ep1ns_Arsenal.instance.parryCDTiming, PersistentDataType.INTEGER) == 0) {
                        ev.getPlayer().getPersistentDataContainer().set(Ep1ns_Arsenal.instance.parryTiming, PersistentDataType.INTEGER, 3);
                        ev.getPlayer().getPersistentDataContainer().set(Ep1ns_Arsenal.instance.parryCDTiming, PersistentDataType.INTEGER, 15);
                        ev.getPlayer().setShieldBlockingDelay(0);
                    }
                }
            }
        }
    }

    @EventHandler
    public void onHitParrying(EntityDamageByEntityEvent ev)
    {
        if(ev.getEntity() instanceof Player && ev.getDamager() instanceof Player)
        {
            Player p = (Player) ev.getDamager();
            Player e = (Player) ev.getEntity();
            if(e.getInventory().getItemInOffHand().getType().equals(Material.SHIELD))
            {
                if(e.getPersistentDataContainer().get(Ep1ns_Arsenal.instance.parryTiming, PersistentDataType.INTEGER) > 0)
                {
                    if(e.isBlocking()) {
                        p.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 20, 2));
                        p.playSound(p, Sound.BLOCK_ANVIL_BREAK, 1F, 1F);
                        e.getPersistentDataContainer().set(Ep1ns_Arsenal.instance.parryCDTiming, PersistentDataType.INTEGER, 0);
                    }
                }
            }
        }
    }
}
