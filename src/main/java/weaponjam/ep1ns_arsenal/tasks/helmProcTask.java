package weaponjam.ep1ns_arsenal.tasks;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class helmProcTask extends BukkitRunnable {

    private Player p;

    public helmProcTask(Player p) {
        this.p = p;
    }

    @Override
    public void run() {
        if(p.getHealth() <= 6.0) {
            p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 65, 100));
            p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 65, 3));
            p.setFireTicks(65);
        }
        else {
            this.cancel();
        }
    }
}
