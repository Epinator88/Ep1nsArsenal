package weaponjam.ep1ns_arsenal.listeners;

import com.destroystokyo.paper.event.player.PlayerJumpEvent;
import net.kyori.adventure.text.Component;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import weaponjam.ep1ns_arsenal.Ep1ns_Arsenal;

import java.awt.*;

public class onHops implements Listener {

    @EventHandler
    public void onJump(PlayerJumpEvent ev)
    {
        if(ev.getPlayer().getInventory().getHelmet().equals(Ep1ns_Arsenal.instance.helm) && ev.getPlayer().getInventory().getHelmet() != null)
        {
            Location l = ev.getPlayer().getLocation().clone();
            l.add(0, 2, 0);
            l.getBlock().breakNaturally(new ItemStack(Material.NETHERITE_PICKAXE), true, true);
        }
    }
}
