package me.charashenko.commandmanager;

import me.charashenko.commandmanager.commands.Help;
import me.charashenko.commandmanager.commands.players.subcommands.Player;
import me.charashenko.commandmanager.typesofargument.EndArgument;
import me.charashenko.commandmanager.typesofargument.VariableArgument;
import me.charashenko.commandmanager.typesofargument.SubCommand;
import me.charashenko.commandmanager.commands.ReloadPermissions;
import me.charashenko.commandmanager.commands.ShowPermissionGroupsInfo;
import me.charashenko.commandmanager.commands.groups.subcommands.Group;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Manager implements TabExecutor {

    private List<SubCommand> subCommands;

    public Manager() {
        subCommands = new ArrayList<>();
        subCommands.add(new Group());
        subCommands.add(new ReloadPermissions());
        subCommands.add(new ShowPermissionGroupsInfo());
        subCommands.add(new Player());
        subCommands.add(new Help());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length > 0) {
            Object cmd = getCommand(subCommands, args, 0);
            if (cmd instanceof SubCommand) {
                ((SubCommand) cmd).execute(sender, args);
            } else if (cmd instanceof VariableArgument) {
                ((VariableArgument) cmd).execute(sender, args);
            } else if (cmd instanceof EndArgument) {
                ((EndArgument) cmd).execute(sender, args);
            }
        } else {
            return false;
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {

        if (args.length > 1) {
            Object cmd;
            try {
                cmd = getCommand(subCommands, Arrays.copyOf(args, args.length - 1), 0);
                if (cmd instanceof SubCommand) {
                    return ((SubCommand) cmd).getTabSuggestions();
                } else if (cmd instanceof VariableArgument) {
                    return ((VariableArgument) cmd).getTabSuggestions();
                } else {
                    return null;
                }
            } catch (NullPointerException exception) {
                exception.printStackTrace();
            }
        } else {   // Suggests all subcommands of main command
            List<String> subCmdsNames = new ArrayList<>();
            for (SubCommand subCommand : subCommands) {
                subCmdsNames.add(subCommand.getName());
            }
            return subCmdsNames;
        }
        return null;

    }

    private Object getCommand(List<SubCommand> subCommands, String[] args, int argIndex) { //get instance of command

        for (SubCommand subCommand : subCommands) {
            if (subCommand.getName().equalsIgnoreCase(args[argIndex])) {
                if (subCommand.hasSubCommands()) {
                    if (args.length > argIndex + 1) { // Checks if user finished the command
                        return getCommand(subCommand.getSubCommands(), args, argIndex + 1);
                    }
                } else if (subCommand.hasVariableArgument()) {
                    if (args.length > argIndex + 1) { // Checks if user has finished the command
                        VariableArgument variableArgument = subCommand.getVariableArgument();
                        if (variableArgument.getValidArguments().contains((args[argIndex + 1].toLowerCase()))) {
                            if (variableArgument.hasSubCommands()) {
                                if (args.length > argIndex + 2) { // Checks if user has finished the command
                                    return getCommand(variableArgument.getSubCommands(), args, argIndex + 2);
                                } else {
                                    return variableArgument;
                                }
                            }
                        }
                    }
                } else if (subCommand.hasEndArgument()) {
                    if (args.length > argIndex + 1) {
                        return subCommand.getEndArgument();
                    }
                }
                return subCommand;
            }
        }
        return null;

    }

}
