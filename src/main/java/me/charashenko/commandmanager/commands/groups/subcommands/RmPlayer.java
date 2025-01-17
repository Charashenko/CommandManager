package me.charashenko.commandmanager.commands.groups.subcommands;

import me.charashenko.commandmanager.commands.endargs.PlayerName;
import me.charashenko.commandmanager.typesofargument.EndArgument;
import me.charashenko.commandmanager.typesofargument.VariableArgument;
import me.charashenko.commandmanager.typesofargument.SubCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class RmPlayer extends SubCommand {

    private EndArgument endArgument;

    public RmPlayer() {
        endArgument = new PlayerName();
    }

    @Override
    public String getName() {
        return "rmplayer";
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String getSyntax() {
        return "/perm group <groupname> rmplayer <playername>";
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
    public boolean hasSubCommands() {
        return false;
    }

    @Override
    public boolean hasVariableArgument() {
        return false;
    }

    @Override
    public boolean hasEndArgument() {
        return true;
    }

    @Override
    public VariableArgument getVariableArgument() {
        return null;
    }

    @Override
    public EndArgument getEndArgument() {
        return endArgument;
    }

    @Override
    public List<String> getTabSuggestions() {
        List<String> playerNames = new ArrayList<>();
        for (Player player : Bukkit.getOnlinePlayers()) {
            playerNames.add(player.getName());
        }
        return playerNames;
    }

    @Override
    public List<SubCommand> getSubCommands() {
        return null;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        sender.sendMessage(getSyntax());
    }
}
