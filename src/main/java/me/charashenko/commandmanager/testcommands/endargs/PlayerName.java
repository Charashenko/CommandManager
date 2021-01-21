package me.charashenko.commandmanager.testcommands.endargs;

import me.charashenko.commandmanager.typesofarguments.EndArgument;
import org.bukkit.command.CommandSender;

public class PlayerName extends EndArgument {

    @Override
    public String getName() {
        return "playername";
    }

    @Override
    public String getSyntax() {
        return "/perm group <groupname> addplayer/rmplayer <playername>";
    }

    @Override
    public Boolean isConsoleOnly() {
        return null;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {

    }
}
