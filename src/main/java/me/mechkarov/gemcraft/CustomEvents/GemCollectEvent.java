package me.mechkarov.gemcraft.CustomEvents;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.block.Action;

public class GemCollectEvent extends Event {


    private static final HandlerList handlers = new HandlerList();


    Player collector;
    Block generator;
    Action action;

    public Action getAction() {
        return action;
    }

    public GemCollectEvent(Player collector, Block generator) {
        this.collector = collector;
        this.generator = generator;

    }

    public Block getGenerator() { return generator; }

    public Player getCollector() { return collector; }

    public HandlerList getHandlers() { return handlers; }

    public static HandlerList getHandlerList() { return handlers; }
}
