package bot.brain;

import bot.brain.subroutines.ReverseText;
import bot.telegram.MessageHandler;
import com.rivescript.RiveScript;
import resource_loader.ResourceLoader;

public class TelegramBotBrain {

    private static TelegramBotBrain fakeGuruBrain = null;
    private final RiveScript bot;
    private final ResourceLoader resourceLoader;


    private TelegramBotBrain() {
        bot = new RiveScript();
        resourceLoader = new ResourceLoader("rivescript");
        bot.loadDirectory(resourceLoader.getFolderPath());
        bot.sortReplies();

        bot.setSubroutine("reverse_word", new ReverseText());
    }

    public static TelegramBotBrain getInstance() {
        if (fakeGuruBrain == null) {
            fakeGuruBrain = new TelegramBotBrain();
        }
        return fakeGuruBrain;
    }

    private void setUser(String username, String firstname, String lastname) {
        bot.setUservar(username, "username", username);
        bot.setUservar(username, "firstname", firstname);
        bot.setUservar(username, "lastname", lastname);
    }

    public void reply(MessageHandler messageHandler) {
        setUser(messageHandler.getUserName(), messageHandler.getFirstName(), messageHandler.getLastName());
        String response = bot.reply(messageHandler.getUserName(), messageHandler.getMessageText());
        messageHandler.setResponse(response);
        messageHandler.sendResponse();
    }

    public void reply(String message, MessageHandler messageHandler) {
        setUser(messageHandler.getUserName(), messageHandler.getFirstName(), messageHandler.getLastName());
        String response = bot.reply(messageHandler.getUserName(), message);
        messageHandler.setResponse(response);
        messageHandler.sendResponse();
    }

    public void setTopic(String topic, MessageHandler messageHandler) {
        bot.setUservar(messageHandler.getUserName(), "topic", topic);
    }


}
