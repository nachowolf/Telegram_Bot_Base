package bot.commander.commands;


import bot.telegram.MessageHandler;


public class StartCommand implements BotCommand {

    private MessageHandler messageHandler;

    @Override
    public String execute() {
        messageHandler.setResponse("/start ran");
        messageHandler.sendResponse();
        return "";
    }

    @Override
    public void setMessage(MessageHandler messageHandler) {
        this.messageHandler = messageHandler;
    }
}
