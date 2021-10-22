package function;

import org.*;

import java.util.Arrays;

public class Utils {
    public static boolean isAllPositiveNumbers(String... str) {
        if (str.length == 0) {
            return false;
        }
        return Arrays.stream(str)
                .allMatch(StringUtils::isPositiveNumber);
    }

    public static boolean isAnyPositiveNumbers(String... str) {
        for (String information : str) {
            if (StringUtils.isPositiveNumber(information)) {
                return true;
            }
        }
        return false;
    }
}
