package me.charashenko.commandmanager;

import me.charashenko.commandmanager.commands.Help;
import me.charashenko.commandmanager.commands.players.subcommands.Player;
import me.charashenko.commandmanager.typesofarguments.EndArgument;
import me.charashenko.commandmanager.typesofarguments.Option;
import me.charashenko.commandmanager.typesofarguments.SubCommand;
import me.charashenko.commandmanager.commands.ReloadPermissions;
import me.charashenko.commandmanager.commands.ShowPermissionGroupsInfo;
import me.charashenko.commandmanager.commands.groups.subcommands.Group;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

import java.util.ArrayList;
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
            Object cmd;
            try {
                cmd = getCommand(subCommands, args, 0, sender);
                if (cmd instanceof SubCommand) {
                    ((SubCommand) cmd).execute(sender, args);
                } else if (cmd instanceof EndArgument) {
                    ((EndArgument) cmd).execute(sender, args);
                }
            } catch (NullPointerException exception) {
                exception.printStackTrace();
            }
        } else {
            sender.sendMessage("Options of /perm:");
            for (SubCommand cmd : subCommands) {
                sender.sendMessage(cmd.getName());
            }
        }

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {

        return loopThroughCmdChainSuggestions(subCommands, sender, args);

    }

    private List<String> loopThroughCmdChainSuggestions(List<SubCommand> subCommands, CommandSender sender, String[] args) {

        if (args.length > 1) {
            //TODO Add Tab Completion for subcommands
        } else {   // Suggests all subcommands of main command
            List<String> subCmdsNames = new ArrayList<>();
            for (SubCommand subCommand : subCommands) {
                subCmdsNames.add(subCommand.getName());
            }
            return subCmdsNames;
        }
        return null;

    }

    private Object getCommand(List<SubCommand> subCommands, String[] args, int argIndex, CommandSender sender) { //get instance of command

        for (SubCommand subCommand : subCommands) {
            if (subCommand.getName().equalsIgnoreCase(args[argIndex])) {
                if (subCommand.hasSubCommands()) {
                    if (args.length > argIndex + 1) {
                        getCommand(subCommand.getSubCommands(), args, argIndex + 1, sender);
                    } else {
                        subCommand.execute(sender, args);
                        // Execute current command even if it's not completed
                        // syntax warning is inside this command's execute function
                    }
                } else if (subCommand.hasOptions()) {
                    if (args.length > argIndex + 1) {
                        for (Option opt : subCommand.getOptions()) {
                            if (opt.getValidOptions().contains(args[argIndex + 1])) {
                                if (opt.hasSubCommands()) {
                                    if (args.length > argIndex + 2) {
                                        getCommand(opt.getSubCommands(), args, argIndex + 2, sender);
                                    } else {
                                        opt.execute(sender, args);
                                        // Execute current command even if it's not completed
                                        // syntax warning is inside this command's execute function
                                    }
                                }
                            }
                        }
                    } else {
                        subCommand.execute(sender, args);
                        // Execute current command even if it's not completed
                        // syntax warning is inside this command's execute function
                    }
                } else if (subCommand.hasEndArgument()) {
                    if (args.length > argIndex + 1) {
                        subCommand.getEndArgument().execute(sender, args);
                        return subCommand.getEndArgument();
                    } else {
                        subCommand.execute(sender, args);
                        // Execute current command even if it's not completed
                        // syntax warning is inside this command's execute function
                    }
                } else {
                    return subCommand;
                }
            }
        }
        return null;
    }

}
