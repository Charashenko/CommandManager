package me.charashenko.commandmanager;

import me.charashenko.commandmanager.testcommands.players.subcommands.Player;
import me.charashenko.commandmanager.typesofarguments.Option;
import me.charashenko.commandmanager.typesofarguments.SubCommand;
import me.charashenko.commandmanager.testcommands.ReloadPermissions;
import me.charashenko.commandmanager.testcommands.ShowPermissionGroupsInfo;
import me.charashenko.commandmanager.testcommands.groups.subcommands.Group;
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
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length > 0) {
            SubCommand cmd = getCommand(subCommands, args, 0, sender);
            if (cmd != null) {
                cmd.execute(sender, args);
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

    private SubCommand getCommand(List<SubCommand> subCommands, String[] args, int argIndex, CommandSender sender) { //get instance of command

        for (SubCommand subCommand : subCommands) {
            if (subCommand.getName().equalsIgnoreCase(args[argIndex])) {
                if (subCommand.hasSubCommands()) {
                    if (args.length > argIndex + 1) {
                        getCommand(subCommand.getSubCommands(), args, argIndex + 1, sender);
                    } else {
                        for (String msg : subCommand.getTabSuggestions()) { // Tells player next subcommands for current subcommand
                            sender.sendMessage(msg);
                        }
                    }
                } else if (subCommand.hasOptions()) {
                    if (args.length > argIndex + 1) {
                        for (Option opt : subCommand.getOptions()) {
                            if (opt.getValidOptions().contains(args[argIndex + 1].toLowerCase())) {
                                if (opt.hasSubCommands()) {
                                    if (args.length > argIndex + 2) {
                                        getCommand(opt.getSubCommands(), args, argIndex + 2, sender);
                                    } else { // Tells player next subcommands for current subcommand
                                        for (SubCommand cmd : opt.getSubCommands()) {
                                            sender.sendMessage(cmd.getName());
                                        }
                                    }
                                }
                            }
                        }
                    } else { // Tells player all available options for subcommand
                        for (Option opt : subCommand.getOptions()) {
                            sender.sendMessage(opt.getSyntax());
                        }
                    }
                } else {
                    return subCommand;
                }
            }
        }
        return null;
    }

}
