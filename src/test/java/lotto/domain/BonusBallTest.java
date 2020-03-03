package lotto.domain;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusBallTest {

	@DisplayName("1~6까지의 로또번호를 가진 로또 생성 후 보너스볼이 포함되어있는지 테스트")
	@Test
	void isContainBonusBall() {
		Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

		BonusBall containsBall = new BonusBall("3");
		BonusBall notContainsBall = new BonusBall("9");

		assertThat(containsBall.isMatch(lotto)).isTrue();
		assertThat(notContainsBall.isMatch(lotto)).isFalse();
	}
}
