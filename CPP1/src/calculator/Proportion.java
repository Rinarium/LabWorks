package calculator;

/**
 * ������ ����� ������������ ��� ������� ������������ �������� ���������.
 *
 * @author ���� �������
 * @version 1.0
 */
public final class Proportion {
    /**
     * ����������� ����������, ������� ������������ �����
     * ����� ����� - 100%.
     */
    public static final int FULL_PART = 100;

    /**
     * ������� ������� ���������.
     * <br>a = b - ������ ���������</br>
     * c = d - ������ ���������
     * <br>�������������:</br>
     * a = (b*c)/d
     * @param rightFirstAttitude - � ������� ������������ b.
     * @param leftSecondAttitude - � ������� ������������ c.
     * @param rightSecondAttitude - � ������� ������������ d.
     * @return ���������� �����, ������� � ������� ������������ a.
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
     * ��������� �����������, ������������ ��� �����������
     * ������������� ������������� ������.
     */
    private Proportion() {
        throw new AssertionError("�������� ������� ���������� ������.");
    }
}
