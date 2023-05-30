/*package me.mechkarov.gemcraft.Listeners.CustomRecipes.Weapons;

import me.mechkarov.gemcraft.Gemcraft;
import me.mechkarov.gemcraft.Items;
import me.mechkarov.gemcraft.Listeners.CustomRecipes.Armor.GodBoots;
import me.mechkarov.gemcraft.Listeners.CustomRecipes.Armor.GodChestplate;
import me.mechkarov.gemcraft.Listeners.CustomRecipes.Armor.GodHelmet;
import me.mechkarov.gemcraft.Listeners.CustomRecipes.Armor.GodLeggings;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.LightningStrike;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class Excalibur implements Listener {

    private Gemcraft plugin;

    public Excalibur(Gemcraft plugin) {
        this.plugin = plugin;
    }

    public static ItemStack excalibur() {
        ItemStack excalibur = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = excalibur.getItemMeta();

        assert meta != null;
        meta.setDisplayName(ChatColor.GOLD + "Excalibur");
        meta.setLore(Arrays.asList(ChatColor.GOLD + "Right-Click to shoot a FireBall" , "if full God Armor is being worn!"));

        meta.addEnchant(Enchantment.DAMAGE_ALL, 10, true);
        meta.addEnchant(Enchantment.FIRE_ASPECT, 5, true);
        meta.addEnchant(Enchantment.LOOT_BONUS_MOBS, 5, true);
        meta.addEnchant(Enchantment.DURABILITY, 5, true);

        //meta.addEnchant(Enchantment.DURABILITY, 1,true);
        //meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        excalibur.setItemMeta(meta);

        return excalibur;
    }

    public ShapedRecipe getExcalibur() {

        ItemStack getExcalibur = excalibur();
        ItemStack useEnchantedGem = Items.enchantedgem();

        NamespacedKey key = new NamespacedKey(plugin, "excalibur");
        ShapedRecipe recipe = new ShapedRecipe(key, getExcalibur);

        recipe.shape(" G ", " G ", " N ");
        recipe.setIngredient('G', new RecipeChoice.ExactChoice(useEnchantedGem));
        recipe.setIngredient('N', Material.NETHERITE_INGOT);

        return recipe;
    }

    @EventHandler
    public void onRightClickExcalibur(PlayerInteractEvent e) {

        ItemMeta meta = excalibur().getItemMeta();

        if ((e.getPlayer().getInventory().getHelmet().equals(GodHelmet.godhelmet())) && (e.getPlayer().getInventory().getChestplate().equals(GodChestplate.godchestplate())) &&
                (e.getPlayer().getInventory().getLeggings().equals(GodLeggings.godleggings())) && (e.getPlayer().getInventory().getBoots().equals(GodBoots.godboots()))) {
            if((e.getPlayer().getInventory().getHelmet().getDurability() < 50000) || (e.getPlayer().getInventory().getChestplate().getDurability() <50000) ||
                    (e.getPlayer().getInventory().getLeggings().getDurability() <50000) || (e.getPlayer().getInventory().getBoots().getDurability() <50000)) {
                if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                    if (e.getHand() == EquipmentSlot.HAND) {
                        if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().equals(meta)) {

                            Fireball f = e.getPlayer().launchProjectile(Fireball.class);
                            f.setIsIncendiary(false);

                        }
                    }
                }
            }
        }
    }
}*/
