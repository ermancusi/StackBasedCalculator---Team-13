package UserInterface.CellFactory;

import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;
import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.util.Precision;

/**
 * * A column cell factory for Complex Number.
 *
 * Implement the callback's functional interface in order to override the
 * TableCell method for display a complex number C(real,image) in the following
 * way:
 * <p>
 * realDisplay + imageDisplay<code>j</code>
 * <p>
 * where <code>j</code> is the imaginary unit.
 * <p>
 * A complex number of <code>Complex</code> class is used.
 *
 * @see org.apache.commons.math3.complex.Complex
 *
 * @author Speranza
 */
public class NumberColumnFactory implements Callback<TableColumn<String, Complex>, TableCell<String, Complex>> {

    @Override
    public TableCell<String, Complex> call(TableColumn<String, Complex> param) {
        return new TableCell<>() {
            @Override
            public void updateItem(Complex number, boolean empty) {
                super.updateItem(number, empty);

                if (empty || number == null) {
                    // If the cell is empty or number is null, then the visualized text is empy
                    setText(null);
                } else {
                    Double image = Precision.round(number.getImaginary(), 8);
                    Double real = Precision.round(number.getReal(), 8);
                    String realDisplay = "", imageDisplay = "";
                    if (image != 0.000) {
                        imageDisplay = image + "j";
                    }
                    if (real != 0.000) {
                        realDisplay = String.valueOf(real);
                    }
                    if (number.getImaginary() <= 0) {// If imaginary part is less than 0, then not display the '-' in the text
                        setText(realDisplay + imageDisplay);
                    } else { // Otherwise, include '+' in the text
                        setText(realDisplay + "+" + imageDisplay);
                    }
                    if (real == 0.000 && image == 0.000) {
                        setText("0");
                    }
                }
            }
        };
    }
}
