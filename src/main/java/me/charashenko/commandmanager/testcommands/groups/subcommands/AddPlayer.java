package me.charashenko.commandmanager.testcommands.groups.subcommands;

import me.charashenko.commandmanager.testcommands.endargs.PlayerName;
import me.charashenko.commandmanager.typesofarguments.EndArgument;
import me.charashenko.commandmanager.typesofarguments.Option;
import me.charashenko.commandmanager.typesofarguments.SubCommand;
import org.bukkit.command.CommandSender;

import java.util.List;

public class AddPlayer extends SubCommand {

    private EndArgument endArgument;

    public AddPlayer() {
        endArgument = new PlayerName();
    }

    @Override
    public String getName() {
        return "addplayer";
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String getSyntax() {
        return "/perm group <groupname> addplayer <playername>";
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
        return false;
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
        sender.sendMessage(getSyntax());
    }

}
