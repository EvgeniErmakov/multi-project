import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import function.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("NumbersTest")
public class UtilsTest {
    static Stream<Arguments> provideArgumentsIsAllPositiveNumbers() {
        return Stream.of(
                Arguments.of(new String[]{}, false),
                Arguments.of(new String[]{"123", "12"}, true),
                Arguments.of(new String[]{"-123", "12"}, false),
                Arguments.of(new String[]{"123", "12", "text"}, false),
                Arguments.of(new String[]{"Hi"}, false),
                Arguments.of(new String[]{""}, false),
                Arguments.of(new String[]{"123.123"}, true),
                Arguments.of(new String[]{"-123.123"}, false),
                Arguments.of(new String[]{"123,123"}, false)
        );
    }

    @MethodSource("provideArgumentsIsAllPositiveNumbers")
    @ParameterizedTest()
    void isAllPositiveNumbersTest(String[] array, boolean expected) {
        boolean actual = Utils.isAllPositiveNumbers(array);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> provideArgumentsIsAnyPositiveNumbers() {
        return Stream.of(
                Arguments.of(new String[]{"123", "12"}, true),
                Arguments.of(new String[]{"-123", "12"}, true),
                Arguments.of(new String[]{"-1", "-2", "-3", "10", "-4", "-5",}, true),
                Arguments.of(new String[]{"-1", "-2", "-3", "-10", "-4", "-5",}, false),
                Arguments.of(new String[]{"123", "12", "text"}, true),
                Arguments.of(new String[]{"Hi"}, false),
                Arguments.of(new String[]{""}, false),
                Arguments.of(new String[]{"123.123"}, true),
                Arguments.of(new String[]{"-123.123"}, false),
                Arguments.of(new String[]{"123,123"}, false)
        );
    }

    @MethodSource("provideArgumentsIsAnyPositiveNumbers")
    @ParameterizedTest()
    void isAnyPositiveNumbersTest(String[] array, boolean expected) {
        boolean actual = Utils.isAnyPositiveNumbers(array);
        assertEquals(expected, actual);

    }
}

