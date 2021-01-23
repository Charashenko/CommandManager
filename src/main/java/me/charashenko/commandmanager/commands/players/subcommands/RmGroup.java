package me.charashenko.commandmanager.commands.players.subcommands;

import me.charashenko.commandmanager.commands.endargs.GroupName;
import me.charashenko.commandmanager.typesofargument.EndArgument;
import me.charashenko.commandmanager.typesofargument.VariableArgument;
import me.charashenko.commandmanager.typesofargument.SubCommand;
import org.bukkit.command.CommandSender;

import java.util.List;

public class RmGroup extends SubCommand {

    private EndArgument endArgument;

    public RmGroup() {
        endArgument = new GroupName();
    }

    @Override
    public String getName() {
        return "rmgroup";
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String getSyntax() {
        return "/perm player <playername> rmgroup <groupname>";
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
        return null;
    }

    @Override
    public List<SubCommand> getSubCommands() {
        return null;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {

    }
}
