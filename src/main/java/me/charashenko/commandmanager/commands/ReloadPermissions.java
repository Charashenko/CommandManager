package me.charashenko.commandmanager.commands;

import me.charashenko.commandmanager.typesofargument.EndArgument;
import me.charashenko.commandmanager.typesofargument.VariableArgument;
import me.charashenko.commandmanager.typesofargument.SubCommand;
import org.bukkit.command.CommandSender;

import java.util.List;

public class ReloadPermissions extends SubCommand {

    @Override
    public String getName() {
        return "reload";
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String getSyntax() {
        return "Execute /perm reload";
    }

    @Override
    public Boolean hasSubCommands() {
        return false;
    }

    @Override
    public Boolean hasVariableArgument() {
        return false;
    }

    @Override
    public Boolean hasEndArgument() {
        return false;
    }

    @Override
    public VariableArgument getVariableArgument() {
        return null;
    }

    @Override
    public EndArgument getEndArgument() {
        return null;
    }

    @Override
    public List<String> getTabSuggestions() {
        return null;
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
