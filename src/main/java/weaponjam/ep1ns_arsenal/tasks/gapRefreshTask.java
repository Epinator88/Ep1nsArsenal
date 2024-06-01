package weaponjam.ep1ns_arsenal.tasks;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import weaponjam.ep1ns_arsenal.Ep1ns_Arsenal;

public class gapRefreshTask extends BukkitRunnable {

    private Player p;

    Ep1ns_Arsenal plugin;

    public gapRefreshTask(Player p, Ep1ns_Arsenal plugin) {
        this.p = p;
        this.plugin = plugin;
    }

    @Override
    public void run()
    {
        int index = p.getInventory().first(Ep1ns_Arsenal.instance.infGappleCool);
        p.getInventory().setItem(index, Ep1ns_Arsenal.instance.infGapple);
        p.playSound(p, Sound.ENTITY_PLAYER_BURP, 0.5F, 1F);
    }
}
