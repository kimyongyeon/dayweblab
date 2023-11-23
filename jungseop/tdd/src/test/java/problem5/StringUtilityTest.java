package problem5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.NullString;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilityTest {

    @ParameterizedTest
    @CsvSource(value = {
            ":",
            "a:A", "abc:ABC", "dfgh:DFGH",
            " ab: AB", "a bc:A BC", "ab :AB ",
            "String Utility Test:STRING UTILITY TEST", "abCdEFg:ABCDEFG",
            "테스트:테스트","황:황","ㅁㄴㅇㄹ:ㅁㄴㅇㄹ"
    }, delimiter = ':')
    @DisplayName("입력받은 문자열을 대문자로 바꿔 반환하는지 검사한다.")
    void checkConvertToUpperCorrectly(String input, String expected) {
        String upperCase = StringUtility.convertToUpper(input);

        assertEquals(upperCase, expected);
    }

}