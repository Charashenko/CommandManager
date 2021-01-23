package me.charashenko.commandmanager.typesofargument;

import org.bukkit.command.CommandSender;

import java.util.List;

public abstract class SubCommand {

    public abstract String getName();

    public abstract String getDescription();

    public abstract String getSyntax();

    public abstract String neededPermission();

    public abstract boolean isPermissionOnly();

    public abstract boolean hasSubCommands();

    public abstract boolean hasVariableArgument();

    public abstract boolean hasEndArgument();

    public abstract VariableArgument getVariableArgument();

    public abstract EndArgument getEndArgument();

    public abstract List<String> getTabSuggestions();

    public abstract List<SubCommand> getSubCommands();

    public abstract void execute(CommandSender sender, String[] args);

}
