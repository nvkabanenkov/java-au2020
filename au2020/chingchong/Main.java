package au2020.chingchong;

public class Main {
    public static void main(String[] args) {
        var chingChonger = new ChingChonger();
        new Thread(chingChonger).start();
        new Thread(chingChonger).start();
    }
}
