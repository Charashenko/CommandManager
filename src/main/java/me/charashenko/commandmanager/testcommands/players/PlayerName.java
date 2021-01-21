package me.charashenko.commandmanager.testcommands.players;

import me.charashenko.commandmanager.testcommands.players.subcommands.AddGroup;
import me.charashenko.commandmanager.testcommands.players.subcommands.RmGroup;
import me.charashenko.commandmanager.typesofarguments.Option;
import me.charashenko.commandmanager.typesofarguments.SubCommand;
import org.bukkit.command.CommandSender;

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
        return "/perm player <playername>";
    }

    @Override
    public Boolean hasSubCommands() {
        return true;
    }

    @Override
    public List<String> getTabSuggestions() {
        return null;
    }

    @Override
    public List<String> getValidOptions() {
        return null;
    }

    @Override
    public List<SubCommand> getSubCommands() {
        return null;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {

    }
}
