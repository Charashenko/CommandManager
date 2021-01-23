package me.charashenko.commandmanager.commands.endargs;

import me.charashenko.commandmanager.typesofargument.EndArgument;
import org.bukkit.command.CommandSender;

public class PlayerName extends EndArgument {

    @Override
    public String getSyntax() {
        return "/perm group <groupname> addplayer/rmplayer <playername>";
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args[args.length - 2].equalsIgnoreCase("addplayer")) {
            sender.sendMessage("Player " + args[args.length - 1] + " added");
        } else if (args[args.length - 2].equalsIgnoreCase("rmplayer")) {
            sender.sendMessage("Player " + args[args.length - 1] + " removed");
        }
    }
}
