package function;

import org.*;

import java.util.Arrays;

public class Utils {
    public static boolean isAllPositiveNumbers(String... str) {
        return Arrays.stream(str)
                .allMatch(StringUtils::isPositiveNumber);
    }
}
