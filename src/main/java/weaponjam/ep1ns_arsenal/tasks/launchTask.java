package weaponjam.ep1ns_arsenal.tasks;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Parrot;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class launchTask extends BukkitRunnable {

    private LivingEntity l;

    public launchTask(LivingEntity l)
    {
        this.l = l;
    }

    public void run()
    {
        while(l.getVelocity().getY() < 4.0)
        {
            Vector z = l.getVelocity();
            z.setY(5.0);
            l.setVelocity(z);
        }
    }

}
