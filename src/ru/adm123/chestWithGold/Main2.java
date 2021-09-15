package ru.adm123.chestWithGold;

import ru.adm123.chestWithGold.model.Chest;
import ru.adm123.chestWithGold.model.ChestNotSynchronized;
import ru.adm123.chestWithGold.model.Player;

import java.util.concurrent.Semaphore;

import static ru.adm123.chestWithGold.util.UtilThread.semaphoreAcquire;

/**
 * @author Dmitry Ushakov on 15.09.21
 * <p>
 * Демо синхронизации с помощью семафора
 */
public class Main2 {

    public static void main(String[] args) throws InterruptedException {

        Semaphore semaphore = new Semaphore(1);
        Chest chest = new ChestNotSynchronized(100);
        Player player1 = new Player("Player1");
        Player player2 = new Player("Player2");
        Player player3 = new Player("Player3");

        Thread t1 = new Thread(() -> {
            semaphoreAcquire(semaphore);
            player1.takeFromChest(chest, 50);
            player1.printMoneyInfo();
            semaphore.release();
        });
        Thread t2 = new Thread(() -> {
            semaphoreAcquire(semaphore);
            player2.takeFromChest(chest, 50);
            player2.printMoneyInfo();
            semaphore.release();
        });
        Thread t3 = new Thread(() -> {
            semaphoreAcquire(semaphore);
            player3.takeFromChest(chest, 50);
            player3.printMoneyInfo();
            semaphore.release();
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
