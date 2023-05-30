/*package me.mechkarov.gemcraft.Listeners.CustomRecipes.Talismans;

import jdk.nashorn.internal.objects.annotations.Property;
import me.mechkarov.gemcraft.Gemcraft;
import me.mechkarov.gemcraft.Items;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Collections;

public class RegenerationTalisman implements Listener {

    private Gemcraft plugin;

    public RegenerationTalisman(Gemcraft plugin) {
        this.plugin = plugin;
    }

    public static ItemStack regentalisman() {

        ItemStack regentalisman = new ItemStack(Material.POTION);
        PotionMeta meta = (PotionMeta) regentalisman.getItemMeta();

        assert meta != null;
        meta.setBasePotionData(new PotionData(PotionType.REGEN));
        meta.setDisplayName(ChatColor.RED + "Regeneration Talisman");
        meta.setLore(Collections.singletonList(ChatColor.DARK_GREEN + "Gives you permanent regeneration!"));

        //meta.addEnchant(Enchantment.DURABILITY, 1, true);
        //meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);

        regentalisman.setItemMeta(meta);

        return regentalisman;
    }

    public ShapedRecipe getRegenerationTalisman() {

        ItemStack getRegenerationTalisman = regentalisman();
        ItemStack useEnchantedGem = Items.enchantedgem();

        NamespacedKey key = new NamespacedKey(plugin, "regeneration_talisman");
        ShapedRecipe recipe = new ShapedRecipe(key, getRegenerationTalisman);

        recipe.shape(" G ", "GTG", " G ");
        recipe.setIngredient('G', new RecipeChoice.ExactChoice(useEnchantedGem));
        recipe.setIngredient('T', Material.TOTEM_OF_UNDYING);

        return recipe;
    }

    @EventHandler
    public void onTalismanContain(BlockPlaceEvent e) {

        ItemStack RegenerationTalisman = regentalisman();
        ItemMeta ActivationBedrock = Items.ActivationBedrock().getItemMeta();
        ItemMeta DeactivationBedrock = Items.DeactivationBedrock().getItemMeta();

        if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().equals(ActivationBedrock)) {
            e.getPlayer().sendMessage("Activated");
            new BukkitRunnable() {

                //Change the duration and the level of the potion effect
                int Duration = Integer.MAX_VALUE; //Permanent
                int Level = 1;

                PotionEffect potion = new PotionEffect(PotionEffectType.REGENERATION, Duration, Level - 1);

                //SkullMeta meta = (SkullMeta) RegenerationTalisman.getItemMeta();

                @Override
                public void run() {

                    if (e.getPlayer().getInventory().contains(RegenerationTalisman)) {

                        e.getPlayer().addPotionEffect(potion);
                    } else if (!(e.getPlayer().getInventory().contains(RegenerationTalisman))) {
                        if (e.getPlayer().hasPotionEffect(PotionEffectType.REGENERATION)) {

                            PotionEffect duration = e.getPlayer().getPotionEffect(PotionEffectType.REGENERATION);

                            if (duration != null && duration.getDuration() > 1600) {
                                e.getPlayer().removePotionEffect(PotionEffectType.REGENERATION);
                            }
                        }
                    }

                    if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().equals(DeactivationBedrock)) {
                        this.cancel();
                        e.getPlayer().sendMessage("Deactivated");
                    }
                }
            }.runTaskTimer(plugin, 1L, 20L);
        }
    }
}*/

