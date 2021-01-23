package me.charashenko.commandmanager.commands.players.subcommands.variableargument;

import me.charashenko.commandmanager.commands.players.subcommands.AddGroup;
import me.charashenko.commandmanager.commands.players.subcommands.RmGroup;
import me.charashenko.commandmanager.typesofargument.VariableArgument;
import me.charashenko.commandmanager.typesofargument.SubCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerNames extends VariableArgument {

    private List<SubCommand> subCommands;

    public PlayerNames() {
        subCommands = new ArrayList<>();
        subCommands.add(new AddGroup());
        subCommands.add(new RmGroup());
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
    public List<String> getValidArguments() {
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
    }
}
