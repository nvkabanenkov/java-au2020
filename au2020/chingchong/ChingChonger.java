package au2020.chingchong;

import static java.lang.Thread.sleep;

public class ChingChonger implements Runnable {
    private static final int NUMBER_OF_CHINGCHONGS = 10;
    private static final int DELAY = 500;

    public ChingChonger() {
        currentState = STATE_CHONG;
    }

    public synchronized void say() throws InterruptedException {
        if (currentState == STATE_CHING) {
            currentState = STATE_CHONG;
            System.out.println("Chong!");
        } else if (currentState == STATE_CHONG) {
            currentState = STATE_CHING;
            System.out.println("Ching!");
        }
        sleep(DELAY);
    }

    @Override
    public void run() {
        try {
            for(int i = 0; i < NUMBER_OF_CHINGCHONGS; ++i)
                say();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private int currentState;

    private static final int STATE_CHING = 1;
    private static final int STATE_CHONG = 2;
}
