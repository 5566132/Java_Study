package Try_Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Desk {
    static boolean foodflag = true;
    static Lock lock = new ReentrantLock();
    static int food = 10;
}
