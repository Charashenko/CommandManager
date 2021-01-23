package me.charashenko.commandmanager.commands.endargs;

import me.charashenko.commandmanager.typesofargument.EndArgument;
import org.bukkit.command.CommandSender;

public class Rank extends EndArgument {

    @Override
    public String getSyntax() {
        return "/perm group <groupname> setrank <rank>";
    }

    @Override
    public String neededPermission() {
        return null;
    }

    @Override
    public boolean isPermissionOnly() {
        return false;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        sender.sendMessage("Execute " + getSyntax());
    }
}
