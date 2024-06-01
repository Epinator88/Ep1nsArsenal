package weaponjam.ep1ns_arsenal.listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitTask;
import weaponjam.ep1ns_arsenal.Ep1ns_Arsenal;
import weaponjam.ep1ns_arsenal.tasks.*;

public class gappleUpdateListener implements Listener {

    @EventHandler
    public void onGapEat(PlayerItemConsumeEvent ev)
    {
        if(ev.getItem().equals(Ep1ns_Arsenal.instance.infGapple))
        {
            ev.getPlayer().getInventory().setItemInMainHand(Ep1ns_Arsenal.instance.infGappleCool);
            BukkitTask gapRefreshTask = new gapRefreshTask(ev.getPlayer(), Ep1ns_Arsenal.instance).runTaskLater(Ep1ns_Arsenal.instance, 1800);
        }
    }
}
