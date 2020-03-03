package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import lotto.exception.InvalidRangeException;
import lotto.validator.Validator;

public class LottoNo implements Comparable<LottoNo> {
	public static final int MIN = 1;
	public static final int MAX = 45;
	private static final Map<Integer, LottoNo> lottoBox = new HashMap<>();

	private final int number;

	static {
		for (int index = MIN; index <= MAX; index++) {
			lottoBox.put(index, new LottoNo(index));
		}
	}

	private LottoNo(int number) {
		this.number = number;
	}

	public static LottoNo of(String number) {
		Validator.validateInteger(number);
		return of(Integer.parseInt(number));
	}

	public static LottoNo of(int number) {
		validateLottoRange(number);
		return lottoBox.get(number);
	}

	private static void validateLottoRange(int number) {
		if (isNotLottoRange(number)) {
			throw new InvalidRangeException();
		}
	}

	private static boolean isNotLottoRange(int number) {
		return number < MIN || number > MAX;
	}

	@Override
	public int compareTo(LottoNo other) {
		return this.number - other.number;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		LottoNo lottoNo = (LottoNo)o;
		return number == lottoNo.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}

	@Override
	public String toString() {
		return String.valueOf(number);
	}
}
