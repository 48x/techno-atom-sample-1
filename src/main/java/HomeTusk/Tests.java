package HomeTusk;

import org.junit.jupiter.api.Test;
import ru.odnoklassniki.ClassToBeTested;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Created by Dmitry Kachalin
 *
 * Исходный метод generateIntSequence получает на вход 2 числа типа int:
 * startingNumber - начальное число, от которого будет вестись отсчет.
 * itemsCount - число раз, которое метож будет последовательно прибавлять к исходному числу 1 и записывать получаемые числа в массив.
 *
 * Чек-лист:
 * 1) Проверка случая, когда itemsCount<0
 * 2) Проверка случая, когда itemsCount=0
 * 3) Проверка случая, когда startingNumber + itemsCount больше масимального значения типа int
 * 4) Проверка случая, когда startingNumber + itemsCount равно масимальному начению типа int
 * 5) Проверка случая, когда startingNumber + itemsCount меньше максимального значения типа int
 */


public class Tests{
    /**
     * 1) Проверка случая, когда itemsCount<0
     */
    @Test
    public void TestIfItemsCountLessThanZero() {
        try{
            ClassToBeTested.generateIntSequence(500, -5);
            fail();
        }
        catch(IllegalArgumentException ex){
            assertEquals("itemsCount must be greater than 0", ex.getMessage());

        }
    }

    /**
     * 2) Проверка случая, когда itemsCount=0
     */
    @Test
    public void TestIfItemsCountEqualsZero() {
        try{
            ClassToBeTested.generateIntSequence(100,0);
            fail();
        }
        catch(IllegalArgumentException ex){
            assertEquals("itemsCount must be greater than 0", ex.getMessage());
        }
    }

    /**
     * 3) Проверка случая, когда startingNumber + itemsCount больше масимального значения типа int
     */
    @Test
    public void TestIfFinishNumberGreaterThanMaxInt(){
        try{
            ClassToBeTested.generateIntSequence(Integer.MAX_VALUE - 1, 15);
            fail();
        }
        catch(IllegalArgumentException ex){
            assertEquals("can't generate an int greater than integer's max value", ex.getMessage());
        }
    }

    /**
     * 4) Проверка случая, когда startingNumber + itemsCount равно масимальному начению типа int
     */
    @Test
    public void TestIfFinishNumberEqualsManInt(){
        int startingNumber = Integer.MAX_VALUE - 2;
        int itemsCount = 2;
        ClassToBeTested.generateIntSequence( startingNumber, itemsCount);
        assertEquals(startingNumber + itemsCount,Integer.MAX_VALUE);
    }

    /**
     * 5) Проверка случая, когда startingNumber + itemsCount меньше максимального значения типа int
     */
    @Test
    public void TestIfEverythingIsNormal(){
        int startingNumber = 100;
        int itemsCount = 300;
        ClassToBeTested.generateIntSequence(startingNumber, itemsCount);
    }
}
