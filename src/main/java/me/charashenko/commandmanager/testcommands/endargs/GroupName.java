package me.charashenko.commandmanager.testcommands.endargs;

import me.charashenko.commandmanager.typesofarguments.EndArgument;
import org.bukkit.command.CommandSender;

public class GroupName extends EndArgument {

    @Override
    public String getName() {
        return "groupname";
    }

    @Override
    public String getSyntax() {
        return "/perm player <playername> addgroup/rmgroup <groupname>";
    }

    @Override
    public Boolean isConsoleOnly() {
        return false;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {

    }
}
