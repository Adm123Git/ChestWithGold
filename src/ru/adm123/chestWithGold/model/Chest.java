package ru.adm123.chestWithGold.model;

import static ru.adm123.chestWithGold.util.UtilThread.threadSleep;

/**
 * @author Dmitry Ushakov on 15.09.21
 * <p>
 * Класс сундука с золотом. Абстрактный, чтобы использовать его наследников для обоих вариантов синхронизации - с помощью synchronized-метода и с помощью семафора
 */
public abstract class Chest implements MoneyHolder {

    private int money;

    public Chest(int money) {
        this.money = money;
    }

    @Override
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

}
