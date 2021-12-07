package UserInterface.CellFactory;

import Operations.SupportedOperation;
import UserDefinedOperation.VariablesOperations.*;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

/**
 * This class provides an implementation of a CellFactory for
 * SupportedOperations.
 *
 * In this case, if the list cell is not empty, the name of the operation is
 * shown.
 *
 * @author gparrella
 * @see Operations.SupportedOperation
 */
public class OperationCellFactory implements Callback<ListView<SupportedOperation>, ListCell<SupportedOperation>> {

    @Override
    public ListCell<SupportedOperation> call(ListView<SupportedOperation> param) {
        return new ListCell<SupportedOperation>() {
            @Override
            public void updateItem(SupportedOperation operation, boolean empty) {
                super.updateItem(operation, empty);
                if (!empty) {
                    setText(operation.getName());
                    if (operation instanceof LoadOperation || operation instanceof SaveOperation || operation instanceof SumVarOperation || operation instanceof SubVarOperation) {
                        setText(getText() + "Name");
                    }
                }
            }
        };
    }
;
}
