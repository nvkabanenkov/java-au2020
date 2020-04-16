package au2020.chingchong2;

import static java.lang.Thread.sleep;

public class ChingChonger implements Runnable {
    private static final int NUMBER_OF_CHINGCHONGS = 100000;
    private static final int DELAY = 0;

    public ChingChonger() {
        currentState = STATE_CHONG;
    }

    public synchronized void say(int threadId) throws InterruptedException {
        if (threadId % 2 == 0 && currentState == STATE_CHING) {
            currentState = STATE_CHONG;
            System.out.println("Chong! Said thread \"" + threadId + "\"");
        } else if (threadId % 2 == 1 && currentState == STATE_CHONG) {
            currentState = STATE_CHING;
            System.out.println("Ching! Said thread \"" + threadId + "\"");
        }

        sleep(DELAY);
    }

    @Override
    public void run() {
        int threadId = lastThreadId;
        ++lastThreadId;
        try {
            for(int i = 0; i < NUMBER_OF_CHINGCHONGS; ++i)
                say(threadId);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private int currentState;
    private static int lastThreadId = 0;

    private static final int STATE_CHING = 1;
    private static final int STATE_CHONG = 2;
}
