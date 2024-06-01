package weaponjam.ep1ns_arsenal.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;
import weaponjam.ep1ns_arsenal.Ep1ns_Arsenal;

public class storedQuery implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        Player p = (Player) sender;
        p.sendMessage("You have " + p.getPersistentDataContainer().get(Ep1ns_Arsenal.instance.storedHealth, PersistentDataType.DOUBLE) + " health stored in the Vampirism Sword.");

        return true;
    }
}
