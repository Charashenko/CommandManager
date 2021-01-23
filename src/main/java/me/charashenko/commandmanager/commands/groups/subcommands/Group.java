package me.charashenko.commandmanager.commands.groups.subcommands;

import me.charashenko.commandmanager.typesofargument.EndArgument;
import me.charashenko.commandmanager.typesofargument.VariableArgument;
import me.charashenko.commandmanager.typesofargument.SubCommand;
import me.charashenko.commandmanager.commands.groups.subcommands.variableargument.GroupNames;
import org.bukkit.command.CommandSender;

import java.util.List;

public class Group extends SubCommand {

    private VariableArgument variableArgument;

    public Group() {
        variableArgument = new GroupNames();
    }

    @Override
    public String getName() {
        return "group";
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String getSyntax() {
        return "/perm group <groupname>";
    }

    @Override
    public String neededPermission() {
        return null;
    }

    @Override
    public boolean isPermissionOnly() {
        return false;
    }

    @Override
    public boolean hasSubCommands() {
        return false;
    }

    @Override
    public boolean hasVariableArgument() {
        return true;
    }

    @Override
    public boolean hasEndArgument() {
        return false;
    }

    @Override
    public VariableArgument getVariableArgument() {
        return variableArgument;
    }

    @Override
    public EndArgument getEndArgument() {
        return null;
    }

    @Override
    public List<String> getTabSuggestions() {
        return variableArgument.getValidArguments();
    }

    @Override
    public List<SubCommand> getSubCommands() {
        return null;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        sender.sendMessage(getSyntax());
    }
}
