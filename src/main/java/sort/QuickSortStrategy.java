package sort;

public class QuickSortStrategy implements SortStrategy {
    @Override
    public void sort(int[] tab) {
        sort(tab, 0, tab.length - 1);
    }

    private void sort(int[] tab, int left, int right) {

        int pivotIndex = left;
        int switchIndex = right;
        boolean fromLeft = false;

        if (left < right) {
            while (pivotIndex != switchIndex) {

                if ((tab[pivotIndex] > tab[switchIndex] && !fromLeft) || (tab[pivotIndex] < tab[switchIndex] && fromLeft)) {

                    int tmp = tab[switchIndex];
                    tab[switchIndex] = tab[pivotIndex];
                    tab[pivotIndex] = tmp;

                    int tmpIndex = switchIndex;
                    switchIndex = pivotIndex;
                    pivotIndex = tmpIndex;

                    fromLeft = !fromLeft;
                }

                if (fromLeft) {
                    switchIndex++;
                } else {
                    switchIndex--;
                }
            }

            sort(tab, left, pivotIndex - 1);
            sort(tab, pivotIndex + 1, right);
        }
    }
}
