package weaponjam.ep1ns_arsenal.tasks;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class fakeBackTask extends BukkitRunnable {

    private Location l;

    private Player p;

    public fakeBackTask(Location l, Player p)
    {
        this.l = l;
        this.p = p;
    }

    @Override
    public void run()
    {
        Vector v = p.getEyeLocation().getDirection();
        p.teleport(l);
        p.getEyeLocation().setDirection(v);
        p.playSound(p, Sound.ENTITY_ENDERMAN_TELEPORT, 1F, 1F);
    }

}
