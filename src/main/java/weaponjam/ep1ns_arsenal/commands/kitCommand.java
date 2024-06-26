package weaponjam.ep1ns_arsenal.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import weaponjam.ep1ns_arsenal.Ep1ns_Arsenal;

public class kitCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        Player p = (Player) sender;

        p.getInventory().clear();
        p.getInventory().setHelmet(Ep1ns_Arsenal.instance.helm);
        p.getInventory().setChestplate(Ep1ns_Arsenal.instance.chest);
        p.getInventory().setLeggings(Ep1ns_Arsenal.instance.jorts);
        p.getInventory().setBoots(Ep1ns_Arsenal.instance.boots);

        p.getInventory().setItem(0, Ep1ns_Arsenal.instance.vampSword);
        p.getInventory().setItem(1, Ep1ns_Arsenal.instance.doubleaxe);
        p.getInventory().setItem(2, Ep1ns_Arsenal.instance.trident);
        p.getInventory().setItem(3, Ep1ns_Arsenal.instance.bow);
        p.getInventory().setItem(4, Ep1ns_Arsenal.instance.gatlingBow);
        p.getInventory().setItem(5, new ItemStack(Material.ENDER_PEARL, 16));
        p.getInventory().setItem(6, Ep1ns_Arsenal.instance.infGapple);
        p.getInventory().setItem(7, Ep1ns_Arsenal.instance.fakePearl.asQuantity(16));
        p.getInventory().setItem(8, new ItemStack(Material.GOLDEN_CARROT, 64));
        p.getInventory().setItem(9, new ItemStack(Material.ARROW, 64));
        p.getInventory().setItem(10, new ItemStack(Material.ARROW, 64));
        p.getInventory().setItem(11, new ItemStack(Material.ARROW, 64));
        p.getInventory().setItem(32, new ItemStack(Material.ENDER_PEARL, 16));
        p.getInventory().setItem(34, Ep1ns_Arsenal.instance.fakePearl.asQuantity(16));
        p.getInventory().setItemInOffHand(Ep1ns_Arsenal.instance.godShield);

        return true;
    }
}
