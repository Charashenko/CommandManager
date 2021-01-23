package me.charashenko.commandmanager.commands.groups.subcommands.variableargument;

import me.charashenko.commandmanager.typesofargument.VariableArgument;
import me.charashenko.commandmanager.typesofargument.SubCommand;
import me.charashenko.commandmanager.commands.groups.subcommands.AddPlayer;
import me.charashenko.commandmanager.commands.groups.subcommands.RmPlayer;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroupNames extends VariableArgument {

    private List<SubCommand> subCommands;

    public GroupNames() {
        subCommands = new ArrayList<>();
        subCommands.add(new AddPlayer());
        subCommands.add(new RmPlayer());
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
        List<String> subCmdNames = new ArrayList<>();
        for (SubCommand subCommand : subCommands) {
            subCmdNames.add(subCommand.getName());
        }
        return subCmdNames;
    }

    @Override
    public List<String> getValidArguments() {
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
