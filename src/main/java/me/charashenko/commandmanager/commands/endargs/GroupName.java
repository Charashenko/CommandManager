package me.charashenko.commandmanager.commands.endargs;

import me.charashenko.commandmanager.typesofarguments.EndArgument;
import org.bukkit.command.CommandSender;

public class GroupName extends EndArgument {

    @Override
    public String getSyntax() {
        return "/perm player <playername> addgroup/rmgroup <groupname>";
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args[args.length - 2].equalsIgnoreCase("addgroup")) {
            sender.sendMessage("Group " + args[args.length - 1] + " added");
        } else if (args[args.length - 2].equalsIgnoreCase("rmgroup")) {
            sender.sendMessage("Group " + args[args.length - 1] + " removed");
        }
    }
}
