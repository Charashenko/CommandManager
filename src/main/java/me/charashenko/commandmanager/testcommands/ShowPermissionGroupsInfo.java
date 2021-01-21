package me.charashenko.commandmanager.testcommands;

import me.charashenko.commandmanager.typesofarguments.Option;
import me.charashenko.commandmanager.typesofarguments.SubCommand;
import org.bukkit.command.CommandSender;

import java.util.List;

public class ShowPermissionGroupsInfo extends SubCommand {

    @Override
    public String getName() {
        return "showgroups";
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String getSyntax() {
        return "/perm showgroups";
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
