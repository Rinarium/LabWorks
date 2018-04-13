package calculator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * Основной класс, который предназначен для создания графического интерфейса
 * программы и контроля правильной работы.
 *
 * @author Егор Пташник
 * @version 1.0
 */
public final class ChemicalCalculator {

    /**
     * Функция для задания параметров окну и поведения его
     * элементам.
     *
     * @param display - объект экрана, к которому прикрепляется
     * оболочка окна.
     *
     * @return возвращает сконфигурированную оболочку окна.
     */
    public static Shell configureShell(final Display display) {
        Shell shell = new Shell(display,
                                SWT.SHELL_TRIM & (~SWT.RESIZE));
        shell.setText("Химический калькулятор");
        shell.setSize(Window.WINDOW_WIDTH, Window.WINDOW_HEIGHT);

        FormLayout layout = new FormLayout();
        layout.marginWidth = Window.MARGIN;
        layout.marginHeight = Window.MARGIN;
        shell.setLayout(layout);

        Label substanceLabel = new Label(shell, SWT.LEFT);
        substanceLabel.setText("Масса раствора");

        Text substanceTextField = new Text(shell, SWT.BORDER);
        FormData substanceData = new FormData(Window.SUBS_FIELD_WIDTH,
                                              Window.FIELD_HEIGHT);
        substanceData.left = new FormAttachment(substanceLabel,
                                                Window.LABEL_HEIGHT);
        substanceData.top = new FormAttachment(substanceLabel,
                                               0, SWT.CENTER);
        substanceTextField.setLayoutData(substanceData);

        Button calcSubstanceButton = new Button(shell, SWT.CENTER);
        calcSubstanceButton.setText("Узнать массу раствора");
        FormData calcSubstanceForm = new FormData(Window.BUTTON_WIDTH,
                                                  Window.BUTTON_HEIGHT);
        calcSubstanceForm.left = new FormAttachment(substanceTextField,
                                                    Window.BUTTON_OFFSET);
        calcSubstanceForm.top = new FormAttachment(substanceTextField,
                                                   0, SWT.CENTER);
        calcSubstanceButton.setLayoutData(calcSubstanceForm);

        Label concentrationLabel = new Label(shell, SWT.LEFT);
        concentrationLabel.setText("Процентное содержание");
        FormData concentrationLabelForm = new FormData();
        concentrationLabelForm.top = new FormAttachment(substanceLabel,
                                                        Window.FIELD_HEIGHT);
        concentrationLabel.setLayoutData(concentrationLabelForm);

        Text concentrationTextField = new Text(shell, SWT.BORDER);
        FormData concentrationTextForm = new FormData(Window.CONC_FIELD_WIDTH,
                                                      Window.FIELD_HEIGHT);
        concentrationTextForm.left = new FormAttachment(concentrationLabel,
                                                        Window.LABEL_HEIGHT);
        concentrationTextForm.top = new FormAttachment(concentrationLabel,
                                                       0, SWT.CENTER);
        concentrationTextField.setLayoutData(concentrationTextForm);

        Button calcDryButton = new Button(shell, SWT.CENTER);
        calcDryButton.setText("Узнать массу сухого вещества");
        FormData calcDryForm = new FormData();
        calcDryForm.left = new FormAttachment(concentrationTextField,
                                              Window.BUTTON_OFFSET);
        calcDryForm.top = new FormAttachment(concentrationTextField,
                                             0, SWT.CENTER);
        calcDryButton.setLayoutData(calcDryForm);

        Label dryLabel = new Label(shell, SWT.LEFT);
        dryLabel.setText("Масса сухого вещества");
        FormData dryLabelForm = new FormData();
        dryLabelForm.top = new FormAttachment(concentrationLabel,
                                              Window.FIELD_HEIGHT);
        dryLabel.setLayoutData(dryLabelForm);

        Text dryTextField = new Text(shell, SWT.BORDER);
        FormData dryTextForm = new FormData(Window.DRY_FIELD_WIDTH,
                                            Window.FIELD_HEIGHT);
        dryTextForm.left = new FormAttachment(dryLabel, Window.FIELD_OFFSET);
        dryTextForm.top = new FormAttachment(dryLabel,
                                             0, SWT.CENTER);
        dryTextField.setLayoutData(dryTextForm);

        calcSubstanceButton.addListener(SWT.Selection, new Listener() {

            @Override
            public void handleEvent(final Event event) {
                try {
                    Integer dry = Integer.parseInt(dryTextField.getText());
                    Integer concentration =
                            Integer.parseInt(concentrationTextField.getText());
                    Integer substance =
                            Proportion.findUnknown(Proportion.FULL_PART,
                                                   dry,
                                                   concentration);

                    if (substance < 0) {
                        throw new NumberFormatException();
                        }

                    substanceTextField.setText(substance.toString());
                } catch (NumberFormatException exception) {
                    return;
                }
           }
        });

        calcDryButton.addListener(SWT.Selection, new Listener() {

            @Override
            public void handleEvent(final Event event) {
               try {
                   Integer substance =
                           Integer.parseInt(substanceTextField.getText());
                   Integer concentration =
                           Integer.parseInt(concentrationTextField.getText());
                   Integer dry = Proportion.findUnknown(concentration,
                           substance,
                           Proportion.FULL_PART);

                   dryTextField.setText(dry.toString());
               } catch (NumberFormatException exception) {
                   return;
               }
            }
        });


        return shell;
    }

    /**
     * Приватный конструктор, предназначен для обнаружения
     * неправильного использования класса.
     */
    private ChemicalCalculator() {
        throw new AssertionError("Создание объекта служебного класса.");
    }

    /**
     * Точка входа в программу.
     *
     * @param args - без него не компилит (абсурд).
     */
    public static void main(final String[] args) {
        Display display = new Display();
        Shell shell = configureShell(display);
        shell.open();

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
               display.sleep();
            }
        }

        display.dispose();
    }
}
