package calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Данный класс предназначен для тестирования отдельных компонентов программы.
 *
 * @author Егор Пташник
 * @version 1.0
 */
public class ProportionTest {

    /**
     * Тестирование работы функции при нормальных входных значениях.
     */
    @Test
    public void testForNormalValues() {
        assertEquals(20, Proportion.findUnknown(100, 5, 25));
    }

    /**
     * Тестирование работы функции при отрицательных входных значениях.
     */
    @Test
    public void testForNegativeValues() {
        assertEquals(-1, Proportion.findUnknown(-100, 5, 25));
    }

    /**
     * Тестирование работы функции при попытке
     * вызвать исключение (деление на ноль).
     */
    @Test
    public void testForNaN() {
        assertEquals(-1, Proportion.findUnknown(100, 5, 0));
    }

}
