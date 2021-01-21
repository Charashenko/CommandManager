package me.charashenko.commandmanager.testcommands.groups.subcommands;

import me.charashenko.commandmanager.argumenttypes.Option;
import me.charashenko.commandmanager.argumenttypes.SubCommand;
import org.bukkit.command.CommandSender;

import java.util.List;

public class AddPlayer extends SubCommand {

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
