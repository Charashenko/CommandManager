package me.charashenko.commandmanager.testcommands.players.subcommands;

import me.charashenko.commandmanager.testcommands.players.PlayerName;
import me.charashenko.commandmanager.typesofarguments.EndArgument;
import me.charashenko.commandmanager.typesofarguments.Option;
import me.charashenko.commandmanager.typesofarguments.SubCommand;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;

public class Player extends SubCommand {

    private List<Option> options;

    public Player() {
        options = new ArrayList<>();
        options.add(new PlayerName());
    }

    @Override
    public String getName() {
        return "player";
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String getSyntax() {
        return "/perm player";
    }

    @Override
    public Boolean isConsoleOnly() {
        return null;
    }

    @Override
    public Boolean hasSubCommands() {
        return null;
    }

    @Override
    public Boolean hasOptions() {
        return null;
    }

    @Override
    public Boolean hasEndArgument() {
        return false;
    }

    @Override
    public EndArgument getEndArgument() {
        return null;
    }

    @Override
    public List<String> getTabSuggestions() {
        return null;
    }

    @Override
    public List<Option> getOptions() {
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
