package bot.telegram;


import bot.brain.TelegramBotBrain;
import bot.commander.BotCommandExtractor;
import bot.commander.BotCommandInvoker;
import bot.constants.Constants;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TelegramBotController extends TelegramLongPollingBot {

    private static TelegramBotController controller = null;

    private final BotCommandInvoker botCommandInvoker;
    private final BotCommandExtractor botCommandExtractor;
    //  RiveScript bot
    private final TelegramBotBrain botBrain;

    private TelegramBotController() {
        botCommandInvoker = new BotCommandInvoker();
        botCommandExtractor = new BotCommandExtractor();
        botBrain = TelegramBotBrain.getInstance();
    }

    public static TelegramBotController getInstance() {
        if (controller == null) {
            controller = new TelegramBotController();
        }
        return controller;
    }

    @Override
    public String getBotUsername() {
        return Constants.BOT_USERNAME;
    }

    @Override
    public String getBotToken() {
        return Constants.BOT_TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
        MessageHandler messageHandler = new MessageHandler(update);

//        Check if request was command (message starts with '/')
        if (messageHandler.getMessageText().startsWith("/")) {
            System.out.println(messageHandler.getMessageText());
            botCommandInvoker.executeCommand(botCommandExtractor.extractCommand(messageHandler.getMessageText()), messageHandler);
        } else {
//        Check if message is from group
            if (update.getMessage().getChat().isGroupChat()) {
//                Check if bot was tagged
                if (update.getMessage().hasEntities()) {
                    botBrain.reply(messageHandler);
                }
            }
//            Check if message is from user chat
            if (update.getMessage().getChat().isUserChat()) {
                botBrain.reply(messageHandler);
            }

        }
    }

    //    Initiate process to respond through bot
    public void send(SendMessage message) {
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
