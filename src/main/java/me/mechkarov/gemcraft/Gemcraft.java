package me.mechkarov.gemcraft;

import me.mechkarov.gemcraft.Commands.*;
import me.mechkarov.gemcraft.Listeners.*;
/*import me.mechkarov.gemcraft.Listeners.CustomRecipes.Armor.GodBoots;
import me.mechkarov.gemcraft.Listeners.CustomRecipes.Armor.GodChestplate;
import me.mechkarov.gemcraft.Listeners.CustomRecipes.Armor.GodHelmet;
import me.mechkarov.gemcraft.Listeners.CustomRecipes.Armor.GodLeggings;
import me.mechkarov.gemcraft.Listeners.CustomRecipes.Talismans.RegenerationTalisman;
import me.mechkarov.gemcraft.Listeners.CustomRecipes.Weapons.Excalibur;*/
import me.mechkarov.gemcraft.Listeners.Portals;
import me.mechkarov.gemcraft.Listeners.Tools.*;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.event.Listener;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class Gemcraft extends JavaPlugin implements Listener {

    private static Economy econ = null;

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Plugin is started");

        if (!setupEconomy() ) {
            System.out.println("No economy plugin found. Disabling Vault.");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        getServer().getPluginManager().registerEvents(this, this);

        //Listeners
        getServer().getPluginManager().registerEvents(new SpawnerUpgradeListener(this), this);
        getServer().getPluginManager().registerEvents(new SpawnerPlaceListener(), this);
        getServer().getPluginManager().registerEvents(new GemCollectListener(this), this);
        getServer().getPluginManager().registerEvents(new Items(), this);
        getServer().getPluginManager().registerEvents(new Raidshop(), this);
        //getServer().getPluginManager().registerEvents(new Merchant(), this);
        //getServer().getPluginManager().registerEvents(new CustomRecipes(), this);

        getServer().getPluginManager().registerEvents(new Portals(this), this);

        //RaidTools
        getServer().getPluginManager().registerEvents(new BlockPlacer(this), this);
        getServer().getPluginManager().registerEvents(new BlockBreaker(this), this);
        getServer().getPluginManager().registerEvents(new WarpSign(this), this);
        getServer().getPluginManager().registerEvents(new Harvesters(), this);
        getServer().getPluginManager().registerEvents(new DoorBreaker(), this);
        getServer().getPluginManager().registerEvents(new LockPick(), this);

        //Commands
        Objects.requireNonNull(getCommand("raidshop")).setExecutor(new Raidshop());
        //Objects.requireNonNull(getCommand("merchant")).setExecutor(new Merchant());
        //Objects.requireNonNull(getCommand("customrecipes")).setExecutor(new CustomRecipes());
        Objects.requireNonNull(getCommand("freegems")).setExecutor(new FreeGems());
        Objects.requireNonNull(getCommand("freesapphire")).setExecutor(new FreeSapphire());
        //Objects.requireNonNull(getCommand("activationbedrock")).setExecutor(new ActivationBedrock());
        //Objects.requireNonNull(getCommand("deactivationbedrock")).setExecutor(new DeactivationBedrock());

        //CustomRecipes
        /*getServer().getPluginManager().registerEvents(new Excalibur(this), this);
        getServer().addRecipe(new Excalibur(this).getExcalibur());

        getServer().getPluginManager().registerEvents(new GodHelmet(this), this);
        getServer().addRecipe(new GodHelmet(this).getGodhelmet());

        getServer().getPluginManager().registerEvents(new GodChestplate(this), this);
        getServer().addRecipe(new GodChestplate(this).getGodchestplate());

        getServer().getPluginManager().registerEvents(new GodLeggings(this), this);
        getServer().addRecipe(new GodLeggings(this).getGodleggings());

        getServer().getPluginManager().registerEvents(new GodBoots(this), this);
        getServer().addRecipe(new GodBoots(this).getGodboots());*/


            //Talismans
            //getServer().getPluginManager().registerEvents(new RegenerationTalisman(this), this);
            //getServer().addRecipe(new RegenerationTalisman(this).getRegenerationTalisman());

    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }

    public static Economy getEconomy() {
        return econ;
    }
}










