import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AffichageTest {

    @Test
    void formatSuffixes() {

        int[] numbers = {1, 2, 3, 4, 5};
        for(int number : numbers) {
            System.out.println(Affichage.formatSuffixes(number));

        }
    }
}