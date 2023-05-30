package me.mechkarov.gemcraft.Listeners.Tools;

import me.mechkarov.gemcraft.Gemcraft;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitScheduler;

import static me.mechkarov.gemcraft.Items.*;
import static me.mechkarov.gemcraft.Items.breaker4;

public class BlockBreaker implements Listener {

    private Gemcraft plugin;

    public BlockBreaker(Gemcraft plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBreakBlock(BlockBreakEvent event) {

        //Spawn (x >= -325 && x <= 310) && (z >= 75 && z <= 750)
        //NorthGate (x >= 90 && x <= 134) && (z >= -1963 && z <= -1919)
        //SouthGate (x >= -191 && x <= -147) && (z >= 2077 && z <= 2121)
        //WestGate (x >= -2177 && x <= -2133) && (z >= -265 && z <= -221)
        //EastGate (x >= 2105 && x <= 2149) && (z >= 246 && z <= 290)

        int x = event.getBlock().getLocation().getBlockX();
        int z = event.getBlock().getLocation().getBlockZ();

        Player player = event.getPlayer();
        Block block = event.getBlock();

        ItemMeta meta = breaker().getItemMeta();
        ItemMeta meta2 = breaker2().getItemMeta();
        ItemMeta meta3 = breaker3().getItemMeta();
        ItemMeta meta4 = breaker4().getItemMeta();

        //Adjust how long the block should stay broken for (20 ticks = 1 second)
        int DiamondDelay = 24000;
        int GoldDelay = 12000;
        int IronDelay = 6000;
        int StoneDelay = 2400;

        int BreakerDelay = 0;

        if (player.getInventory().getItemInMainHand().getItemMeta().equals(meta)) {
            BreakerDelay = DiamondDelay;
        } else if (player.getInventory().getItemInMainHand().getItemMeta().equals(meta2)) {
            BreakerDelay = GoldDelay;
        } else if (player.getInventory().getItemInMainHand().getItemMeta().equals(meta3)) {
            BreakerDelay = IronDelay;
        } else if (player.getInventory().getItemInMainHand().getItemMeta().equals(meta4)) {
            BreakerDelay = StoneDelay;
        }

        if ((player.getInventory().getItemInMainHand().getItemMeta().equals(meta)) || (player.getInventory().getItemInMainHand().getItemMeta().equals(meta2)) ||
                (player.getInventory().getItemInMainHand().getItemMeta().equals(meta3)) || (player.getInventory().getItemInMainHand().getItemMeta().equals(meta4))) {
            //This prevents block breakers from being used at spawn, warzone and gates.
            if (((x >= -325 && x <= 310) && (z >= 75 && z <= 750)) || ((x >= 90 && x <= 134) && (z >= -1963 && z <= -1919)) ||
                    ((x >= -191 && x <= -147) && (z >= 2077 && z <= 2121)) || ((x >= -2177 && x <= -2133) && (z >= -265 && z <= -221)) ||
                    ((x >= 2105 && x <= 2149) && (z >= 246 && z <= 290))) {
                event.getPlayer().sendMessage("You are not allowed to use that here!");
            } else {

                //Blocks which are not affected by block breakers
                if      //Doors
                        (!((block.getType() == Material.IRON_DOOR) || (block.getType() == Material.OAK_DOOR) ||
                        (block.getType() == Material.DARK_OAK_DOOR) || (block.getType() == Material.ACACIA_DOOR) ||
                        (block.getType() == Material.BIRCH_DOOR) || (block.getType() == Material.JUNGLE_DOOR) ||
                        (block.getType() == Material.SPRUCE_DOOR) || (block.getType() == Material.CRIMSON_DOOR) ||
                        (block.getType() == Material.WARPED_DOOR) ||
                        //Trap doors
                        (block.getType() == Material.OAK_TRAPDOOR) || (block.getType() == Material.IRON_TRAPDOOR) ||
                        (block.getType() == Material.DARK_OAK_TRAPDOOR) || (block.getType() == Material.SPRUCE_TRAPDOOR) ||
                        (block.getType() == Material.BIRCH_TRAPDOOR) || (block.getType() == Material.ACACIA_TRAPDOOR) ||
                        (block.getType() == Material.JUNGLE_TRAPDOOR) || (block.getType() == Material.CRIMSON_TRAPDOOR) ||
                        (block.getType() == Material.WARPED_TRAPDOOR) ||
                        //Fence gates
                        (block.getType() == Material.OAK_FENCE_GATE) || (block.getType() == Material.DARK_OAK_FENCE_GATE) ||
                        (block.getType() == Material.SPRUCE_FENCE_GATE) || (block.getType() == Material.BIRCH_FENCE_GATE) ||
                        (block.getType() == Material.ACACIA_FENCE_GATE) || (block.getType() == Material.JUNGLE_FENCE_GATE) ||
                        (block.getType() == Material.WARPED_FENCE_GATE) || (block.getType() == Material.CRIMSON_FENCE_GATE) ||
                        //Spawners
                        (block.getType() == Material.SPAWNER))) {

                    //If the broken block is a CHEST, SHULKER BOX, BARREL or SIGN, save it's contents before breaking it
                    if ((block.getType() == Material.CHEST) || (block.getType() == Material.TRAPPED_CHEST)) {

                        player.getInventory().getItemInMainHand().setAmount((player.getInventory().getItemInMainHand().getAmount()) - 1);
                        event.getPlayer().getWorld().playSound(event.getPlayer().getLocation(), Sound.ENTITY_ITEM_BREAK, 2, 2);

                        Chest chest = (Chest) event.getBlock().getState();

                        ItemStack[] inv = chest.getInventory().getContents();
                        chest.getInventory().clear();

                        Material mat = block.getType();
                        block.setType(Material.AIR);

                        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
                        scheduler.scheduleSyncDelayedTask(plugin, new Runnable() {

                            public void run() {
                                block.setType(mat);
                                chest.getInventory().setContents(inv);
                                chest.update();
                            }
                        }, BreakerDelay);
                    } else if ((block.getType() == Material.SHULKER_BOX) || (block.getType() == Material.WHITE_SHULKER_BOX) || (block.getType() == Material.ORANGE_SHULKER_BOX) ||
                            (block.getType() == Material.MAGENTA_SHULKER_BOX) || (block.getType() == Material.LIGHT_BLUE_SHULKER_BOX) || (block.getType() == Material.YELLOW_SHULKER_BOX) ||
                            (block.getType() == Material.LIME_SHULKER_BOX) || (block.getType() == Material.PINK_SHULKER_BOX) || (block.getType() == Material.GRAY_SHULKER_BOX) ||
                            (block.getType() == Material.LIGHT_GRAY_SHULKER_BOX) || (block.getType() == Material.CYAN_SHULKER_BOX) || (block.getType() == Material.PURPLE_SHULKER_BOX) ||
                            (block.getType() == Material.BLUE_SHULKER_BOX) || (block.getType() == Material.BROWN_SHULKER_BOX) || (block.getType() == Material.GREEN_SHULKER_BOX) ||
                            (block.getType() == Material.RED_SHULKER_BOX) || (block.getType() == Material.BLACK_SHULKER_BOX)) {

                        player.getInventory().getItemInMainHand().setAmount((player.getInventory().getItemInMainHand().getAmount()) - 1);
                        event.getPlayer().getWorld().playSound(event.getPlayer().getLocation(), Sound.ENTITY_ITEM_BREAK, 2, 2);

                        ShulkerBox shulker = (ShulkerBox) event.getBlock().getState();

                        ItemStack[] inv = shulker.getInventory().getContents();
                        shulker.getInventory().clear();

                        Material mat = block.getType();
                        block.setType(Material.AIR);

                        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
                        scheduler.scheduleSyncDelayedTask(plugin, new Runnable() {

                            public void run() {
                                block.setType(mat);
                                shulker.getInventory().setContents(inv);
                                shulker.update();
                            }
                        }, BreakerDelay);
                    } else if (block.getType().equals(Material.BARREL)) {

                        player.getInventory().getItemInMainHand().setAmount((player.getInventory().getItemInMainHand().getAmount()) - 1);
                        event.getPlayer().getWorld().playSound(event.getPlayer().getLocation(), Sound.ENTITY_ITEM_BREAK, 2, 2);

                        Barrel barrel = (Barrel) event.getBlock().getState();

                        ItemStack[] inv = barrel.getInventory().getContents();
                        barrel.getInventory().clear();

                        Material mat = block.getType();
                        block.setType(Material.AIR);

                        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
                        scheduler.scheduleSyncDelayedTask(plugin, new Runnable() {

                            public void run() {
                                block.setType(mat);
                                barrel.getInventory().setContents(inv);
                                barrel.update();
                            }
                        }, BreakerDelay);
                    } else if ((block.getType() == Material.OAK_SIGN) || (block.getType() == Material.SPRUCE_SIGN) || (block.getType() == Material.BIRCH_SIGN) ||
                            (block.getType() == Material.JUNGLE_SIGN) || (block.getType() == Material.ACACIA_SIGN) || (block.getType() == Material.DARK_OAK_SIGN) ||
                            (block.getType() == Material.CRIMSON_SIGN) || (block.getType() == Material.WARPED_SIGN) ||

                            (block.getType() == Material.OAK_WALL_SIGN) || (block.getType() == Material.SPRUCE_WALL_SIGN) || (block.getType() == Material.BIRCH_WALL_SIGN) ||
                            (block.getType() == Material.JUNGLE_WALL_SIGN) || (block.getType() == Material.ACACIA_WALL_SIGN) || (block.getType() == Material.DARK_OAK_WALL_SIGN) ||
                            (block.getType() == Material.CRIMSON_WALL_SIGN) || (block.getType() == Material.WARPED_WALL_SIGN)) {

                        player.getInventory().getItemInMainHand().setAmount((player.getInventory().getItemInMainHand().getAmount()) - 1);
                        event.getPlayer().getWorld().playSound(event.getPlayer().getLocation(), Sound.ENTITY_ITEM_BREAK, 2, 2);

                        Sign sign = (Sign) event.getBlock().getState();
                        Material mat = event.getBlock().getType();

                        String s1 = sign.getLine(0);
                        String s2 = sign.getLine(1);
                        String s3 = sign.getLine(2);
                        String s4 = sign.getLine(3);

                        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
                        scheduler.scheduleSyncDelayedTask(plugin, new Runnable() {

                            public void run() {
                                block.setType(mat);
                                sign.setLine(0, s1);
                                sign.setLine(1, s2);
                                sign.setLine(2, s3);
                                sign.setLine(3, s4);
                                sign.update();
                            }
                        }, BreakerDelay);
                    } else {

                        player.getInventory().getItemInMainHand().setAmount((player.getInventory().getItemInMainHand().getAmount()) - 1);
                        event.getPlayer().getWorld().playSound(event.getPlayer().getLocation(), Sound.ENTITY_ITEM_BREAK, 2, 2);

                        Material mat = block.getType();
                        block.setType(Material.AIR);

                        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
                        scheduler.scheduleSyncDelayedTask(plugin, new Runnable() {

                            public void run() {
                                block.setType(mat);
                            }
                        }, BreakerDelay);
                    }
                } else {
                    event.getPlayer().sendMessage("You cannot break that block with that tool!");
                    event.setCancelled(true);
                }
            }
        }
    }
}
