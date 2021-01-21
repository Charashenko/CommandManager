package me.charashenko.commandmanager.typesofarguments;

import org.bukkit.command.CommandSender;

public abstract class EndArgument {

    public abstract String getName();

    public abstract String getSyntax();

    public abstract Boolean isConsoleOnly();

    public abstract void execute(CommandSender sender, String[] args);

}
