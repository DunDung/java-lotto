package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import lotto.exception.InvalidSizeException;

public class Lotto {
	private static final int LOTTO_SIZE = 6;

	private final Set<LottoNo> lottoNumbers;

	public Lotto(List<Integer> lottoNumbers) {
		this.lottoNumbers = lottoNumbers.stream()
			.map(LottoNo::of)
			.collect(Collectors.toSet());

		if (this.lottoNumbers.size() != LOTTO_SIZE) {
			throw new InvalidSizeException();
		}
	}

	public boolean contain(LottoNo lottoNo) {
		return lottoNumbers.contains(lottoNo);
	}

	public int compare(Lotto lotto) {
		return (int)this.lottoNumbers.stream()
			.filter(lotto::contain)
			.count();
	}

	@Override
	public String toString() {
		return lottoNumbers.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Lotto lotto = (Lotto)o;
		return Objects.equals(lottoNumbers, lotto.lottoNumbers);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lottoNumbers);
	}
}
