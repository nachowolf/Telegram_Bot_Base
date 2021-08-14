package bot.commander.commands;

import bot.telegram.MessageHandler;

public interface BotCommand {
    static void log(String string) {

    }

    String execute();

    void setMessage(MessageHandler messageHandler);
}
