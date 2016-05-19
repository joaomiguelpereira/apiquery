package eu.jpereira.ext.provider;

/**
 * Created by jpereira on 19/05/2016.
 */
public class ProviderException extends RuntimeException {
    public ProviderException(String message, Exception ex) {

        super(message,ex);
    }

    public ProviderException(String message) {
        super(message);
    }
}
