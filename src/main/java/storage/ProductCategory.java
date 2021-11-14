package storage;

import javax.print.attribute.standard.MediaSize;

public enum ProductCategory {
    SRODKI_CZYSTOSCI,
    POZYWIENIE,
    NARZEDZIA;

    public static ProductCategory fromInteger(int x) {
        switch(x) {
            case 1:
                return SRODKI_CZYSTOSCI;
            case 2:
                return POZYWIENIE;
            case 3:
                return NARZEDZIA;
        }
        return null;
    }
}
