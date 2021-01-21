package me.charashenko.commandmanager.commands.groups;

import me.charashenko.commandmanager.typesofarguments.Option;
import me.charashenko.commandmanager.typesofarguments.SubCommand;
import me.charashenko.commandmanager.commands.groups.subcommands.AddPlayer;
import me.charashenko.commandmanager.commands.groups.subcommands.RmPlayer;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroupName extends Option {

    private List<SubCommand> subCommands;

    public GroupName() {
        subCommands = new ArrayList<>();
        subCommands.add(new AddPlayer());
        subCommands.add(new RmPlayer());
    }

    @Override
    public String getName() {
        return "groupname";
    }

    @Override
    public String getSyntax() {
        return "/perm group <groupname> <action>";
    }

    @Override
    public Boolean hasSubCommands() {
        return true;
    }

    @Override
    public List<String> getTabSuggestions() {
        return Arrays.asList("Owner", "Admin", "Player");
    }

    @Override
    public List<String> getValidOptions() {
        return Arrays.asList("owner", "admin", "player");
    }

    @Override
    public List<SubCommand> getSubCommands() {
        return subCommands;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        sender.sendMessage(getSyntax());
        sender.sendMessage("Actions:");
        for (SubCommand subCommand : subCommands) {
            sender.sendMessage(subCommand.getName());
        }
    }
}
