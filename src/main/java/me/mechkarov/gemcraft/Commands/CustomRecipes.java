/*package me.mechkarov.gemcraft.Commands;
import me.mechkarov.gemcraft.Items;
import me.mechkarov.gemcraft.Listeners.CustomRecipes.Armor.GodBoots;
import me.mechkarov.gemcraft.Listeners.CustomRecipes.Armor.GodChestplate;
import me.mechkarov.gemcraft.Listeners.CustomRecipes.Armor.GodHelmet;
import me.mechkarov.gemcraft.Listeners.CustomRecipes.Armor.GodLeggings;
import me.mechkarov.gemcraft.Listeners.CustomRecipes.Weapons.Excalibur;
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

public class CustomRecipes implements CommandExecutor, Listener {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        {

            if (commandSender instanceof Player) {

                Player player = (Player) commandSender;

                //shop
                Inventory customrecipes = Bukkit.createInventory(player, 9, ChatColor.AQUA + "Custom Recipes");

                ItemStack border = Items.border();
                ItemStack excalibur = Excalibur.excalibur();
                ItemStack godhelmet = GodHelmet.godhelmet();
                ItemStack godchestplate = GodChestplate.godchestplate();
                ItemStack godleggings = GodLeggings.godleggings();
                ItemStack godboots = GodBoots.godboots();


                customrecipes.setItem(0, border);
                customrecipes.setItem(1, godhelmet);
                customrecipes.setItem(2, godchestplate);
                customrecipes.setItem(3, godleggings);
                customrecipes.setItem(4, godboots);
                customrecipes.setItem(5, border);
                customrecipes.setItem(6, excalibur);
                customrecipes.setItem(7, border);
                customrecipes.setItem(8, border);

                player.openInventory(customrecipes);

            } else {
                System.out.println("You must be a player to execute this command.");
            }

            return true;
        }

    }

    @EventHandler
    public void onInventoryClick(final InventoryClickEvent e) {

        if ((e.getView().getTitle().equals(ChatColor.AQUA + "Custom Recipes"))||(e.getView().getTitle().equals(ChatColor.AQUA + "How to craft it"))) {
            e.setCancelled(true);

            if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_RED + "Back")) {

                Inventory customrecipes = Bukkit.createInventory(e.getWhoClicked(), 9, ChatColor.AQUA + "Custom Recipes");

                ItemStack border = Items.border();
                ItemStack excalibur = Excalibur.excalibur();
                ItemStack godhelmet = GodHelmet.godhelmet();
                ItemStack godchestplate = GodChestplate.godchestplate();
                ItemStack godleggings = GodLeggings.godleggings();
                ItemStack godboots = GodBoots.godboots();


                customrecipes.setItem(0, border);
                customrecipes.setItem(1, godhelmet);
                customrecipes.setItem(2, godchestplate);
                customrecipes.setItem(3, godleggings);
                customrecipes.setItem(4, godboots);
                customrecipes.setItem(5, border);
                customrecipes.setItem(6, excalibur);
                customrecipes.setItem(7, border);
                customrecipes.setItem(8, border);

                e.getWhoClicked().openInventory(customrecipes);

            }
            else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Excalibur")) {

                Inventory ExcaliburRecipe = Bukkit.createInventory(e.getWhoClicked(), 27, ChatColor.AQUA + "How to craft it");

                ItemStack enchantedgem = Items.enchantedgem();
                ItemStack netherite = Items.netherite();
                ItemStack arrow = Items.arrow();

                ExcaliburRecipe.setItem(4, enchantedgem);
                ExcaliburRecipe.setItem(13, enchantedgem);
                ExcaliburRecipe.setItem(22, netherite);
                ExcaliburRecipe.setItem(26, arrow);


                e.getWhoClicked().openInventory(ExcaliburRecipe);

            }
            else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Helmet of the Gods")) {

                Inventory GodhelmetRecipe = Bukkit.createInventory(e.getWhoClicked(), 27, ChatColor.AQUA + "How to craft it");

                ItemStack enchantedgem = Items.enchantedgem();
                ItemStack netherite = Items.netherite();
                ItemStack arrow = Items.arrow();

                GodhelmetRecipe.setItem(3, netherite);
                GodhelmetRecipe.setItem(4, netherite);
                GodhelmetRecipe.setItem(5, netherite);
                GodhelmetRecipe.setItem(12, enchantedgem);
                GodhelmetRecipe.setItem(14, enchantedgem);
                GodhelmetRecipe.setItem(26, arrow);

                e.getWhoClicked().openInventory(GodhelmetRecipe);

            }
            else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Chestplate of the Gods")) {

                Inventory GodchestplateRecipe = Bukkit.createInventory(e.getWhoClicked(), 27, ChatColor.AQUA + "How to craft it");

                ItemStack enchantedgem = Items.enchantedgem();
                ItemStack netherite = Items.netherite();
                ItemStack arrow = Items.arrow();

                GodchestplateRecipe.setItem(3, enchantedgem);
                GodchestplateRecipe.setItem(5, enchantedgem);
                GodchestplateRecipe.setItem(12, netherite);
                GodchestplateRecipe.setItem(13, enchantedgem);
                GodchestplateRecipe.setItem(14, netherite);
                GodchestplateRecipe.setItem(21, netherite);
                GodchestplateRecipe.setItem(22, netherite);
                GodchestplateRecipe.setItem(23, netherite);
                GodchestplateRecipe.setItem(26, arrow);

                e.getWhoClicked().openInventory(GodchestplateRecipe);

            }
            else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Leggings of the Gods")) {

                Inventory GodleggingsRecipe = Bukkit.createInventory(e.getWhoClicked(), 27, ChatColor.AQUA + "How to craft it");

                ItemStack enchantedgem = Items.enchantedgem();
                ItemStack netherite = Items.netherite();
                ItemStack arrow = Items.arrow();

                GodleggingsRecipe.setItem(3, enchantedgem);
                GodleggingsRecipe.setItem(4, enchantedgem);
                GodleggingsRecipe.setItem(5, enchantedgem);
                GodleggingsRecipe.setItem(12, netherite);
                GodleggingsRecipe.setItem(14, netherite);
                GodleggingsRecipe.setItem(21, netherite);
                GodleggingsRecipe.setItem(23, netherite);
                GodleggingsRecipe.setItem(26, arrow);

                e.getWhoClicked().openInventory(GodleggingsRecipe);

            }
            else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Boots of the Gods")) {

                Inventory GodbootsRecipe = Bukkit.createInventory(e.getWhoClicked(), 27, ChatColor.AQUA + "How to craft it");

                ItemStack enchantedgem = Items.enchantedgem();
                ItemStack netherite = Items.netherite();
                ItemStack arrow = Items.arrow();

                GodbootsRecipe.setItem(12, enchantedgem);
                GodbootsRecipe.setItem(14, enchantedgem);
                GodbootsRecipe.setItem(21, netherite);
                GodbootsRecipe.setItem(23, netherite);
                GodbootsRecipe.setItem(26, arrow);

                e.getWhoClicked().openInventory(GodbootsRecipe);

            }
        }
    }
}*/
