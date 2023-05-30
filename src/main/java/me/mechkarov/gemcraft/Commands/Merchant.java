/*package me.mechkarov.gemcraft.Commands;
import me.mechkarov.gemcraft.Items;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

import static me.mechkarov.gemcraft.Items.*;

public class Merchant implements CommandExecutor, Listener {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        {

            if (commandSender instanceof Player) {

                Player player = (Player) commandSender;

                //shop
                Inventory merchant = Bukkit.createInventory(player, 9, ChatColor.DARK_RED + "Merchant");

                ItemStack border = Items.border();
                ItemStack shopsapphire = Items.shopsapphire();
                ItemStack shopenchantedgem = Items.shopenchantedgem();

                shopsapphire.setAmount(1);
                shopenchantedgem.setAmount(1);

                merchant.setItem(0, border);
                merchant.setItem(1, border);
                merchant.setItem(2, border);
                merchant.setItem(3, shopsapphire);
                merchant.setItem(4, border);
                merchant.setItem(5, shopenchantedgem);
                merchant.setItem(6, border);
                merchant.setItem(7, border);
                merchant.setItem(8, border);

                player.openInventory(merchant);

            } else {
                System.out.println("You must be a player to execute this command.");
            }

            return true;
        }

    }

    @EventHandler
    public void onInventoryClick(final InventoryClickEvent e) {

        if (e.getView().getTitle().equals(ChatColor.DARK_RED + "Merchant")) {
            e.setCancelled(true);

            if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE + "~Sapphire~ (Cost: 2240 Gems)")) {
                if (e.getWhoClicked().getInventory().containsAtLeast(Items.gems(), 2240)) {
                    ItemStack gem = Items.gems();
                    gem.setAmount(2240);
                    if (Objects.requireNonNull(e.getWhoClicked()).getInventory().firstEmpty() == -1) {

                        e.getWhoClicked().getWorld().dropItemNaturally(e.getWhoClicked().getLocation(), sapphire());

                    } else {

                        e.getWhoClicked().getInventory().addItem(sapphire());
                    }
                    e.getWhoClicked().getInventory().removeItem(gem);
                    e.getWhoClicked().getWorld().playSound(e.getWhoClicked().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2, 2);
                } else {
                    e.getWhoClicked().sendMessage("Insufficient gem balance");
                    e.getWhoClicked().getWorld().playSound(e.getWhoClicked().getLocation(), Sound.ENTITY_VILLAGER_NO, 2, 1);
                }
            }
            //Buying a spawner
            else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Level 1 (Cost: $69)")) {

                Economy eco = Gemcraft.getEconomy();

                if (eco.getBalance((OfflinePlayer) e.getWhoClicked()) >= 69) {

                    if (Objects.requireNonNull(e.getWhoClicked()).getInventory().firstEmpty() == -1) {

                        e.getWhoClicked().getWorld().dropItemNaturally(e.getWhoClicked().getLocation(), spawner());
                        EconomyResponse response = eco.withdrawPlayer((OfflinePlayer) e.getWhoClicked(), 69);
                        e.getWhoClicked().sendMessage(ChatColor.RED + eco.format(response.amount) + " was taken from your balance.");

                    } else {
                        e.getWhoClicked().getInventory().addItem(spawner());
                        EconomyResponse response = eco.withdrawPlayer((OfflinePlayer) e.getWhoClicked(), 69);
                        e.getWhoClicked().sendMessage(ChatColor.RED + eco.format(response.amount) + " was taken from your balance.");
                    }

                    e.getWhoClicked().getWorld().playSound(e.getWhoClicked().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2, 2);

                } else {
                    e.getWhoClicked().sendMessage("Insufficient balance");
                    e.getWhoClicked().getWorld().playSound(e.getWhoClicked().getLocation(), Sound.ENTITY_VILLAGER_NO, 2, 1);
                }
             else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_GREEN + "~Enchanted Gem~ (Cost: 2240 Gems)")) {
                if (e.getWhoClicked().getInventory().containsAtLeast(Items.gems(), 2240)) {
                    ItemStack gem = Items.gems();
                    gem.setAmount(2240);
                    if (Objects.requireNonNull(e.getWhoClicked()).getInventory().firstEmpty() == -1) {

                        e.getWhoClicked().getWorld().dropItemNaturally(e.getWhoClicked().getLocation(), enchantedgem());

                    } else {

                        e.getWhoClicked().getInventory().addItem(enchantedgem());
                    }
                    e.getWhoClicked().getInventory().removeItem(gem);
                    e.getWhoClicked().getWorld().playSound(e.getWhoClicked().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2, 2);
                } else {
                    e.getWhoClicked().sendMessage("Insufficient gem balance");
                    e.getWhoClicked().getWorld().playSound(e.getWhoClicked().getLocation(), Sound.ENTITY_VILLAGER_NO, 2, 1);
                }
            }
        }
    }
}*/

/*merchant:
        description: open the merchant shop
        usage: /<command>
        customrecipes:
        description: open the custom recipes
        usage: /<command>
        activationbedrock:
        description: gives activation bedrock
        usage: /<command>
        deactivationbedrock:
        description: gives deactivation bedrock
        usage: /<command>*/
