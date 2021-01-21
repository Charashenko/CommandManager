package me.charashenko.commandmanager.testcommands.groups.subcommands;

import me.charashenko.commandmanager.argumenttypes.Option;
import me.charashenko.commandmanager.argumenttypes.SubCommand;
import me.charashenko.commandmanager.testcommands.groups.options.GroupName;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Group extends SubCommand {

    private List<Option> options;

    public Group() {
        options = new ArrayList<>();
        options.add(new GroupName());
    }

    @Override
    public String getName() {
        return "group";
    }

    @Override
    public String getDescription() {
        return "/perm group";
    }

    @Override
    public String getSyntax() {
        return null;
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
    public List<String> getTabSuggestions() {
        return Collections.singletonList("group");
    }

    @Override
    public List<Option> getOptions() {
        return options;
    }

    @Override
    public List<SubCommand> getSubCommands() {
        return null;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(sender instanceof Player) {
            sender.sendMessage(getDescription());
        }
    }
}
