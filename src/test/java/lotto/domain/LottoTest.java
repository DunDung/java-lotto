package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.exception.InvalidSizeException;

public class LottoTest {

	@Test
	void isContain() {
		Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

		assertThat(lotto.contain(LottoNo.of(1))).isTrue();
		assertThat(lotto.contain(LottoNo.of(7))).isFalse();
	}

	@DisplayName("로또 번호의 개수가 6개인지 검사")
	@Test
	void validateLottoSizeTest() {
		assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6, 7)))
			.isInstanceOf(InvalidSizeException.class);
	}

	@DisplayName("로또 번호에 중복된 숫자가 있는지 검사")
	@Test
	void validateDuplicateNumbersTest() {
		assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 1, 2, 2, 3, 3)))
			.isInstanceOf(InvalidSizeException.class);
	}
}
