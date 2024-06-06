package weaponjam.ep1ns_arsenal.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitTask;
import weaponjam.ep1ns_arsenal.Ep1ns_Arsenal;
import weaponjam.ep1ns_arsenal.tasks.countdownTask;

public class playerJoinEvent implements Listener {

    @EventHandler
    public void PlayerJoin(PlayerJoinEvent ev)
    {
        ev.getPlayer().getPersistentDataContainer().set(Ep1ns_Arsenal.instance.jumpTimer, PersistentDataType.INTEGER, 30);
        ev.getPlayer().getPersistentDataContainer().set(Ep1ns_Arsenal.instance.axeTimer, PersistentDataType.INTEGER, 50);
        ev.getPlayer().getPersistentDataContainer().set(Ep1ns_Arsenal.instance.storedHealth, PersistentDataType.DOUBLE, 0.0);
        ev.getPlayer().getPersistentDataContainer().set(Ep1ns_Arsenal.instance.parryTiming, PersistentDataType.INTEGER, 5);
        ev.getPlayer().getPersistentDataContainer().set(Ep1ns_Arsenal.instance.parryCDTiming, PersistentDataType.INTEGER, 0);
        BukkitTask countdownTask = new countdownTask(ev.getPlayer(), Ep1ns_Arsenal.instance).runTaskTimer(Ep1ns_Arsenal.instance, 0L, 2L);
        ev.setJoinMessage(ev.getPlayer().getDisplayName() + " joined!!!");
    }

}
