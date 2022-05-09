package studio.square.testproject.common.exception;

import org.springframework.http.HttpStatus;
import studio.square.testproject.common.Constants;

public class AroundHubException extends Exception {

    private static final long serialVersionUID = 1L;

    private Constants.ExceptionClass exceptionClass;
    private HttpStatus httpStatus;

    public AroundHubException(Constants.ExceptionClass exceptionClass, HttpStatus httpStatus, String message) {
        super(exceptionClass.toString() + message);
        this.exceptionClass = exceptionClass;
        this.httpStatus = httpStatus;
    }

    public Constants.ExceptionClass getExceptionClass() {
        return exceptionClass;
    }

    public int getHttpStatusCode() {
        return httpStatus.value();
    }

    public String getHttpStatusType() {
        return httpStatus.getReasonPhrase();
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
