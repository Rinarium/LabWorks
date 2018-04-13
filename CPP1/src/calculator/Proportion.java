package calculator;

/**
 * Данный класс предназначен для расчёта неизвестного элемента пропорции.
 *
 * @author Егор Пташник
 * @version 1.0
 */
public final class Proportion {
    /**
     * Статическая переменная, которая представляет собой
     * целую часть - 100%.
     */
    public static final int FULL_PART = 100;

    /**
     * Функция расчёта пропорции.
     * <br>a = b - первое отношение</br>
     * c = d - второе отношение
     * <br>Следовательно:</br>
     * a = (b*c)/d
     * @param rightFirstAttitude - в формуле соотвествует b.
     * @param leftSecondAttitude - в формуле соотвествует c.
     * @param rightSecondAttitude - в формуле соотвествует d.
     * @return возвращает число, которое в формуле соотвествует a.
     */
    public static int findUnknown(final int rightFirstAttitude,
                                  final int leftSecondAttitude,
                                  final int rightSecondAttitude) {
     try {
         int unknown = rightFirstAttitude * leftSecondAttitude
                 / rightSecondAttitude;

         if (unknown < 0) {
             throw new ArithmeticException();
             }

         return unknown;
     } catch (ArithmeticException exception) {
         return -1;
     }
    }

    /**
     * Приватный конструктор, предназначен для обнаружения
     * неправильного использования класса.
     */
    private Proportion() {
        throw new AssertionError("Создание объекта служебного класса.");
    }
}
