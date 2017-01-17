
package tmp;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.SortedMap;
import java.util.stream.Collectors;

public class Demo {
    public String test(final SortedMap<DayOfWeek, SortedMap<LocalTime, BigDecimal>> timeTemperatures) {
        return String.format("time=[%s]", timeTemperatures.keySet().stream()
                .map(key -> String.format("%s=%s", key, timeTemperatures.get(key))).collect(Collectors.joining(",")));
    }
}
