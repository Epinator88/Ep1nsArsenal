package weaponjam.ep1ns_arsenal.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.damage.DamageType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;
import weaponjam.ep1ns_arsenal.Ep1ns_Arsenal;

import java.util.Objects;

public class longfallListener implements Listener {

    @EventHandler
    public void onLongFallWithBoots(EntityDamageEvent ev)
    {
        if(ev.getEntity() instanceof Player)
        {
            Player p = (Player) ev.getEntity();
            if(ev.getDamageSource().getDamageType().equals(DamageType.FALL)) {
                if(p.getInventory().getChestplate() != null && p.getInventory().getChestplate().equals(Ep1ns_Arsenal.instance.chest))
                {
                    double damage = ev.getDamage();
                    float mod = (float) ((float) damage * 0.4);
                    if(mod > 4.3F) {
                        p.setInvulnerable(true);
                        p.getLocation().createExplosion(mod, false, true);
                        p.setInvulnerable(false);
                        p.playSound(p, Sound.BLOCK_ANVIL_LAND, 3F, 0.25F);
                    }
                }
                if (p.getInventory().getBoots() != null && p.getInventory().getBoots().equals(Ep1ns_Arsenal.instance.boots)) {
                    ev.setDamage(0.0);
                    p.playSound(p, Sound.BLOCK_ANVIL_LAND, .15F, 3F);
                }
            }
        }
    }
}
