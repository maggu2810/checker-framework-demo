
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public class Test {

    private void testNnSNnA(@NonNull String @NonNull [] tmp) {
        tmp = null; // error: incompatible types in assignment.
        tmp[0] = null; // error: incompatible types in assignment.
    }

    private void testNnSCnA(@NonNull String @Nullable [] tmp) {
        tmp = null;
        tmp[0] = null; // error: accessing a possibly-null array tmp, incompatible types in assignment
    }

    private void testCnSNnA(@Nullable String @NonNull [] tmp) {
        tmp = null; // error: incompatible types in assignment
        tmp[0] = null;
    }

    private void testCnSCnA(@Nullable String @Nullable [] tmp) {
        tmp = null;
        tmp[0] = null; // error: accessing a possibly-null array tmp
    }

}
