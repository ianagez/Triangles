package runner;

import service.messenger.ConsoleMessenger;

/**
 * This console program displays geometric figures in descending
 * order by their area. At first, user choose figure hi/she wants
 * to work with. There are three figures available: circle,
 * triangle, rectangle. After that program asks to enter parameters for
 * choosen figure by the exemple. After adding  new figure, the program
 * asks if the user wants to add one more. If the user answers “y” or “yes”
 * (case insensitive), the program will ask you to enter data for one
 * more figure, otherwise it will output the result to the console.
 */

public class Main {
    public static void main(String[] args) {
        Application app = new Application(new ConsoleMessenger());
        app.run();
    }
}
