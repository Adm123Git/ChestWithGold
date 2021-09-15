package ru.adm123.chestWithGold.model;

/**
 * @author Dmitry Ushakov on 15.09.21
 *
 * Класс сундука с золотом
 *
 */
public class Chest implements MoneyHolder {

    private int money;

    public Chest(int money) {
        this.money = money;
    }

    @Override
    synchronized
    public int giveMoney(int amount) {
        threadSleep(5);
        int sum = 0;
        if (money >= amount) {
            sum = amount;
            money -= amount;
        } else if (money > 0) {
            sum = money;
            money = 0;
        }
        return sum;
    }

    public void printMoneyInfo() {
        System.out.println("Chest: " + money);
    }

    private void threadSleep(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException ignored) {
        }
    }

}
