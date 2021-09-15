package ru.adm123.chestWithGold.model;

import org.jetbrains.annotations.NotNull;

/**
 * @author Dmitry Ushakov on 15.09.21
 * <p>
 * Класс игрока
 */
public class Player {

    @NotNull
    private String name;
    private int money;

    public Player(@NotNull String name) {
        this.name = name;
    }

    public void takeFromChest(@NotNull MoneyHolder moneyHolder,
                              int amount) {
        money += moneyHolder.giveMoney(amount);
    }

    public void printMoneyInfo() {
        System.out.println("Player " + name + ": " + money);
    }

}
