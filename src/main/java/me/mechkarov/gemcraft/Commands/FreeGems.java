package me.mechkarov.gemcraft.Commands;

import me.mechkarov.gemcraft.Items;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class FreeGems implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {


        if (commandSender instanceof Player) {

            //creates the instance of the player
            Player player = (Player) commandSender;

            ItemStack gem = Items.gems();
            ItemStack enchgem = Items.enchantedgem();
            gem.setAmount(64);

            if (player.hasPermission("gemcraft.freegems")) {
                if (Objects.requireNonNull(player.getInventory().firstEmpty() == -1)) {
                    player.getWorld().dropItemNaturally(player.getLocation(), gem);
                    player.getWorld().dropItemNaturally(player.getLocation(), enchgem);
                } else {
                    player.getInventory().addItem(gem);
                    player.getInventory().addItem(enchgem);
                }
            }
        }
        return true;
    }
}