package bot.commander;

import bot.commander.commands.*;
import bot.telegram.MessageHandler;

import java.util.HashMap;
import java.util.Map;

import static bot.commander.commands.Command.*;

public class BotCommandInvoker {

    private final Map<Command, BotCommand> commandList = new HashMap<>();

    public BotCommandInvoker() {
        commandList.put(VOID, new VoidCommand());
        commandList.put(START, new StartCommand());
        commandList.put(KNOCK_KNOCK_JOKE, new KnockKnockJokeCommand());
    }

    public void executeCommand(Command command, MessageHandler messageHandler) {
        messageHandler.getMessageText().substring(1);
        BotCommand botCommand = commandList.get(command);

        if (command == VOID) {
            messageHandler.setResponse(VOID.getDescription());
        }
        botCommand.setMessage(messageHandler);
        botCommand.execute();
    }

}
