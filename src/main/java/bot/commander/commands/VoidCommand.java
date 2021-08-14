package bot.commander.commands;

import bot.telegram.MessageHandler;

public class VoidCommand implements BotCommand {

    private MessageHandler messageHandler;

    @Override
    public String execute() {
        messageHandler.sendResponse();
        return null;
    }

    @Override
    public void setMessage(MessageHandler messageHandler) {
        this.messageHandler = messageHandler;
    }
}
