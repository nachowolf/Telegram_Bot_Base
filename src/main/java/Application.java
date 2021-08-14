import bot.telegram.TelegramBotController;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Application {

    public static void main(String[] args) {

//        CommandExecutor

        try {
            // Create the TelegramBotsApi object to register bots
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);

            // Register newly created Bot
            TelegramBotController bot = TelegramBotController.getInstance();
            botsApi.registerBot(bot);

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}
