package HomeWork02;

class StaticPharseService {
    public static String removeFirstChar(String s) {
        return (s == null || s.length() == 0) ? "" : (s.substring(1));
    }
}
