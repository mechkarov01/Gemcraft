package me.mechkarov.gemcraft.CustomEvents;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

public class SpawnerBreakEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    Player breaker;
    Block spawner;
    ItemStack harvaster;

    public ItemStack getHarvaster() {
        return harvaster;
    }

    public SpawnerBreakEvent(Player breaker, Block spawner, ItemStack harvaster) {
        this.breaker = breaker;
        this.spawner = spawner;
        this.harvaster = harvaster;

    }

    public Block getSpawner() {
        return spawner;
    }

    public Player getBreaker() {
        return breaker;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}

