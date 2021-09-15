package ru.adm123.chestWithGold.model;

/**
 * @author Dmitry Ushakov on 15.09.21
 */
public class ChestNotSynchronized extends Chest{

    public ChestNotSynchronized(int money) {
        super(money);
    }

    @Override
    public int giveMoney(int amount) {
        return super.giveMoney(amount);
    }

}
