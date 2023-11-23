package date;

public class YearHelper {

    static boolean isSchaltjahr(int jahr) {
        return ((jahr % 4 == 0) && (jahr % 100 != 0) || (jahr % 400 == 0));
    }
}
