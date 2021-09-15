package ru.adm123.chestWithGold.model;

/**
 * @author Dmitry Ushakov on 15.09.21
 * <p>
 * Что-то, где хранятся деньги и откуда игрок может их взять
 */
public interface MoneyHolder {

    int giveMoney(int amount);

}
