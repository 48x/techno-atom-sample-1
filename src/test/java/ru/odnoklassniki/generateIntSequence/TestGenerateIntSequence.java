package ru.odnoklassniki.generateIntSequence;

import org.junit.Assert;
import org.junit.Test;
import ru.odnoklassniki.ClassToBeTested;

import java.util.List;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;

/**
 * Created by Dmitriy Tcibisov on 4/14/18 at 1:31 AM
 */
public class TestGenerateIntSequence {

    /**
     * Название тестового метода:
     * - начинается с test
     * - краткое описание кейса. Где, что, когда
     *
     * Содержание теста:
     * - Атомарность (в идеале)
     * - Логирование
     * - Информативные сообщения об ошибках
     *
     * Чек-лист:
     * 1. Проверка на то что генерируется корректное количество элементов последовательности
     *          PASS
     * 2. Проверка на то что генерируются корректные элементы последовательности
     *          PASS
     * 3. Проверка на то что не выбрасывается исключение при вводе itemsCount > 0 (1)
     *          PASS
     * 4. Проверка на то что выбрасывается исключение при вводе itemsCount < 0 (itemsCount = -1)
     *          PASS
     * 5. Проверка на то что выбрасывается исключение при вводе itemsCount = 0
     *          PASS
     * 6. Проверка на то что не выбрасывается исключение при finishNumber < Integer.MAX_VALUE
     *          PASS
     * 7. Проверка на то что не выбрасывается исключение при finishNumber = Integer.MAX_VALUE
     *          FAIL
     *          P.S. выбрасывает исключение, ошибка при определении значения finishNumber.
     *          Корректировка кода (забыли вычесть единицу, или нет?):
     *          long finishNumber = new Long(startingNumber) + new Long(itemsCount) - 1;
     * 8. Проверка на то что выбрасывается исключение при finishNumber > Integer.MAX_VALUE
     *          PASS
     * 9. Проверка на то что генерируемые элементы последовательности являются целыми числами
     *          PASS
     */

    // 1. Проверка на то что генерируется корректное количество элементов последовательности
    @Test
    public void testCorrectCountOfIntegersReturnedInGeneratedIntSequence() throws Exception {
        final Integer startingNumber = 1;
        final Integer itemsCount = 3;
        final List<Integer> generatedIntSequence = ClassToBeTested.generateIntSequence(startingNumber, itemsCount);

        Assert.assertThat(
                "В ответе неправильное количество элементов последовательности",
                generatedIntSequence,
                hasSize(equalTo(3))
        );
    }

    // 2. Проверка на то что генерируются корректные элементы последовательности
    @Test
    public void testCorrectIntegersReturnedInGeneratedIntSequence() throws Exception {
        final Integer startingNumber = -3;
        final Integer itemsCount = 4;
        final List<Integer> generatedIntSequence = ClassToBeTested.generateIntSequence(startingNumber, itemsCount);

        Assert.assertThat(
                "В ответе не те элементы, которые ожидались",
                generatedIntSequence,
                allOf(
                        hasItem(-3),
                        hasItem(-2),
                        hasItem(-1),
                        hasItem(0)
                )
        );
    }

    // 3. Проверка на то что не выбрасывается исключение при вводе itemsCount > 0
    @Test
    public void testItemsCountGreaterThanZeroExceptionNotThrown() throws Exception {
        final Integer startingNumber = 2;
        final Integer itemsCount = 1;
        try {
            ClassToBeTested.generateIntSequence(startingNumber, itemsCount);
        } catch (IllegalArgumentException e) {
            Assert.fail("Метод выбросил исключение когда itemsCount > 0");
        }
    }

    // 4. Проверка на то что выбрасывается исключение при вводе itemsCount < 0
    @Test(expected = IllegalArgumentException.class)
    public void testItemsCountLowerThanZeroExceptionIsThrown() throws Exception {
        ClassToBeTested.generateIntSequence(1, -1);
    }

    // 5. Проверка на то что выбрасывается исключение при вводе itemsCount = 0
    @Test
    public void testItemsCountIsZeroExceptionIsThrown() throws Exception {
        try {
            ClassToBeTested.generateIntSequence(1, 0);
            Assert.fail("Метод не выбросил исключение когда itemsCount равно 0");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("itemsCount must be greater than 0", e.getMessage());
        }
    }

    // 6. Проверка на то что не выбрасывается исключение при finishNumber < Integer.MAX_VALUE
    @Test
    public void testFinishNumberLowerThanIntegerMaxValueExceptionNotThrown() throws Exception {
        final Integer startingNumber = Integer.MAX_VALUE - 1;
        final Integer itemsCount = 1;
        try {
            final List<Integer> generatedIntSequence = ClassToBeTested.generateIntSequence(startingNumber, itemsCount);
        } catch (IllegalArgumentException e) {
            Assert.fail("Метод выбросил исключение когда finishNumber < Integer.MAX_VALUE");
        }
    }

    // 7. Проверка на то что не выбрасывается исключение при finishNumber = Integer.MAX_VALUE
    @Test
    public void testFinishNumberEqualIntegerMaxValueExceptionNotThrown() throws Exception {
        final Integer startingNumber = Integer.MAX_VALUE - 1;
        final Integer itemsCount = 2;
        try {
            ClassToBeTested.generateIntSequence(startingNumber, itemsCount);
        } catch (IllegalArgumentException e) {
            Assert.fail("Метод выбросил исключение когда finishNumber = Integer.MAX_VALUE");
        }
    }

    // 8. Проверка на то что выбрасывается исключение при finishNumber > Integer.MAX_VALUE
    @Test
    public void testFinishNumberIsGreaterThanIntegerMaxValueExceptionIsThrown() throws Exception {
        final Integer startingNumber = Integer.MAX_VALUE - 1;
        final Integer itemsCount = 3;
        try {
            ClassToBeTested.generateIntSequence(startingNumber, itemsCount);
            Assert.fail("Метод не выбросил исключение когда finishNumber > Integer.MAX_VALUE");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("can't generate an int greater than integer's max value", e.getMessage());
        }
    }

    // 9. Проверка на то что генерируемые элементы последовательности являются целыми числами
    @Test
    public void testGeneratedIntegersSequence() throws Exception {
        final Integer startingNumber = 1;
        final Integer itemsCount = 3;
        final List<Integer> generatedIntSequence = ClassToBeTested.generateIntSequence(startingNumber, itemsCount);

        for (Object item : generatedIntSequence) {
            if (!(item instanceof Integer)) {
                Assert.fail("Метод вернул не целое(Integer) число");
            }
        }
    }
}
