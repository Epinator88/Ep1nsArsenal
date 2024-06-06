package weaponjam.ep1ns_arsenal.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import weaponjam.ep1ns_arsenal.Ep1ns_Arsenal;

public class getAllCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(sender instanceof Player)
        {
            Player p = (Player) sender;
            p.getInventory().addItem(Ep1ns_Arsenal.instance.vampSword);
            p.getInventory().addItem(Ep1ns_Arsenal.instance.doubleaxe);
            p.getInventory().addItem(Ep1ns_Arsenal.instance.trident);
            p.getInventory().addItem(Ep1ns_Arsenal.instance.bow);
            p.getInventory().addItem(Ep1ns_Arsenal.instance.gatlingBow);
            p.getInventory().addItem(Ep1ns_Arsenal.instance.fakePearl.asQuantity(16));
            p.getInventory().addItem(Ep1ns_Arsenal.instance.infGapple);
            p.getInventory().setBoots(Ep1ns_Arsenal.instance.boots);
            p.getInventory().setItemInOffHand(Ep1ns_Arsenal.instance.godShield);
            p.getInventory().setChestplate(Ep1ns_Arsenal.instance.chest);
            p.getInventory().setHelmet(Ep1ns_Arsenal.instance.helm);
            p.getInventory().setLeggings(Ep1ns_Arsenal.instance.jorts);
        }
        return true;
    }
}
