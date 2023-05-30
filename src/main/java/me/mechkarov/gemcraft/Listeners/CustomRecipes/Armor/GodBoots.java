/*package me.mechkarov.gemcraft.Listeners.CustomRecipes.Armor;

import me.mechkarov.gemcraft.Gemcraft;
import me.mechkarov.gemcraft.Items;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Listener;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class GodBoots implements Listener {

    private Gemcraft plugin;

    public GodBoots(Gemcraft plugin) {
        this.plugin = plugin;
    }

    public static ItemStack godboots() {
        ItemStack godboots = new ItemStack(Material.NETHERITE_BOOTS);
        ItemMeta meta = godboots.getItemMeta();

        assert meta != null;
        meta.setDisplayName(ChatColor.GOLD + "Boots of the Gods");
        //meta.setLore(Arrays.asList(ChatColor.RED + "nothing yet",
        //ChatColor.YELLOW + "nothing yet"));

        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 10, true);
        meta.addEnchant(Enchantment.DURABILITY, 5, true);
        meta.addEnchant(Enchantment.THORNS, 5, true);

        //meta.addEnchant(Enchantment.DURABILITY, 1,true);
        //meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        godboots.setItemMeta(meta);

        return godboots;
    }

    public ShapedRecipe getGodboots() {

        ItemStack getGodboots = godboots();
        ItemStack useEnchantedGem = Items.enchantedgem();

        NamespacedKey key = new NamespacedKey(plugin, "godboots");
        ShapedRecipe recipe = new ShapedRecipe(key, getGodboots);

        recipe.shape("   ", "G G", "N N");
        recipe.setIngredient('G', new RecipeChoice.ExactChoice(useEnchantedGem));
        recipe.setIngredient('N', Material.NETHERITE_INGOT);

        return recipe;
    }

}*/

