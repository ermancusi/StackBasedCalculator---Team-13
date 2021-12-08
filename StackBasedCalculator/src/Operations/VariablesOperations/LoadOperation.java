package Operations.VariablesOperations;

import Stack.ObservableStack;
import Operations.OperationsEnum;
import Operations.SupportedOperation;
import VariablesManager.VariablesStorage;
import org.apache.commons.math3.complex.Complex;

/**
 *
 * @author fsonnessa
 */
public class LoadOperation extends SupportedOperation {

    private final VariablesStorage variableManager;
    private final String variableName;

    public LoadOperation(ObservableStack<Complex> stack, VariablesStorage variableManager, String variableName) {
        super(OperationsEnum.LOAD, stack);
        this.variableManager = variableManager;
        this.variableName = variableName;
    }

    @Override
    public void execute() {
        super.push(this.variableManager.getVariableValue(this.variableName));
    }

    @Override
    public String toString() {
        return super.getName().substring(0, 1) + variableName;
    }
    
    

}