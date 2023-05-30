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

public class GodLeggings implements Listener {

    private Gemcraft plugin;

    public GodLeggings(Gemcraft plugin) {
        this.plugin = plugin;
    }

    public static ItemStack godleggings() {
        ItemStack godleggings = new ItemStack(Material.NETHERITE_LEGGINGS);
        ItemMeta meta = godleggings.getItemMeta();

        assert meta != null;
        meta.setDisplayName(ChatColor.GOLD + "Leggings of the Gods");
        //meta.setLore(Arrays.asList(ChatColor.RED + "nothing yet",
        //ChatColor.YELLOW + "nothing yet"));

        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 10, true);
        meta.addEnchant(Enchantment.DURABILITY, 5, true);
        meta.addEnchant(Enchantment.THORNS, 5, true);

        //meta.addEnchant(Enchantment.DURABILITY, 1,true);
        //meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        godleggings.setItemMeta(meta);

        return godleggings;
    }

    public ShapedRecipe getGodleggings() {

        ItemStack getGodleggings = godleggings();
        ItemStack useEnchantedGem = Items.enchantedgem();

        NamespacedKey key = new NamespacedKey(plugin, "godleggings");
        ShapedRecipe recipe = new ShapedRecipe(key, getGodleggings);

        recipe.shape("GGG", "N N", "N N");
        recipe.setIngredient('G', new RecipeChoice.ExactChoice(useEnchantedGem));
        recipe.setIngredient('N', Material.NETHERITE_INGOT);

        return recipe;
    }

}*/


