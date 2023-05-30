/*package me.mechkarov.gemcraft.Commands;

import me.mechkarov.gemcraft.Items;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class ActivationBedrock implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {


        if (commandSender instanceof Player) {

            //creates the instance of the player
            Player player = (Player) commandSender;

            ItemStack ActivationBedrock = Items.ActivationBedrock();
            ActivationBedrock.setAmount(1);

            if (Objects.requireNonNull(player.getInventory().firstEmpty() == -1)) {
                player.getWorld().dropItemNaturally(player.getLocation(), ActivationBedrock);
            } else {
                player.getInventory().addItem(ActivationBedrock);
            }
        }
        return true;
    }
}*/