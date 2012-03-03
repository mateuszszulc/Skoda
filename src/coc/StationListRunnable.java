package coc;

/**
 * Created by IntelliJ IDEA.
 * User: mateusz
 * Date: 03.03.12
 * Time: 11:21
 */
public class StationListRunnable implements Runnable {
    public void run() {
        while (true) {
            System.out.println("StationList Update perfomed...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("StationList Update completed");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
