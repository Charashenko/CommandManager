package me.charashenko.commandmanager.commands.players;

import me.charashenko.commandmanager.commands.players.subcommands.AddGroup;
import me.charashenko.commandmanager.commands.players.subcommands.RmGroup;
import me.charashenko.commandmanager.typesofarguments.Option;
import me.charashenko.commandmanager.typesofarguments.SubCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerName extends Option {

    private List<SubCommand> subCommands;

    public PlayerName() {
        subCommands = new ArrayList<>();
        subCommands.add(new AddGroup());
        subCommands.add(new RmGroup());
    }

    @Override
    public String getName() {
        return "playername";
    }

    @Override
    public String getSyntax() {
        return "/perm player <playername> <action>";
    }

    @Override
    public Boolean hasSubCommands() {
        return true;
    }

    @Override
    public List<String> getTabSuggestions() {
        List<String> subCmdsNames = new ArrayList<>();
        for (SubCommand subCommand : subCommands) {
            subCmdsNames.add(subCommand.getName());
        }
        return subCmdsNames;
    }

    @Override
    public List<String> getValidOptions() {
        List<String> playerNames = new ArrayList<>();
        for (Player player : Bukkit.getOnlinePlayers()) {
            playerNames.add(player.getName());
        }
        return playerNames;
    }

    @Override
    public List<SubCommand> getSubCommands() {
        return subCommands;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        sender.sendMessage(getSyntax());
        sender.sendMessage("Actions:");
        for (String msg : getTabSuggestions()) {
            sender.sendMessage(msg);
        }
    }
}
