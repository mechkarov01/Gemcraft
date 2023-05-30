package me.mechkarov.gemcraft.Listeners.Tools;

import me.mechkarov.gemcraft.Gemcraft;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Random;

import static me.mechkarov.gemcraft.Items.ram;

public class DoorBreaker implements Listener {

    @EventHandler
    public void onClickButton(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (event.getAction() == Action.LEFT_CLICK_BLOCK) {

            int x = event.getClickedBlock().getLocation().getBlockX();
            int y = event.getClickedBlock().getLocation().getBlockY();
            int z = event.getClickedBlock().getLocation().getBlockZ();

            if((x==6)&&(y==72)&&(z==457)){
                player.getWorld().playSound(event.getClickedBlock().getLocation(), Sound.BLOCK_NOTE_BLOCK_BIT, 2, (float) 0.5);
            }
        }
    }


    @EventHandler
    public void onDragonKill(EntityDeathEvent e){

        Entity dragon = e.getEntity();
        Entity killer = e.getEntity().getKiller();


        if(killer instanceof Player) {
            if (dragon.getType().equals(EntityType.ENDER_DRAGON)) {
                Economy eco = Gemcraft.getEconomy();
                EconomyResponse response = eco.depositPlayer((OfflinePlayer) killer, 10000);
                killer.sendMessage(ChatColor.GREEN + eco.format(response.amount) + " was deposited into your balance for killing the " + ChatColor.DARK_PURPLE + "Ender Dragon");
            }
        }
    }

    @EventHandler
    public void onClickDoor(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        int x = event.getClickedBlock().getLocation().getBlockX();
        int z = event.getClickedBlock().getLocation().getBlockZ();

        ItemMeta meta = ram().getItemMeta();

        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Block block = event.getClickedBlock();

            //Blocks which are affected by door breakers
            if
                    //Doors
                    ((block.getType() == Material.IRON_DOOR) || (block.getType() == Material.OAK_DOOR) ||
                    (block.getType() == Material.DARK_OAK_DOOR) || (block.getType() == Material.ACACIA_DOOR) ||
                    (block.getType() == Material.BIRCH_DOOR) || (block.getType() == Material.JUNGLE_DOOR) ||
                    (block.getType() == Material.SPRUCE_DOOR) || (block.getType() == Material.WARPED_DOOR) ||
                    (block.getType() == Material.CRIMSON_DOOR) ||
                    //Trap doors
                    (block.getType() == Material.OAK_TRAPDOOR) || (block.getType() == Material.IRON_TRAPDOOR) ||
                    (block.getType() == Material.DARK_OAK_TRAPDOOR) || (block.getType() == Material.SPRUCE_TRAPDOOR) ||
                    (block.getType() == Material.BIRCH_TRAPDOOR) || (block.getType() == Material.ACACIA_TRAPDOOR) ||
                    (block.getType() == Material.JUNGLE_TRAPDOOR) || (block.getType() == Material.WARPED_TRAPDOOR) ||
                    (block.getType() == Material.CRIMSON_TRAPDOOR) ||
                    //Fence gates
                    (block.getType() == Material.OAK_FENCE_GATE) || (block.getType() == Material.DARK_OAK_FENCE_GATE) ||
                    (block.getType() == Material.SPRUCE_FENCE_GATE) || (block.getType() == Material.BIRCH_FENCE_GATE) ||
                    (block.getType() == Material.ACACIA_FENCE_GATE) || (block.getType() == Material.JUNGLE_FENCE_GATE) ||
                    (block.getType() == Material.WARPED_FENCE_GATE) || (block.getType() == Material.CRIMSON_FENCE_GATE)) {

                if (player.getInventory().getItemInMainHand().getItemMeta().equals(meta)) {
                    if (event.getHand() == EquipmentSlot.HAND) {
                        //This prevents door breakers from being used at spawn, warzone and gates.
                        if (((x >= -325 && x <= 310) && (z >= 75 && z <= 750)) || ((x >= 90 && x <= 134) && (z >= -1963 && z <= -1919)) ||
                                ((x >= -191 && x <= -147) && (z >= 2077 && z <= 2121)) || ((x >= -2177 && x <= -2133) && (z >= -265 && z <= -221)) ||
                                ((x >= 2105 && x <= 2149) && (z >= 246 && z <= 290))) {
                            event.getPlayer().sendMessage("You are not allowed to use that here!");
                        } else {
                            Random rand = new Random();
                            int number = rand.nextInt(99);
                            if (number < 51) {
                                ItemStack stack = player.getInventory().getItemInHand();
                                stack.setAmount(stack.getAmount() - 1);
                                player.setItemInHand(stack);
                                player.updateInventory();
                                event.getClickedBlock().setType(Material.AIR);
                                player.sendMessage(ChatColor.YELLOW + "You broke your battering ram!");
                                event.getPlayer().getWorld().playSound(event.getPlayer().getLocation(), Sound.ENTITY_ITEM_BREAK, 2, 2);
                            }
                            if (number >= 51) {
                                event.getClickedBlock().setType(Material.AIR);
                                player.sendMessage(ChatColor.GREEN + "Your battering ram survived!");
                                event.getPlayer().getWorld().playSound(event.getPlayer().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2, 2);
                            }
                        }
                    }
                }
            }
        }
    }
}
