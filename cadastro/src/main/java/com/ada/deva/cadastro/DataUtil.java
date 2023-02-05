package com.ada.deva.cadastro;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DataUtil {
    public static LocalDate formatarData(String date) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return LocalDate.parse(date, formatter);
        } catch(DateTimeParseException e) {
            System.err.println("Data inserida possui formato inválido. Formato aceito: DD/MM/AAAA");
        }
        return  null;
    }
}
