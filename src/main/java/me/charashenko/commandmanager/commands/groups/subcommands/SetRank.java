package me.charashenko.commandmanager.commands.groups.subcommands;

import me.charashenko.commandmanager.commands.endargs.Rank;
import me.charashenko.commandmanager.typesofargument.EndArgument;
import me.charashenko.commandmanager.typesofargument.SubCommand;
import me.charashenko.commandmanager.typesofargument.VariableArgument;
import org.bukkit.command.CommandSender;

import java.util.Collections;
import java.util.List;

public class SetRank extends SubCommand {

    private EndArgument endArgument;

    public SetRank() {
        endArgument = new Rank();
    }

    @Override
    public String getName() {
        return "setrank";
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String getSyntax() {
        return "/perm group <groupname> setrank <rank>";
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
        return false;
    }

    @Override
    public boolean hasEndArgument() {
        return true;
    }

    @Override
    public VariableArgument getVariableArgument() {
        return null;
    }

    @Override
    public EndArgument getEndArgument() {
        return endArgument;
    }

    @Override
    public List<String> getTabSuggestions() {
        return Collections.singletonList("<number>");
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
