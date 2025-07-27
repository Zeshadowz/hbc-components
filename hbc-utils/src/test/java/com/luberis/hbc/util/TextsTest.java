package com.luberis.hbc.util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class TextsTest {

    private static Stream<Arguments> provideStringsForIsBlank() {
        return Stream.of(
                Arguments.of(null, true),
                Arguments.of("", true),
                Arguments.of("  ", true),
                Arguments.of(" \t ", true),
                Arguments.of(" \n ", true),
                Arguments.of(" Not ", false),
                Arguments.of(" 1 ", false),
                Arguments.of("not blank", false)
        );
    }

    @ParameterizedTest
    @MethodSource("provideStringsForIsBlank")
    void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input, boolean expected) {
        assertThat(Texts.isBlank(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("provideStringsForIsBlank")
    void isNotBlank_ShouldReturnFalseForNullOrBlankStrings(String input, boolean expected) {
        assertThat(Texts.isNotBlank(input)).isEqualTo(!expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  ", "\t", "\n"})
    @NullSource
    @EmptySource
    @NullAndEmptySource
    void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input) {
        assertThat(Texts.isBlank(input)).isTrue();
    }
}