package me.mechkarov.gemcraft.Listeners;

import me.mechkarov.gemcraft.CustomEvents.GemCollectEvent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class SpawnerPlaceListener implements Listener {

    @EventHandler
    public void onSpawnerPlaceEvent(BlockPlaceEvent e) {

        CreatureSpawner cs = (CreatureSpawner) e.getBlockPlaced().getState();
        Block generator = e.getBlockPlaced();

        int x = e.getBlockPlaced().getLocation().getBlockX();
        int y = e.getBlockPlaced().getLocation().getBlockY();
        int z = e.getBlockPlaced().getLocation().getBlockZ();

        Block air = e.getPlayer().getWorld().getBlockAt(x, y + 1, z);

        if (air.getType().equals(Material.AIR)) {

            if (cs.getSpawnedType().equals(EntityType.ZOMBIE)) {
                Bukkit.getServer().getPluginManager().callEvent(new GemCollectEvent(e.getPlayer(), generator));

            } else if (cs.getSpawnedType().equals(EntityType.SKELETON)) {
                Bukkit.getServer().getPluginManager().callEvent(new GemCollectEvent(e.getPlayer(), generator));

            } else if (cs.getSpawnedType().equals(EntityType.SPIDER)) {
                Bukkit.getServer().getPluginManager().callEvent(new GemCollectEvent(e.getPlayer(), generator));

            } else if (cs.getSpawnedType().equals(EntityType.CAVE_SPIDER)) {
                Bukkit.getServer().getPluginManager().callEvent(new GemCollectEvent(e.getPlayer(), generator));

            } else if (cs.getSpawnedType().equals(EntityType.BLAZE)) {
                Bukkit.getServer().getPluginManager().callEvent(new GemCollectEvent(e.getPlayer(), generator));

            } else if (cs.getSpawnedType().equals(EntityType.MAGMA_CUBE)) {
                Bukkit.getServer().getPluginManager().callEvent(new GemCollectEvent(e.getPlayer(), generator));

            } else if (cs.getSpawnedType().equals(EntityType.SILVERFISH)) {
                Bukkit.getServer().getPluginManager().callEvent(new GemCollectEvent(e.getPlayer(), generator));

            } else if (cs.getSpawnedType().equals(EntityType.CHICKEN)) {
                Bukkit.getServer().getPluginManager().callEvent(new GemCollectEvent(e.getPlayer(), generator));

            } else if (cs.getSpawnedType().equals(EntityType.PIG)) {
                Bukkit.getServer().getPluginManager().callEvent(new GemCollectEvent(e.getPlayer(), generator));

            } else if (cs.getSpawnedType().equals(EntityType.SHEEP)) {
                Bukkit.getServer().getPluginManager().callEvent(new GemCollectEvent(e.getPlayer(), generator));

            } else if (cs.getSpawnedType().equals(EntityType.COW)) {
                Bukkit.getServer().getPluginManager().callEvent(new GemCollectEvent(e.getPlayer(), generator));

            } else if (cs.getSpawnedType().equals(EntityType.MUSHROOM_COW)) {
                Bukkit.getServer().getPluginManager().callEvent(new GemCollectEvent(e.getPlayer(), generator));

            } else if (cs.getSpawnedType().equals(EntityType.HORSE)) {
                Bukkit.getServer().getPluginManager().callEvent(new GemCollectEvent(e.getPlayer(), generator));

            } else if (cs.getSpawnedType().equals(EntityType.LLAMA)) {
                Bukkit.getServer().getPluginManager().callEvent(new GemCollectEvent(e.getPlayer(), generator));

            } else if (cs.getSpawnedType().equals(EntityType.OCELOT)) {
                Bukkit.getServer().getPluginManager().callEvent(new GemCollectEvent(e.getPlayer(), generator));

            } else if (cs.getSpawnedType().equals(EntityType.PANDA)) {
                Bukkit.getServer().getPluginManager().callEvent(new GemCollectEvent(e.getPlayer(), generator));

            } else if (cs.getSpawnedType().equals(EntityType.WOLF)) {
                Bukkit.getServer().getPluginManager().callEvent(new GemCollectEvent(e.getPlayer(), generator));

            } else if (cs.getSpawnedType().equals(EntityType.PIGLIN)) {
                Bukkit.getServer().getPluginManager().callEvent(new GemCollectEvent(e.getPlayer(), generator));

            } else if (cs.getSpawnedType().equals(EntityType.BAT)) {
                Bukkit.getServer().getPluginManager().callEvent(new GemCollectEvent(e.getPlayer(), generator));

            } else if (cs.getSpawnedType().equals(EntityType.IRON_GOLEM)) {
                Bukkit.getServer().getPluginManager().callEvent(new GemCollectEvent(e.getPlayer(), generator));

            } else if (cs.getSpawnedType().equals(EntityType.WITHER_SKELETON)) {
                Bukkit.getServer().getPluginManager().callEvent(new GemCollectEvent(e.getPlayer(), generator));

            } else if (cs.getSpawnedType().equals(EntityType.ENDERMAN)) {
                Bukkit.getServer().getPluginManager().callEvent(new GemCollectEvent(e.getPlayer(), generator));

            } else if (cs.getSpawnedType().equals(EntityType.ELDER_GUARDIAN)) {
                Bukkit.getServer().getPluginManager().callEvent(new GemCollectEvent(e.getPlayer(), generator));

            } else if (cs.getSpawnedType().equals(EntityType.WITHER)) {
                Bukkit.getServer().getPluginManager().callEvent(new GemCollectEvent(e.getPlayer(), generator));

            } else if (cs.getSpawnedType().equals(EntityType.ENDER_DRAGON)) {
                Bukkit.getServer().getPluginManager().callEvent(new GemCollectEvent(e.getPlayer(), generator));
            }
        }
        else {
            e.getPlayer().sendMessage("The block above the spawner must be free in order to place it down.");
            e.setCancelled(true);
        }
    }
}


/*try { Thread.sleep(1000);
        } catch (InterruptedException ex) {
        Thread.currentThread().interrupt(); }*/









