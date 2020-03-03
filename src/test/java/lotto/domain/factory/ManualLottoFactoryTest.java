package lotto.domain.factory;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import lotto.domain.Lotto;

public class ManualLottoFactoryTest {

	@Test
	void createTest() {
		Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
		assertThat(new ManualLottoFactory("1, 2, 3, 4, 5, 6").create()).isEqualTo(lotto);
	}
}
