import javax.swing.*; // Importujemy bibliotekę do obsługi okien dialogowych

public class Main {

    public static void main(String[] args) {
        // Tablica dostępnych walut (kody ISO 4217)
        String[] currencies = {
                "USD", "EUR", "GBP", "JPY", "AUD", "CAD", "CHF", "CNY", "SEK", "NZD",
                "INR", "BRL", "ZAR", "RUB", "MXN", "HKD", "SGD", "KRW", "TRY", "PLN"
        };

        // Kursy wymiany względem bazowej waluty (np. USD)
        double[] exchangeRates = {
                1.0, 0.85, 0.75, 110.0, 1.35, 1.25, 0.92, 6.5, 8.7, 1.4,
                74.0, 5.5, 18.0, 72.0, 20.0, 7.8, 1.34, 1200.0, 18.5, 4.0
        };

        // Użytkownik wybiera walutę początkową
        String fromCurrency = (String) JOptionPane.showInputDialog(
                null,
                "Wybierz walutę początkową:",
                "Przelicznik walut",
                JOptionPane.QUESTION_MESSAGE,
                null,
                currencies,
                currencies[0]
        );

        // Jeśli użytkownik anulował, kończymy program
        if (fromCurrency == null) {
            JOptionPane.showMessageDialog(null, "Dziękujemy za skorzystanie z przelicznika!");
            return;
        }

        // Użytkownik wybiera walutę docelową
        String toCurrency = (String) JOptionPane.showInputDialog(
                null,
                "Wybierz walutę docelową:",
                "Przelicznik walut",
                JOptionPane.QUESTION_MESSAGE,
                null,
                currencies,
                currencies[1]
        );

        // Jeśli użytkownik anulował, kończymy program
        if (toCurrency == null) {
            JOptionPane.showMessageDialog(null, "Dziękujemy za skorzystanie z przelicznika!");
            return;
        }

        // Pobieramy kursy wymiany dla wybranych walut
        double fromRate = exchangeRates[java.util.Arrays.asList(currencies).indexOf(fromCurrency)];
        double toRate = exchangeRates[java.util.Arrays.asList(currencies).indexOf(toCurrency)];

        // Użytkownik wprowadza kwotę do przeliczenia
        String amountString = JOptionPane.showInputDialog(null, "Podaj kwotę w " + fromCurrency + ":");

        // Jeśli użytkownik anulował lub nie podał danych, kończymy program
        if (amountString == null || amountString.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Dziękujemy za skorzystanie z przelicznika!");
            return;
        }

        try {
            // Parsujemy wprowadzoną kwotę do liczby
            double amount = Double.parseDouble(amountString);

            // Obliczamy kwotę w walucie docelowej
            double convertedAmount = (amount / fromRate) * toRate;

            // Wyświetlamy wynik w oknie dialogowym
            JOptionPane.showMessageDialog(null, String.format(
                    "%.2f %s to %.2f %s",
                    amount, fromCurrency, convertedAmount, toCurrency
            ));
        } catch (NumberFormatException e) {
            // Obsługa błędu: użytkownik wpisał nieprawidłową kwotę
            JOptionPane.showMessageDialog(null, "Podano nieprawidłową kwotę. Spróbuj ponownie.");
        }

        // Kończymy działanie programu
        JOptionPane.showMessageDialog(null, "Dziękujemy za skorzystanie z przelicznika!");
    }
}
