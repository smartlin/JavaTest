package cn.lxh.java.telegram;

import lombok.Data;
import org.springframework.web.client.RestTemplate;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Map;

@Data
public class MyAmazingBot extends TelegramLongPollingBot {

    private String token;
    private String botName;
    private String botUsername;
    private RestTemplate restTemplate;

    private String apiUrl = "https://api.telegram.org";
    private String chatId = "2125619071";
    private String authToken = "5298655421:AAFIQmnTIonRz3S-fV793ZKCbCmJ67JzsoM";
    private String parseMode = "HTML";
    private boolean disable_notification = false;

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();
            SendMessage sendMessage = new SendMessage();
            sendMessage.enableMarkdown(true);
            sendMessage.setChatId(String.valueOf(chatId));
            sendMessage.setText(message);
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    public void sendMessage(String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(getBotUsername());
        sendMessage.setText(message);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String chatId, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setText(message);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String chatId, String message, Map<String, String> map) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setText(message);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    protected  String buildUrl() {
        return String.format("%s/bot%s/sendmessage?chat_id={chat_id}&text={text}&parse_mode={parse_mode}"
            + "&disable_notification={disable_notification}", this.apiUrl, this.authToken);
    }

    public static void main(String[] args) {
        MyAmazingBot bot = new MyAmazingBot();
        bot.sendMessage("2125619071","Hello");
    }
}