package calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * ������ ����� ������������ ��� ������������ ��������� ����������� ���������.
 *
 * @author ���� �������
 * @version 1.0
 */
public class ProportionTest {

    /**
     * ������������ ������ ������� ��� ���������� ������� ���������.
     */
    @Test
    public void testForNormalValues() {
        assertEquals(20, Proportion.findUnknown(100, 5, 25));
    }

    /**
     * ������������ ������ ������� ��� ������������� ������� ���������.
     */
    @Test
    public void testForNegativeValues() {
        assertEquals(-1, Proportion.findUnknown(-100, 5, 25));
    }

    /**
     * ������������ ������ ������� ��� �������
     * ������� ���������� (������� �� ����).
     */
    @Test
    public void testForNaN() {
        assertEquals(-1, Proportion.findUnknown(100, 5, 0));
    }

}
