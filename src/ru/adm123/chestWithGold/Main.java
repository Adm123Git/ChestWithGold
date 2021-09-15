package ru.adm123.chestWithGold;

import ru.adm123.chestWithGold.model.Chest;
import ru.adm123.chestWithGold.model.Player;

/**
 * @author Dmitry Ushakov on 15.09.21
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        Chest chest = new Chest(100);
        Player player1 = new Player("Player1");
        Player player2 = new Player("Player2");
        Player player3 = new Player("Player3");

        Thread t1 = new Thread(() -> {
            player1.takeFromChest(chest, 50);
            player1.printMoneyInfo();
        });
        Thread t2 = new Thread(() -> {
            player2.takeFromChest(chest, 50);
            player2.printMoneyInfo();
        });
        Thread t3 = new Thread(() -> {
            player3.takeFromChest(chest, 50);
            player3.printMoneyInfo();
        });

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        chest.printMoneyInfo();

    }

}
