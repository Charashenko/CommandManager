package me.charashenko.commandmanager.typesofargument;

import org.bukkit.command.CommandSender;

public abstract class EndArgument {

    public abstract String getSyntax();

    public abstract String neededPermission();

    public abstract boolean isPermissionOnly();

    public abstract void execute(CommandSender sender, String[] args);

}
