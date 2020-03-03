package lotto.domain;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoManagerTest {
	private LottoManager lottoManager;

	@BeforeEach
	void setUp() {
		Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
		Lotto lotto2 = new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9));

		List<Lotto> lotteries = Arrays.asList(lotto1, lotto2);
		WinLotto winLotto = new WinLotto("1,2,3,4,5,7", "6");
		lottoManager = new LottoManager(lotteries, winLotto);
	}

	@Test
	void compareLotteriesTest() {
		List<Rank> ranks = Arrays.asList(Rank.SECOND, Rank.FIFTH);

		assertThat(lottoManager.compareLotteries()).isEqualTo(ranks);
	}

}