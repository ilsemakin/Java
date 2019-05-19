package Exception;

public class FileReadException extends Exception {

    private final String output;

    public FileReadException() {
        this.output = "Данная строка не соответствует требуемому формату :\n";
    }

    @Override
    public String toString() {
        return output;
    }

    @Override
    public String getMessage() {
        return this.toString();
    }

}
