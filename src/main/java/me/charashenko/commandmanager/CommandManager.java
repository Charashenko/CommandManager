package me.charashenko.commandmanager;

import org.bukkit.plugin.java.JavaPlugin;

public final class CommandManager extends JavaPlugin {

    @Override
    public void onEnable() {

        getCommand("perm").setExecutor(new Manager());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


}
