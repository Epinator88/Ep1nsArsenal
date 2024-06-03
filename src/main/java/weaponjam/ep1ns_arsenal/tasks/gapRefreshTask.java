package weaponjam.ep1ns_arsenal.tasks;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import weaponjam.ep1ns_arsenal.Ep1ns_Arsenal;

public class gapRefreshTask extends BukkitRunnable {

    private Player p;

    Ep1ns_Arsenal plugin;

    private String type;

    public gapRefreshTask(Player p, Ep1ns_Arsenal plugin, String type) {
        this.p = p;
        this.plugin = plugin;
        this.type = type;
    }

    @Override
    public void run()
    {
        if(type.equalsIgnoreCase("fromCore"))
        {
            int index = p.getInventory().first(Ep1ns_Arsenal.instance.infGappleCool);
            if(index != -1) {
                p.getInventory().setItem(index, Ep1ns_Arsenal.instance.infGappleMid1);
                p.playSound(p, Sound.ENTITY_PLAYER_BURP, 0.5F, 3F);
            }
        }
        if(type.equalsIgnoreCase("from1"))
        {
            int index = p.getInventory().first(Ep1ns_Arsenal.instance.infGappleMid1);
            if(index != -1) {
                p.getInventory().setItem(index, Ep1ns_Arsenal.instance.infGappleMid2);
                p.playSound(p, Sound.ENTITY_PLAYER_BURP, 0.5F, 1.5F);
            }
        }
        if(type.equalsIgnoreCase("from2"))
        {
            int index = p.getInventory().first(Ep1ns_Arsenal.instance.infGappleMid2);
            if(index != -1) {
                p.getInventory().setItem(index, Ep1ns_Arsenal.instance.infGapple);
                p.playSound(p, Sound.ENTITY_PLAYER_BURP, 0.5F, 1F);
            }
        }
    }
}
