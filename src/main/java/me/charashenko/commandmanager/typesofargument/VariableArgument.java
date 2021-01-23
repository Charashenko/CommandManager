package me.charashenko.commandmanager.typesofargument;

import org.bukkit.command.CommandSender;

import java.util.List;

public abstract class VariableArgument {

    public abstract String getSyntax();

    public abstract String neededPermission();

    public abstract boolean isPermissionOnly();

    public abstract boolean hasSubCommands();

    public abstract List<String> getTabSuggestions();

    public abstract List<String> getValidArguments();

    public abstract List<SubCommand> getSubCommands();

    public abstract void execute(CommandSender sender, String[] args);

}
