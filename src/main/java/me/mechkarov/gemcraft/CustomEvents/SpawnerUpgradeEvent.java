package me.mechkarov.gemcraft.CustomEvents;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.block.Action;

public class SpawnerUpgradeEvent extends Event {


    private static final HandlerList handlers = new HandlerList();


    Player upgrader;
    Block spawner;
    Action action;

    public Action getAction() {
        return action;
    }

    public SpawnerUpgradeEvent(Player upgrader,Block spawner) {
        this.upgrader = upgrader;
        this.spawner = spawner;

    }

    public Block getSpawner() {
        return spawner;
    }

    public Player getUpgrader() {
        return upgrader;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
