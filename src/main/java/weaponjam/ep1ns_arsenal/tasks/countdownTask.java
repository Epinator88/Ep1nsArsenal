package weaponjam.ep1ns_arsenal.tasks;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import weaponjam.ep1ns_arsenal.Ep1ns_Arsenal;

public class countdownTask extends BukkitRunnable {

    private Player p;

    private int multiplier;

    private Ep1ns_Arsenal plugin;

    public countdownTask(Player p, Ep1ns_Arsenal plugin) {
        this.p = p;
        this.plugin = plugin;
    }

    @Override
    public void run() {
        if(p.getPersistentDataContainer().get(Ep1ns_Arsenal.instance.jumpTimer, PersistentDataType.INTEGER) > 0)
        {
            p.getPersistentDataContainer().set(Ep1ns_Arsenal.instance.jumpTimer, PersistentDataType.INTEGER, (p.getPersistentDataContainer().get(Ep1ns_Arsenal.instance.jumpTimer, PersistentDataType.INTEGER) - 1));
        }
        if(p.getPersistentDataContainer().get(Ep1ns_Arsenal.instance.axeTimer, PersistentDataType.INTEGER) > 0)
        {
            p.getPersistentDataContainer().set(Ep1ns_Arsenal.instance.axeTimer, PersistentDataType.INTEGER, (p.getPersistentDataContainer().get(Ep1ns_Arsenal.instance.axeTimer, PersistentDataType.INTEGER) - 1));
        }
    }
}
