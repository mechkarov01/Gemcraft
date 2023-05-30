package me.mechkarov.gemcraft.Listeners.Tools;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Barrel;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.block.ShulkerBox;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Random;

import static me.mechkarov.gemcraft.Items.*;

public class LockPick  implements Listener {

    @EventHandler
    public void onClickChest(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        ItemMeta meta = lockpick().getItemMeta();
        ItemMeta meta2 = lockpick2().getItemMeta();
        ItemMeta meta3 = lockpick3().getItemMeta();

        int x = event.getClickedBlock().getLocation().getBlockX();
        int z = event.getClickedBlock().getLocation().getBlockZ();

        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Block block = event.getClickedBlock();

            //Blocks which are affected by lock picks
            if      //Chests
                    ((block.getType() == Material.CHEST) || (block.getType() == Material.TRAPPED_CHEST) ||
                    (block.getType() == Material.CHEST_MINECART) || (block.getType() == Material.ENDER_CHEST) ||
                    //Shulker boxes
                    (block.getType() == Material.SHULKER_BOX) || (block.getType() == Material.WHITE_SHULKER_BOX) || (block.getType() == Material.ORANGE_SHULKER_BOX) ||
                    (block.getType() == Material.MAGENTA_SHULKER_BOX) || (block.getType() == Material.LIGHT_BLUE_SHULKER_BOX) || (block.getType() == Material.YELLOW_SHULKER_BOX) ||
                    (block.getType() == Material.LIME_SHULKER_BOX) || (block.getType() == Material.PINK_SHULKER_BOX) || (block.getType() == Material.GRAY_SHULKER_BOX) ||
                    (block.getType() == Material.LIGHT_GRAY_SHULKER_BOX) || (block.getType() == Material.CYAN_SHULKER_BOX) || (block.getType() == Material.PURPLE_SHULKER_BOX) ||
                    (block.getType() == Material.BLUE_SHULKER_BOX) || (block.getType() == Material.BROWN_SHULKER_BOX) || (block.getType() == Material.GREEN_SHULKER_BOX) ||
                    (block.getType() == Material.RED_SHULKER_BOX) || (block.getType() == Material.BLACK_SHULKER_BOX) ||
                    //Barrel
                    (block.getType() == Material.BARREL)) {
                if ((player.getInventory().getItemInMainHand().getItemMeta().equals(meta)) || (player.getInventory().getItemInMainHand().getItemMeta().equals(meta2)) ||
                        (player.getInventory().getItemInMainHand().getItemMeta().equals(meta3))) {

                    //This prevents lock picks from being used at spawn, warzone and gates.
                    if (((x >= -325 && x <= 310) && (z >= 75 && z <= 750)) || ((x >= 90 && x <= 134) && (z >= -1963 && z <= -1919)) ||
                            ((x >= -191 && x <= -147) && (z >= 2077 && z <= 2121)) || ((x >= -2177 && x <= -2133) && (z >= -265 && z <= -221)) ||
                            ((x >= 2105 && x <= 2149) && (z >= 246 && z <= 290))) {
                        event.getPlayer().sendMessage("You are not allowed to use that here!");
                    } else {

                        //First lock pick
                        if (player.getInventory().getItemInMainHand().getItemMeta().equals(meta)) {
                            if (event.getHand() == EquipmentSlot.HAND) {

                                Random rand = new Random();
                                int number = rand.nextInt(99);
                                if (number < 51) {
                                    if ((event.getClickedBlock().getType().equals(Material.CHEST)) ||
                                            (event.getClickedBlock().getType().equals(Material.TRAPPED_CHEST)) ||
                                            (event.getClickedBlock().getType().equals(Material.CHEST_MINECART))) {
                                        event.setCancelled(true);
                                        Chest chest = (Chest) event.getClickedBlock().getState();
                                        event.getPlayer().openInventory(chest.getInventory());
                                    } else if ((block.getType() == Material.SHULKER_BOX) || (block.getType() == Material.WHITE_SHULKER_BOX) || (block.getType() == Material.ORANGE_SHULKER_BOX) ||
                                            (block.getType() == Material.MAGENTA_SHULKER_BOX) || (block.getType() == Material.LIGHT_BLUE_SHULKER_BOX) || (block.getType() == Material.YELLOW_SHULKER_BOX) ||
                                            (block.getType() == Material.LIME_SHULKER_BOX) || (block.getType() == Material.PINK_SHULKER_BOX) || (block.getType() == Material.GRAY_SHULKER_BOX) ||
                                            (block.getType() == Material.LIGHT_GRAY_SHULKER_BOX) || (block.getType() == Material.CYAN_SHULKER_BOX) || (block.getType() == Material.PURPLE_SHULKER_BOX) ||
                                            (block.getType() == Material.BLUE_SHULKER_BOX) || (block.getType() == Material.BROWN_SHULKER_BOX) || (block.getType() == Material.GREEN_SHULKER_BOX) ||
                                            (block.getType() == Material.RED_SHULKER_BOX) || (block.getType() == Material.BLACK_SHULKER_BOX)) {
                                        ShulkerBox shulker = (ShulkerBox) event.getClickedBlock().getState();
                                        event.getPlayer().openInventory(shulker.getInventory());
                                    } else if (event.getClickedBlock().getType().equals(Material.BARREL)) {
                                        Barrel barrel = (Barrel) event.getClickedBlock().getState();
                                        event.getPlayer().openInventory(barrel.getInventory());
                                    }

                                    player.getInventory().getItemInMainHand().setAmount((player.getInventory().getItemInMainHand().getAmount()) - 1);
                                    player.sendMessage(ChatColor.YELLOW + "Your lock pick broke!");
                                    event.getPlayer().getWorld().playSound(event.getPlayer().getLocation(), Sound.ENTITY_ITEM_BREAK, 2, 2);
                                }
                                if (number >= 51) {
                                    if ((event.getClickedBlock().getType().equals(Material.CHEST)) ||
                                            (event.getClickedBlock().getType().equals(Material.TRAPPED_CHEST)) ||
                                            (event.getClickedBlock().getType().equals(Material.CHEST_MINECART))) {
                                        event.setCancelled(true);
                                        Chest chest = (Chest) event.getClickedBlock().getState();
                                        event.getPlayer().openInventory(chest.getInventory());
                                    } else if ((block.getType() == Material.SHULKER_BOX) || (block.getType() == Material.WHITE_SHULKER_BOX) || (block.getType() == Material.ORANGE_SHULKER_BOX) ||
                                            (block.getType() == Material.MAGENTA_SHULKER_BOX) || (block.getType() == Material.LIGHT_BLUE_SHULKER_BOX) || (block.getType() == Material.YELLOW_SHULKER_BOX) ||
                                            (block.getType() == Material.LIME_SHULKER_BOX) || (block.getType() == Material.PINK_SHULKER_BOX) || (block.getType() == Material.GRAY_SHULKER_BOX) ||
                                            (block.getType() == Material.LIGHT_GRAY_SHULKER_BOX) || (block.getType() == Material.CYAN_SHULKER_BOX) || (block.getType() == Material.PURPLE_SHULKER_BOX) ||
                                            (block.getType() == Material.BLUE_SHULKER_BOX) || (block.getType() == Material.BROWN_SHULKER_BOX) || (block.getType() == Material.GREEN_SHULKER_BOX) ||
                                            (block.getType() == Material.RED_SHULKER_BOX) || (block.getType() == Material.BLACK_SHULKER_BOX)) {
                                        ShulkerBox shulker = (ShulkerBox) event.getClickedBlock().getState();
                                        event.getPlayer().openInventory(shulker.getInventory());
                                    } else if (event.getClickedBlock().getType().equals(Material.BARREL)) {
                                        Barrel barrel = (Barrel) event.getClickedBlock().getState();
                                        event.getPlayer().openInventory(barrel.getInventory());
                                    }
                                    player.sendMessage(ChatColor.GREEN + "Your lock pick survived!");
                                    event.getPlayer().getWorld().playSound(event.getPlayer().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2, 2);
                                }

                            }
                        }


                        //Second lock pick
                        if (player.getInventory().getItemInMainHand().getItemMeta().equals(meta2)) {
                            if (event.getHand() == EquipmentSlot.HAND) {

                                Random rand = new Random();
                                int number = rand.nextInt(99);
                                if (number < 51) {
                                    player.getInventory().getItemInMainHand().setAmount((player.getInventory().getItemInMainHand().getAmount()) - 1);
                                    player.sendMessage(ChatColor.RED + "Your lock pick broke!");
                                    event.getPlayer().getWorld().playSound(event.getPlayer().getLocation(), Sound.ENTITY_ITEM_BREAK, 2, 2);
                                }
                                if (number >= 51) {
                                    if ((event.getClickedBlock().getType().equals(Material.CHEST)) ||
                                            (event.getClickedBlock().getType().equals(Material.TRAPPED_CHEST)) ||
                                            (event.getClickedBlock().getType().equals(Material.CHEST_MINECART))) {
                                        event.setCancelled(true);
                                        Chest chest = (Chest) event.getClickedBlock().getState();
                                        event.getPlayer().openInventory(chest.getInventory());
                                    } else if ((block.getType() == Material.SHULKER_BOX) || (block.getType() == Material.WHITE_SHULKER_BOX) || (block.getType() == Material.ORANGE_SHULKER_BOX) ||
                                            (block.getType() == Material.MAGENTA_SHULKER_BOX) || (block.getType() == Material.LIGHT_BLUE_SHULKER_BOX) || (block.getType() == Material.YELLOW_SHULKER_BOX) ||
                                            (block.getType() == Material.LIME_SHULKER_BOX) || (block.getType() == Material.PINK_SHULKER_BOX) || (block.getType() == Material.GRAY_SHULKER_BOX) ||
                                            (block.getType() == Material.LIGHT_GRAY_SHULKER_BOX) || (block.getType() == Material.CYAN_SHULKER_BOX) || (block.getType() == Material.PURPLE_SHULKER_BOX) ||
                                            (block.getType() == Material.BLUE_SHULKER_BOX) || (block.getType() == Material.BROWN_SHULKER_BOX) || (block.getType() == Material.GREEN_SHULKER_BOX) ||
                                            (block.getType() == Material.RED_SHULKER_BOX) || (block.getType() == Material.BLACK_SHULKER_BOX)) {
                                        ShulkerBox shulker = (ShulkerBox) event.getClickedBlock().getState();
                                        event.getPlayer().openInventory(shulker.getInventory());
                                    } else if (event.getClickedBlock().getType().equals(Material.BARREL)) {
                                        Barrel barrel = (Barrel) event.getClickedBlock().getState();
                                        event.getPlayer().openInventory(barrel.getInventory());
                                    }
                                    player.getInventory().getItemInMainHand().setAmount((player.getInventory().getItemInMainHand().getAmount()) - 1);
                                    player.sendMessage(ChatColor.YELLOW + "You successfully opened the chest but broke your lock pick in the process!");
                                    event.getPlayer().getWorld().playSound(event.getPlayer().getLocation(), Sound.ENTITY_ITEM_BREAK, 2, 2);
                                }

                            }
                        }


                        // Third lock pick
                        if (player.getInventory().getItemInMainHand().getItemMeta().equals(meta3)) {
                            if (event.getHand() == EquipmentSlot.HAND) {

                                Random rand = new Random();
                                int number = rand.nextInt(99);
                                if (number > 19) {
                                    player.getInventory().getItemInMainHand().setAmount((player.getInventory().getItemInMainHand().getAmount()) - 1);
                                    player.sendMessage(ChatColor.RED + "Your lock pick broke!");
                                    event.getPlayer().getWorld().playSound(event.getPlayer().getLocation(), Sound.ENTITY_ITEM_BREAK, 2, 2);
                                }
                                if (number <= 19) {
                                    if ((event.getClickedBlock().getType().equals(Material.CHEST)) ||
                                            (event.getClickedBlock().getType().equals(Material.TRAPPED_CHEST)) ||
                                            (event.getClickedBlock().getType().equals(Material.CHEST_MINECART))) {
                                        event.setCancelled(true);
                                        Chest chest = (Chest) event.getClickedBlock().getState();
                                        event.getPlayer().openInventory(chest.getInventory());
                                    } else if ((block.getType() == Material.SHULKER_BOX) || (block.getType() == Material.WHITE_SHULKER_BOX) || (block.getType() == Material.ORANGE_SHULKER_BOX) ||
                                            (block.getType() == Material.MAGENTA_SHULKER_BOX) || (block.getType() == Material.LIGHT_BLUE_SHULKER_BOX) || (block.getType() == Material.YELLOW_SHULKER_BOX) ||
                                            (block.getType() == Material.LIME_SHULKER_BOX) || (block.getType() == Material.PINK_SHULKER_BOX) || (block.getType() == Material.GRAY_SHULKER_BOX) ||
                                            (block.getType() == Material.LIGHT_GRAY_SHULKER_BOX) || (block.getType() == Material.CYAN_SHULKER_BOX) || (block.getType() == Material.PURPLE_SHULKER_BOX) ||
                                            (block.getType() == Material.BLUE_SHULKER_BOX) || (block.getType() == Material.BROWN_SHULKER_BOX) || (block.getType() == Material.GREEN_SHULKER_BOX) ||
                                            (block.getType() == Material.RED_SHULKER_BOX) || (block.getType() == Material.BLACK_SHULKER_BOX)) {
                                        ShulkerBox shulker = (ShulkerBox) event.getClickedBlock().getState();
                                        event.getPlayer().openInventory(shulker.getInventory());
                                    } else if (event.getClickedBlock().getType().equals(Material.BARREL)) {
                                        Barrel barrel = (Barrel) event.getClickedBlock().getState();
                                        event.getPlayer().openInventory(barrel.getInventory());
                                    }
                                    player.getInventory().getItemInMainHand().setAmount((player.getInventory().getItemInMainHand().getAmount()) - 1);
                                    player.sendMessage(ChatColor.YELLOW + "You successfully opened the chest but broke your lock pick in the process!");
                                    event.getPlayer().getWorld().playSound(event.getPlayer().getLocation(), Sound.ENTITY_ITEM_BREAK, 2, 2);
                                }

                            }
                        }
                    }
                }
            }
        }
    }
}
