public class TabHelper {

    public static void swap(int leftIndex, int rightIndex, int[] tab) {
        int tmp = tab[leftIndex];
        tab[leftIndex] = tab[rightIndex];
        tab[rightIndex] = tmp;
    }
}
