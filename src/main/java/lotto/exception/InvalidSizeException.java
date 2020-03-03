package lotto.exception;

public class InvalidSizeException extends RuntimeException {
	private static final String ERROR_MESSAGE_LOTTO_SIZE = "6개의 숫자가 아니거나 중복된 숫자가 있습니다.";

	public InvalidSizeException() {
		super(ERROR_MESSAGE_LOTTO_SIZE);
	}
}
