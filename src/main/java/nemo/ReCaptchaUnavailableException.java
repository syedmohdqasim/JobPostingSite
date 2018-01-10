package nemo;

import org.springframework.web.client.RestClientException;

public class ReCaptchaUnavailableException extends Throwable {
    public ReCaptchaUnavailableException(String message, RestClientException rce) {

    }
}
