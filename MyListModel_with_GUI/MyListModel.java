package zadanie_21;


import javax.swing.*;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class MyListModel extends AbstractListModel<String> {

    LocalDate dzis = LocalDate.now();
    //LocalDate dzis = LocalDate.of(2020, 2, 13);
    Locale lokalizacja = new Locale("PL");

    @Override
    public int getSize() {
        return dzis.lengthOfMonth ();
    }
    @Override
    public String getElementAt(int index) {
        LocalDate date = LocalDate.of(dzis.getYear(), dzis.getMonthValue(), index+1);
        return date.getDayOfMonth() + " - " + date.getDayOfWeek().getDisplayName(TextStyle.FULL,lokalizacja);
    }
}