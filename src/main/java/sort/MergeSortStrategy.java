package sort;

public class MergeSortStrategy implements SortStrategy {
    @Override
    public void sort(int[] tab) {
        sort(tab, 0, tab.length - 1);
    }

    private void sort(int[] tab, int left, int right) {
        if (left < right) {
            int srodek = (left + right) / 2;
            sort(tab, left, srodek);
            sort(tab, srodek + 1, right);
            scal(tab, left, srodek, right);
        }
    }

    private void scal(int[] tab, int left, int srodek, int right) {

        // potrzebujemy określić, gdzie w naszej tablicy znajdują się podtablice do scalenia
        int leftIndex1 = left;
        int rightIndex1 = srodek;

        int leftIndex2 = srodek + 1;
        int rightIndex2 = right;

        int[] tmpTab = new int[tab.length];

        int i = left;

        while (leftIndex1 <= rightIndex1 && leftIndex2 <= rightIndex2) {

            if (tab[leftIndex1] < tab[leftIndex2]) {
                tmpTab[i] = tab[leftIndex1];
                leftIndex1++;
            } else {
                tmpTab[i] = tab[leftIndex2];
                leftIndex2++;
            }

            i++;
        }

        while (leftIndex1 <= rightIndex1) {
            tmpTab[i] = tab[leftIndex1];
            i++;
            leftIndex1++;
        }

        while (leftIndex2 <= rightIndex2) {
            tmpTab[i] = tab[leftIndex2];
            i++;
            leftIndex2++;
        }

        for (i = left; i <= right; i++) {
            tab[i] = tmpTab[i];
        }
    }
}
