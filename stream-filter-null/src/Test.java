import java.util.stream.Stream;

import org.checkerframework.checker.nullness.qual.Nullable;

public class Test {

    public interface SerialSegment {
        /**
         * Gets the serial segment partition.
         *
         * @return the segment part (only valid if {@link #isValid()} returns <code>true</code>).
         */
        long getPart();

        /**
         * Signals if the part is valid.
         *
         * @return indication if {@link #getPart()} returns a valid partition
         */
        boolean isValid();
    }

    private static @Nullable String getSerial(final @Nullable SerialSegment serial1,
            final @Nullable SerialSegment serial2) {
        if (Stream.of(serial1, serial2).map(response -> response == null || !response.isValid())
                .filter(invalid -> invalid).findAny().isPresent()) {
            return null;
        } else {
            // at this place we analyzed that the serial fields (1 and 2) are not null and the partitions are valid.
            return String.format("%08x%08x", serial1.getPart(), serial2.getPart());
        }
    }

    // TEST

    private static class SerialSegmentImpl implements SerialSegment {

        private final long part;
        private final boolean valid;

        public SerialSegmentImpl(final long part, final boolean valid) {
            this.part = part;
            this.valid = valid;
        }

        @Override
        public long getPart() {
            return part;
        }

        @Override
        public boolean isValid() {
            return valid;
        }

    }

    public static void main(final String[] args) {
        System.out.println(getSerial(new SerialSegmentImpl(1, true), new SerialSegmentImpl(2, true)));
        System.out.println(getSerial(new SerialSegmentImpl(1, true), new SerialSegmentImpl(2, false)));
        System.out.println(getSerial(new SerialSegmentImpl(1, false), new SerialSegmentImpl(2, true)));
        System.out.println(getSerial(new SerialSegmentImpl(1, false), new SerialSegmentImpl(2, false)));
        System.out.println(getSerial(new SerialSegmentImpl(1, true), null));
        System.out.println(getSerial(null, new SerialSegmentImpl(2, true)));
        System.out.println(getSerial(null, null));
    }

}
