package lotto.exception;

public class DuplicateNumberException extends RuntimeException {
	private static final String ERROR_MESSAGE_DUPLICATE_NUMBER = "보너스볼이 중복됩니다.";

	public DuplicateNumberException() {
		super(ERROR_MESSAGE_DUPLICATE_NUMBER);
	}
}
