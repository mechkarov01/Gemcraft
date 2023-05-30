package me.mechkarov.gemcraft.Listeners.Tools;

import me.mechkarov.gemcraft.Gemcraft;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import static me.mechkarov.gemcraft.Items.placer;

public class BlockPlacer implements Listener {

    private Gemcraft plugin;

    public BlockPlacer(Gemcraft plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlaceBlock(BlockPlaceEvent e) {

        e.getPlayer().sendMessage("Works??");

        ItemMeta meta = placer().getItemMeta();

        int x = e.getBlockPlaced().getLocation().getBlockX();
        int y = e.getBlockPlaced().getLocation().getBlockY();
        int z = e.getBlockPlaced().getLocation().getBlockZ();

        Block Placer = e.getBlockPlaced().getWorld().getBlockAt(x, y, z);

        if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().equals(meta)) {

            //This prevents block placers from being used at spawn, warzone and gates
            if (((x >= -325 && x <= 310) && (z >= 75 && z <= 750)) || ((x >= 90 && x <= 134) && (z >= -1963 && z <= -1919)) ||
                    ((x >= -191 && x <= -147) && (z >= 2077 && z <= 2121)) || ((x >= -2177 && x <= -2133) && (z >= -265 && z <= -221)) ||
                    ((x >= 2105 && x <= 2149) && (z >= 246 && z <= 290))) {
                e.getPlayer().sendMessage("You are not allowed to use that here!");
            }
            else{
                e.getPlayer().getInventory().getItemInMainHand().setAmount((e.getPlayer().getInventory().getItemInMainHand().getAmount()) - 1);
                e.getPlayer().updateInventory();
                e.setCancelled(true);

                new BukkitRunnable() {
                    int tick = 0;

                    @Override
                    public void run() {

                        //e.getPlayer().sendMessage("Block placer activated");

                        if (tick <= 10 || (20 < tick && tick <= 30) || (40 < tick && tick <= 50) || (60 < tick && tick <= 70) || (80 < tick && tick <= 90)
                                || (100 < tick && tick <= 110) || (120 < tick && tick <= 130) || (140 < tick && tick <= 150) || (160 < tick && tick <= 170)
                                || (180 < tick && tick <= 190) || (200 < tick && tick <= 210) || (220 < tick && tick <= 230) || (240 < tick && tick <= 250)
                                || (260 < tick && tick <= 270) || (280 < tick && tick <= 290)) {
                            Placer.setType(Material.RED_STAINED_GLASS);
                        }
                        if ((10 < tick && tick <= 20) || (30 < tick && tick <= 40) || (50 < tick && tick <= 60) || (70 < tick && tick <= 80)
                                || (90 < tick && tick <= 100) || (110 < tick && tick <= 120) || (130 < tick && tick <= 140) || (150 < tick && tick <= 160)
                                || (170 < tick && tick <= 180) || (190 < tick && tick <= 200) || (210 < tick && tick <= 220) || (230 < tick && tick <= 240)
                                || (250 < tick && tick <= 260) || (270 < tick && tick <= 280) || (290 < tick && tick <= 300)) {
                            Placer.setType(Material.WHITE_STAINED_GLASS);
                        }

                        if (tick == 300) {
                            Placer.setType(Material.AIR);
                            this.cancel();
                            //e.getPlayer().sendMessage("Block placer disappeared");
                        }
                        tick++;
                    }
                }.runTaskTimer(plugin, 0L, 1L);
            }
        }
    }
}
