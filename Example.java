public class Example {
public static void main(String[] args){}

    public static boolean isInteger(String x) {
        try {
            if (Integer.parseInt(x) % 1 == 0) {
                return true;
            }
        }
        catch (NumberFormatException e) {
            return false;
        }
        return false;
    }
}
