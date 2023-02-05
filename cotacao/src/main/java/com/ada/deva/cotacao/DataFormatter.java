package com.ada.deva.cotacao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DataFormatter {
    public static LocalDateTime dataFormatter(String date) {
        date = date.replace(" ", "T");

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
            return LocalDateTime.parse(date, formatter);
        } catch(DateTimeParseException e) {
            System.err.println("Formato de data inválido! Digite como dd/mm/aaaa");
        }

        return  null;
    }
}
