package weaponjam.ep1ns_arsenal.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import weaponjam.ep1ns_arsenal.Ep1ns_Arsenal;

public class getAllCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(sender instanceof Player)
        {
            Player p = (Player) sender;
            int x = p.getInventory().firstEmpty();
            p.getInventory().setItem(x, Ep1ns_Arsenal.instance.vampSword);
            x = p.getInventory().firstEmpty();
            p.getInventory().setItem(x, Ep1ns_Arsenal.instance.doubleaxe);
            x = p.getInventory().firstEmpty();
            p.getInventory().setItem(x, Ep1ns_Arsenal.instance.trident);
            x = p.getInventory().firstEmpty();
            p.getInventory().setItem(x, Ep1ns_Arsenal.instance.bow);
            x = p.getInventory().firstEmpty();
            p.getInventory().setItem(x, Ep1ns_Arsenal.instance.gatlingBow);
            x = p.getInventory().firstEmpty();
            p.getInventory().setItem(x, Ep1ns_Arsenal.instance.fakePearl.asQuantity(16));
            x = p.getInventory().firstEmpty();
            p.getInventory().setItem(x, Ep1ns_Arsenal.instance.infGapple);
            p.getInventory().setBoots(Ep1ns_Arsenal.instance.boots);
            p.getInventory().setItemInOffHand(Ep1ns_Arsenal.instance.godShield);
            p.getInventory().setChestplate(Ep1ns_Arsenal.instance.chest);
        }
        return true;
    }
}
