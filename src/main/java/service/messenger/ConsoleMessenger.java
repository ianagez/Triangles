package service.messenger;

import java.util.Scanner;

public class ConsoleMessenger extends Messenger {
    @Override
    public void sendMessage(String message) {
        System.out.println(message);
    }

    @Override
    public String getMessage() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
