package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static validate.InputValidation.validateNumericInput;
import static validate.InputValidation.validateInputLengthExceeded;

public class ValidateTest {

    @Test
    public void validateNumericInput_입력된_값에_숫자가_아닌_문자가_포함되어있으면_예외_발생() {
        String input = "1a";

        assertThatThrownBy(() -> validateNumericInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력된 값에 숫자가 아닌 값이 포함되어있습니다.");
     }

     @Test
    public void validateInputLengthExceeded_입력된_자동차의_이름이_5글자를_초과했을때_예외_발생() {
        String name = "abcdef";

        assertThatThrownBy(() -> validateInputLengthExceeded(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름은 5글자를 초과할 수 없습니다.");
     }
}
