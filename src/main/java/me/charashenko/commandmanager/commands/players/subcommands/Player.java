package me.charashenko.commandmanager.commands.players.subcommands;

import me.charashenko.commandmanager.commands.players.subcommands.variableargument.PlayerNames;
import me.charashenko.commandmanager.typesofargument.EndArgument;
import me.charashenko.commandmanager.typesofargument.VariableArgument;
import me.charashenko.commandmanager.typesofargument.SubCommand;
import org.bukkit.command.CommandSender;

import java.util.Collections;
import java.util.List;

public class Player extends SubCommand {

    private VariableArgument variableArgument;

    public Player() {
        variableArgument = new PlayerNames();
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
        return "/perm player <playername>";
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
        return true;
    }

    @Override
    public boolean hasEndArgument() {
        return false;
    }

    @Override
    public VariableArgument getVariableArgument() {
        return variableArgument;
    }

    @Override
    public EndArgument getEndArgument() {
        return null;
    }

    @Override
    public List<String> getTabSuggestions() {
        return getVariableArgument().getValidArguments();
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
