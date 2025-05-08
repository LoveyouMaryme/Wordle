import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AffichageTest {

    @Test
    void formatSuffixes() {
        StringBuilder actual = new StringBuilder();

        int[] numbers = {1, 2, 3, 4, 5};

        for (int number : numbers) {
            actual.append(Affichage.formatSuffixes(number));
        }

        assertEquals("stndrdthth", actual.toString());
    }
}
