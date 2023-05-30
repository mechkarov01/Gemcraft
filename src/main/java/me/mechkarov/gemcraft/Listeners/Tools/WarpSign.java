package me.mechkarov.gemcraft.Listeners.Tools;

import me.mechkarov.gemcraft.Gemcraft;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.Arrays;
import java.util.Objects;

import static me.mechkarov.gemcraft.Items.warp;

public class WarpSign implements Listener {

    private Gemcraft plugin;
    public WarpSign(Gemcraft plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onWarpSign(SignChangeEvent e) {

        ItemMeta meta = warp().getItemMeta();

        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        scheduler.scheduleSyncDelayedTask(plugin, new Runnable() {

            public void run() {

                //Creates your warp sign with auto-generated coordinates and your password at the bottom

                if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().equals(meta)) {

                    int x = e.getBlock().getLocation().getBlockX();
                    int y = e.getBlock().getLocation().getBlockY();
                    int z = e.getBlock().getLocation().getBlockZ();

                    Sign sign = (Sign) e.getPlayer().getWorld().getBlockAt(x, y, z).getState();

                    String password = sign.getLine(0);

                    sign.setLine(0, ChatColor.LIGHT_PURPLE + "Warp Sign");
                    sign.setLine(1, ChatColor.YELLOW + "Coords/Password");
                    sign.setLine(2, ChatColor.GREEN + (x + " " + y + " " + z + ""));
                    sign.setLine(3, password);
                    sign.update();

                    ItemStack note = new ItemStack(Material.PAPER, 1);
                    ItemMeta meta = note.getItemMeta();
                    meta.setDisplayName(ChatColor.AQUA + "Note");
                    meta.setLore(Arrays.asList(ChatColor.WHITE + "Coordinates: "+(x + " " + y + " " + z + ""),ChatColor.WHITE + "Password: "+password,ChatColor.DARK_PURPLE + "Store this in your vault or somewhere safe!"));
                    note.setItemMeta(meta);

                    if (Objects.requireNonNull(e.getPlayer().getInventory().firstEmpty() == -1)) {
                        e.getPlayer().getWorld().dropItemNaturally(e.getPlayer().getLocation(), note);
                    }
                    else{
                        e.getPlayer().getInventory().addItem(note);
                    }
                    e.getPlayer().sendMessage(ChatColor.AQUA+"Note"+ChatColor.WHITE+" was added to your inventory!");

                }
            }
        }, 3);

        //Checks if the contents on a regular sign match an intention of teleporting or just normal writing
        new BukkitRunnable() {

            int i = 0;

            Location location = e.getPlayer().getLocation();

            @Override
            public void run() {

                if (i >= 0 && 60 >= i) {

                    if (!(e.getPlayer().getInventory().getItemInMainHand().getItemMeta().equals(meta))) {

                        int x2 = e.getBlock().getLocation().getBlockX();
                        int y2 = e.getBlock().getLocation().getBlockY();
                        int z2 = e.getBlock().getLocation().getBlockZ();

                        Block teleportsign = e.getPlayer().getWorld().getBlockAt(x2, y2, z2);
                        if((!(teleportsign.getType().equals(Material.OAK_SIGN)))&&(!(teleportsign.getType().equals(Material.OAK_WALL_SIGN)))){
                            //e.getPlayer().sendMessage("You broke the teleport sign!");
                            this.cancel();
                        }

                        Sign sign = (Sign) e.getPlayer().getWorld().getBlockAt(x2, y2, z2).getState();

                        String s = sign.getLine(0);
                        String s1 = sign.getLine(1);
                        String s2 = sign.getLine(2);

                        String password = sign.getLine(3);

                        if (s.length() == 0 || s1.length() == 0 || s2.length() == 0) {
                            this.cancel();
                            //e.getPlayer().sendMessage("Line must not be blank");
                        }

                        int x3 = 0, y3 = 0, z3 = 0;

                        try {
                            x3 = Integer.parseInt(sign.getLine(0));
                            y3 = Integer.parseInt(sign.getLine(1));
                            z3 = Integer.parseInt(sign.getLine(2));
                        } catch (NumberFormatException n) {
                            //e.getPlayer().sendMessage("Not a valid coordinate");
                        }

                        if (e.getPlayer().getWorld().getBlockAt(x3, y3, z3).getType().equals(Material.OAK_WALL_SIGN) ||
                                e.getPlayer().getWorld().getBlockAt(x3, y3, z3).getType().equals(Material.OAK_SIGN)) {

                            Sign sign2 = (Sign) e.getPlayer().getWorld().getBlockAt(x3, y3, z3).getState();

                            if (sign2.getLine(0).equals(ChatColor.LIGHT_PURPLE + "Warp Sign")) {
                                if (sign2.getLine(3).equals(password)) {

                                    if (i == 0) {
                                        e.getPlayer().sendMessage("Teleporting in 3 seconds. " + ChatColor.RED + "Do not move!");
                                    }
                                    if (i == 20) {
                                        e.getPlayer().sendMessage("Teleporting in 2 seconds. " + ChatColor.RED + "Do not move!");
                                    }
                                    if (i == 40) {
                                        e.getPlayer().sendMessage("Teleporting in 1 seconds. " + ChatColor.RED + "Do not move!");
                                    }
                                    if (i >= 1 && 59 >= i) {
                                        if (!(e.getPlayer().getLocation().equals(location))) {
                                            e.getPlayer().sendMessage(ChatColor.YELLOW + "Teleportation cancelled");
                                            teleportsign.setType(Material.AIR);
                                            e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_LADDER_BREAK, 2, 1);
                                            this.cancel();
                                        }
                                    }
                                    if (i == 60) {
                                        e.getPlayer().sendMessage(ChatColor.LIGHT_PURPLE+"Warped!");

                                        Location loc = new Location(e.getPlayer().getWorld(), x3, y3, z3, 0, 0);
                                        e.getPlayer().teleport(loc);
                                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 2, 1);

                                        teleportsign.setType(Material.AIR);
                                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_LADDER_BREAK, 2, 1);
                                    }
                                }
                            }
                        } else {
                            this.cancel();
                            //e.getPlayer().sendMessage("Invalid Coordinates");
                        }
                    }
                }
                if (i == 60) {
                    this.cancel();
                    //e.getPlayer().sendMessage("Cancelled");
                }
                i++;
            }
        }.runTaskTimer(plugin, 5L, 1L);
    }

    //Checks if you've right clicked a Warp Sign. If so, hide the coordinates and the password by disabling it. (Toggleable)
    @EventHandler
    public void onHideWarp(PlayerInteractEvent e) {

        if ((e.getClickedBlock().getType().equals(Material.OAK_SIGN) && e.getAction().equals(Action.RIGHT_CLICK_BLOCK))
                || (e.getClickedBlock().getType().equals(Material.OAK_WALL_SIGN) && e.getAction().equals(Action.RIGHT_CLICK_BLOCK))) {
            if (e.getHand() == EquipmentSlot.HAND) {

                Block warp = e.getClickedBlock();
                int x = warp.getLocation().getBlockX();
                //int y = warp.getLocation().getBlockY();
                int z = warp.getLocation().getBlockZ();

                Block savedwarp = e.getPlayer().getWorld().getBlockAt(x, 0, z);
                Block bedrock = e.getPlayer().getWorld().getBlockAt(x, 1, z);

                BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
                scheduler.scheduleSyncDelayedTask(plugin, new Runnable() {

                    public void run() {

                        Sign sign = (Sign) e.getClickedBlock().getState();

                        String s1 = sign.getLine(0);
                        String s2 = sign.getLine(1);
                        String s3 = sign.getLine(2);
                        String s4 = sign.getLine(3);

                        if(s2.equals(ChatColor.YELLOW + "Coords/Password")){

                            sign.setLine(0,"");
                            sign.setLine(1,ChatColor.LIGHT_PURPLE+"Warp Sign");
                            sign.setLine(2,ChatColor.RED+"[Closed]");
                            sign.setLine(3,"");
                            sign.update();

                            savedwarp.setType(Material.OAK_SIGN);
                            Sign savedsign = (Sign) e.getPlayer().getWorld().getBlockAt(x,0,z).getState();

                            savedsign.setLine(0,s1);
                            savedsign.setLine(1,s2);
                            savedsign.setLine(2,s3);
                            savedsign.setLine(3,s4);
                            savedsign.update();

                            bedrock.setType(Material.BEDROCK);
                        }
                        if(s3.equals(ChatColor.RED+"[Closed]")){

                            Sign savedsign = (Sign) e.getPlayer().getWorld().getBlockAt(x,0,z).getState();

                            String s11 = savedsign.getLine(0);
                            String s22 = savedsign.getLine(1);
                            String s33 = savedsign.getLine(2);
                            String s44 = savedsign.getLine(3);

                            sign.setLine(0,s11);
                            sign.setLine(1,s22);
                            sign.setLine(2,s33);
                            sign.setLine(3,s44);
                            sign.update();

                            savedwarp.setType(Material.BEDROCK);
                            bedrock.setType(Material.AIR);

                        }
                    }
                }, 5);
            }
        }
    }
}
