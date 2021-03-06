
public class Test {

    public interface Variable<T> {

        void addChangedListener(VariableChangedListener<T> listener);
    }

    public interface VariableChangedListener<T> {

        void variableChanged(final Variable<T> variable);
    }

    protected <T> void addChangedListener(final Variable<T> variable, final VariableChangedListener<T> listener) {
    }

    public void main(final Variable<?> tmp) {
        addChangedListener(tmp, variable -> System.out.println(variable));
    }

}
