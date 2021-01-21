package me.charashenko.commandmanager.typesofarguments;

import org.bukkit.command.CommandSender;

import java.util.List;

public abstract class Option {

    public abstract String getName();

    public abstract String getSyntax();

    public abstract Boolean hasSubCommands();

    public abstract List<String> getTabSuggestions();

    public abstract List<String> getValidOptions();

    public abstract List<SubCommand> getSubCommands();

    public abstract void execute(CommandSender sender, String[] args);

}
