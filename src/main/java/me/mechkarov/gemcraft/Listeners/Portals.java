package me.mechkarov.gemcraft.Listeners;

import me.mechkarov.gemcraft.Gemcraft;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.NPC;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;

public class Portals implements Listener {

    private Gemcraft plugin;

    public Portals(Gemcraft plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPortalEnter(PlayerPortalEvent e){

        if(e.getCause() == PlayerTeleportEvent.TeleportCause.NETHER_PORTAL) {

            int x = e.getPlayer().getLocation().getBlockX();
            int y = e.getPlayer().getLocation().getBlockY();
            int z = e.getPlayer().getLocation().getBlockZ();

            Material block = e.getPlayer().getWorld().getBlockAt(x, y - 2, z).getType();
            Material block2 = e.getPlayer().getWorld().getBlockAt(x, y - 3, z).getType();
            Material block3 = e.getPlayer().getWorld().getBlockAt(x, y - 4, z).getType();
            Material block4 = e.getPlayer().getWorld().getBlockAt(x, y - 7, z).getType();
            Material block5 = e.getPlayer().getWorld().getBlockAt(x, y - 8, z).getType();
            Material block6 = e.getPlayer().getWorld().getBlockAt(x, y - 9, z).getType();
            Material block7 = e.getPlayer().getWorld().getBlockAt(x, y - 12, z).getType();
            Material block8 = e.getPlayer().getWorld().getBlockAt(x, y - 13, z).getType();
            Material block9 = e.getPlayer().getWorld().getBlockAt(x, y - 14, z).getType();
            Material block10 = e.getPlayer().getWorld().getBlockAt(x, y - 17, z).getType();
            Material block11 = e.getPlayer().getWorld().getBlockAt(x, y - 18, z).getType();
            Material block12 = e.getPlayer().getWorld().getBlockAt(x, y - 19, z).getType();

            //North Gate
            if ((block.equals(Material.BARRIER)) || (block2.equals(Material.BARRIER)) || (block3.equals(Material.BARRIER))) {
                e.setCancelled(true);
                e.getPlayer().sendMessage(ChatColor.DARK_PURPLE + (ChatColor.ITALIC + "Teleporting to North Gate"));

                BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
                scheduler.scheduleSyncDelayedTask(plugin, new Runnable() {

                    public void run() {

                        Location loc = new Location(e.getPlayer().getWorld(), 112.5, 67, -1940.5, 180, 0);
                        e.getPlayer().teleport(loc);

                    }
                }, 20);

                /*e.setCancelled(true);

                new BukkitRunnable() {

                    int i = -1;

                    @Override
                    public void run() {

                        e.getPlayer().sendMessage("teleporting...");

                        Material Pblock = e.getPlayer().getWorld().getBlockAt(x, y - 2, z).getType();
                        Material Pblock2 = e.getPlayer().getWorld().getBlockAt(x, y - 3, z).getType();
                        Material Pblock3 = e.getPlayer().getWorld().getBlockAt(x, y - 4, z).getType();

                        if ((Pblock.equals(Material.BARRIER)) || (Pblock2.equals(Material.BARRIER)) || (Pblock3.equals(Material.BARRIER))) {
                            if (i == 12) {
                                e.getPlayer().sendMessage("Teleported to north gateeee");
                                this.cancel();
                                Location loc = new Location(e.getPlayer().getWorld(), 130.5, 63, 219.5, 90, 0);
                                e.getPlayer().teleport(loc);
                            }
                            i++;
                        } else {
                            this.cancel();
                            e.getPlayer().sendMessage("You pussied out");
                        }
                    }
                }.runTaskTimer(plugin, 0L, 5L);*/
            }

            //South Gate
             else if((block4.equals(Material.BARRIER))||(block5.equals(Material.BARRIER))||(block6.equals(Material.BARRIER))) {
                 e.setCancelled(true);
                e.getPlayer().sendMessage(ChatColor.DARK_PURPLE + (ChatColor.ITALIC + "Teleporting to South Gate"));

                BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
                scheduler.scheduleSyncDelayedTask(plugin, new Runnable() {

                    public void run() {

                        Location loc = new Location(e.getPlayer().getWorld(), -168.5, 65, 2099.5, 0, 0);
                        e.getPlayer().teleport(loc);

                    }
                }, 20);
            }
            //East Gate
             else if((block7.equals(Material.BARRIER))||(block8.equals(Material.BARRIER))||(block9.equals(Material.BARRIER))) {
                 e.setCancelled(true);
                e.getPlayer().sendMessage(ChatColor.DARK_PURPLE + (ChatColor.ITALIC + "Teleporting to East Gate"));

                BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
                scheduler.scheduleSyncDelayedTask(plugin, new Runnable() {

                    public void run() {

                        Location loc = new Location(e.getPlayer().getWorld(), 2127.5, 65, 268.5, -90, 0);
                        e.getPlayer().teleport(loc);

                    }
                }, 20);
            }
            //West Gate
             else if((block10.equals(Material.BARRIER))||(block11.equals(Material.BARRIER))||(block12.equals(Material.BARRIER))) {
                 e.setCancelled(true);
                e.getPlayer().sendMessage(ChatColor.DARK_PURPLE + (ChatColor.ITALIC + "Teleporting to West Gate"));

                BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
                scheduler.scheduleSyncDelayedTask(plugin, new Runnable() {

                    public void run() {

                        Location loc = new Location(e.getPlayer().getWorld(), -2154.5, 69, -242.5, 90, 0);
                        e.getPlayer().teleport(loc);

                    }
                }, 20);
            }
            //Nether World
            else{
                e.setCancelled(true);
                e.getPlayer().sendMessage(ChatColor.DARK_PURPLE + (ChatColor.ITALIC + "Teleporting to Nether"));

                BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
                scheduler.scheduleSyncDelayedTask(plugin, new Runnable() {

                    public void run() {

                        World nether = Bukkit.getWorld("world_nether");
                        Location loc = new Location(nether, -170.5, 77, 11.5, -90, 0);
                        e.getPlayer().teleport(loc);

                    }
                }, 20);
            }
        }

        //End World
        if(e.getCause() == PlayerTeleportEvent.TeleportCause.END_PORTAL){

            e.setCancelled(true);
            e.getPlayer().sendMessage(ChatColor.DARK_PURPLE + (ChatColor.ITALIC + "Teleporting to End"));
            World end = Bukkit.getWorld("world_the_end");
            Location loc = new Location(end, 11.5, 63, 0.5, 90, -30);
            e.getPlayer().teleport(loc);
            BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
            scheduler.scheduleSyncDelayedTask(plugin, new Runnable() {

                public void run() {
                    e.getPlayer().teleport(loc);
                }
            }, 20);

            /*Location loc2 = (Location) end.getBlockAt(0,54,473);

            if(e.getPlayer().getLocation().equals(loc2)){
                e.getPlayer().teleport(loc);
                e.getPlayer().sendMessage("Bruh");
            }*/

        }

    }

}