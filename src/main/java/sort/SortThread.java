package sort;

public class SortThread extends Thread {

    private final SortStrategy sortStrategy;
    private final int[] tab;
//    private boolean ended;

    public SortThread(SortStrategy sortStrategy, int[] tab) {
        this.sortStrategy = sortStrategy;
        this.tab = tab;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            sortStrategy.sort(tab);
//            ended = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//    public boolean isEnded() {
//        return ended;
//    }
}
