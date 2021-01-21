package me.charashenko.commandmanager.typesofarguments;

import org.bukkit.command.CommandSender;

import java.util.List;

public abstract class SubCommand {

    public abstract String getName();

    public abstract String getDescription();

    public abstract String getSyntax();

    public abstract Boolean isConsoleOnly();

    public abstract Boolean hasSubCommands();

    public abstract Boolean hasOptions();

    public abstract Boolean hasEndArgument();

    public abstract EndArgument getEndArgument();

    public abstract List<String> getTabSuggestions();

    public abstract List<Option> getOptions();

    public abstract List<SubCommand> getSubCommands();

    public abstract void execute(CommandSender sender, String[] args);

}
