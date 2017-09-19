
import org.checkerframework.checker.nullness.qual.NonNull;

public class Test {

    public interface Consumer {

        <@NonNull T> void foo(final Container<@NonNull T> c);
    }

    public static class Container<@NonNull T> {

        private @NonNull
        T t;

        public Container(final @NonNull T t) {
            this.t = t;
        }

        public void set(final @NonNull T t) {
            this.t = t;
        }

        public @NonNull
        T get() {
            return t;
        }

        public void call(final @NonNull Consumer c) {
            c.foo(this);
        }
    }

}
