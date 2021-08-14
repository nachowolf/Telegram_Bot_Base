package bot.commander.commands;

import bot.brain.TelegramBotBrain;
import bot.telegram.MessageHandler;

public class KnockKnockJokeCommand implements BotCommand {

    private MessageHandler messageHandler;

    @Override
    public String execute() {
        TelegramBotBrain.getInstance().setTopic("knock", messageHandler);
        TelegramBotBrain.getInstance().reply("tell_knock_knock_joke", messageHandler);
        return null;
    }

    @Override
    public void setMessage(MessageHandler messageHandler) {
        this.messageHandler = messageHandler;
    }
}
