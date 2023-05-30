
package me.mechkarov.gemcraft;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;
import org.bukkit.inventory.meta.ItemMeta;

import javax.swing.text.StyledEditorKit;
import java.util.*;

public class Items implements Listener {

    //Disable placement of certain blocks like gems and sapphires.
    @EventHandler
    public void onBlockPlaced(BlockPlaceEvent event) {
        ItemStack blockType = event.getItemInHand();
        ItemStack gem = Items.gems();
        ItemStack sapphire = Items.sapphire();
        gem.setAmount(blockType.getAmount());
        sapphire.setAmount(blockType.getAmount());

        if (blockType.equals(gem) || blockType.equals(sapphire)) {
            event.setCancelled(true);
        }
    }

    public static ItemStack viphelmet() {
        ItemStack viphelmet = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta meta = viphelmet.getItemMeta();

        assert meta != null;
        meta.setDisplayName(ChatColor.BLUE + "MVP"+ChatColor.WHITE+"+"+ChatColor.BLUE+" Helmet");

        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
        meta.addEnchant(Enchantment.DURABILITY, 3, true);

        viphelmet.setItemMeta(meta);

        return viphelmet;
    }
    public static ItemStack vipchestplate() {
        ItemStack vipchestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta meta = vipchestplate.getItemMeta();

        assert meta != null;
        meta.setDisplayName(ChatColor.BLUE + "MVP"+ChatColor.WHITE+"+"+ChatColor.BLUE+" Chestplate");

        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
        meta.addEnchant(Enchantment.DURABILITY, 3, true);

        vipchestplate.setItemMeta(meta);

        return vipchestplate;
    }
    public static ItemStack vipleggings() {
        ItemStack vipleggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta meta = vipleggings.getItemMeta();

        assert meta != null;
        meta.setDisplayName(ChatColor.BLUE + "MVP"+ChatColor.WHITE+"+"+ChatColor.BLUE+" Leggings");

        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
        meta.addEnchant(Enchantment.DURABILITY, 3, true);

        vipleggings.setItemMeta(meta);

        return vipleggings;
    }
    public static ItemStack vipboots() {
        ItemStack vipboots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta meta = vipboots.getItemMeta();

        assert meta != null;
        meta.setDisplayName(ChatColor.BLUE + "MVP"+ChatColor.WHITE+"+"+ChatColor.BLUE+" Boots");

        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
        meta.addEnchant(Enchantment.DURABILITY, 3, true);

        vipboots.setItemMeta(meta);

        return vipboots;
    }
    public static ItemStack vipsword() {
        ItemStack vipsword = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemMeta meta = vipsword.getItemMeta();

        assert meta != null;
        meta.setDisplayName(ChatColor.AQUA + "Diamond Tools");

        meta.addEnchant(Enchantment.DURABILITY, 1,true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        vipsword.setItemMeta(meta);

        return vipsword;
    }
    public static ItemStack money() {
        ItemStack money = new ItemStack(Material.PAPER);
        ItemMeta meta = money.getItemMeta();

        assert meta != null;
        meta.setDisplayName(ChatColor.GREEN + "$15,000");

        meta.addEnchant(Enchantment.DURABILITY, 1,true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        money.setItemMeta(meta);

        return money;
    }
    public static ItemStack money2() {
        ItemStack money2 = new ItemStack(Material.PAPER);
        ItemMeta meta = money2.getItemMeta();

        assert meta != null;
        meta.setDisplayName(ChatColor.GREEN + "$30,000");

        meta.addEnchant(Enchantment.DURABILITY, 1,true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        money2.setItemMeta(meta);

        return money2;
    }
    public static ItemStack exp() {
        ItemStack exp = new ItemStack(Material.EXPERIENCE_BOTTLE);
        ItemMeta meta = exp.getItemMeta();

        assert meta != null;
        meta.setDisplayName(ChatColor.YELLOW + "1,500 Exp");

        exp.setItemMeta(meta);

        return exp;
    }
    public static ItemStack builderkit() {
        ItemStack builderkit = new ItemStack(Material.OAK_LOG);
        ItemMeta meta = builderkit.getItemMeta();

        assert meta != null;
        meta.setDisplayName(ChatColor.RED + "Builder Kit");

        builderkit.setItemMeta(meta);

        return builderkit;
    }
    public static ItemStack dtools() {
        ItemStack dtools = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemMeta meta = dtools.getItemMeta();

        meta.addEnchant(Enchantment.DURABILITY, 1,true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        dtools.setItemMeta(meta);

        return dtools;
    }
    public static ItemStack vipkit() {
        ItemStack vipkit = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta meta = vipkit.getItemMeta();

        assert meta != null;
        meta.setDisplayName(ChatColor.GREEN + "VIP Kit");

        vipkit.setItemMeta(meta);

        return vipkit;
    }
    public static ItemStack claimshovel() {
        ItemStack claimshovel = new ItemStack(Material.GOLDEN_SHOVEL);
        ItemMeta meta = claimshovel.getItemMeta();

        meta.addEnchant(Enchantment.DURABILITY, 1,true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        claimshovel.setItemMeta(meta);

        return claimshovel;
    }
    public static ItemStack ActivationBedrock(){
        ItemStack ActivationBedrock = new ItemStack(Material.BEDROCK);
        ItemMeta meta = ActivationBedrock.getItemMeta();

        assert meta != null;
        meta.setDisplayName(ChatColor.GREEN+"Activate");
        meta.setLore(Collections.singletonList(ChatColor.YELLOW + "Place down to activate"));
        ActivationBedrock.setItemMeta(meta);

        return ActivationBedrock;
    }
    public static ItemStack DeactivationBedrock(){
        ItemStack DeactivationBedrock = new ItemStack(Material.BEDROCK);
        ItemMeta meta = DeactivationBedrock.getItemMeta();

        assert meta != null;
        meta.setDisplayName(ChatColor.RED+"Deactivate");
        meta.setLore(Collections.singletonList(ChatColor.YELLOW + "Hold in hand to deactivate"));
        DeactivationBedrock.setItemMeta(meta);

        return DeactivationBedrock;
    }
    public static ItemStack yes(){
        ItemStack yes = new ItemStack(Material.GREEN_WOOL);
        ItemMeta meta = yes.getItemMeta();

        assert meta != null;
        meta.setDisplayName("Yes");
        yes.setItemMeta(meta);

        return yes;
    }
    public static ItemStack no(){
        ItemStack no = new ItemStack(Material.RED_WOOL);
        ItemMeta meta = no.getItemMeta();

        assert meta != null;
        meta.setDisplayName("No");
        no.setItemMeta(meta);

        return no;
    }
    public static ItemStack spawner() {
        ItemStack spawner = new ItemStack(Material.SPAWNER);
        BlockStateMeta meta = (BlockStateMeta) spawner.getItemMeta();
        assert meta != null;
        CreatureSpawner css = (CreatureSpawner) meta.getBlockState();

        meta.setDisplayName(ChatColor.GREEN + "Level 1");
        meta.setLore(Arrays.asList(ChatColor.GOLD + "Generates: 20 minutes Per", ChatColor.GOLD + "Storage: 6 Gems", ChatColor.GOLD + "Upgrade: 6 Gems"));

        css.setSpawnedType(EntityType.ZOMBIE);
        meta.setBlockState(css);
        spawner.setItemMeta(meta);

        return spawner;
    }
    public static ItemStack shopspawner() {
        ItemStack shopspawner = new ItemStack(Material.SPAWNER);
        BlockStateMeta meta = (BlockStateMeta) shopspawner.getItemMeta();
        assert meta != null;
        CreatureSpawner css = (CreatureSpawner) meta.getBlockState();

        meta.setDisplayName(ChatColor.GREEN + "Level 1 (Cost: $69)");
        meta.setLore(Arrays.asList(ChatColor.GOLD + "Generates: 20 minutes Per", ChatColor.GOLD + "Storage: 6 Gems", ChatColor.GOLD + "Upgrade: 6 Gems"));

        css.setSpawnedType(EntityType.ZOMBIE);
        meta.setBlockState(css);
        shopspawner.setItemMeta(meta);

        return shopspawner;
    }
    public static ItemStack gems(){
        ItemStack gem = new ItemStack(Material.GREEN_STAINED_GLASS);
        ItemMeta meta = gem.getItemMeta();

        assert meta != null;
        meta.setDisplayName(ChatColor.DARK_GREEN + "~Gem~");
        meta.setLore(Collections.singletonList(ChatColor.GREEN + "Can be used in /raidshop!"));
        gem.setItemMeta(meta);

        return gem;
    }
    public static ItemStack enchantedgem(){
        ItemStack enchantedgem = new ItemStack(Material.GREEN_STAINED_GLASS);
        ItemMeta meta = enchantedgem.getItemMeta();

        assert meta != null;
        meta.setDisplayName(ChatColor.DARK_GREEN + "~Enchanted Gem~");
        meta.setLore(Collections.singletonList(ChatColor.GREEN + "Can be used in custom recipes!"));
        meta.addEnchant(Enchantment.DURABILITY, 1,true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        enchantedgem.setItemMeta(meta);

        return enchantedgem;
    }
    public static ItemStack shopenchantedgem(){
        ItemStack shopenchantedgem = new ItemStack(Material.GREEN_STAINED_GLASS);
        ItemMeta meta = shopenchantedgem.getItemMeta();

        assert meta != null;
        meta.setDisplayName(ChatColor.DARK_GREEN + "~Enchanted Gem~ (Cost: 2240 Gems)");
        meta.setLore(Collections.singletonList(ChatColor.GREEN + "Can be used in custom recipes!"));
        meta.addEnchant(Enchantment.DURABILITY, 1,true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        shopenchantedgem.setItemMeta(meta);

        return shopenchantedgem;
    }
    public static ItemStack netherite(){
        ItemStack netherite = new ItemStack(Material.NETHERITE_INGOT);
        ItemMeta meta = netherite.getItemMeta();

        return netherite;
    }
    public static ItemStack arrow(){
        ItemStack arrow = new ItemStack(Material.ARROW);
        ItemMeta meta = arrow.getItemMeta();

        assert meta != null;
        meta.setDisplayName(ChatColor.DARK_RED + "Back");
        meta.addEnchant(Enchantment.DURABILITY, 1,true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        arrow.setItemMeta(meta);

        return arrow;
    }
    public static ItemStack sapphire(){
        ItemStack sapphire = new ItemStack(Material.BLUE_STAINED_GLASS);
        ItemMeta meta = sapphire.getItemMeta();

        assert meta != null;
        meta.setDisplayName(ChatColor.BLUE + "~Sapphire~");
        meta.setLore(Arrays.asList(ChatColor.AQUA + "The secret gem" ,"of highest value"));
        sapphire.setItemMeta(meta);

        return sapphire;
    }
    public static ItemStack shopsapphire(){
        ItemStack shopsapphire = new ItemStack(Material.BLUE_STAINED_GLASS);
        ItemMeta meta = shopsapphire.getItemMeta();

        assert meta != null;
        meta.setDisplayName(ChatColor.BLUE + "~Sapphire~");
        meta.setLore(Arrays.asList(ChatColor.AQUA + "The secret gem" ,"of highest value",
                "",ChatColor.GOLD+"Cost: "+ChatColor.GREEN+"2240 Gems"));
        shopsapphire.setItemMeta(meta);

        return shopsapphire;
    }
    public static ItemStack warp(){
        ItemStack warp = new ItemStack(Material.OAK_SIGN, 1);
        ItemMeta meta = warp.getItemMeta();

        assert meta != null;
        meta.setDisplayName(ChatColor.LIGHT_PURPLE+"Warp Sign");
        meta.setLore(Arrays.asList(ChatColor.GREEN+"Useful for teleporting"));
        warp.setItemMeta(meta);

        return warp;
    }
    public static ItemStack shopwarp(){
        ItemStack shopwarp = new ItemStack(Material.OAK_SIGN, 1);
        ItemMeta meta = shopwarp.getItemMeta();

        assert meta != null;
        meta.setDisplayName(ChatColor.LIGHT_PURPLE+"Warp Sign");
        meta.setLore(Arrays.asList(ChatColor.GREEN+"Useful for teleporting",
                "",ChatColor.GOLD+"Cost: "+ChatColor.GREEN+"100 Gems"));
        shopwarp.setItemMeta(meta);

        return shopwarp;
    }
    public static ItemStack ram(){
        ItemStack ram = new ItemStack(Material.IRON_SHOVEL, 1);
        ItemMeta meta = ram.getItemMeta();

        assert meta != null;
        meta.setDisplayName(ChatColor.WHITE+"RAM");
        meta.setLore(Arrays.asList(ChatColor.GREEN+"Useful for breaching doors",
                ChatColor.DARK_PURPLE+"Might break once used",ChatColor.DARK_GRAY+"(Better clear your browsing history, F.B.I Open up!)"));
        meta.setUnbreakable(true);
        ram.setItemMeta(meta);

        return ram;
    }
    public static ItemStack shopram(){
        ItemStack shopram = new ItemStack(Material.IRON_SHOVEL, 1);
        ItemMeta shopmeta = shopram.getItemMeta();

        assert shopmeta != null;
        shopmeta.setDisplayName(ChatColor.WHITE+"RAM");
        shopmeta.setLore(Arrays.asList(ChatColor.GREEN+"Useful for breaching doors",
                ChatColor.DARK_PURPLE+"Might break once used",ChatColor.DARK_GRAY+"(Better clear your browsing history, F.B.I Open up!)",
                "",ChatColor.GOLD+"Cost: "+ChatColor.GREEN+"8 Gems"));
        shopram.setItemMeta(shopmeta);

        return shopram;
    }
    public static ItemStack border(){
        ItemStack border = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);

        return border;
    }
    public static ItemStack placer(){
        ItemStack placer = new ItemStack(Material.RED_STAINED_GLASS, 1);
        ItemMeta meta = placer.getItemMeta();

        assert meta != null;
        meta.setDisplayName(ChatColor.RED+"Block Placer");
        meta.setLore(Arrays.asList(ChatColor.GREEN+"Useful for trapping",
                ChatColor.YELLOW+"Duration: 15 seconds"));
        placer.setItemMeta(meta);

        return placer;
    }
    public static ItemStack shopplacer(){
        ItemStack shopplacer = new ItemStack(Material.RED_STAINED_GLASS, 1);
        ItemMeta meta = shopplacer.getItemMeta();

        assert meta != null;
        meta.setDisplayName(ChatColor.RED+"Block Placer");
        meta.setLore(Arrays.asList(ChatColor.GREEN+"Useful for trapping",
                ChatColor.YELLOW+"Duration: 15 seconds",
                "",ChatColor.GOLD+"Cost: "+ChatColor.GREEN+"8 Gems"));
        shopplacer.setItemMeta(meta);

        return shopplacer;
    }
    public static ItemStack lockpick(){
        ItemStack lockpick = new ItemStack(Material.TRIPWIRE_HOOK, 1);
        ItemMeta meta = lockpick.getItemMeta();

        meta.setDisplayName(ChatColor.AQUA+"Level 3 Lock Pick");
        meta.setLore(Arrays.asList(ChatColor.GREEN+"Useful for looting chests",ChatColor.YELLOW+"Chance: 100%",
                ChatColor.DARK_PURPLE+"Might break once used", ChatColor.DARK_GRAY+"(The pick that Bosnianbill and I made)"));
        lockpick.setItemMeta(meta);

        return lockpick;
    }
    public static ItemStack shoplockpick(){
        ItemStack shoplockpick = new ItemStack(Material.TRIPWIRE_HOOK, 1);
        ItemMeta meta = shoplockpick.getItemMeta();

        meta.setDisplayName(ChatColor.AQUA+"Level 3 Lock Pick");
        meta.setLore(Arrays.asList(ChatColor.GREEN+"Useful for looting chests",ChatColor.YELLOW+"Chance: 100%",
                ChatColor.DARK_PURPLE+"Might break once used", ChatColor.DARK_GRAY+"(The pick that Bosnianbill and I made)",
                "",ChatColor.GOLD+"Cost: "+ChatColor.GREEN+"128 Gems"));
        shoplockpick.setItemMeta(meta);

        return shoplockpick;
    }
    public static ItemStack lockpick2() {
        ItemStack lockpick2 = new ItemStack(Material.TRIPWIRE_HOOK, 1);
        ItemMeta meta2 = lockpick2.getItemMeta();

        meta2.setDisplayName(ChatColor.AQUA + "Level 2 Lock Pick");
        meta2.setLore(Arrays.asList(ChatColor.GREEN+"Useful for looting chests",ChatColor.YELLOW+"Chance: 50%",
                ChatColor.DARK_PURPLE+"Will break once used"));
        lockpick2.setItemMeta(meta2);

        return lockpick2;
    }
    public static ItemStack shoplockpick2() {
        ItemStack shoplockpick2 = new ItemStack(Material.TRIPWIRE_HOOK, 1);
        ItemMeta meta2 = shoplockpick2.getItemMeta();

        meta2.setDisplayName(ChatColor.AQUA + "Level 2 Lock Pick");
        meta2.setLore(Arrays.asList(ChatColor.GREEN+"Useful for looting chests",ChatColor.YELLOW+"Chance: 50%",
                ChatColor.DARK_PURPLE+"Will break once used",
                "",ChatColor.GOLD+"Cost: "+ChatColor.GREEN+"64 Gems"));
        shoplockpick2.setItemMeta(meta2);

        return shoplockpick2;
    }
    public static ItemStack lockpick3() {
        ItemStack lockpick3 = new ItemStack(Material.TRIPWIRE_HOOK, 1);
        ItemMeta meta3 = lockpick3.getItemMeta();

        meta3.setDisplayName(ChatColor.AQUA + "Level 1 Lock Pick");
        meta3.setLore(Arrays.asList(ChatColor.GREEN+"Useful for looting chests",ChatColor.YELLOW+"Chance: 20%",
                ChatColor.DARK_PURPLE+"Will break once used", ChatColor.DARK_GRAY+"(Forged by following a 5-Minute Crafts video)"));
        lockpick3.setItemMeta(meta3);

        return lockpick3;
    }
    public static ItemStack shoplockpick3() {
        ItemStack shoplockpick3 = new ItemStack(Material.TRIPWIRE_HOOK, 1);
        ItemMeta meta3 = shoplockpick3.getItemMeta();

        meta3.setDisplayName(ChatColor.AQUA + "Level 1 Lock Pick");
        meta3.setLore(Arrays.asList(ChatColor.GREEN+"Useful for looting chests",ChatColor.YELLOW+"Chance: 20%",
                ChatColor.DARK_PURPLE+"Will break once used", ChatColor.DARK_GRAY+"(Forged by following a 5-Minute Crafts video)",
                "",ChatColor.GOLD+"Cost: "+ChatColor.GREEN+"16 Gems"));
        shoplockpick3.setItemMeta(meta3);

        return shoplockpick3;
    }
    public static ItemStack breaker() {
        ItemStack breaker = new ItemStack(Material.DIAMOND_PICKAXE, 1);
        ItemMeta meta = breaker.getItemMeta();

        meta.setDisplayName(ChatColor.DARK_RED + "Diamond Block Breaker");
        meta.setLore(Arrays.asList(ChatColor.GREEN + "Useful for breaking blocks",ChatColor.YELLOW + "Duration: 20 Minutes",ChatColor.DARK_PURPLE + "Will break once used"));
        breaker.setItemMeta(meta);

        return breaker;
    }
    public static ItemStack shopbreaker() {
        ItemStack shopbreaker = new ItemStack(Material.DIAMOND_PICKAXE, 1);
        ItemMeta meta = shopbreaker.getItemMeta();

        meta.setDisplayName(ChatColor.DARK_RED + "Diamond Block Breaker");
        meta.setLore(Arrays.asList(ChatColor.GREEN + "Useful for breaking blocks",ChatColor.YELLOW + "Duration: 20 Minutes",ChatColor.DARK_PURPLE + "Will break once used",
                "",ChatColor.GOLD+"Cost: "+ChatColor.GREEN+"128 Gems"));
        shopbreaker.setItemMeta(meta);

        return shopbreaker;
    }
    public static ItemStack breaker2() {
        ItemStack breaker2 = new ItemStack(Material.GOLDEN_PICKAXE, 1);
        ItemMeta meta2 = breaker2.getItemMeta();

        meta2.setDisplayName(ChatColor.DARK_RED + "Gold Block Breaker");
        meta2.setLore(Arrays.asList(ChatColor.GREEN + "Useful for breaking blocks",ChatColor.YELLOW + "Duration: 10 Minutes",ChatColor.DARK_PURPLE + "Will break once used"));
        breaker2.setItemMeta(meta2);

        return breaker2;
    }
    public static ItemStack shopbreaker2() {
        ItemStack shopbreaker2 = new ItemStack(Material.GOLDEN_PICKAXE, 1);
        ItemMeta meta2 = shopbreaker2.getItemMeta();

        meta2.setDisplayName(ChatColor.DARK_RED + "Gold Block Breaker");
        meta2.setLore(Arrays.asList(ChatColor.GREEN + "Useful for breaking blocks",ChatColor.YELLOW + "Duration: 10 Minutes",ChatColor.DARK_PURPLE + "Will break once used",
                "",ChatColor.GOLD+"Cost: "+ChatColor.GREEN+"64 Gems"));
        shopbreaker2.setItemMeta(meta2);

        return shopbreaker2;
    }
    public static ItemStack breaker3() {
        ItemStack breaker3 = new ItemStack(Material.IRON_PICKAXE, 1);
        ItemMeta meta3 = breaker3.getItemMeta();

        meta3.setDisplayName(ChatColor.DARK_RED + "Iron Block Breaker");
        meta3.setLore(Arrays.asList(ChatColor.GREEN + "Useful for breaking blocks",ChatColor.YELLOW + "Duration: 5 Minutes",ChatColor.DARK_PURPLE + "Will break once used"));
        breaker3.setItemMeta(meta3);

        return breaker3;
    }
    public static ItemStack shopbreaker3() {
        ItemStack shopbreaker3 = new ItemStack(Material.IRON_PICKAXE, 1);
        ItemMeta meta3 = shopbreaker3.getItemMeta();

        meta3.setDisplayName(ChatColor.DARK_RED + "Iron Block Breaker");
        meta3.setLore(Arrays.asList(ChatColor.GREEN + "Useful for breaking blocks",ChatColor.YELLOW + "Duration: 5 Minutes",ChatColor.DARK_PURPLE + "Will break once used",
                "",ChatColor.GOLD+"Cost: "+ChatColor.GREEN+"32 Gems"));
        shopbreaker3.setItemMeta(meta3);

        return shopbreaker3;
    }
    public static ItemStack breaker4() {
        ItemStack breaker4 = new ItemStack(Material.STONE_PICKAXE, 1);
        ItemMeta meta4 = breaker4.getItemMeta();

        meta4.setDisplayName(ChatColor.DARK_RED + "Stone Block Breaker");
        meta4.setLore(Arrays.asList(ChatColor.GREEN + "Useful for breaking blocks",ChatColor.YELLOW + "Duration: 2 Minutes",ChatColor.DARK_PURPLE + "Will break once used",
                ChatColor.DARK_GRAY + "(Still longer than you in bed)"));
        breaker4.setItemMeta(meta4);

        return breaker4;
    }
    public static ItemStack shopbreaker4() {
        ItemStack shopbreaker4 = new ItemStack(Material.STONE_PICKAXE, 1);
        ItemMeta meta4 = shopbreaker4.getItemMeta();

        meta4.setDisplayName(ChatColor.DARK_RED + "Stone Block Breaker");
        meta4.setLore(Arrays.asList(ChatColor.GREEN + "Useful for breaking blocks",ChatColor.YELLOW + "Duration: 2 Minutes",ChatColor.DARK_PURPLE + "Will break once used",
                ChatColor.DARK_GRAY + "(Still longer than you in bed)",
                "",ChatColor.GOLD+"Cost: "+ChatColor.GREEN+"8 Gems"));
        shopbreaker4.setItemMeta(meta4);

        return shopbreaker4;
    }
    public static ItemStack harvester() {
        ItemStack harvester = new ItemStack(Material.GOLDEN_HOE, 1);
        ItemMeta meta = harvester.getItemMeta();

        meta.setDisplayName(ChatColor.GOLD + "Level 1 Harvester");
        meta.setLore(Arrays.asList(ChatColor.GREEN + "Useful for mining spawners", ChatColor.YELLOW + "Effective range: Level 5", ChatColor.DARK_PURPLE + "Will break once used"));
        meta.setUnbreakable(true);
        harvester.setItemMeta(meta);

        return harvester;
    }
    public static ItemStack shopharvester() {
        ItemStack shopharvester = new ItemStack(Material.GOLDEN_HOE, 1);
        ItemMeta meta = shopharvester.getItemMeta();

        meta.setDisplayName(ChatColor.GOLD + "Level 1 Harvester");
        meta.setLore(Arrays.asList(ChatColor.GREEN + "Useful for mining spawners", ChatColor.YELLOW + "Effective range: Level 5", ChatColor.DARK_PURPLE + "Will break once used",
                "",ChatColor.GOLD+"Cost: "+ChatColor.GREEN+"6 Gems"));
        shopharvester.setItemMeta(meta);

        return shopharvester;
    }
    public static ItemStack harvester2() {
        ItemStack harvester2 = new ItemStack(Material.GOLDEN_HOE, 1);
        ItemMeta meta2 = harvester2.getItemMeta();

        meta2.setDisplayName(ChatColor.GOLD + "Level 2 Harvester");
        meta2.setLore(Arrays.asList(ChatColor.GREEN + "Useful for mining spawners", ChatColor.YELLOW + "Effective range: Level 10", ChatColor.DARK_PURPLE + "Will break once used"));
        meta2.setUnbreakable(true);
        harvester2.setItemMeta(meta2);

        return harvester2;
    }
    public static ItemStack shopharvester2() {
        ItemStack shopharvester2 = new ItemStack(Material.GOLDEN_HOE, 1);
        ItemMeta meta2 = shopharvester2.getItemMeta();

        meta2.setDisplayName(ChatColor.GOLD + "Level 2 Harvester");
        meta2.setLore(Arrays.asList(ChatColor.GREEN + "Useful for mining spawners", ChatColor.YELLOW + "Effective range: Level 10", ChatColor.DARK_PURPLE + "Will break once used",
                "",ChatColor.GOLD+"Cost: "+ChatColor.GREEN+"16 Gems"));
        shopharvester2.setItemMeta(meta2);

        return shopharvester2;
    }
    public static ItemStack harvester3() {
        ItemStack harvester3 = new ItemStack(Material.GOLDEN_HOE, 1);
        ItemMeta meta3 = harvester3.getItemMeta();

        meta3.setDisplayName(ChatColor.GOLD + "Level 3 Harvester");
        meta3.setLore(Arrays.asList(ChatColor.GREEN + "Useful for mining spawners", ChatColor.YELLOW + "Effective range: Level 15", ChatColor.DARK_PURPLE + "Will break once used"));
        meta3.setUnbreakable(true);
        harvester3.setItemMeta(meta3);

        return harvester3;
    }
    public static ItemStack shopharvester3() {
        ItemStack shopharvester3 = new ItemStack(Material.GOLDEN_HOE, 1);
        ItemMeta meta3 = shopharvester3.getItemMeta();

        meta3.setDisplayName(ChatColor.GOLD + "Level 3 Harvester");
        meta3.setLore(Arrays.asList(ChatColor.GREEN + "Useful for mining spawners", ChatColor.YELLOW + "Effective range: Level 15", ChatColor.DARK_PURPLE + "Will break once used",
                "",ChatColor.GOLD+"Cost: "+ChatColor.GREEN+"40 Gems"));
        shopharvester3.setItemMeta(meta3);

        return shopharvester3;
    }
    public static ItemStack harvester4() {
        ItemStack harvester4 = new ItemStack(Material.GOLDEN_HOE, 1);
        ItemMeta meta4 = harvester4.getItemMeta();

        meta4.setDisplayName(ChatColor.GOLD + "Level 4 Harvester");
        meta4.setLore(Arrays.asList(ChatColor.GREEN + "Useful for mining spawners", ChatColor.YELLOW + "Effective range: Level 20", ChatColor.DARK_PURPLE + "Will break once used"));
        meta4.setUnbreakable(true);
        harvester4.setItemMeta(meta4);

        return harvester4;
    }
    public static ItemStack shopharvester4() {
        ItemStack shopharvester4 = new ItemStack(Material.GOLDEN_HOE, 1);
        ItemMeta meta4 = shopharvester4.getItemMeta();

        meta4.setDisplayName(ChatColor.GOLD + "Level 4 Harvester");
        meta4.setLore(Arrays.asList(ChatColor.GREEN + "Useful for mining spawners", ChatColor.YELLOW + "Effective range: Level 20", ChatColor.DARK_PURPLE + "Will break once used",
                "",ChatColor.GOLD+"Cost: "+ChatColor.GREEN+"300 Gems"));
        shopharvester4.setItemMeta(meta4);

        return shopharvester4;
    }
    public static ItemStack harvester5() {
        ItemStack harvester5 = new ItemStack(Material.GOLDEN_HOE, 1);
        ItemMeta meta5 = harvester5.getItemMeta();

        meta5.setDisplayName(ChatColor.GOLD + "Level 5 Harvester");
        meta5.setLore(Arrays.asList(ChatColor.GREEN + "Useful for mining spawners", ChatColor.YELLOW + "Effective range: Level 24", ChatColor.DARK_PURPLE + "Will break once used"));
        meta5.setUnbreakable(true);
        harvester5.setItemMeta(meta5);

        return harvester5;
    }
    public static ItemStack shopharvester5() {
        ItemStack shopharvester5 = new ItemStack(Material.GOLDEN_HOE, 1);
        ItemMeta meta5 = shopharvester5.getItemMeta();

        meta5.setDisplayName(ChatColor.GOLD + "Level 5 Harvester");
        meta5.setLore(Arrays.asList(ChatColor.GREEN + "Useful for mining spawners", ChatColor.YELLOW + "Effective range: Level 24", ChatColor.DARK_PURPLE + "Will break once used",
                "",ChatColor.GOLD+"Cost: "+ChatColor.BLUE+"8 Sapphire"));
        shopharvester5.setItemMeta(meta5);

        return shopharvester5;
    }
    public static ItemStack harvester6() {
        ItemStack harvester6 = new ItemStack(Material.TRIDENT, 1);
        ItemMeta meta6 = harvester6.getItemMeta();

        meta6.setDisplayName(ChatColor.GOLD + "Neptunes Trident");
        meta6.setLore(Arrays.asList(ChatColor.GREEN + "Useful for mining spawners", ChatColor.YELLOW + "Effective range: Level 25", ChatColor.DARK_PURPLE + "Will break once used"));
        meta6.setUnbreakable(true);
        harvester6.setItemMeta(meta6);

        return harvester6;
    }
    public static ItemStack shopharvester6() {
        ItemStack shopharvester6 = new ItemStack(Material.TRIDENT, 1);
        ItemMeta meta6 = shopharvester6.getItemMeta();

        meta6.setDisplayName(ChatColor.GOLD + "Neptunes Trident");
        meta6.setLore(Arrays.asList(ChatColor.GREEN + "Useful for mining spawners", ChatColor.YELLOW + "Effective range: Level 25", ChatColor.DARK_PURPLE + "Will break once used",
                "",ChatColor.GOLD+"Cost: "+ChatColor.BLUE+"512 Sapphire"));
        shopharvester6.setItemMeta(meta6);

        return shopharvester6;
    }
    public static void giveSpawner(Player p, EntityType e, Block b){

        CreatureSpawner cs = (CreatureSpawner) b.getState();
        ItemStack spawner_to_give = new ItemStack(Material.SPAWNER);
        BlockStateMeta meta = (BlockStateMeta) spawner_to_give.getItemMeta();
        assert meta != null;
        CreatureSpawner css = (CreatureSpawner) meta.getBlockState();


        if(cs.getSpawnedType().equals(EntityType.ZOMBIE)){

            meta.setDisplayName(ChatColor.DARK_GREEN + "Level 1");
            meta.setLore(Arrays.asList(ChatColor.GOLD + "Generates: 20 minutes Per" ,  ChatColor.GOLD + "Storage: 6 Gems" ,  ChatColor.GOLD + "Upgrade: 6 Gems"));

        }
        else if (cs.getSpawnedType().equals(EntityType.SKELETON)){

            meta.setDisplayName(ChatColor.DARK_GREEN + "Level 2");
            meta.setLore(Arrays.asList(ChatColor.GOLD +"Generates: 20 minutes Per" ,  ChatColor.GOLD + "Storage: 9 Gems" ,  ChatColor.GOLD + "Upgrade: 8 Gems"));

        }else if (cs.getSpawnedType().equals(EntityType.SPIDER)){

            meta.setDisplayName(ChatColor.DARK_GREEN + "Level 3");
            meta.setLore(Arrays.asList(ChatColor.GOLD +"Generates: 18 minutes Per" ,  ChatColor.GOLD + "Storage: 9 Gems" ,  ChatColor.GOLD + "Upgrade: 10 Gems"));

        }else if (cs.getSpawnedType().equals(EntityType.CAVE_SPIDER)){

            meta.setDisplayName(ChatColor.DARK_GREEN + "Level 4");
            meta.setLore(Arrays.asList(ChatColor.GOLD +"Generates: 18 minutes Per" ,  ChatColor.GOLD + "Storage: 15 Gems" ,  ChatColor.GOLD + "Upgrade: 14 Gems"));

        }else if (cs.getSpawnedType().equals(EntityType.BLAZE)){

            meta.setDisplayName(ChatColor.DARK_GREEN + "Level 5");
            meta.setLore(Arrays.asList(ChatColor.GOLD +"Generates: 15 minutes Per" ,  ChatColor.GOLD + "Storage: 15 Gems" ,  ChatColor.GOLD + "Upgrade: 16 Gems"));

        }else if (cs.getSpawnedType().equals(EntityType.MAGMA_CUBE)){

            meta.setDisplayName(ChatColor.YELLOW + "Level 6");
            meta.setLore(Arrays.asList(ChatColor.GOLD + "Generates: 15 minutes Per" ,  ChatColor.GOLD + "Storage: 27 Gems" ,  ChatColor.GOLD + "Upgrade: 18 Gems"));

        }else if (cs.getSpawnedType().equals(EntityType.SILVERFISH)){

            meta.setDisplayName(ChatColor.YELLOW + "Level 7");
            meta.setLore(Arrays.asList(ChatColor.GOLD +"Generates: 12 Minutes Per" ,  ChatColor.GOLD + "Storage: 27 Gems" ,  ChatColor.GOLD + "Upgrade: 20 Gems"));

        }else if (cs.getSpawnedType().equals(EntityType.CHICKEN)){

            meta.setDisplayName(ChatColor.YELLOW + "Level 8");
            meta.setLore(Arrays.asList(ChatColor.GOLD +"Generates: 12 Minutes Per" ,  ChatColor.GOLD + "Storage: 36 Gems" ,  ChatColor.GOLD + "Upgrade: 24 Gems"));

        }else if (cs.getSpawnedType().equals(EntityType.PIG)){

            meta.setDisplayName(ChatColor.YELLOW + "Level 9");
            meta.setLore(Arrays.asList(ChatColor.GOLD +"Generates: 10 Minutes Per" ,  ChatColor.GOLD + "Storage: 36 Gems" ,  ChatColor.GOLD + "Upgrade: 32 Gems"));

        }else if (cs.getSpawnedType().equals(EntityType.SHEEP)){

            meta.setDisplayName(ChatColor.YELLOW + "Level 10");
            meta.setLore(Arrays.asList(ChatColor.GOLD +"Generates: 10 Minutes Per" ,  ChatColor.GOLD + "Storage: 48 Gems" ,  ChatColor.GOLD + "Upgrade: 40 Gems"));

        }else if (cs.getSpawnedType().equals(EntityType.COW)){

            meta.setDisplayName(ChatColor.AQUA + "Level 11");
            meta.setLore(Arrays.asList(ChatColor.GOLD +"Generates: 8 Minutes Per" ,  ChatColor.GOLD + "Storage: 48 Gems" ,  ChatColor.GOLD + "Upgrade: 56 Gems"));

        }else if (cs.getSpawnedType().equals(EntityType.MUSHROOM_COW)){

            meta.setDisplayName(ChatColor.AQUA + "Level 12");
            meta.setLore(Arrays.asList(ChatColor.GOLD +"Generates: 8 Minutes Per" ,  ChatColor.GOLD + "Storage: 54 Gems" ,  ChatColor.GOLD + "Upgrade: 64 Gems"));

        }else if (cs.getSpawnedType().equals(EntityType.HORSE)){

            meta.setDisplayName(ChatColor.AQUA + "Level 13");
            meta.setLore(Arrays.asList(ChatColor.GOLD +"Generates: 7 Minutes Per" ,  ChatColor.GOLD + "Storage: 54 Gems" ,  ChatColor.GOLD + "Upgrade: 96 Gems"));

        }else if (cs.getSpawnedType().equals(EntityType.LLAMA)){

            meta.setDisplayName(ChatColor.AQUA + "Level 14");
            meta.setLore(Arrays.asList(ChatColor.GOLD +"Generates: 6 Minutes Per" ,  ChatColor.GOLD + "Storage: 72 Gems" ,  ChatColor.GOLD + "Upgrade: 128 Gems"));

        }else if (cs.getSpawnedType().equals(EntityType.OCELOT)){

            meta.setDisplayName(ChatColor.AQUA + "Level 15");
            meta.setLore(Arrays.asList(ChatColor.GOLD +"Generates: 5 Minutes Per" ,  ChatColor.GOLD + "Storage: 72 Gems" ,  ChatColor.GOLD + "Upgrade: 196 Gems"));

        }else if (cs.getSpawnedType().equals(EntityType.PANDA)){

            meta.setDisplayName(ChatColor.DARK_RED + "Level 16");
            meta.setLore(Arrays.asList(ChatColor.GOLD +"Generates: 4 Minutes Per" ,  ChatColor.GOLD + "Storage: 84 Gems" ,  ChatColor.GOLD + "Upgrade: 336 Gems"));

        }else if (cs.getSpawnedType().equals(EntityType.WOLF)){

            meta.setDisplayName(ChatColor.DARK_RED + "Level 17");
            meta.setLore(Arrays.asList(ChatColor.GOLD +"Generates: 3 minutes Per" ,  ChatColor.GOLD + "Storage: 96 Gems" ,  ChatColor.GOLD +"Upgrade: 512 Gems"));

        }else if (cs.getSpawnedType().equals(EntityType.PIGLIN)){

            meta.setDisplayName(ChatColor.DARK_RED + "Level 18");
            meta.setLore(Arrays.asList(ChatColor.GOLD +"Generates: 2 Minutes Per" ,  ChatColor.GOLD + "Storage: 128 Gems" ,  ChatColor.GOLD + "Upgrade: 1156 Gems"));

        }else if (cs.getSpawnedType().equals(EntityType.BAT)){

            meta.setDisplayName(ChatColor.DARK_RED + "Level 19");
            meta.setLore(Arrays.asList(ChatColor.GOLD +"Generates: 60 Seconds Per" ,  ChatColor.GOLD + "Storage: 160 Gems",  ChatColor.GOLD +"Upgrade: 2240 Gems"));

        }else if (cs.getSpawnedType().equals(EntityType.IRON_GOLEM)){

            meta.setDisplayName(ChatColor.DARK_RED + "Level 20");
            meta.setLore(Arrays.asList(ChatColor.GOLD +"Generates: 45 Seconds per" ,  ChatColor.GOLD + "Storage: 192 Gems ",
                    ChatColor.GOLD + "Upgrade: " + ChatColor.MAGIC + "" + ChatColor.GOLD + "4" + ChatColor.GOLD + " Sapphires"));

        }else if (cs.getSpawnedType().equals(EntityType.WITHER_SKELETON)){

            meta.setDisplayName(ChatColor.BLUE + "Level 21 ");
            meta.setLore(Arrays.asList(ChatColor.DARK_PURPLE +"Generates: 20 hours per" ,  ChatColor.DARK_PURPLE + "Storage: 1 Sapphire " ,  ChatColor.DARK_PURPLE + "Upgrade: 16 Sapphires"));

        }else if (cs.getSpawnedType().equals(EntityType.ENDERMAN)){

            meta.setDisplayName(ChatColor.BLUE + "Level 22");
            meta.setLore(Arrays.asList(ChatColor.DARK_PURPLE +"Generates: 16 hours per" ,  ChatColor.DARK_PURPLE + "Storage: 2 Sapphires " ,  ChatColor.DARK_PURPLE + "Upgrade: 64 Sapphires"));

        }else if (cs.getSpawnedType().equals(EntityType.ELDER_GUARDIAN)){

            meta.setDisplayName(ChatColor.BLUE + "Level 23");
            meta.setLore(Arrays.asList(ChatColor.DARK_PURPLE +"Generates: 10 hours per" ,  ChatColor.DARK_PURPLE + "Storage: 4 Sapphires " ,  ChatColor.DARK_PURPLE + "Upgrade: 256 Sapphires"));

        }else if (cs.getSpawnedType().equals(EntityType.WITHER)){

            meta.setDisplayName(ChatColor.BLUE + "Level 24");
            meta.setLore(Arrays.asList(ChatColor.DARK_PURPLE +"Generates: 5 hours per" ,  ChatColor.DARK_PURPLE + "Storage: 8 Sapphires " ,  ChatColor.DARK_PURPLE + "Upgrade: 2240 Sapphires"));

        }else if (cs.getSpawnedType().equals(EntityType.ENDER_DRAGON)){

            meta.setDisplayName(ChatColor.BLUE + "Level 25");
            meta.setLore(Arrays.asList(ChatColor.DARK_PURPLE +"Generates: 1 hour per" ,  ChatColor.DARK_PURPLE + "Storage: 24 Sapphires" ));

        }else{

            meta.setDisplayName(ChatColor.GREEN + "level " + ChatColor.MAGIC + "420 ");
            meta.setLore(Arrays.asList("Generates: unlimited " ,  ChatColor.GOLD + "Storage: unlimited " ,  ChatColor.GOLD + "Upgrade: unlimited" ," ", ChatColor.WHITE + "how did you get this..."));

        }

        /* Checks if player's inventory is full of gems. If so, spawner will drop.
            Only needed for maxing spawners, iron golem/enderdragon.
            0 = false / 1 = true
            */

        css.setSpawnedType(e);
        meta.setBlockState(css);
        spawner_to_give.setItemMeta(meta);

        if(Objects.requireNonNull(p.getPlayer()).getInventory().firstEmpty() == -1){

            p.getWorld().dropItemNaturally(p.getLocation(),spawner_to_give);

        }else{
            p.getInventory().addItem(spawner_to_give);
        }
    }
}