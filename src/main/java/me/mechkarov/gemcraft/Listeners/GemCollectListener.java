package me.mechkarov.gemcraft.Listeners;

import me.mechkarov.gemcraft.CustomEvents.GemCollectEvent;
import me.mechkarov.gemcraft.Gemcraft;
import me.mechkarov.gemcraft.Items;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.block.Sign;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.Objects;

public class GemCollectListener implements Listener {

    private Gemcraft plugin;

    public GemCollectListener(Gemcraft plugin) {
        this.plugin = plugin;
    }

    //Disabling signs being placed on the spawners generation sign.
    @EventHandler
    public void onSignPlaceEvent(BlockPlaceEvent e) {

        if ((e.getBlockPlaced().getType().equals(Material.OAK_SIGN)) || (e.getBlockPlaced().getType().equals(Material.BIRCH_SIGN)) ||
                (e.getBlockPlaced().getType().equals(Material.SPRUCE_SIGN)) || (e.getBlockPlaced().getType().equals(Material.DARK_OAK_SIGN)) ||
                (e.getBlockPlaced().getType().equals(Material.JUNGLE_SIGN)) || (e.getBlockPlaced().getType().equals(Material.WARPED_SIGN)) ||
                (e.getBlockPlaced().getType().equals(Material.CRIMSON_SIGN)) || (e.getBlockPlaced().getType().equals(Material.ACACIA_SIGN)) ||
                (e.getBlockPlaced().getType().equals(Material.OAK_WALL_SIGN)) || (e.getBlockPlaced().getType().equals(Material.BIRCH_WALL_SIGN)) ||
                (e.getBlockPlaced().getType().equals(Material.SPRUCE_WALL_SIGN)) || (e.getBlockPlaced().getType().equals(Material.DARK_OAK_WALL_SIGN)) ||
                (e.getBlockPlaced().getType().equals(Material.JUNGLE_WALL_SIGN)) || (e.getBlockPlaced().getType().equals(Material.WARPED_WALL_SIGN)) ||
                (e.getBlockPlaced().getType().equals(Material.CRIMSON_WALL_SIGN)) || (e.getBlockPlaced().getType().equals(Material.ACACIA_WALL_SIGN))) {

            int x = e.getBlockPlaced().getLocation().getBlockX();
            int y = e.getBlockPlaced().getLocation().getBlockY();
            int z = e.getBlockPlaced().getLocation().getBlockZ();

            Block generator = e.getPlayer().getWorld().getBlockAt(x, y - 1, z);
            Block generator2 = e.getPlayer().getWorld().getBlockAt(x, y - 1, z - 1);
            Block generator3 = e.getPlayer().getWorld().getBlockAt(x, y - 1, z + 1);
            Block generator4 = e.getPlayer().getWorld().getBlockAt(x - 1, y - 1, z);
            Block generator5 = e.getPlayer().getWorld().getBlockAt(x + 1, y - 1, z);

            Block sign = e.getPlayer().getWorld().getBlockAt(x, y - 2, z);
            Block sign2 = e.getPlayer().getWorld().getBlockAt(x, y, z - 1);
            Block sign3 = e.getPlayer().getWorld().getBlockAt(x, y, z + 1);
            Block sign4 = e.getPlayer().getWorld().getBlockAt(x - 1, y, z);
            Block sign5 = e.getPlayer().getWorld().getBlockAt(x + 1, y, z);

            if (generator.getType().equals(Material.SPAWNER)) {
                e.setCancelled(true);
            }
            if ((generator.getType().equals(Material.OAK_SIGN)) && (sign.getType().equals(Material.SPAWNER))) {
                e.setCancelled(true);
            }
            if ((sign2.getType().equals(Material.OAK_SIGN)) && (generator2.getType().equals(Material.SPAWNER))) {
                e.setCancelled(true);
            }
            if ((sign3.getType().equals(Material.OAK_SIGN)) && (generator3.getType().equals(Material.SPAWNER))) {
                e.setCancelled(true);
            }
            if ((sign4.getType().equals(Material.OAK_SIGN)) && (generator4.getType().equals(Material.SPAWNER))) {
                e.setCancelled(true);
            }
            if ((sign5.getType().equals(Material.OAK_SIGN)) && (generator5.getType().equals(Material.SPAWNER))) {
                e.setCancelled(true);
            }
        }
    }

    //Checks the amount of gems that had been generated, gives you that many gems and resets to 0
    @EventHandler
    public void onSignClickEvent(PlayerInteractEvent e) {

        if (e.getAction().equals(Action.LEFT_CLICK_BLOCK)) {

            Block sign = e.getClickedBlock();

            int x = sign.getLocation().getBlockX();
            int y = sign.getLocation().getBlockY();
            int z = sign.getLocation().getBlockZ();
            Block generator = e.getPlayer().getWorld().getBlockAt(x, y - 1, z);

            CreatureSpawner cs = (CreatureSpawner) generator.getState();

            if (sign.getState() instanceof Sign) {

                if (generator.getType().equals(Material.SPAWNER)) {

                    Sign sign1 = (Sign) e.getClickedBlock().getState();
                    String Line2 = sign1.getLine(2);
                    Character[] ch = new Character[Line2.length()];

                    int j = 0;
                    String num = new String();

                    for (int i = 2; i < Line2.length(); i++) {
                        if (Line2.charAt(i) == '/') {
                            break;
                        }
                        ch[j] = Line2.charAt(i);
                        num = num.concat(String.valueOf(ch[j]));
                        j++;
                    }

                    ItemStack gem = Items.gems();
                    gem.setAmount(Integer.parseInt(num));

                    ItemStack sapphire = Items.sapphire();
                    sapphire.setAmount(Integer.parseInt(num));


                    if (cs.getSpawnedType().equals(EntityType.ZOMBIE) || cs.getSpawnedType().equals(EntityType.SKELETON) || cs.getSpawnedType().equals(EntityType.SPIDER)
                            || cs.getSpawnedType().equals(EntityType.CAVE_SPIDER) || cs.getSpawnedType().equals(EntityType.BLAZE) || cs.getSpawnedType().equals(EntityType.MAGMA_CUBE)
                            || cs.getSpawnedType().equals(EntityType.SILVERFISH) || cs.getSpawnedType().equals(EntityType.CHICKEN) || cs.getSpawnedType().equals(EntityType.PIG)
                            || cs.getSpawnedType().equals(EntityType.SHEEP) || cs.getSpawnedType().equals(EntityType.COW) || cs.getSpawnedType().equals(EntityType.MUSHROOM_COW)
                            || cs.getSpawnedType().equals(EntityType.HORSE) || cs.getSpawnedType().equals(EntityType.LLAMA) || cs.getSpawnedType().equals(EntityType.OCELOT)
                            || cs.getSpawnedType().equals(EntityType.PANDA) || cs.getSpawnedType().equals(EntityType.WOLF) || cs.getSpawnedType().equals(EntityType.PIGLIN)
                            || cs.getSpawnedType().equals(EntityType.BAT) || cs.getSpawnedType().equals(EntityType.IRON_GOLEM)) {

                        if (Objects.requireNonNull(e.getPlayer().getInventory().firstEmpty() == -1)) {
                            e.getPlayer().getWorld().dropItemNaturally(e.getPlayer().getLocation(), gem);
                        } else {
                            e.getPlayer().getInventory().addItem(gem);
                        }
                        e.getPlayer().sendMessage("You collected " + Integer.parseInt(num) + " gems!");
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2, 1);
                    }

                    if (cs.getSpawnedType().equals(EntityType.WITHER_SKELETON) || cs.getSpawnedType().equals(EntityType.ENDERMAN) || cs.getSpawnedType().equals(EntityType.ELDER_GUARDIAN)
                            || cs.getSpawnedType().equals(EntityType.WITHER) || cs.getSpawnedType().equals(EntityType.ENDER_DRAGON)) {

                        if (Objects.requireNonNull(e.getPlayer().getInventory().firstEmpty() == -1)) {
                            e.getPlayer().getWorld().dropItemNaturally(e.getPlayer().getLocation(), sapphire);
                        } else {
                            e.getPlayer().getInventory().addItem(sapphire);
                        }
                        e.getPlayer().sendMessage("You collected " + Integer.parseInt(num) + " sapphires!");
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2, 1);
                    }

                    BlockState blockState = generator.getState();
                    CreatureSpawner Mob = ((CreatureSpawner) blockState);

                    sign.setType(Material.AIR);
                    generator.setType(Material.AIR);

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
                    }

                    BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
                    scheduler.scheduleSyncDelayedTask(plugin, new Runnable() {

                        public void run() {

                            generator.setType(Material.SPAWNER);
                            Mob.setSpawnedType(cs.getSpawnedType());
                            blockState.update();

                            Bukkit.getServer().getPluginManager().callEvent(new GemCollectEvent(e.getPlayer(), generator));
                        }
                    }, 1);

                }
            }
        }
    }

    @EventHandler
    public void onGemCollectEvent(GemCollectEvent e) {

        Block block = e.getGenerator();
        CreatureSpawner cs = (CreatureSpawner) block.getState();

        int x = block.getLocation().getBlockX();
        int y = block.getLocation().getBlockY();
        int z = block.getLocation().getBlockZ();

        Block generator = e.getCollector().getWorld().getBlockAt(x, y, z);
        Block above = e.getCollector().getWorld().getBlockAt(x, y + 1, z);
        above.setType(Material.OAK_SIGN, false);

        Sign sign = (Sign) e.getCollector().getWorld().getBlockAt(x, y + 1, z).getState();
        sign.update(true, false);

        //Adjust what level to display
        int LevelZombie = 1;
        int LevelSkeleton = 2;
        int LevelSpider = 3;
        int LevelCaveSpider = 4;
        int LevelBlaze = 5;
        int LevelMagma = 6;
        int LevelSilverfish = 7;
        int LevelChicken = 8;
        int LevelPig = 9;
        int LevelSheep = 10;
        int LevelCow = 11;
        int LevelMooshroom = 12;
        int LevelHorse = 13;
        int LevelLlama = 14;
        int LevelOcelot = 15;
        int LevelPanda = 16;
        int LevelWolf = 17;
        int LevelPigman = 18;
        int LevelBat = 19;
        int LevelIron_Golem = 20;
        int LevelWither_Skeleton = 21;
        int LevelEnderman = 22;
        int LevelElder_Guardian = 23;
        int LevelWither = 24;
        int LevelEnder_Dragon = 25;

        int MobLevel = 0;

        //Adjust delay before a new gem is generated. (20 ticks = 1 second)
        int DelayZombie = 24000;
        int DelaySkeleton = 24000;
        int DelaySpider = 21600;
        int DelayCaveSpider = 21600;
        int DelayBlaze = 18000;
        int DelayMagma = 18000;
        int DelaySilverfish = 14400;
        int DelayChicken = 14400;
        int DelayPig = 12000;
        int DelaySheep = 12000;
        int DelayCow = 9600;
        int DelayMooshroom = 9600;
        int DelayHorse = 8400;
        int DelayLlama = 7200;
        int DelayOcelot = 6000;
        int DelayPanda = 4800;
        int DelayWolf = 3600;
        int DelayPigman = 2400;
        int DelayBat = 1200;
        int DelayIron_Golem = 900;
        int DelayWither_Skeleton = 1440000;
        int DelayEnderman = 1152000;
        int DelayElder_Guardian = 720000;
        int DelayWither = 360000;
        int DelayEnder_Dragon = 72000;

        int MobDelay = 0;

        //Adjust how much gems the generator can hold
        int StorageZombie = 6;
        int StorageSkeleton = 9;
        int StorageSpider = 9;
        int StorageCaveSpider = 15;
        int StorageBlaze = 15;
        int StorageMagma = 27;
        int StorageSilverfish = 27;
        int StorageChicken = 36;
        int StoragePig = 36;
        int StorageSheep = 48;
        int StorageCow = 48;
        int StorageMooshroom = 54;
        int StorageHorse = 54;
        int StorageLlama = 72;
        int StorageOcelot = 72;
        int StoragePanda = 84;
        int StorageWolf = 96;
        int StoragePigman = 128;
        int StorageBat = 160;
        int StorageIron_Golem = 192;
        int StorageWither_Skeleton = 1;
        int StorageEnderman = 2;
        int StorageElder_Guardian = 4;
        int StorageWither = 8;
        int StorageEnder_Dragon = 24;

        int MobStorage = 0;

        //Adjust which type of gem the spawner generates
        String GemTypeZombie = ChatColor.GREEN + "Gems";
        String GemTypeSkeleton = ChatColor.GREEN + "Gems";
        String GemTypeSpider = ChatColor.GREEN + "Gems";
        String GemTypeCaveSpider = ChatColor.GREEN + "Gems";
        String GemTypeBlaze = ChatColor.GREEN + "Gems";
        String GemTypeMagma = ChatColor.GREEN + "Gems";
        String GemTypeSilverfish = ChatColor.GREEN + "Gems";
        String GemTypeChicken = ChatColor.GREEN + "Gems";
        String GemTypePig = ChatColor.GREEN + "Gems";
        String GemTypeSheep = ChatColor.GREEN + "Gems";
        String GemTypeCow = ChatColor.GREEN + "Gems";
        String GemTypeMooshroom = ChatColor.GREEN + "Gems";
        String GemTypeHorse = ChatColor.GREEN + "Gems";
        String GemTypeLlama = ChatColor.GREEN + "Gems";
        String GemTypeOcelot = ChatColor.GREEN + "Gems";
        String GemTypePanda = ChatColor.GREEN + "Gems";
        String GemTypeWolf = ChatColor.GREEN + "Gems";
        String GemTypePigman = ChatColor.GREEN + "Gems";
        String GemTypeBat = ChatColor.GREEN + "Gems";
        String GemTypeIron_Golem = ChatColor.GREEN + "Gems";
        String GemTypeWither_Skeleton = ChatColor.DARK_BLUE + "Sapphires";
        String GemTypeEnderman = ChatColor.DARK_BLUE + "Sapphires";
        String GemTypeElder_Guardian = ChatColor.DARK_BLUE + "Sapphires";
        String GemTypeWither = ChatColor.DARK_BLUE + "Sapphires";
        String GemTypeEnder_Dragon = ChatColor.DARK_BLUE + "Sapphires";

        String GemType = "";

        //Adjust what color should the "Level ?" display
        ChatColor MobColorZombie = ChatColor.DARK_GREEN;
        ChatColor MobColorSkeleton = ChatColor.DARK_GREEN;
        ChatColor MobColorSpider = ChatColor.DARK_GREEN;
        ChatColor MobColorCaveSpider = ChatColor.DARK_GREEN;
        ChatColor MobColorBlaze = ChatColor.DARK_GREEN;
        ChatColor MobColorMagma = ChatColor.YELLOW;
        ChatColor MobColorSilverfish = ChatColor.YELLOW;
        ChatColor MobColorChicken = ChatColor.YELLOW;
        ChatColor MobColorPig = ChatColor.YELLOW;
        ChatColor MobColorSheep = ChatColor.YELLOW;
        ChatColor MobColorCow = ChatColor.AQUA;
        ChatColor MobColorMooshroom = ChatColor.AQUA;
        ChatColor MobColorHorse = ChatColor.AQUA;
        ChatColor MobColorLlama = ChatColor.AQUA;
        ChatColor MobColorOcelot = ChatColor.AQUA;
        ChatColor MobColorPanda = ChatColor.DARK_RED;
        ChatColor MobColorWolf = ChatColor.DARK_RED;
        ChatColor MobColorPigman = ChatColor.DARK_RED;
        ChatColor MobColorBat = ChatColor.DARK_RED;
        ChatColor MobColorIron_Golem = ChatColor.DARK_RED;
        ChatColor MobColorWither_Skeleton = ChatColor.BLUE;
        ChatColor MobColorEnderman = ChatColor.BLUE;
        ChatColor MobColorElder_Guardian = ChatColor.BLUE;
        ChatColor MobColorWither = ChatColor.BLUE;
        ChatColor MobColorEnder_Dragon = ChatColor.BLUE;

        ChatColor MobColor = ChatColor.WHITE;


        if (cs.getSpawnedType().equals(EntityType.ZOMBIE)) {

            cs.setSpawnedType(EntityType.ZOMBIE);
            MobDelay = DelayZombie;
            MobColor = MobColorZombie;
            MobLevel = LevelZombie;
            MobStorage = StorageZombie;
            GemType = GemTypeZombie;

        } else if (cs.getSpawnedType().equals(EntityType.SKELETON)) {

            cs.setSpawnedType(EntityType.SKELETON);
            MobDelay = DelaySkeleton;
            MobColor = MobColorSkeleton;
            MobLevel = LevelSkeleton;
            MobStorage = StorageSkeleton;
            GemType = GemTypeSkeleton;

        } else if (cs.getSpawnedType().equals(EntityType.SPIDER)) {

            cs.setSpawnedType(EntityType.SPIDER);
            MobDelay = DelaySpider;
            MobColor = MobColorSpider;
            MobLevel = LevelSpider;
            MobStorage = StorageSpider;
            GemType = GemTypeSpider;

        } else if (cs.getSpawnedType().equals(EntityType.CAVE_SPIDER)) {

            cs.setSpawnedType(EntityType.CAVE_SPIDER);
            MobDelay = DelayCaveSpider;
            MobColor = MobColorCaveSpider;
            MobLevel = LevelCaveSpider;
            MobStorage = StorageCaveSpider;
            GemType = GemTypeCaveSpider;

        } else if (cs.getSpawnedType().equals(EntityType.BLAZE)) {

            cs.setSpawnedType(EntityType.BLAZE);
            MobDelay = DelayBlaze;
            MobColor = MobColorBlaze;
            MobLevel = LevelBlaze;
            MobStorage = StorageBlaze;
            GemType = GemTypeBlaze;

        } else if (cs.getSpawnedType().equals(EntityType.MAGMA_CUBE)) {

            cs.setSpawnedType(EntityType.MAGMA_CUBE);
            MobDelay = DelayMagma;
            MobColor = MobColorMagma;
            MobLevel = LevelMagma;
            MobStorage = StorageMagma;
            GemType = GemTypeMagma;

        } else if (cs.getSpawnedType().equals(EntityType.SILVERFISH)) {

            cs.setSpawnedType(EntityType.SILVERFISH);
            MobDelay = DelaySilverfish;
            MobColor = MobColorSilverfish;
            MobLevel = LevelSilverfish;
            MobStorage = StorageSilverfish;
            GemType = GemTypeSilverfish;

        } else if (cs.getSpawnedType().equals(EntityType.CHICKEN)) {

            cs.setSpawnedType(EntityType.CHICKEN);
            MobDelay = DelayChicken;
            MobColor = MobColorChicken;
            MobLevel = LevelChicken;
            MobStorage = StorageChicken;
            GemType = GemTypeChicken;

        } else if (cs.getSpawnedType().equals(EntityType.PIG)) {

            cs.setSpawnedType(EntityType.PIG);
            MobDelay = DelayPig;
            MobColor = MobColorPig;
            MobLevel = LevelPig;
            MobStorage = StoragePig;
            GemType = GemTypePig;

        } else if (cs.getSpawnedType().equals(EntityType.SHEEP)) {

            cs.setSpawnedType(EntityType.SHEEP);
            MobDelay = DelaySheep;
            MobColor = MobColorSheep;
            MobLevel = LevelSheep;
            MobStorage = StorageSheep;
            GemType = GemTypeSheep;

        } else if (cs.getSpawnedType().equals(EntityType.COW)) {

            cs.setSpawnedType(EntityType.COW);
            MobDelay = DelayCow;
            MobColor = MobColorCow;
            MobLevel = LevelCow;
            MobStorage = StorageCow;
            GemType = GemTypeCow;

        } else if (cs.getSpawnedType().equals(EntityType.MUSHROOM_COW)) {

            cs.setSpawnedType(EntityType.MUSHROOM_COW);
            MobDelay = DelayMooshroom;
            MobColor = MobColorMooshroom;
            MobLevel = LevelMooshroom;
            MobStorage = StorageMooshroom;
            GemType = GemTypeMooshroom;

        } else if (cs.getSpawnedType().equals(EntityType.HORSE)) {

            cs.setSpawnedType(EntityType.HORSE);
            MobDelay = DelayHorse;
            MobColor = MobColorHorse;
            MobLevel = LevelHorse;
            MobStorage = StorageHorse;
            GemType = GemTypeHorse;

        } else if (cs.getSpawnedType().equals(EntityType.LLAMA)) {

            cs.setSpawnedType(EntityType.LLAMA);
            MobDelay = DelayLlama;
            MobColor = MobColorLlama;
            MobLevel = LevelLlama;
            MobStorage = StorageLlama;
            GemType = GemTypeLlama;

        } else if (cs.getSpawnedType().equals(EntityType.OCELOT)) {

            cs.setSpawnedType(EntityType.OCELOT);
            MobDelay = DelayOcelot;
            MobColor = MobColorOcelot;
            MobLevel = LevelOcelot;
            MobStorage = StorageOcelot;
            GemType = GemTypeOcelot;

        } else if (cs.getSpawnedType().equals(EntityType.PANDA)) {

            cs.setSpawnedType(EntityType.PANDA);
            MobDelay = DelayPanda;
            MobColor = MobColorPanda;
            MobLevel = LevelPanda;
            MobStorage = StoragePanda;
            GemType = GemTypePanda;

        } else if (cs.getSpawnedType().equals(EntityType.WOLF)) {

            cs.setSpawnedType(EntityType.WOLF);
            MobDelay = DelayWolf;
            MobColor = MobColorWolf;
            MobLevel = LevelWolf;
            MobStorage = StorageWolf;
            GemType = GemTypeWolf;

        } else if (cs.getSpawnedType().equals(EntityType.PIGLIN)) {

            cs.setSpawnedType(EntityType.PIGLIN);
            MobDelay = DelayPigman;
            MobColor = MobColorPigman;
            MobLevel = LevelPigman;
            MobStorage = StoragePigman;
            GemType = GemTypePigman;

        } else if (cs.getSpawnedType().equals(EntityType.BAT)) {

            cs.setSpawnedType(EntityType.BAT);
            MobDelay = DelayBat;
            MobColor = MobColorBat;
            MobLevel = LevelBat;
            MobStorage = StorageBat;
            GemType = GemTypeBat;

        } else if (cs.getSpawnedType().equals(EntityType.IRON_GOLEM)) {

            cs.setSpawnedType(EntityType.IRON_GOLEM);
            MobDelay = DelayIron_Golem;
            MobColor = MobColorIron_Golem;
            MobLevel = LevelIron_Golem;
            MobStorage = StorageIron_Golem;
            GemType = GemTypeIron_Golem;

        } else if (cs.getSpawnedType().equals(EntityType.WITHER_SKELETON)) {

            cs.setSpawnedType(EntityType.WITHER_SKELETON);
            MobDelay = DelayWither_Skeleton;
            MobColor = MobColorWither_Skeleton;
            MobLevel = LevelWither_Skeleton;
            MobStorage = StorageWither_Skeleton;
            GemType = GemTypeWither_Skeleton;

        } else if (cs.getSpawnedType().equals(EntityType.ENDERMAN)) {

            cs.setSpawnedType(EntityType.ENDERMAN);
            MobDelay = DelayEnderman;
            MobColor = MobColorEnderman;
            MobLevel = LevelEnderman;
            MobStorage = StorageEnderman;
            GemType = GemTypeEnderman;

        } else if (cs.getSpawnedType().equals(EntityType.ELDER_GUARDIAN)) {

            cs.setSpawnedType(EntityType.ELDER_GUARDIAN);
            MobDelay = DelayElder_Guardian;
            MobColor = MobColorElder_Guardian;
            MobLevel = LevelElder_Guardian;
            MobStorage = StorageElder_Guardian;
            GemType = GemTypeElder_Guardian;

        } else if (cs.getSpawnedType().equals(EntityType.WITHER)) {

            cs.setSpawnedType(EntityType.WITHER);
            MobDelay = DelayWither;
            MobColor = MobColorWither;
            MobLevel = LevelWither;
            MobStorage = StorageWither;
            GemType = GemTypeWither;

        } else if (cs.getSpawnedType().equals(EntityType.ENDER_DRAGON)) {

            cs.setSpawnedType(EntityType.ENDER_DRAGON);
            MobDelay = DelayEnder_Dragon;
            MobColor = MobColorEnder_Dragon;
            MobLevel = LevelEnder_Dragon;
            MobStorage = StorageEnder_Dragon;
            GemType = GemTypeEnder_Dragon;
        }

        int finalMobLevel = MobLevel;
        int finalMobDelay = MobDelay;
        int finalMobStorage = MobStorage;

        int finalMobConstant = finalMobDelay * finalMobStorage;

        ChatColor finalMobColor = MobColor;
        String finalGemType = GemType;

        new BukkitRunnable() {
            int total = 0;
            int tick = 0;
            int a = 0;

            @Override
            public void run() {

                if (!(generator.getType().equals(Material.SPAWNER))) {
                    this.cancel();
                }

                CreatureSpawner gen = (CreatureSpawner) e.getCollector().getWorld().getBlockAt(x, y, z).getState();

                if (!(gen.getSpawnedType().equals(cs.getSpawnedType()))) {
                    total = -1;
                }

                if (a == 0 || a == finalMobDelay) {

                    if (total >= 0 && total <= finalMobStorage) {

                        sign.setEditable(true);
                        sign.setLine(1, finalMobColor + "Level " + finalMobLevel);
                        sign.setLine(2, ChatColor.GREEN + (total + "/" + finalMobStorage + " " + finalGemType));
                        sign.setLine(3, ChatColor.YELLOW + "L:Take R:Upgrade");
                        sign.update(true);

                        total++;
                        a = 0;
                    }
                }

                if (tick == finalMobConstant) {
                    tick = 0;
                    this.cancel();
                }
                if (total == -1) {
                    total = 0;
                    this.cancel();
                }

                tick++;
                a = a + 1;
            }
        }.runTaskTimer(plugin, 0L, 1L);
    }
}

