package me.charashenko.commandmanager.testcommands.players.subcommands;

import me.charashenko.commandmanager.testcommands.endargs.GroupName;
import me.charashenko.commandmanager.typesofarguments.EndArgument;
import me.charashenko.commandmanager.typesofarguments.Option;
import me.charashenko.commandmanager.typesofarguments.SubCommand;
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
    public Boolean isConsoleOnly() {
        return false;
    }

    @Override
    public Boolean hasSubCommands() {
        return false;
    }

    @Override
    public Boolean hasOptions() {
        return true;
    }

    @Override
    public Boolean hasEndArgument() {
        return true;
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
    public List<Option> getOptions() {
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
