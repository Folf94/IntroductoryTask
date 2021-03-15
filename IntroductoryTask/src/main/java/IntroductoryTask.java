import java.util.*;
import java.util.regex.Pattern;

public class IntroductoryTask {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Введите выражение, например: 2[3[x]y]");
        String s = SCANNER.nextLine();
        StringTokenizer stringTokenizer = new StringTokenizer(s, "[]", false);

        if (!isValid(s)) {
            System.out.println("Введены недопустимые символы, введите заново:");
            s = SCANNER.nextLine();
        }

        if (isValid(s)) {
            while (stringTokenizer.hasMoreTokens()) {
                String a = stringTokenizer.nextToken();
                if (isNumeric(a)) {
                    int digitFirst = Integer.parseInt(a);
                    String b = stringTokenizer.nextToken();
                    if (isNumeric(b)) {
                        int digitSecond = Integer.parseInt(b);
                        String c = stringTokenizer.nextToken();
                        if (!isNumeric(c)) {
                            System.out.print(c.repeat(digitSecond));
                            String d = stringTokenizer.nextToken();
                            if (!isNumeric(d)) {
                                System.out.print(d);
                                System.out.print(c.repeat(digitSecond));
                            }
                            System.out.print(d);
                        }
                    }
                    if (!isNumeric(b)) {
                        System.out.print(b.repeat(digitFirst));
                    }

                } else System.out.println(a);
            }
        }
        SCANNER.close();
    }

    public static boolean isValid(String str) {
        return str.matches("[0-9_a-zA-Z\\]\\[]+");
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
