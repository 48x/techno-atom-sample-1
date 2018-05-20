package homework;

import org.junit.Assert;
import org.junit.Test;
import ru.odnoklassniki.ClassToBeTested;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Maxim Vyshegorodtsev
 *
 * Проверка метода ClassToBeTested.generateIntSequence(int startingNumber, int itemsCount)
 *
 * Метод возвращает нам возрастающую последовательность целых чисел длины itemsCount, начиная
 * с startingNumber и далее увеличивая каждое число на 1
 *
 * Метод принимает на вход два параметра:
 * startingNumber - число, с которого начинается последователность
 * itemsCount - количсетво элементов последовательности
 *
 * Метод возвращает упорядоченный список целых чисел
 *
 * Чек-лист
 *
 * 1. Проверка метода на выброс исключения, если во второй аргумент передать
 *    число меньшее 0
 *
 * 2. Проверка метода на выброс исключения, если во второй аргумент передать 0
 *
 * 3. Проверка метода на выброс исключения, если сумма двух аргументов будет
 *    больше допустимого максимального значения для типа Integer
 *
 * 4. Проверка на корректную работу метода, если сумма двух аргументов
 *    равна максимальному допустимому значению типа Integer
 *
 * 5. Проверка на корректную работу метода, если сумма двух аргументов
 *    меньше либо равно максимальному допустимому значению для типа Integer
 *
 */
public class TestGeneratorIntSequence {
    private static final int STARTING_NUMBER = 0;
    private static final Logger LOGGER = Logger.getLogger(TestGeneratorIntSequence.class.getSimpleName());
    private static final String ITEMS_COUNT_ERROR_MESSAGE = "itemsCount must be greater than 0";
    private static final String GENERATOR_ERROR_MESSAGE = "can't generate an int greater than integer's max value";

    /**
     * Проверка метода на выброс исключения, если во второй аргумент передать
     * число меньшее 0
     */
    @Test
    public void testThrowingExceptionIfItemsCountIsLessZero() {
        LOGGER.info("Вызовем метод, передав во второй аргумент отрицательное число");
        try {
            ClassToBeTested.generateIntSequence(STARTING_NUMBER, -2);
            Assert.fail("Метод не кидает ошибку при вызове метода с отрицательным вторым аргументом");
        }

        catch (IllegalArgumentException ex) {
            LOGGER.info("Получили ошибку, проверим ее текст");
            Assert.assertEquals("Метод бросает другую ошибку", ITEMS_COUNT_ERROR_MESSAGE, ex.getMessage());
        }
        LOGGER.info("Метод выбрасывает ошибку");
    }

    /**
     * Проверка метода на выброс исключения, если во второй аргумент передать 0
     */
    @Test
    public void testThrowingExceptionIfItemsCountIsZero() {
        LOGGER.info("Вызовем метод, передав во второй аргумент 0");
        try {
            ClassToBeTested.generateIntSequence(STARTING_NUMBER, 0);
            Assert.fail("Метод не кидает ошибку при вызове метода с нулевым вторым параметром");
        }

        catch (IllegalArgumentException ex) {
            LOGGER.info("Получили ошибку, проверим ее текст");
            Assert.assertEquals("Метод бросает другую ошибку", ITEMS_COUNT_ERROR_MESSAGE, ex.getMessage());
        }
        LOGGER.info("Метод выбрасывает ошибку");
    }

    /**
     * Проверка метода на выброс исключения, если сумма двух аргументов будет
     * больше допустимого максимального значения для типа Integer
     */
    @Test
    public void testThrowingExceptionIfSumIsGreaterMaxInteger() {
        LOGGER.info("Вызовем метод так, чтобы сумма двух переданных параметров была больше Integer.MAX_VALUE");
        try {
            ClassToBeTested.generateIntSequence(STARTING_NUMBER + 1, Integer.MAX_VALUE);
            Assert.fail("Метод не кидает ошибку, если сумма двух аргументов больше Integer.MAX_VALUE");
        }

        catch (IllegalArgumentException ex) {
            LOGGER.info("Получили ошибку, проверим ее текст");
            Assert.assertEquals("Метод бросает другую ошибку", GENERATOR_ERROR_MESSAGE, ex.getMessage());
        }
        LOGGER.info("Метод бросает ошибку");
    }

    /**
     * Проверка на корректную работу метода, если сумма двух аргументов
     * равна максимальному допустимому значению типа Integer
     */
    @Test
    public void testCorrectIntSequenceIfSumIsMaxInteger() {
        LOGGER.info("Вызовем метод так, чтобы сумма двух параметров равнялась Integer.MAX_VALUE");
        List<Integer> intSequence = ClassToBeTested.generateIntSequence(STARTING_NUMBER, Integer.MAX_VALUE);

        LOGGER.info("Проверим, что метод на сгенерировал валидную последовательность");
        Assert.assertNotNull("Метод вернул null", intSequence);
        Assert.assertFalse("Метод вернул пустую последовательность", intSequence.isEmpty());
        Assert.assertEquals("Размер последовательности не совпадает с переданным параметром", intSequence.size(), Integer.MAX_VALUE);

        LOGGER.info("Метод возвращает валидную последовательность");
    }

    /**
     * Проверка на корректную работу метода, если сумма двух аргументов
     * меньше максимального допустимого значения для типа Integer
     */

    @Test
    public void testCorrectIntSequence() {
        LOGGER.info("Вызовем метод так, чтобы сумма двух параметров была меньше Integer.MAX_VALUE");
        int startingNumber = STARTING_NUMBER;
        List<Integer> intSequence = ClassToBeTested.generateIntSequence(STARTING_NUMBER, 4);

        LOGGER.info("Проверим, что метод на сгенерировал валидную последовательность");
        Assert.assertNotNull("Метод вернул null", intSequence);
        Assert.assertFalse("Метод вернул пустую последовательность", intSequence.isEmpty());
        Assert.assertEquals("Размер последовательности не совпадает с переданным параметром", intSequence.size(), 4);

        LOGGER.info("Проверим, что все элементы последовательности правильные");
        for (int element : intSequence) {
            Assert.assertEquals("Элементы не совпадают", startingNumber++, element);
        }

        LOGGER.info("Метод возвращает правильную последовательность");
    }


}
