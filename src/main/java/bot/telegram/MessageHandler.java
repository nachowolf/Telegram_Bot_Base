package bot.telegram;


import bot.exceptions.NoResponseSetException;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MessageHandler {
    private final long userID;
    private final String firstName;
    private final String lastName;
    private final String userName;
    private final String messageText;
    private final Date date;
    private final long chatID;
    private final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private String response;


    public MessageHandler(Update update) {
        this.userID = update.getMessage().getFrom().getId();
        this.firstName = update.getMessage().getFrom().getFirstName();
        this.lastName = update.getMessage().getFrom().getLastName();
        this.userName = update.getMessage().getFrom().getUserName();
        this.messageText = update.getMessage().getText();
        this.chatID = update.getMessage().getChatId();
        this.date = new Date();

    }

    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public String getUserName() {
        return userName;
    }


    public String getMessageText() {
        return messageText;
    }


    public long getUserID() {
        return userID;
    }


    public Date getDate() {
        return date;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public void sendResponse() {
        if (response != null) {
            SendMessage message = new SendMessage();
            message.setChatId(Long.toString(this.chatID));
            message.setText(response);
            TelegramBotController.getInstance().send(message);
            log();
        } else {
            throw new NoResponseSetException();
        }
    }

    private void log() {
        System.out.println("\n\n----------------------------------------------------------------------------");
        System.out.println(dateFormat.format(date));
        System.out.println("Message from - @" + userName);
        System.out.println("{FirstName: " + firstName + ", LastName: " + lastName + ", id = " + userID + "}");
        System.out.println("User message: '" + messageText + "'");
        System.out.println("Bot response: '" + response + "'");
    }

    @Override
    public String toString() {
        return "MessageHandler{" +
                "userID=" + userID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", messageText='" + messageText + '\'' +
                ", date=" + dateFormat.format(date) +
                ", response='" + response + '\'' +
                ", chatID=" + chatID +
                '}';
    }
}
