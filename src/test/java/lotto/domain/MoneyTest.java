package lotto.domain;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.exception.InvalidMoneyException;
import lotto.exception.NotIntegerException;

public class MoneyTest {
	@DisplayName("숫자가 아닌 구입금액을 입력한 경우")
	@Test
	void validateInteger() {
		assertThatThrownBy(() -> new Money("학성"))
			.isInstanceOf(NotIntegerException.class);
	}

	@DisplayName("1000원 미만의 금액을 입력한 경우")
	@Test
	void validateOverThousand() {
		assertThatThrownBy(() -> new Money("999"))
			.isInstanceOf(InvalidMoneyException.class);
	}

	@Test
	void canBuyLottoTest() {
		Money money = new Money("1000");
		assertThat(money.canBuyLotto(1)).isTrue();
		assertThat(money.canBuyLotto(2)).isFalse();
	}

	@Test
	void calculateLottoCountTest() {
		Money money = new Money("10000");
		assertThat(money.calculateLottoCount(1)).isEqualTo(9);
	}

	@DisplayName("수익률 계산")
	@Test
	void calculateIncomeRate() {
		Money money = new Money("1000");
		assertThat(money.calculateIncomeRate(3000)).isEqualTo(300);

		money = new Money("1000");
		assertThat(money.calculateIncomeRate(0)).isEqualTo(0);

		money = new Money("10000");
		assertThat(money.calculateIncomeRate(5000)).isEqualTo(50);
	}
}
