package au2020.chingchong;

public class Main {
    public static void main(String[] args) {
        var fooClass = new ChingChonger();
        new Thread(fooClass).start();
        new Thread(fooClass).start();
    }
}
