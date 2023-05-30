package me.mechkarov.gemcraft.Listeners;

import me.mechkarov.gemcraft.CustomEvents.GemCollectEvent;
import me.mechkarov.gemcraft.CustomEvents.SpawnerUpgradeEvent;
import me.mechkarov.gemcraft.Gemcraft;
import me.mechkarov.gemcraft.Items;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.Arrays;

public class SpawnerUpgradeListener implements Listener {

    private Gemcraft plugin;
    public SpawnerUpgradeListener(Gemcraft plugin){
        this.plugin = plugin;
    }

    //Checks if you've right clicked the sign displaying gems. If so, open gui to confirm upgrading.
    @EventHandler
    public void onSignClick(PlayerInteractEvent e) {

        Block sign = e.getClickedBlock();
        if (sign == null) {
            assert false;
            sign.setType(Material.AIR);
        }

        if (e.getClickedBlock().getType().equals(Material.OAK_SIGN) && e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if (e.getHand() == EquipmentSlot.HAND) {

                int x = sign.getLocation().getBlockX();
                int y = sign.getLocation().getBlockY();
                int z = sign.getLocation().getBlockZ();
                Block generator = e.getPlayer().getWorld().getBlockAt(x, y - 1, z);
                Block barrier = e.getPlayer().getWorld().getBlockAt(x, y - 4, z);

                if (barrier.getType().equals(Material.BARRIER)) {
                    e.getPlayer().sendMessage("You are not allowed to upgrade this spawner!");
                }

                    else {
                    if (generator.getType().equals(Material.SPAWNER)) {

                        Inventory upgrade = Bukkit.createInventory(e.getPlayer(), 9, ChatColor.DARK_GREEN + "Upgrade Generator?");

                        CreatureSpawner cs = (CreatureSpawner) generator.getState();

                        ItemStack spawner_to_give = new ItemStack(Material.SPAWNER);
                        BlockStateMeta meta = (BlockStateMeta) spawner_to_give.getItemMeta();
                        assert meta != null;
                        CreatureSpawner css = (CreatureSpawner) meta.getBlockState();


                        if (cs.getSpawnedType().equals(EntityType.ZOMBIE)) {

                            cs.setSpawnedType(EntityType.SKELETON);
                            meta.setDisplayName(ChatColor.DARK_GREEN + "Level 2");
                            meta.setLore(Arrays.asList(ChatColor.GOLD + "Generates: 20 minutes Per", ChatColor.GOLD + "Storage: 9 Gems", ChatColor.GOLD + "Upgrade: 8 Gems"));

                        } else if (cs.getSpawnedType().equals(EntityType.SKELETON)) {

                            cs.setSpawnedType(EntityType.SPIDER);
                            meta.setDisplayName(ChatColor.DARK_GREEN + "Level 3");
                            meta.setLore(Arrays.asList(ChatColor.GOLD + "Generates: 18 minutes Per", ChatColor.GOLD + "Storage: 9 Gems", ChatColor.GOLD + "Upgrade: 10 Gems"));

                        } else if (cs.getSpawnedType().equals(EntityType.SPIDER)) {

                            cs.setSpawnedType(EntityType.CAVE_SPIDER);
                            meta.setDisplayName(ChatColor.DARK_GREEN + "Level 4");
                            meta.setLore(Arrays.asList(ChatColor.GOLD + "Generates: 18 minutes Per", ChatColor.GOLD + "Storage: 15 Gems", ChatColor.GOLD + "Upgrade: 14 Gems"));

                        } else if (cs.getSpawnedType().equals(EntityType.CAVE_SPIDER)) {

                            cs.setSpawnedType(EntityType.BLAZE);
                            meta.setDisplayName(ChatColor.DARK_GREEN + "Level 5");
                            meta.setLore(Arrays.asList(ChatColor.GOLD + "Generates: 15 minutes Per", ChatColor.GOLD + "Storage: 15 Gems", ChatColor.GOLD + "Upgrade: 16 Gems"));

                        } else if (cs.getSpawnedType().equals(EntityType.BLAZE)) {

                            cs.setSpawnedType(EntityType.MAGMA_CUBE);
                            meta.setDisplayName(ChatColor.YELLOW + "Level 6");
                            meta.setLore(Arrays.asList(ChatColor.GOLD + "Generates: 15 minutes Per", ChatColor.GOLD + "Storage: 27 Gems", ChatColor.GOLD + "Upgrade: 18 Gems"));

                        } else if (cs.getSpawnedType().equals(EntityType.MAGMA_CUBE)) {

                            cs.setSpawnedType(EntityType.SILVERFISH);
                            meta.setDisplayName(ChatColor.YELLOW + "Level 7");
                            meta.setLore(Arrays.asList(ChatColor.GOLD + "Generates: 12 Minutes Per", ChatColor.GOLD + "Storage: 27 Gems", ChatColor.GOLD + "Upgrade: 20 Gems"));

                        } else if (cs.getSpawnedType().equals(EntityType.SILVERFISH)) {

                            cs.setSpawnedType(EntityType.CHICKEN);
                            meta.setDisplayName(ChatColor.YELLOW + "Level 8");
                            meta.setLore(Arrays.asList(ChatColor.GOLD + "Generates: 12 Minutes Per", ChatColor.GOLD + "Storage: 36 Gems", ChatColor.GOLD + "Upgrade: 24 Gems"));

                        } else if (cs.getSpawnedType().equals(EntityType.CHICKEN)) {

                            cs.setSpawnedType(EntityType.PIG);
                            meta.setDisplayName(ChatColor.YELLOW + "Level 9");
                            meta.setLore(Arrays.asList(ChatColor.GOLD + "Generates: 10 Minutes Per", ChatColor.GOLD + "Storage: 36 Gems", ChatColor.GOLD + "Upgrade: 32 Gems"));

                        } else if (cs.getSpawnedType().equals(EntityType.PIG)) {

                            cs.setSpawnedType(EntityType.SHEEP);
                            meta.setDisplayName(ChatColor.YELLOW + "Level 10");
                            meta.setLore(Arrays.asList(ChatColor.GOLD + "Generates: 10 Minutes Per", ChatColor.GOLD + "Storage: 48 Gems", ChatColor.GOLD + "Upgrade: 40 Gems"));

                        } else if (cs.getSpawnedType().equals(EntityType.SHEEP)) {

                            cs.setSpawnedType(EntityType.COW);
                            meta.setDisplayName(ChatColor.AQUA + "Level 11");
                            meta.setLore(Arrays.asList(ChatColor.GOLD + "Generates: 8 Minutes Per", ChatColor.GOLD + "Storage: 48 Gems", ChatColor.GOLD + "Upgrade: 56 Gems"));

                        } else if (cs.getSpawnedType().equals(EntityType.COW)) {

                            cs.setSpawnedType(EntityType.MUSHROOM_COW);
                            meta.setDisplayName(ChatColor.AQUA + "Level 12");
                            meta.setLore(Arrays.asList(ChatColor.GOLD + "Generates: 8 Minutes Per", ChatColor.GOLD + "Storage: 54 Gems", ChatColor.GOLD + "Upgrade: 64 Gems"));

                        } else if (cs.getSpawnedType().equals(EntityType.MUSHROOM_COW)) {

                            cs.setSpawnedType(EntityType.HORSE);
                            meta.setDisplayName(ChatColor.AQUA + "Level 13");
                            meta.setLore(Arrays.asList(ChatColor.GOLD + "Generates: 7 Minutes Per", ChatColor.GOLD + "Storage: 54 Gems", ChatColor.GOLD + "Upgrade: 96 Gems"));

                        } else if (cs.getSpawnedType().equals(EntityType.HORSE)) {

                            cs.setSpawnedType(EntityType.LLAMA);
                            meta.setDisplayName(ChatColor.AQUA + "Level 14");
                            meta.setLore(Arrays.asList(ChatColor.GOLD + "Generates: 6 Minutes Per", ChatColor.GOLD + "Storage: 72 Gems", ChatColor.GOLD + "Upgrade: 128 Gems"));

                        } else if (cs.getSpawnedType().equals(EntityType.LLAMA)) {

                            cs.setSpawnedType(EntityType.OCELOT);
                            meta.setDisplayName(ChatColor.AQUA + "Level 15");
                            meta.setLore(Arrays.asList(ChatColor.GOLD + "Generates: 5 Minutes Per", ChatColor.GOLD + "Storage: 72 Gems", ChatColor.GOLD + "Upgrade: 196 Gems"));

                        } else if (cs.getSpawnedType().equals(EntityType.OCELOT)) {

                            cs.setSpawnedType(EntityType.PANDA);
                            meta.setDisplayName(ChatColor.DARK_RED + "Level 16");
                            meta.setLore(Arrays.asList(ChatColor.GOLD + "Generates: 4 Minutes Per", ChatColor.GOLD + "Storage: 84 Gems", ChatColor.GOLD + "Upgrade: 336 Gems"));

                        } else if (cs.getSpawnedType().equals(EntityType.PANDA)) {

                            cs.setSpawnedType(EntityType.WOLF);
                            meta.setDisplayName(ChatColor.DARK_RED + "Level 17");
                            meta.setLore(Arrays.asList(ChatColor.GOLD + "Generates: 3 minutes Per", ChatColor.GOLD + "Storage: 96 Gems", ChatColor.GOLD + "Upgrade: 512 Gems"));

                        } else if (cs.getSpawnedType().equals(EntityType.WOLF)) {

                            cs.setSpawnedType(EntityType.PIGLIN);
                            meta.setDisplayName(ChatColor.DARK_RED + "Level 18");
                            meta.setLore(Arrays.asList(ChatColor.GOLD + "Generates: 2 Minutes Per", ChatColor.GOLD + "Storage: 128 Gems", ChatColor.GOLD + "Upgrade: 1156 Gems"));

                        } else if (cs.getSpawnedType().equals(EntityType.PIGLIN)) {

                            cs.setSpawnedType(EntityType.BAT);
                            meta.setDisplayName(ChatColor.DARK_RED + "Level 19");
                            meta.setLore(Arrays.asList(ChatColor.GOLD + "Generates: 60 Seconds Per", ChatColor.GOLD + "Storage: 160 Gems", ChatColor.GOLD + "Upgrade: 2240 Gems"));

                        } else if (cs.getSpawnedType().equals(EntityType.BAT)) {

                            cs.setSpawnedType(EntityType.IRON_GOLEM);
                            meta.setDisplayName(ChatColor.DARK_RED + "Level 20");
                            meta.setLore(Arrays.asList(ChatColor.GOLD + "Generates: 45 Seconds per", ChatColor.GOLD + "Storage: 192 Gems ",
                                    ChatColor.GOLD + "Upgrade: " + ChatColor.MAGIC + "" + ChatColor.GOLD + "4" + ChatColor.GOLD + " Sapphires"));

                        } else if (cs.getSpawnedType().equals(EntityType.IRON_GOLEM)) {

                            cs.setSpawnedType(EntityType.WITHER_SKELETON);
                            meta.setDisplayName(ChatColor.BLUE + "Level 21 ");
                            meta.setLore(Arrays.asList(ChatColor.DARK_PURPLE + "Generates: 20 hours per", ChatColor.DARK_PURPLE + "Storage: 1 Sapphire ", ChatColor.DARK_PURPLE + "Upgrade: 16 Sapphires"));

                        } else if (cs.getSpawnedType().equals(EntityType.WITHER_SKELETON)) {

                            cs.setSpawnedType(EntityType.ENDERMAN);
                            meta.setDisplayName(ChatColor.BLUE + "Level 22");
                            meta.setLore(Arrays.asList(ChatColor.DARK_PURPLE + "Generates: 16 hours per", ChatColor.DARK_PURPLE + "Storage: 2 Sapphires ", ChatColor.DARK_PURPLE + "Upgrade: 64 Sapphires"));

                        } else if (cs.getSpawnedType().equals(EntityType.ENDERMAN)) {

                            cs.setSpawnedType(EntityType.ELDER_GUARDIAN);
                            meta.setDisplayName(ChatColor.BLUE + "Level 23");
                            meta.setLore(Arrays.asList(ChatColor.DARK_PURPLE + "Generates: 10 hours per", ChatColor.DARK_PURPLE + "Storage: 4 Sapphires ", ChatColor.DARK_PURPLE + "Upgrade: 256 Sapphires"));

                        } else if (cs.getSpawnedType().equals(EntityType.ELDER_GUARDIAN)) {

                            cs.setSpawnedType(EntityType.WITHER);
                            meta.setDisplayName(ChatColor.BLUE + "Level 24");
                            meta.setLore(Arrays.asList(ChatColor.DARK_PURPLE + "Generates: 5 hours per", ChatColor.DARK_PURPLE + "Storage: 8 Sapphires ", ChatColor.DARK_PURPLE + "Upgrade: 2240 Sapphires"));

                        } else if (cs.getSpawnedType().equals(EntityType.WITHER)) {

                            cs.setSpawnedType(EntityType.ENDER_DRAGON);
                            meta.setDisplayName(ChatColor.BLUE + "Level 25");
                            meta.setLore(Arrays.asList(ChatColor.DARK_PURPLE + "Generates: 1 hour per", ChatColor.DARK_PURPLE + "Storage: 24 Sapphires"));

                        }

                        css.setSpawnedType(cs.getSpawnedType());
                        meta.setBlockState(css);
                        spawner_to_give.setItemMeta(meta);

                        upgrade.setItem(4, spawner_to_give);


                        ItemStack yes = Items.yes();
                        ItemStack no = Items.no();

                        yes.setAmount(1);
                        no.setAmount(1);

                        upgrade.setItem(2, yes);
                        upgrade.setItem(6, no);

                        e.getPlayer().openInventory(upgrade);


                        new BukkitRunnable() {

                            @Override
                            public void run() {

                                int x1 = e.getPlayer().getLocation().getBlockX();
                                int z1 = e.getPlayer().getLocation().getBlockZ();
                                Block barrier = e.getPlayer().getWorld().getBlockAt(x1, 0, z1);
                                Block barrier2 = e.getPlayer().getWorld().getBlockAt(x1 + 1, 0, z1);
                                Block barrier3 = e.getPlayer().getWorld().getBlockAt(x1 - 1, 0, z1);

                                //e.getPlayer().sendMessage("Active");

                                if (barrier3.getType().equals(Material.BARRIER)) {
                                    this.cancel();
                                    // e.getPlayer().sendMessage("cancelled2");
                                }

                                if (barrier2.getType().equals(Material.BARRIER)) {
                                    this.cancel();
                                    //e.getPlayer().sendMessage("cancelled");
                                }

                                if (barrier.getType().equals(Material.BARRIER)) {

                                    Bukkit.getServer().getPluginManager().callEvent(new SpawnerUpgradeEvent(e.getPlayer(), generator));
                                    this.cancel();
                                }

                            }
                        }.runTaskTimer(plugin, 0L, 1L);
                    }
                }
            }
        }
    }

    //Checks if you've clicked "yes" or "no" on the GUI asking for the upgrade.
    @EventHandler
    public void onInventoryClick(final InventoryClickEvent e) {
        if (e.getView().getTitle().equals(ChatColor.DARK_GREEN + "Upgrade Generator?")) {
            e.setCancelled(true);

            int x1 = e.getWhoClicked().getLocation().getBlockX();
            int z1 = e.getWhoClicked().getLocation().getBlockZ();

            Block barrier = e.getWhoClicked().getWorld().getBlockAt(x1, 0, z1);
            Block barrier2 = e.getWhoClicked().getWorld().getBlockAt(x1 + 1, 0, z1);
            Material mat = barrier.getType();
            Material mat2 = barrier2.getType();

            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("No")) {

                barrier2.setType(Material.BARRIER);
                e.getWhoClicked().closeInventory();

                BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
                scheduler.scheduleSyncDelayedTask(plugin, new Runnable() {

                    public void run() {
                        barrier2.setType(mat2);
                        e.getWhoClicked().closeInventory();
                    }
                }, 2);
            }

            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("Yes")) {

                barrier.setType(Material.BARRIER);
                e.getWhoClicked().closeInventory();

                BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
                scheduler.scheduleSyncDelayedTask(plugin, new Runnable() {

                    public void run() {
                        barrier.setType(mat);
                        e.getWhoClicked().closeInventory();
                    }
                }, 2);
            }
        }
    }

    //Checks if you closed the spawner upgrade inventory, if so, cancel the runnable in the background.
    @EventHandler
    public void onCloseInventory(InventoryCloseEvent e) {
        if (e.getView().getTitle().equals(ChatColor.DARK_GREEN + "Upgrade Generator?")) {

            int x1 = e.getPlayer().getLocation().getBlockX();
            int z1 = e.getPlayer().getLocation().getBlockZ();

            Block barrier3 = e.getPlayer().getWorld().getBlockAt(x1 - 1, 0, z1);
            Material mat3 = barrier3.getType();
            barrier3.setType(Material.BARRIER);

            BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
            scheduler.scheduleSyncDelayedTask(plugin, new Runnable() {

                public void run() {
                    barrier3.setType(mat3);
                    e.getPlayer().closeInventory();
                }
            }, 2);
        }
    }

    @EventHandler
    public void onSpawnerUpgrade(SpawnerUpgradeEvent e) {

        //Cost displayed in gems
        int Zombie = 6;
        int Skeleton = 8;
        int	spider	=	10	;
        int	cavespider	=	12	;
        int	blaze	=	14	;
        int	magma	=	17	;
        int	silverfish	=	20	;
        int	chicken	=	24	;
        int	pig	=	32	;
        int	sheep	=	40	;
        int	cow	=	56	;
        int	mooshroom	=	64	;
        int	horse	=	96	;
        int	llama	=	128	;
        int	ocelot	=	196	;
        int	Panda	=	336	;
        int	wolf	=	512	;
        int	pigman	=	1152	;
        int	Bat	= 2240;
        //Cost displayed in sapphires
        int	Iron_golem = 4;
        int	Wither_Skeleton = 16;
        int	Enderman = 64;
        int	Elder_guardian = 256;
        int	wither = 2240;

        int cost = 0;
        int sapphirecost = 0;

        int display_error = 1;

        ItemStack gem = Items.gems();
        ItemStack sapphire = Items.sapphire();

        CreatureSpawner cs = (CreatureSpawner) e.getSpawner().getState();
        Block generator = e.getSpawner();

        if (cs.getSpawnedType().equals(EntityType.ZOMBIE) && e.getUpgrader().getInventory().containsAtLeast(gem,Zombie)) {

            cost = Zombie;
            cs.setSpawnedType(EntityType.SKELETON);

        } else if (cs.getSpawnedType().equals(EntityType.SKELETON) && e.getUpgrader().getInventory().containsAtLeast(gem,Skeleton)) {

            cost = Skeleton;
            cs.setSpawnedType(EntityType.SPIDER);

        } else if (cs.getSpawnedType().equals(EntityType.SPIDER) && e.getUpgrader().getInventory().containsAtLeast(gem,spider)) {

            cost =(spider);
            cs.setSpawnedType(EntityType.CAVE_SPIDER);

        } else if (cs.getSpawnedType().equals(EntityType.CAVE_SPIDER) && e.getUpgrader().getInventory().containsAtLeast(gem, cavespider)) {

            cost =(cavespider);
            cs.setSpawnedType(EntityType.BLAZE);

        } else if (cs.getSpawnedType().equals(EntityType.BLAZE) && e.getUpgrader().getInventory().containsAtLeast(gem, blaze)) {

            cost =(blaze);
            cs.setSpawnedType(EntityType.MAGMA_CUBE);

        } else if (cs.getSpawnedType().equals(EntityType.MAGMA_CUBE) && e.getUpgrader().getInventory().containsAtLeast(gem, magma)) {

            cost =(magma);
            cs.setSpawnedType(EntityType.SILVERFISH);

        } else if (cs.getSpawnedType().equals(EntityType.SILVERFISH) && e.getUpgrader().getInventory().containsAtLeast(gem, silverfish)) {

            cost =(silverfish);
            cs.setSpawnedType(EntityType.CHICKEN);

        } else if (cs.getSpawnedType().equals(EntityType.CHICKEN) && e.getUpgrader().getInventory().containsAtLeast(gem, chicken)) {

            cost =(chicken);
            cs.setSpawnedType(EntityType.PIG);

        } else if (cs.getSpawnedType().equals(EntityType.PIG) && e.getUpgrader().getInventory().containsAtLeast(gem, pig)) {

            cost =(pig);
            cs.setSpawnedType(EntityType.SHEEP);

        } else if (cs.getSpawnedType().equals(EntityType.SHEEP) && e.getUpgrader().getInventory().containsAtLeast(gem, sheep)) {

            cost =(sheep);
            cs.setSpawnedType(EntityType.COW);

        } else if (cs.getSpawnedType().equals(EntityType.COW) && e.getUpgrader().getInventory().containsAtLeast(gem, cow)) {

            cost =(cow);
            cs.setSpawnedType(EntityType.MUSHROOM_COW);

        } else if (cs.getSpawnedType().equals(EntityType.MUSHROOM_COW) && e.getUpgrader().getInventory().containsAtLeast(gem, mooshroom)) {

            cost =(mooshroom);
            cs.setSpawnedType(EntityType.HORSE);

        } else if (cs.getSpawnedType().equals(EntityType.HORSE) && e.getUpgrader().getInventory().containsAtLeast(gem, horse)) {

            cost =(horse);
            cs.setSpawnedType(EntityType.LLAMA);

        } else if (cs.getSpawnedType().equals(EntityType.LLAMA) && e.getUpgrader().getInventory().containsAtLeast(gem, llama)) {

            cost =(llama);
            cs.setSpawnedType(EntityType.OCELOT);

        } else if (cs.getSpawnedType().equals(EntityType.OCELOT) && e.getUpgrader().getInventory().containsAtLeast(gem, ocelot)) {

            cost =(ocelot);
            cs.setSpawnedType(EntityType.PANDA);

        } else if (cs.getSpawnedType().equals(EntityType.PANDA) && e.getUpgrader().getInventory().containsAtLeast(gem, Panda)) {

            cost =(Panda);
            cs.setSpawnedType(EntityType.WOLF);

        } else if (cs.getSpawnedType().equals(EntityType.WOLF) && e.getUpgrader().getInventory().containsAtLeast(gem, wolf)) {

            cost =(wolf);
            cs.setSpawnedType(EntityType.PIGLIN);

        } else if (cs.getSpawnedType().equals(EntityType.PIGLIN) && e.getUpgrader().getInventory().containsAtLeast(gem, pigman)) {

            cost =(pigman);
            cs.setSpawnedType(EntityType.BAT);

        } else if (cs.getSpawnedType().equals(EntityType.BAT) && e.getUpgrader().getInventory().containsAtLeast(gem, Bat)) {

            cost =(Bat);
            cs.setSpawnedType(EntityType.IRON_GOLEM);

        } else if (cs.getSpawnedType().equals(EntityType.IRON_GOLEM) && e.getUpgrader().getInventory().containsAtLeast(sapphire, Iron_golem)) {

            sapphirecost = (Iron_golem);
            cs.setSpawnedType(EntityType.WITHER_SKELETON);

        } else if (cs.getSpawnedType().equals(EntityType.WITHER_SKELETON) && e.getUpgrader().getInventory().containsAtLeast(sapphire, Wither_Skeleton)) {

            sapphirecost = (Wither_Skeleton);
            cs.setSpawnedType(EntityType.ENDERMAN);

        } else if (cs.getSpawnedType().equals(EntityType.ENDERMAN) && e.getUpgrader().getInventory().containsAtLeast(sapphire, Enderman)) {

            sapphirecost = (Enderman);
            cs.setSpawnedType(EntityType.ELDER_GUARDIAN);

        } else if (cs.getSpawnedType().equals(EntityType.ELDER_GUARDIAN) && e.getUpgrader().getInventory().containsAtLeast(sapphire, Elder_guardian)) {

            sapphirecost = (Elder_guardian);
            cs.setSpawnedType(EntityType.WITHER);

        } else if (cs.getSpawnedType().equals(EntityType.WITHER) && e.getUpgrader().getInventory().containsAtLeast(sapphire, wither)) {

            sapphirecost = (wither);
            cs.setSpawnedType(EntityType.ENDER_DRAGON);

        }else {
            if (cs.getSpawnedType().equals(EntityType.ZOMBIE)) {
                display_error = Zombie;
            } else if (cs.getSpawnedType().equals(EntityType.SKELETON)) {
                display_error = Skeleton;
            } else if (cs.getSpawnedType().equals(EntityType.SPIDER)) {
                display_error = spider;
            } else if (cs.getSpawnedType().equals(EntityType.CAVE_SPIDER)) {
                display_error = cavespider;
            } else if (cs.getSpawnedType().equals(EntityType.BLAZE)) {
                display_error = blaze;
            } else if (cs.getSpawnedType().equals(EntityType.MAGMA_CUBE)) {
                display_error = magma;
            } else if (cs.getSpawnedType().equals(EntityType.SILVERFISH)) {
                display_error = silverfish;
            } else if (cs.getSpawnedType().equals(EntityType.CHICKEN)) {
                display_error = chicken;
            } else if (cs.getSpawnedType().equals(EntityType.PIG)) {
                display_error = pig;
            } else if (cs.getSpawnedType().equals(EntityType.SHEEP)) {
                display_error = sheep;
            } else if (cs.getSpawnedType().equals(EntityType.COW)) {
                display_error = cow;
            } else if (cs.getSpawnedType().equals(EntityType.MUSHROOM_COW)) {
                display_error = mooshroom;
            } else if (cs.getSpawnedType().equals(EntityType.HORSE)) {
                display_error = horse;
            } else if (cs.getSpawnedType().equals(EntityType.LLAMA)) {
                display_error = llama;
            } else if (cs.getSpawnedType().equals(EntityType.OCELOT)) {
                display_error = ocelot;
            } else if (cs.getSpawnedType().equals(EntityType.PANDA)) {
                display_error = Panda;
            } else if (cs.getSpawnedType().equals(EntityType.WOLF)) {
                display_error = wolf;
            } else if (cs.getSpawnedType().equals(EntityType.PIGLIN)) {
                display_error = pigman;
            } else if (cs.getSpawnedType().equals(EntityType.BAT)) {
                display_error = Bat;
            } else if (cs.getSpawnedType().equals(EntityType.IRON_GOLEM)) {
                e.getUpgrader().sendMessage(ChatColor.GRAY + "4 sapphires required");
            } else if (cs.getSpawnedType().equals(EntityType.WITHER_SKELETON)) {
                display_error = 0;
                e.getUpgrader().sendMessage(ChatColor.GRAY + "You dont have the required amount of sapphires to upgrade the spawner. ");
                e.getUpgrader().sendMessage(ChatColor.GRAY + "" + Wither_Skeleton + " sapphires required.");
            } else if (cs.getSpawnedType().equals(EntityType.ENDERMAN)) {
                display_error = 0;
                e.getUpgrader().sendMessage(ChatColor.GRAY + "You dont have the required amount of sapphires to upgrade the spawner. ");
                e.getUpgrader().sendMessage(ChatColor.GRAY + "" + Enderman + " sapphires required.");
            } else if (cs.getSpawnedType().equals(EntityType.ELDER_GUARDIAN)) {
                display_error = 0;
                e.getUpgrader().sendMessage(ChatColor.GRAY + "You dont have the required amount of sapphires to upgrade the spawner. ");
                e.getUpgrader().sendMessage(ChatColor.GRAY + "" + Elder_guardian + " sapphires required.");
            } else if (cs.getSpawnedType().equals(EntityType.WITHER)) {
                display_error = 0;
                e.getUpgrader().sendMessage(ChatColor.GRAY + "You dont have the required amount of sapphires to upgrade the spawner. ");
                e.getUpgrader().sendMessage(ChatColor.GRAY + "" + wither + " sapphires required.");
            } else if (cs.getSpawnedType().equals(EntityType.ENDER_DRAGON)) {
                display_error = 0;
                e.getUpgrader().sendMessage(ChatColor.GRAY + "...You've maxed out your spawner... Do you have a life bro?");
            } else {
                e.getUpgrader().sendMessage(ChatColor.GRAY + "Looks like you cant upgrade this spawner.");
            }

            if (display_error > 5) {
                e.getUpgrader().sendMessage(ChatColor.GRAY + "You dont have the required amount of gems to upgrade the spawner. ");
                e.getUpgrader().sendMessage(ChatColor.GRAY + "" + display_error + " gems required.");
                e.getUpgrader().getWorld().playSound(e.getUpgrader().getLocation(), Sound.ENTITY_VILLAGER_NO, 2,1);

            }
        }

        gem.setAmount(cost);
        sapphire.setAmount(sapphirecost);

        int x = e.getSpawner().getLocation().getBlockX();
        int y = e.getSpawner().getLocation().getBlockY();
        int z = e.getSpawner().getLocation().getBlockZ();
        Block sign = e.getUpgrader().getWorld().getBlockAt(x, y + 1, z);

        if (cost > 1) {

            sign.setType(Material.AIR);
            generator.setType(Material.SPAWNER);

            e.getUpgrader().getInventory().removeItem(gem);
            BlockState blockState = generator.getState();
            CreatureSpawner Mob = ((CreatureSpawner) blockState);
            Mob.setSpawnedType(cs.getSpawnedType());
            blockState.update();
            e.getUpgrader().getWorld().playSound(e.getUpgrader().getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
            e.getUpgrader().getWorld().playSound(e.getUpgrader().getLocation(), Sound.ENTITY_FIREWORK_ROCKET_TWINKLE_FAR, 1, 1);
            e.getUpgrader().getWorld().spawnParticle(Particle.FIREWORKS_SPARK,x,y,z,69);
            e.getUpgrader().sendMessage("You upgraded your generator!");

            Bukkit.getServer().getPluginManager().callEvent(new GemCollectEvent(e.getUpgrader(), generator));
        }

        if (sapphirecost > 1) {

            sign.setType(Material.AIR);
            generator.setType(Material.SPAWNER);

            e.getUpgrader().getInventory().removeItem(sapphire);
            BlockState blockState = generator.getState();
            CreatureSpawner Mob = ((CreatureSpawner) blockState);
            Mob.setSpawnedType(cs.getSpawnedType());
            blockState.update();
            e.getUpgrader().getWorld().playSound(e.getUpgrader().getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
            e.getUpgrader().getWorld().playSound(e.getUpgrader().getLocation(), Sound.ENTITY_FIREWORK_ROCKET_TWINKLE, 1, 1);
            e.getUpgrader().getWorld().spawnParticle(Particle.FIREWORKS_SPARK,x,y,z,69);
            e.getUpgrader().sendMessage("You upgraded your generator!");

            Bukkit.getServer().getPluginManager().callEvent(new GemCollectEvent(e.getUpgrader(), generator));
        }
    }
}