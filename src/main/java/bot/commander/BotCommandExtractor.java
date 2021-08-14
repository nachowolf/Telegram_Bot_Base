package bot.commander;

import bot.commander.commands.Command;
import bot.exceptions.InvalidCommandException;

import static bot.commander.commands.Command.VOID;

public class BotCommandExtractor {

    public Command extractCommand(String string) {
        String requestedCommand = string.substring(1);
        Command command = VOID;
        try {
            command = Command.getCommand(requestedCommand);
        } catch (InvalidCommandException e) {
            e.printStackTrace();

        }
        return command;
    }

}
