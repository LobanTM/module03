package module3_21;

/**
 * Created by tetya on 20.07.2017.
 */
public class CustomException extends Exception {
    private String information;

    public CustomException(String information) {
        this.information = information;
    }

    public CustomException(String message, String information) {
        super(message);
        this.information = information;
    }

    public CustomException(String message, Throwable cause, String information) {
        super(message, cause);
        this.information = information;
    }

    public CustomException(Throwable cause, String information) {
        super(cause);
        this.information = information;
    }

    public CustomException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String information) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.information = information;
    }

    public String toString(){
        return "CustomException: " + information;
    }
}
