package nemo;


public interface ICaptchaService {
    void processResponse(final String response) throws ReCaptchaInvalidException, ReCaptchaUnavailableException;

    String getReCaptchaSite();

    String getReCaptchaSecret();
}
