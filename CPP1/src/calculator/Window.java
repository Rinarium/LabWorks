package calculator;

/**
 * Класс констант, в котором описаны параметры окна
 * и его элементов. Данные значения подбирались в
 * соотвествии с требованиями задания.
 *
 * @author Егор Пташник
 * @version 1.0
 */
public final class Window {
    /**
     * Заданный размер рамки в окне.
     */
    public static final int MARGIN = 10;

    /**
     * Заданный отступ в окне.
     */
    public static final int OFFSET = 15;

    /**
     * Заданная высота окна программы.
     */
    public static final int WINDOW_HEIGHT = 140;

    /**
     * Заданная ширина окна программы.
     */
    public static final int WINDOW_WIDTH = 450;

    /**
     * Заданная высота для всех текстовых полей в окне.
     */
    public static final int FIELD_HEIGHT = 15;

    /**
     * Заданная ширина для текстового поля "Процентное содержание".
     */
    public static final int CONC_FIELD_WIDTH = 40;

    /**
     * Заданная ширина для текстового поля "Масса раствора".
     */
    public static final int SUBS_FIELD_WIDTH = 90;

    /**
     * Заданная ширина для текстового поля "Масса сухого вещества".
     */
    public static final int DRY_FIELD_WIDTH = 49;

    /**
     * Заданный отступ для всех текстовых полей в окне.
     */
    public static final int FIELD_OFFSET = 7;

    /**
     * Заданная высота для всех кнопок в окне.
     */
    public static final int BUTTON_HEIGHT = 23;

    /**
     * Заданная ширина для всех кнопок в окне.
     */
    public static final int BUTTON_WIDTH = 178;

    /**
     * Заданный отступ для всех кнопок в окне.
     */
    public static final int BUTTON_OFFSET = 30;

    /**
     * Заданная высота для всех лейблов в окне.
     */
    public static final int LABEL_HEIGHT = 7;

    /**
     * Приватный конструктор, предназначен для обнаружения
     * неправильного использования класса.
     */
    private Window() {
        throw new AssertionError("Создание объекта служебного класса.");
    }
}
