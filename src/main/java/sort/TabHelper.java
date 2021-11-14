package sort;

public class TabHelper {

    public static void swap(int[] tab, int left, int right) {
        int tmp = tab[left];
        tab[left] = tab[right];
        tab[right] = tmp;
    }
}
