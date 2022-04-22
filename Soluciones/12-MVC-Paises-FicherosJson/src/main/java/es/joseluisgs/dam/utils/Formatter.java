package es.joseluisgs.dam.utils;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Formatter {

    public static String dateParser(LocalDateTime date) {
        final Locale locale = new Locale("es", "ES");
        // private String pattern = "dd/MM/yyyy";
        return date.format(DateTimeFormatter
                .ofLocalizedDate(FormatStyle.MEDIUM).withLocale(locale));
    }

    public static String moneyParser(Double money) {
        final Locale locale = new Locale("es", "ES");
        return NumberFormat.getCurrencyInstance(locale).format(money);
    }
}
