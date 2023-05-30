package me.mechkarov.gemcraft.Listeners.Tools;

import me.mechkarov.gemcraft.CustomEvents.SpawnerBreakEvent;
import me.mechkarov.gemcraft.Items;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;

import static me.mechkarov.gemcraft.Items.*;

public class Harvesters implements Listener {

    @EventHandler
    public void onSpawnerSignBreak(BlockBreakEvent e) {

        Block blockBroken = e.getBlock();

        //Checks the block below the sign you're breaking. If it is a spawner, you cannot break that sign.
        if (blockBroken.getType().equals(Material.OAK_SIGN)) {

            int x = blockBroken.getLocation().getBlockX();
            int y = blockBroken.getLocation().getBlockY();
            int z = blockBroken.getLocation().getBlockZ();

            Block spawner = e.getPlayer().getWorld().getBlockAt(x, y - 1, z);

            if (spawner.getType().equals(Material.SPAWNER)) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onSpawnerBreak(BlockBreakEvent e) {

        Block blockBroken = e.getBlock();

        int x1 = blockBroken.getLocation().getBlockX();
        int y1 = blockBroken.getLocation().getBlockY();
        int z1 = blockBroken.getLocation().getBlockZ();

        Block barrier = e.getPlayer().getWorld().getBlockAt(x1, y1 - 3, z1);

        if (blockBroken.getType().equals(Material.SPAWNER)) {
            //Checks if there is a barrier under the spawner, if so, it must be a protected spawner, therefor, cancel.
            if (!(barrier.getType().equals(Material.BARRIER))) {
                //Checks if you're breaking a spawner with the appropriate tools. If you're not, you cannot break it.
                if (e.getPlayer().getInventory().getItemInMainHand().equals(harvester()) ||
                        e.getPlayer().getInventory().getItemInMainHand().equals(harvester2()) ||
                        e.getPlayer().getInventory().getItemInMainHand().equals(harvester3()) ||
                        e.getPlayer().getInventory().getItemInMainHand().equals(harvester4()) ||
                        e.getPlayer().getInventory().getItemInMainHand().equals(harvester5()) ||
                        e.getPlayer().getInventory().getItemInMainHand().equals(harvester6())) {
                    ItemStack harversterused = e.getPlayer().getInventory().getItemInMainHand();
                    Bukkit.getServer().getPluginManager().callEvent(new SpawnerBreakEvent(e.getPlayer(), blockBroken, harversterused));
                } else {
                    e.getPlayer().sendMessage("Harvesters must be used to break spawners");
                    //e.setCancelled(true);
                }
            } else {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onSpawnerBreak(SpawnerBreakEvent e) {

        int x = e.getSpawner().getLocation().getBlockX();
        int y = e.getSpawner().getLocation().getBlockY();
        int z = e.getSpawner().getLocation().getBlockZ();
        Block sign = e.getBreaker().getWorld().getBlockAt(x, y + 1, z);

        //Checks the type of spawner.
        CreatureSpawner cs = (CreatureSpawner) e.getSpawner().getState();
        ItemStack spawner_to_give = new ItemStack(Material.SPAWNER);
        BlockStateMeta meta = (BlockStateMeta) spawner_to_give.getItemMeta();

        assert meta != null;

        if (e.getHarvaster().equals(harvester())) {
            if (cs.getSpawnedType().equals(EntityType.ZOMBIE)) {
                cs.setSpawnedType(EntityType.ZOMBIE);
            } else if (cs.getSpawnedType().equals(EntityType.SKELETON)) {
                cs.setSpawnedType(EntityType.SKELETON);
            } else if (cs.getSpawnedType().equals(EntityType.SPIDER)) {
                cs.setSpawnedType(EntityType.SPIDER);
            } else if (cs.getSpawnedType().equals(EntityType.CAVE_SPIDER)) {
                cs.setSpawnedType(EntityType.CAVE_SPIDER);
            } else if (cs.getSpawnedType().equals(EntityType.BLAZE)) {
                cs.setSpawnedType(EntityType.BLAZE);
            } else {
                e.getBreaker().sendMessage("Your harvester is not strong enough to obtain that spawner.");

                BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
                scheduler.scheduleSyncDelayedTask((Plugin) this, new Runnable() {

                    public void run() {
                        //This runnable doesn't do anything, but for some reason it's pure existance is what makes this Event work.
                    }
                }, 69);
            }
            Items.giveSpawner(e.getBreaker(), cs.getSpawnedType(), e.getSpawner());
            sign.setType(Material.AIR);
            e.getSpawner().setType(Material.AIR);
            e.getBreaker().getInventory().getItemInMainHand().setAmount((e.getBreaker().getInventory().getItemInMainHand().getAmount()) - 1);
            e.getBreaker().getWorld().playSound(e.getBreaker().getLocation(), Sound.ENTITY_ITEM_BREAK, 2, 2);
        } else if (e.getHarvaster().equals(harvester2())) {
            if (cs.getSpawnedType().equals(EntityType.ZOMBIE)) {
                cs.setSpawnedType(EntityType.ZOMBIE);
            } else if (cs.getSpawnedType().equals(EntityType.SKELETON)) {
                cs.setSpawnedType(EntityType.SKELETON);
            } else if (cs.getSpawnedType().equals(EntityType.SPIDER)) {
                cs.setSpawnedType(EntityType.SPIDER);
            } else if (cs.getSpawnedType().equals(EntityType.CAVE_SPIDER)) {
                cs.setSpawnedType(EntityType.CAVE_SPIDER);
            } else if (cs.getSpawnedType().equals(EntityType.BLAZE)) {
                cs.setSpawnedType(EntityType.BLAZE);
            } else if (cs.getSpawnedType().equals(EntityType.MAGMA_CUBE)) {
                cs.setSpawnedType(EntityType.MAGMA_CUBE);
            } else if (cs.getSpawnedType().equals(EntityType.SILVERFISH)) {
                cs.setSpawnedType(EntityType.SILVERFISH);
            } else if (cs.getSpawnedType().equals(EntityType.CHICKEN)) {
                cs.setSpawnedType(EntityType.CHICKEN);
            } else if (cs.getSpawnedType().equals(EntityType.PIG)) {
                cs.setSpawnedType(EntityType.PIG);
            } else if (cs.getSpawnedType().equals(EntityType.SHEEP)) {
                cs.setSpawnedType(EntityType.SHEEP);
            } else {
                e.getBreaker().sendMessage("Your harvester is not strong enough to obtain that spawner.");

                BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
                scheduler.scheduleSyncDelayedTask((Plugin) this, new Runnable() {

                    public void run() {
                        //This runnable doesn't do anything, but for some reason it's pure existance is what makes this Event work.
                    }
                }, 69);
            }
            Items.giveSpawner(e.getBreaker(), cs.getSpawnedType(), e.getSpawner());
            sign.setType(Material.AIR);
            e.getSpawner().setType(Material.AIR);
            e.getBreaker().getInventory().getItemInMainHand().setAmount((e.getBreaker().getInventory().getItemInMainHand().getAmount()) - 1);
            e.getBreaker().getWorld().playSound(e.getBreaker().getLocation(), Sound.ENTITY_ITEM_BREAK, 2, 2);
        } else if (e.getHarvaster().equals(harvester3())) {
            if (cs.getSpawnedType().equals(EntityType.ZOMBIE)) {
                cs.setSpawnedType(EntityType.ZOMBIE);
            } else if (cs.getSpawnedType().equals(EntityType.SKELETON)) {
                cs.setSpawnedType(EntityType.SKELETON);
            } else if (cs.getSpawnedType().equals(EntityType.SPIDER)) {
                cs.setSpawnedType(EntityType.SPIDER);
            } else if (cs.getSpawnedType().equals(EntityType.CAVE_SPIDER)) {
                cs.setSpawnedType(EntityType.CAVE_SPIDER);
            } else if (cs.getSpawnedType().equals(EntityType.BLAZE)) {
                cs.setSpawnedType(EntityType.BLAZE);
            } else if (cs.getSpawnedType().equals(EntityType.MAGMA_CUBE)) {
                cs.setSpawnedType(EntityType.MAGMA_CUBE);
            } else if (cs.getSpawnedType().equals(EntityType.SILVERFISH)) {
                cs.setSpawnedType(EntityType.SILVERFISH);
            } else if (cs.getSpawnedType().equals(EntityType.CHICKEN)) {
                cs.setSpawnedType(EntityType.CHICKEN);
            } else if (cs.getSpawnedType().equals(EntityType.PIG)) {
                cs.setSpawnedType(EntityType.PIG);
            } else if (cs.getSpawnedType().equals(EntityType.SHEEP)) {
                cs.setSpawnedType(EntityType.SHEEP);
            } else if (cs.getSpawnedType().equals(EntityType.COW)) {
                cs.setSpawnedType(EntityType.COW);
            } else if (cs.getSpawnedType().equals(EntityType.MUSHROOM_COW)) {
                cs.setSpawnedType(EntityType.MUSHROOM_COW);
            } else if (cs.getSpawnedType().equals(EntityType.HORSE)) {
                cs.setSpawnedType(EntityType.HORSE);
            } else if (cs.getSpawnedType().equals(EntityType.LLAMA)) {
                cs.setSpawnedType(EntityType.LLAMA);
            } else if (cs.getSpawnedType().equals(EntityType.OCELOT)) {
                cs.setSpawnedType(EntityType.OCELOT);
            } else {
                e.getBreaker().sendMessage("Your harvester is not strong enough to obtain that spawner.");

                BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
                scheduler.scheduleSyncDelayedTask((Plugin) this, new Runnable() {

                    public void run() {
                        //This runnable doesn't do anything, but for some reason it's pure existance is what makes this Event work.
                    }
                }, 69);
            }
            Items.giveSpawner(e.getBreaker(), cs.getSpawnedType(), e.getSpawner());
            sign.setType(Material.AIR);
            e.getSpawner().setType(Material.AIR);
            e.getBreaker().getInventory().getItemInMainHand().setAmount((e.getBreaker().getInventory().getItemInMainHand().getAmount()) - 1);
            e.getBreaker().getWorld().playSound(e.getBreaker().getLocation(), Sound.ENTITY_ITEM_BREAK, 2, 2);
        } else if (e.getHarvaster().equals(harvester4())) {
            if (cs.getSpawnedType().equals(EntityType.ZOMBIE)) {
                cs.setSpawnedType(EntityType.ZOMBIE);
            } else if (cs.getSpawnedType().equals(EntityType.SKELETON)) {
                cs.setSpawnedType(EntityType.SKELETON);
            } else if (cs.getSpawnedType().equals(EntityType.SPIDER)) {
                cs.setSpawnedType(EntityType.SPIDER);
            } else if (cs.getSpawnedType().equals(EntityType.CAVE_SPIDER)) {
                cs.setSpawnedType(EntityType.CAVE_SPIDER);
            } else if (cs.getSpawnedType().equals(EntityType.BLAZE)) {
                cs.setSpawnedType(EntityType.BLAZE);
            } else if (cs.getSpawnedType().equals(EntityType.MAGMA_CUBE)) {
                cs.setSpawnedType(EntityType.MAGMA_CUBE);
            } else if (cs.getSpawnedType().equals(EntityType.SILVERFISH)) {
                cs.setSpawnedType(EntityType.SILVERFISH);
            } else if (cs.getSpawnedType().equals(EntityType.CHICKEN)) {
                cs.setSpawnedType(EntityType.CHICKEN);
            } else if (cs.getSpawnedType().equals(EntityType.PIG)) {
                cs.setSpawnedType(EntityType.PIG);
            } else if (cs.getSpawnedType().equals(EntityType.SHEEP)) {
                cs.setSpawnedType(EntityType.SHEEP);
            } else if (cs.getSpawnedType().equals(EntityType.COW)) {
                cs.setSpawnedType(EntityType.COW);
            } else if (cs.getSpawnedType().equals(EntityType.MUSHROOM_COW)) {
                cs.setSpawnedType(EntityType.MUSHROOM_COW);
            } else if (cs.getSpawnedType().equals(EntityType.HORSE)) {
                cs.setSpawnedType(EntityType.HORSE);
            } else if (cs.getSpawnedType().equals(EntityType.LLAMA)) {
                cs.setSpawnedType(EntityType.LLAMA);
            } else if (cs.getSpawnedType().equals(EntityType.OCELOT)) {
                cs.setSpawnedType(EntityType.OCELOT);
            } else if (cs.getSpawnedType().equals(EntityType.PANDA)) {
                cs.setSpawnedType(EntityType.PANDA);
            } else if (cs.getSpawnedType().equals(EntityType.WOLF)) {
                cs.setSpawnedType(EntityType.WOLF);
            } else if (cs.getSpawnedType().equals(EntityType.PIGLIN)) {
                cs.setSpawnedType(EntityType.PIGLIN);
            } else if (cs.getSpawnedType().equals(EntityType.BAT)) {
                cs.setSpawnedType(EntityType.BAT);
            } else if (cs.getSpawnedType().equals(EntityType.IRON_GOLEM)) {
                cs.setSpawnedType(EntityType.IRON_GOLEM);
            } else {
                e.getBreaker().sendMessage("Your harvester is not strong enough to obtain that spawner.");

                BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
                scheduler.scheduleSyncDelayedTask((Plugin) this, new Runnable() {

                    public void run() {
                        //This runnable doesn't do anything, but for some reason it's pure existance is what makes this Event work.
                    }
                }, 69);
            }
            Items.giveSpawner(e.getBreaker(), cs.getSpawnedType(), e.getSpawner());
            sign.setType(Material.AIR);
            e.getSpawner().setType(Material.AIR);
            e.getBreaker().getInventory().getItemInMainHand().setAmount((e.getBreaker().getInventory().getItemInMainHand().getAmount()) - 1);
            e.getBreaker().getWorld().playSound(e.getBreaker().getLocation(), Sound.ENTITY_ITEM_BREAK, 2, 2);
        } else if (e.getHarvaster().equals(harvester5())) {
            if (cs.getSpawnedType().equals(EntityType.ZOMBIE)) {
                cs.setSpawnedType(EntityType.ZOMBIE);
            } else if (cs.getSpawnedType().equals(EntityType.SKELETON)) {
                cs.setSpawnedType(EntityType.SKELETON);
            } else if (cs.getSpawnedType().equals(EntityType.SPIDER)) {
                cs.setSpawnedType(EntityType.SPIDER);
            } else if (cs.getSpawnedType().equals(EntityType.CAVE_SPIDER)) {
                cs.setSpawnedType(EntityType.CAVE_SPIDER);
            } else if (cs.getSpawnedType().equals(EntityType.BLAZE)) {
                cs.setSpawnedType(EntityType.BLAZE);
            } else if (cs.getSpawnedType().equals(EntityType.MAGMA_CUBE)) {
                cs.setSpawnedType(EntityType.MAGMA_CUBE);
            } else if (cs.getSpawnedType().equals(EntityType.SILVERFISH)) {
                cs.setSpawnedType(EntityType.SILVERFISH);
            } else if (cs.getSpawnedType().equals(EntityType.CHICKEN)) {
                cs.setSpawnedType(EntityType.CHICKEN);
            } else if (cs.getSpawnedType().equals(EntityType.PIG)) {
                cs.setSpawnedType(EntityType.PIG);
            } else if (cs.getSpawnedType().equals(EntityType.SHEEP)) {
                cs.setSpawnedType(EntityType.SHEEP);
            } else if (cs.getSpawnedType().equals(EntityType.COW)) {
                cs.setSpawnedType(EntityType.COW);
            } else if (cs.getSpawnedType().equals(EntityType.MUSHROOM_COW)) {
                cs.setSpawnedType(EntityType.MUSHROOM_COW);
            } else if (cs.getSpawnedType().equals(EntityType.HORSE)) {
                cs.setSpawnedType(EntityType.HORSE);
            } else if (cs.getSpawnedType().equals(EntityType.LLAMA)) {
                cs.setSpawnedType(EntityType.LLAMA);
            } else if (cs.getSpawnedType().equals(EntityType.OCELOT)) {
                cs.setSpawnedType(EntityType.OCELOT);
            } else if (cs.getSpawnedType().equals(EntityType.PANDA)) {
                cs.setSpawnedType(EntityType.PANDA);
            } else if (cs.getSpawnedType().equals(EntityType.WOLF)) {
                cs.setSpawnedType(EntityType.WOLF);
            } else if (cs.getSpawnedType().equals(EntityType.PIGLIN)) {
                cs.setSpawnedType(EntityType.PIGLIN);
            } else if (cs.getSpawnedType().equals(EntityType.BAT)) {
                cs.setSpawnedType(EntityType.BAT);
            } else if (cs.getSpawnedType().equals(EntityType.IRON_GOLEM)) {
                cs.setSpawnedType(EntityType.IRON_GOLEM);
            } else if (cs.getSpawnedType().equals(EntityType.WITHER_SKELETON)) {
                cs.setSpawnedType(EntityType.WITHER_SKELETON);
            } else if (cs.getSpawnedType().equals(EntityType.ENDERMAN)) {
                cs.setSpawnedType(EntityType.ENDERMAN);
            } else if (cs.getSpawnedType().equals(EntityType.ELDER_GUARDIAN)) {
                cs.setSpawnedType(EntityType.ELDER_GUARDIAN);
            } else if (cs.getSpawnedType().equals(EntityType.WITHER)) {
                cs.setSpawnedType(EntityType.WITHER);
            } else {
                e.getBreaker().sendMessage("Your harvester is not strong enough to obtain that spawner.");

                BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
                scheduler.scheduleSyncDelayedTask((Plugin) this, new Runnable() {

                    public void run() {
                        //This runnable doesn't do anything, but for some reason it's pure existance is what makes this Event work.
                    }
                }, 69);
            }
            Items.giveSpawner(e.getBreaker(), cs.getSpawnedType(), e.getSpawner());
            sign.setType(Material.AIR);
            e.getSpawner().setType(Material.AIR);
            e.getBreaker().getInventory().getItemInMainHand().setAmount((e.getBreaker().getInventory().getItemInMainHand().getAmount()) - 1);
            e.getBreaker().getWorld().playSound(e.getBreaker().getLocation(), Sound.ENTITY_ITEM_BREAK, 2, 2);
        } else if (e.getHarvaster().equals(harvester6())) {
            if (cs.getSpawnedType().equals(EntityType.ZOMBIE)) {
                cs.setSpawnedType(EntityType.ZOMBIE);
            } else if (cs.getSpawnedType().equals(EntityType.SKELETON)) {
                cs.setSpawnedType(EntityType.SKELETON);
            } else if (cs.getSpawnedType().equals(EntityType.SPIDER)) {
                cs.setSpawnedType(EntityType.SPIDER);
            } else if (cs.getSpawnedType().equals(EntityType.CAVE_SPIDER)) {
                cs.setSpawnedType(EntityType.CAVE_SPIDER);
            } else if (cs.getSpawnedType().equals(EntityType.BLAZE)) {
                cs.setSpawnedType(EntityType.BLAZE);
            } else if (cs.getSpawnedType().equals(EntityType.MAGMA_CUBE)) {
                cs.setSpawnedType(EntityType.MAGMA_CUBE);
            } else if (cs.getSpawnedType().equals(EntityType.SILVERFISH)) {
                cs.setSpawnedType(EntityType.SILVERFISH);
            } else if (cs.getSpawnedType().equals(EntityType.CHICKEN)) {
                cs.setSpawnedType(EntityType.CHICKEN);
            } else if (cs.getSpawnedType().equals(EntityType.PIG)) {
                cs.setSpawnedType(EntityType.PIG);
            } else if (cs.getSpawnedType().equals(EntityType.SHEEP)) {
                cs.setSpawnedType(EntityType.SHEEP);
            } else if (cs.getSpawnedType().equals(EntityType.COW)) {
                cs.setSpawnedType(EntityType.COW);
            } else if (cs.getSpawnedType().equals(EntityType.MUSHROOM_COW)) {
                cs.setSpawnedType(EntityType.MUSHROOM_COW);
            } else if (cs.getSpawnedType().equals(EntityType.HORSE)) {
                cs.setSpawnedType(EntityType.HORSE);
            } else if (cs.getSpawnedType().equals(EntityType.LLAMA)) {
                cs.setSpawnedType(EntityType.LLAMA);
            } else if (cs.getSpawnedType().equals(EntityType.OCELOT)) {
                cs.setSpawnedType(EntityType.OCELOT);
            } else if (cs.getSpawnedType().equals(EntityType.PANDA)) {
                cs.setSpawnedType(EntityType.PANDA);
            } else if (cs.getSpawnedType().equals(EntityType.WOLF)) {
                cs.setSpawnedType(EntityType.WOLF);
            } else if (cs.getSpawnedType().equals(EntityType.PIGLIN)) {
                cs.setSpawnedType(EntityType.PIGLIN);
            } else if (cs.getSpawnedType().equals(EntityType.BAT)) {
                cs.setSpawnedType(EntityType.BAT);
            } else if (cs.getSpawnedType().equals(EntityType.IRON_GOLEM)) {
                cs.setSpawnedType(EntityType.IRON_GOLEM);
            } else if (cs.getSpawnedType().equals(EntityType.WITHER_SKELETON)) {
                cs.setSpawnedType(EntityType.WITHER_SKELETON);
            } else if (cs.getSpawnedType().equals(EntityType.ENDERMAN)) {
                cs.setSpawnedType(EntityType.ENDERMAN);
            } else if (cs.getSpawnedType().equals(EntityType.ELDER_GUARDIAN)) {
                cs.setSpawnedType(EntityType.ELDER_GUARDIAN);
            } else if (cs.getSpawnedType().equals(EntityType.WITHER)) {
                cs.setSpawnedType(EntityType.WITHER);
            } else if (cs.getSpawnedType().equals(EntityType.ENDER_DRAGON)) {
                cs.setSpawnedType(EntityType.ENDER_DRAGON);
            } else {
                e.getBreaker().sendMessage("Your harvester is not strong enough to obtain that spawner.");

                BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
                scheduler.scheduleSyncDelayedTask((Plugin) this, new Runnable() {

                    public void run() {
                        //This runnable doesn't do anything, but for some reason it's pure existance is what makes this Event work.
                    }
                }, 69);
            }

            Items.giveSpawner(e.getBreaker(), cs.getSpawnedType(), e.getSpawner());
            sign.setType(Material.AIR);
            e.getSpawner().setType(Material.AIR);
            e.getBreaker().getInventory().getItemInMainHand().setAmount((e.getBreaker().getInventory().getItemInMainHand().getAmount()) - 1);
            e.getBreaker().getWorld().playSound(e.getBreaker().getLocation(), Sound.ENTITY_ITEM_BREAK, 2, 2);
        }
        e.getBreaker().sendMessage(ChatColor.GRAY + "You have obtained a spawner.");
    }

}
