package me.mechkarov.gemcraft.Commands;

import me.mechkarov.gemcraft.Items;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Objects;

public class FreeSapphire implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player) {

            //creates the instance of the player
            Player player = (Player) commandSender;

            ItemStack sapphire =  Items.sapphire();
            sapphire.setAmount(64);

            ItemStack helmet = Items.viphelmet();
            ItemStack chestplate = Items.vipchestplate();
            ItemStack leggings = Items.vipleggings();
            ItemStack boots = Items.vipboots();
            ItemStack sword = Items.vipsword();
            ItemStack money = Items.money();
            ItemStack money2 = Items.money2();
            ItemStack exp = Items.exp();
            ItemStack builderkit = Items.builderkit();
            ItemStack dtools = Items.dtools();
            ItemStack vipkit = Items.vipkit();
            ItemStack claimshovel = Items.claimshovel();

            if(player.hasPermission("gemcraft.freesapphire")) {
                if (Objects.requireNonNull(player.getInventory().firstEmpty() == -1)) {
                    player.getWorld().dropItemNaturally(player.getLocation(), sapphire);
                } else {
                    player.getInventory().addItem(sapphire);
                    //player.getInventory().addItem(helmet);
                    //player.getInventory().addItem(chestplate);
                    //player.getInventory().addItem(leggings);
                    //player.getInventory().addItem(boots);
                    //player.getInventory().addItem(sword);
                    player.getInventory().addItem(money);
                    player.getInventory().addItem(money2);
                    player.getInventory().addItem(exp);
                    player.getInventory().addItem(builderkit);
                    player.getInventory().addItem(dtools);
                    player.getInventory().addItem(vipkit);
                    player.getInventory().addItem(claimshovel);
                }
            }
        }
        return true;
    }
}