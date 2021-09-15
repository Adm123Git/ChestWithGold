package ru.adm123.chestWithGold.util;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.Semaphore;

/**
 * @author Dmitry Ushakov on 15.09.21
 */
public class UtilThread {

    public static void threadSleep(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException ignored) {
        }
    }

    public static void semaphoreAcquire(@NotNull Semaphore semaphore) {
        try {
            semaphore.acquire();
        } catch (InterruptedException ignored) {
            semaphore.release();
            throw new RuntimeException();
        }
    }

}
