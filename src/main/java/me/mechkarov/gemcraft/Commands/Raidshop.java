package me.mechkarov.gemcraft.Commands;

import me.mechkarov.gemcraft.Gemcraft;
import me.mechkarov.gemcraft.Items;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Objects;

import static me.mechkarov.gemcraft.Items.*;

public class Raidshop implements CommandExecutor, Listener {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        {


            if (commandSender instanceof Player) {

                //creates the instance of the player
                Player player = (Player) commandSender;


//creates the instance of the inventories to be opened
                //shop
                Inventory raidshop = Bukkit.createInventory(player, 27, "Raid Shop");

                //creates the top of the glass border for the shop inventory

                /* for (int n = 6; n <= 9; n++) {
                    shop.setItem(n, border);
                }*/


                /*ItemStack spawner_to_give = new ItemStack(Material.SPAWNER);
                BlockStateMeta meta = (BlockStateMeta) spawner_to_give.getItemMeta();
                assert meta != null;
                CreatureSpawner css = (CreatureSpawner) meta.getBlockState();

                meta.setDisplayName(ChatColor.GREEN + "Level 1");
                meta.setLore(Arrays.asList(ChatColor.GOLD + "Generates: 30 minutes Per" , ChatColor.GOLD + "Storage: 6 Gems" ,  ChatColor.GOLD + "Upgrade: 6 Gems"));

                css.setSpawnedType(EntityType.ZOMBIE);
                meta.setBlockState(css);
                spawner_to_give.setItemMeta(meta);*/

                ItemStack spawner = Items.spawner();
                ItemStack shopspawner = Items.shopspawner();
                ItemStack border = Items.border();
                ItemStack gem = Items.gems();
                ItemStack sapphire = Items.sapphire();
                ItemStack warp = Items.warp();
                ItemStack shopwarp = Items.shopwarp();
                ItemStack ram = ram();
                ItemStack shopram = shopram();
                ItemStack placer = Items.placer();
                ItemStack shopplacer = Items.shopplacer();
                ItemStack lockpick = Items.lockpick();
                ItemStack lockpick2 = Items.lockpick2();
                ItemStack lockpick3 = Items.lockpick3();
                ItemStack shoplockpick = Items.shoplockpick();
                ItemStack shoplockpick2 = Items.shoplockpick2();
                ItemStack shoplockpick3 = Items.shoplockpick3();
                ItemStack breaker = Items.breaker();
                ItemStack breaker2 = Items.breaker2();
                ItemStack breaker3 = Items.breaker3();
                ItemStack breaker4 = Items.breaker4();
                ItemStack shopbreaker = Items.shopbreaker();
                ItemStack shopbreaker2 = Items.shopbreaker2();
                ItemStack shopbreaker3 = Items.shopbreaker3();
                ItemStack shopbreaker4 = Items.shopbreaker4();
                ItemStack harvester = Items.harvester();
                ItemStack harvester2 = Items.harvester2();
                ItemStack harvester3 = Items.harvester3();
                ItemStack harvester4 = Items.harvester4();
                ItemStack harvester5 = Items.harvester5();
                ItemStack harvester6 = Items.harvester6();
                ItemStack shopharvester = Items.shopharvester();
                ItemStack shopharvester2 = Items.shopharvester2();
                ItemStack shopharvester3 = Items.shopharvester3();
                ItemStack shopharvester4 = Items.shopharvester4();
                ItemStack shopharvester5 = Items.shopharvester5();
                ItemStack shopharvester6 = Items.shopharvester6();

                border.setAmount(1);
                gem.setAmount(64);
                sapphire.setAmount(64);
                warp.setAmount(1);
                shopwarp.setAmount(1);
                ram.setAmount(1);
                placer.setAmount(1);
                lockpick.setAmount(1);
                lockpick2.setAmount(1);
                lockpick3.setAmount(1);
                breaker.setAmount(1);
                breaker2.setAmount(1);
                breaker3.setAmount(1);
                breaker4.setAmount(1);
                harvester.setAmount(1);
                harvester2.setAmount(1);
                harvester3.setAmount(1);
                harvester4.setAmount(1);
                harvester5.setAmount(1);
                harvester6.setAmount(1);

                raidshop.setItem(0, shopplacer);

                raidshop.setItem(1, border);
                raidshop.setItem(7, border);
                raidshop.setItem(9, border);
                raidshop.setItem(10, border);
                raidshop.setItem(11, border);
                raidshop.setItem(15, border);
                raidshop.setItem(16, border);
                raidshop.setItem(17, border);
                raidshop.setItem(19, border);
                raidshop.setItem(25, border);

                raidshop.setItem(18, shopwarp);
                raidshop.setItem(26, shopsapphire());
                raidshop.setItem(20, shopram);
                raidshop.setItem(21, shopbreaker4);
                raidshop.setItem(22, shopbreaker3);
                raidshop.setItem(23, shopbreaker2);
                raidshop.setItem(24, shopbreaker);
                raidshop.setItem(14, shoplockpick);
                raidshop.setItem(13, shoplockpick2);
                raidshop.setItem(12, shoplockpick3);
                raidshop.setItem(2, shopharvester);
                raidshop.setItem(3, shopharvester2);
                raidshop.setItem(4, shopharvester3);
                raidshop.setItem(5, shopharvester4);
                raidshop.setItem(6, shopharvester5);
                raidshop.setItem(8, shopharvester6);



                /*adds the created items in the shop inventory

                 */

//creates the bottom of the glass border for the shop inventory

                /*for (int n = 23; n <= 26; n++) {
                    shop.setItem(n, border);
                }*/

//key shop creation


                //opens inv once set up is complete
                player.openInventory(raidshop);


            } else {
                System.out.println("You must be a player to execute this command.");
            }

            return true;
        }

    }

    @EventHandler
    public void onInventoryClick(final InventoryClickEvent e) {
        if (e.getView().getTitle().equals("Raid Shop")) {
            e.setCancelled(true);

            ItemMeta meta = Items.shopram().getItemMeta();
            ItemMeta meta2 = Items.shopwarp().getItemMeta();
            ItemMeta meta3 = Items.shopsapphire().getItemMeta();
            ItemMeta meta4 = Items.shopplacer().getItemMeta();
            ItemMeta meta5 = Items.shopbreaker().getItemMeta();
            ItemMeta meta6 = Items.shopbreaker2().getItemMeta();
            ItemMeta meta7 = Items.shopbreaker3().getItemMeta();
            ItemMeta meta8 = Items.shopbreaker4().getItemMeta();
            ItemMeta meta9 = Items.shoplockpick().getItemMeta();
            ItemMeta meta10 = Items.shoplockpick2().getItemMeta();
            ItemMeta meta11 = Items.shoplockpick3().getItemMeta();
            ItemMeta meta12 = Items.shopharvester().getItemMeta();
            ItemMeta meta13 = Items.shopharvester2().getItemMeta();
            ItemMeta meta14 = Items.shopharvester3().getItemMeta();
            ItemMeta meta15 = Items.shopharvester4().getItemMeta();
            ItemMeta meta16 = Items.shopharvester5().getItemMeta();
            ItemMeta meta17 = Items.shopharvester6().getItemMeta();

            //RAM
            if (e.getCurrentItem().getItemMeta().equals(meta)) {
                if (e.getWhoClicked().getInventory().containsAtLeast(Items.gems(), 8)) {
                    ItemStack gem = Items.gems();
                    gem.setAmount(8);
                    if(Objects.requireNonNull(e.getWhoClicked()).getInventory().firstEmpty() == -1){

                        e.getWhoClicked().getWorld().dropItemNaturally(e.getWhoClicked().getLocation(),ram());

                    }else{
                        e.getWhoClicked().getInventory().addItem(ram());
                    }
                    e.getWhoClicked().getInventory().removeItem(gem);
                    e.getWhoClicked().getWorld().playSound(e.getWhoClicked().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2, 2);
                } else {
                    e.getWhoClicked().sendMessage("Insufficient gem balance");
                    e.getWhoClicked().getWorld().playSound(e.getWhoClicked().getLocation(), Sound.ENTITY_VILLAGER_NO, 2,1);
                }
            }
            /*//Buying a spawner
            else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Level 1 (Cost: $69)")) {

                Economy eco = Gemcraft.getEconomy();

                if (eco.getBalance((OfflinePlayer) e.getWhoClicked())>=69) {

                    if (Objects.requireNonNull(e.getWhoClicked()).getInventory().firstEmpty() == -1) {

                        e.getWhoClicked().getWorld().dropItemNaturally(e.getWhoClicked().getLocation(), spawner());
                        EconomyResponse response = eco.withdrawPlayer((OfflinePlayer) e.getWhoClicked(), 69);
                        e.getWhoClicked().sendMessage(ChatColor.RED + eco.format(response.amount) + " was taken from your balance.");

                    } else {
                        e.getWhoClicked().getInventory().addItem(spawner());
                        EconomyResponse response = eco.withdrawPlayer((OfflinePlayer) e.getWhoClicked(), 69);
                        e.getWhoClicked().sendMessage(ChatColor.RED + eco.format(response.amount) + " was taken from your balance.");
                    }

                    e.getWhoClicked().getWorld().playSound(e.getWhoClicked().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2, 2);

                } else {
                    e.getWhoClicked().sendMessage("Insufficient balance");
                    e.getWhoClicked().getWorld().playSound(e.getWhoClicked().getLocation(), Sound.ENTITY_VILLAGER_NO, 2, 1);
                }
            }*/
            //Sapphire
            else if (e.getCurrentItem().getItemMeta().equals(meta3)) {
                if (e.getWhoClicked().getInventory().containsAtLeast(Items.gems(), 2240)) {
                    ItemStack gem = Items.gems();
                    gem.setAmount(2240);
                    if (Objects.requireNonNull(e.getWhoClicked()).getInventory().firstEmpty() == -1) {

                        e.getWhoClicked().getWorld().dropItemNaturally(e.getWhoClicked().getLocation(), sapphire());

                    } else {

                        e.getWhoClicked().getInventory().addItem(sapphire());
                    }
                    e.getWhoClicked().getInventory().removeItem(gem);
                    e.getWhoClicked().getWorld().playSound(e.getWhoClicked().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2, 2);
                } else {
                    e.getWhoClicked().sendMessage("Insufficient gem balance");
                    e.getWhoClicked().getWorld().playSound(e.getWhoClicked().getLocation(), Sound.ENTITY_VILLAGER_NO, 2, 1);
                }
            }
            //WarpSign
            else if (e.getCurrentItem().getItemMeta().equals(meta2)) {
                if (e.getWhoClicked().getInventory().containsAtLeast(Items.gems(), 100)) {
                    ItemStack gem = Items.gems();
                    gem.setAmount(100);
                    if (Objects.requireNonNull(e.getWhoClicked()).getInventory().firstEmpty() == -1) {

                        e.getWhoClicked().getWorld().dropItemNaturally(e.getWhoClicked().getLocation(), warp());

                    } else {

                        e.getWhoClicked().getInventory().addItem(warp());
                    }
                    e.getWhoClicked().getInventory().removeItem(gem);
                    e.getWhoClicked().getWorld().playSound(e.getWhoClicked().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2, 2);
                } else {
                    e.getWhoClicked().sendMessage("Insufficient gem balance");
                    e.getWhoClicked().getWorld().playSound(e.getWhoClicked().getLocation(), Sound.ENTITY_VILLAGER_NO, 2, 1);
                }
            }
            //Block Placer
            else if (e.getCurrentItem().getItemMeta().equals(meta4)) {
                if (e.getWhoClicked().getInventory().containsAtLeast(Items.gems(), 8)) {
                    ItemStack gem = Items.gems();
                    gem.setAmount(8);
                    if (Objects.requireNonNull(e.getWhoClicked()).getInventory().firstEmpty() == -1) {

                        e.getWhoClicked().getWorld().dropItemNaturally(e.getWhoClicked().getLocation(), placer());

                    } else {

                        e.getWhoClicked().getInventory().addItem(placer());
                    }
                    e.getWhoClicked().getInventory().removeItem(gem);
                    e.getWhoClicked().getWorld().playSound(e.getWhoClicked().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2, 2);
                } else {
                    e.getWhoClicked().sendMessage("Insufficient gem balance");
                    e.getWhoClicked().getWorld().playSound(e.getWhoClicked().getLocation(), Sound.ENTITY_VILLAGER_NO, 2, 1);
                }
            }
            //Harvester
            else if (e.getCurrentItem().getItemMeta().equals(meta12)) {
                if (e.getWhoClicked().getInventory().containsAtLeast(Items.gems(), 6)) {
                    ItemStack gem = Items.gems();
                    gem.setAmount(6);
                    if(Objects.requireNonNull(e.getWhoClicked()).getInventory().firstEmpty() == -1){

                        e.getWhoClicked().getWorld().dropItemNaturally(e.getWhoClicked().getLocation(),harvester());

                    }else{

                        e.getWhoClicked().getInventory().addItem(harvester());
                    }
                    e.getWhoClicked().getInventory().removeItem(gem);
                    e.getWhoClicked().getWorld().playSound(e.getWhoClicked().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2, 2);
                } else {
                    e.getWhoClicked().sendMessage("Insufficient gem balance");
                    e.getWhoClicked().getWorld().playSound(e.getWhoClicked().getLocation(), Sound.ENTITY_VILLAGER_NO, 2,1);
                }
            }
            //Harvester 2
            else if (e.getCurrentItem().getItemMeta().equals(meta13)) {
                if (e.getWhoClicked().getInventory().containsAtLeast(Items.gems(), 16)) {
                    ItemStack gem = Items.gems();
                    gem.setAmount(16);
                    if(Objects.requireNonNull(e.getWhoClicked()).getInventory().firstEmpty() == -1){

                        e.getWhoClicked().getWorld().dropItemNaturally(e.getWhoClicked().getLocation(),harvester2());

                    }else{

                        e.getWhoClicked().getInventory().addItem(harvester2());
                    }
                    e.getWhoClicked().getInventory().removeItem(gem);
                    e.getWhoClicked().getWorld().playSound(e.getWhoClicked().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2, 2);
                } else {
                    e.getWhoClicked().sendMessage("Insufficient gem balance");
                    e.getWhoClicked().getWorld().playSound(e.getWhoClicked().getLocation(), Sound.ENTITY_VILLAGER_NO, 2,1);
                }
            }
            //Harvester 3
            else if (e.getCurrentItem().getItemMeta().equals(meta14)) {
                if (e.getWhoClicked().getInventory().containsAtLeast(Items.gems(), 40)) {
                    ItemStack gem = Items.gems();
                    gem.setAmount(40);
                    if(Objects.requireNonNull(e.getWhoClicked()).getInventory().firstEmpty() == -1){

                        e.getWhoClicked().getWorld().dropItemNaturally(e.getWhoClicked().getLocation(),harvester3());

                    }else{

                        e.getWhoClicked().getInventory().addItem(harvester3());
                    }
                    e.getWhoClicked().getInventory().removeItem(gem);
                    e.getWhoClicked().getWorld().playSound(e.getWhoClicked().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2, 2);
                } else {
                    e.getWhoClicked().sendMessage("Insufficient gem balance");
                    e.getWhoClicked().getWorld().playSound(e.getWhoClicked().getLocation(), Sound.ENTITY_VILLAGER_NO, 2,1);
                }
            }
            //Harvester 4
            else if (e.getCurrentItem().getItemMeta().equals(meta15)) {
                if (e.getWhoClicked().getInventory().containsAtLeast(Items.gems(), 300)) {
                    ItemStack gem = Items.gems();
                    gem.setAmount(300);
                    if(Objects.requireNonNull(e.getWhoClicked()).getInventory().firstEmpty() == -1){

                        e.getWhoClicked().getWorld().dropItemNaturally(e.getWhoClicked().getLocation(),harvester4());

                    }else{

                        e.getWhoClicked().getInventory().addItem(harvester4());
                    }
                    e.getWhoClicked().getInventory().removeItem(gem);
                    e.getWhoClicked().getWorld().playSound(e.getWhoClicked().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2, 2);
                } else {
                    e.getWhoClicked().sendMessage("Insufficient gem balance");
                    e.getWhoClicked().getWorld().playSound(e.getWhoClicked().getLocation(), Sound.ENTITY_VILLAGER_NO, 2,1);
                }
            }
            //Harvester 5
            else if (e.getCurrentItem().getItemMeta().equals(meta16)) {
                if (e.getWhoClicked().getInventory().containsAtLeast(Items.sapphire(), 8)) {
                    ItemStack sapphire = Items.sapphire();
                    sapphire.setAmount(8);
                    if(Objects.requireNonNull(e.getWhoClicked()).getInventory().firstEmpty() == -1){

                        e.getWhoClicked().getWorld().dropItemNaturally(e.getWhoClicked().getLocation(),harvester5());

                    }else{

                        e.getWhoClicked().getInventory().addItem(harvester5());
                    }
                    e.getWhoClicked().getInventory().removeItem(sapphire);
                    e.getWhoClicked().getWorld().playSound(e.getWhoClicked().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2, 2);
                } else {
                    e.getWhoClicked().sendMessage("Insufficient sapphire balance");
                    e.getWhoClicked().getWorld().playSound(e.getWhoClicked().getLocation(), Sound.ENTITY_VILLAGER_NO, 2,1);
                }
            }
            //Harvester 6
            else if (e.getCurrentItem().getItemMeta().equals(meta17)) {
                if (e.getWhoClicked().getInventory().containsAtLeast(Items.sapphire(), 512)) {
                    ItemStack sapphire = Items.sapphire();
                    sapphire.setAmount(512);
                    if(Objects.requireNonNull(e.getWhoClicked()).getInventory().firstEmpty() == -1){

                        e.getWhoClicked().getWorld().dropItemNaturally(e.getWhoClicked().getLocation(),harvester6());

                    }else{

                        e.getWhoClicked().getInventory().addItem(harvester6());
                    }
                    e.getWhoClicked().getInventory().removeItem(sapphire);
                    e.getWhoClicked().getWorld().playSound(e.getWhoClicked().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2, 2);
                } else {
                    e.getWhoClicked().sendMessage("Insufficient sapphire balance");
                    e.getWhoClicked().getWorld().playSound(e.getWhoClicked().getLocation(), Sound.ENTITY_VILLAGER_NO, 2,1);
                }
            }
            //Lock Pick
            else if (e.getCurrentItem().getItemMeta().equals(meta9)) {
                if (e.getWhoClicked().getInventory().containsAtLeast(Items.gems(), 128)) {
                    ItemStack gem = Items.gems();
                    gem.setAmount(128);
                    if(Objects.requireNonNull(e.getWhoClicked()).getInventory().firstEmpty() == -1){

                        e.getWhoClicked().getWorld().dropItemNaturally(e.getWhoClicked().getLocation(),lockpick());

                    }else{

                        e.getWhoClicked().getInventory().addItem(lockpick());
                    }
                    e.getWhoClicked().getInventory().removeItem(gem);
                    e.getWhoClicked().getWorld().playSound(e.getWhoClicked().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2, 2);
                } else {
                    e.getWhoClicked().sendMessage("Insufficient gem balance");
                    e.getWhoClicked().getWorld().playSound(e.getWhoClicked().getLocation(), Sound.ENTITY_VILLAGER_NO, 2,1);
                }
            }
            //Lock Pick 2
            else if (e.getCurrentItem().getItemMeta().equals(meta10)) {
                if (e.getWhoClicked().getInventory().containsAtLeast(Items.gems(), 64)) {
                    ItemStack gem = Items.gems();
                    gem.setAmount(64);
                    if(Objects.requireNonNull(e.getWhoClicked()).getInventory().firstEmpty() == -1){

                        e.getWhoClicked().getWorld().dropItemNaturally(e.getWhoClicked().getLocation(),lockpick2());

                    }else{

                        e.getWhoClicked().getInventory().addItem(lockpick2());
                    }
                    e.getWhoClicked().getInventory().removeItem(gem);
                    e.getWhoClicked().getWorld().playSound(e.getWhoClicked().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2, 2);
                } else {
                    e.getWhoClicked().sendMessage("Insufficient gem balance");
                    e.getWhoClicked().getWorld().playSound(e.getWhoClicked().getLocation(), Sound.ENTITY_VILLAGER_NO, 2,1);
                }
            }
            //Lock Pick 3
            else if (e.getCurrentItem().getItemMeta().equals(meta11)) {
                if (e.getWhoClicked().getInventory().containsAtLeast(Items.gems(), 16)) {
                    ItemStack gem = Items.gems();
                    gem.setAmount(16);
                    if(Objects.requireNonNull(e.getWhoClicked()).getInventory().firstEmpty() == -1){

                        e.getWhoClicked().getWorld().dropItemNaturally(e.getWhoClicked().getLocation(),lockpick3());

                    }else{

                        e.getWhoClicked().getInventory().addItem(lockpick3());
                    }
                    e.getWhoClicked().getInventory().removeItem(gem);
                    e.getWhoClicked().getWorld().playSound(e.getWhoClicked().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2, 2);
                } else {
                    e.getWhoClicked().sendMessage("Insufficient gem balance");
                    e.getWhoClicked().getWorld().playSound(e.getWhoClicked().getLocation(), Sound.ENTITY_VILLAGER_NO, 2,1);
                }
            }
            //Breaker 4
            else if (e.getCurrentItem().getItemMeta().equals(meta8)) {
                if (e.getWhoClicked().getInventory().containsAtLeast(Items.gems(), 8)) {
                    ItemStack gem = Items.gems();
                    gem.setAmount(8);
                    if(Objects.requireNonNull(e.getWhoClicked()).getInventory().firstEmpty() == -1){

                        e.getWhoClicked().getWorld().dropItemNaturally(e.getWhoClicked().getLocation(),breaker4());

                    }else{

                        e.getWhoClicked().getInventory().addItem(breaker4());
                    }
                    e.getWhoClicked().getInventory().removeItem(gem);
                    e.getWhoClicked().getWorld().playSound(e.getWhoClicked().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2, 2);
                } else {
                    e.getWhoClicked().sendMessage("Insufficient gem balance");
                    e.getWhoClicked().getWorld().playSound(e.getWhoClicked().getLocation(), Sound.ENTITY_VILLAGER_NO, 2,1);
                }
            }
            //Breaker 3
            else if (e.getCurrentItem().getItemMeta().equals(meta7)) {
                if (e.getWhoClicked().getInventory().containsAtLeast(Items.gems(), 32)) {
                    ItemStack gem = Items.gems();
                    gem.setAmount(32);
                    if(Objects.requireNonNull(e.getWhoClicked()).getInventory().firstEmpty() == -1){

                        e.getWhoClicked().getWorld().dropItemNaturally(e.getWhoClicked().getLocation(),breaker3());

                    }else{

                        e.getWhoClicked().getInventory().addItem(breaker3());
                    }
                    e.getWhoClicked().getInventory().removeItem(gem);
                    e.getWhoClicked().getWorld().playSound(e.getWhoClicked().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2, 2);
                } else {
                    e.getWhoClicked().sendMessage("Insufficient gem balance");
                    e.getWhoClicked().getWorld().playSound(e.getWhoClicked().getLocation(), Sound.ENTITY_VILLAGER_NO, 2,1);
                }
            }
            //Breaker 2
            else if (e.getCurrentItem().getItemMeta().equals(meta6)) {
                if (e.getWhoClicked().getInventory().containsAtLeast(Items.gems(), 64)) {
                    ItemStack gem = Items.gems();
                    gem.setAmount(64);
                    if(Objects.requireNonNull(e.getWhoClicked()).getInventory().firstEmpty() == -1){

                        e.getWhoClicked().getWorld().dropItemNaturally(e.getWhoClicked().getLocation(),breaker2());

                    }else{

                        e.getWhoClicked().getInventory().addItem(breaker2());
                    }
                    e.getWhoClicked().getInventory().removeItem(gem);
                    e.getWhoClicked().getWorld().playSound(e.getWhoClicked().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2, 2);
                } else {
                    e.getWhoClicked().sendMessage("Insufficient gem balance");
                    e.getWhoClicked().getWorld().playSound(e.getWhoClicked().getLocation(), Sound.ENTITY_VILLAGER_NO, 2,1);
                }
            }
            //Breaker
            else if (e.getCurrentItem().getItemMeta().equals(meta5)) {
                if (e.getWhoClicked().getInventory().containsAtLeast(Items.gems(), 128)) {
                    ItemStack gem = Items.gems();
                    gem.setAmount(128);
                    if(Objects.requireNonNull(e.getWhoClicked()).getInventory().firstEmpty() == -1){

                        e.getWhoClicked().getWorld().dropItemNaturally(e.getWhoClicked().getLocation(),breaker());

                    }else{

                        e.getWhoClicked().getInventory().addItem(breaker());
                    }
                    e.getWhoClicked().getInventory().removeItem(gem);
                    e.getWhoClicked().getWorld().playSound(e.getWhoClicked().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2, 2);
                } else {
                    e.getWhoClicked().sendMessage("Insufficient balance");
                    e.getWhoClicked().getWorld().playSound(e.getWhoClicked().getLocation(), Sound.ENTITY_VILLAGER_NO, 2,1);
                }
            }
        }
    }
}
