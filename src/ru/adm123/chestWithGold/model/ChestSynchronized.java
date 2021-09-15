package ru.adm123.chestWithGold.model;

/**
 * @author Dmitry Ushakov on 15.09.21
 */
public class ChestSynchronized extends Chest{

    public ChestSynchronized(int money) {
        super(money);
    }

    @Override
    synchronized
    public int giveMoney(int amount) {
        return super.giveMoney(amount);
    }

}
