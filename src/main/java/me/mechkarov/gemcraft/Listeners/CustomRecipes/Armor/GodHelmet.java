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

public class GodHelmet implements Listener {

    private Gemcraft plugin;

    public GodHelmet(Gemcraft plugin) {
        this.plugin = plugin;
    }

    public static ItemStack godhelmet() {
        ItemStack godhelmet = new ItemStack(Material.NETHERITE_HELMET);
        ItemMeta meta = godhelmet.getItemMeta();

        assert meta != null;
        meta.setDisplayName(ChatColor.GOLD + "Helmet of the Gods");
        //meta.setLore(Arrays.asList(ChatColor.RED + "nothing yet",
        //ChatColor.YELLOW + "nothing yet"));

        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 10, true);
        meta.addEnchant(Enchantment.DURABILITY, 5, true);
        meta.addEnchant(Enchantment.THORNS, 5, true);
        

        //meta.addEnchant(Enchantment.DURABILITY, 1,true);
        //meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        godhelmet.setItemMeta(meta);

        return godhelmet;
    }

    public ShapedRecipe getGodhelmet() {

        ItemStack getGodhelmet = godhelmet();
        ItemStack useEnchantedGem = Items.enchantedgem();

        NamespacedKey key = new NamespacedKey(plugin, "godhelmet");
        ShapedRecipe recipe = new ShapedRecipe(key, getGodhelmet);

        recipe.shape("NNN", "G G", "   ");
        recipe.setIngredient('G', new RecipeChoice.ExactChoice(useEnchantedGem));
        recipe.setIngredient('N', Material.NETHERITE_INGOT);

        return recipe;
    }

}*/

