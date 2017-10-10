package main;

import org.junit.jupiter.api.Test;

class RiddleWordTest {
    @Test
    void getWord() {
        assert (new RiddleWord("TEST")).getWord().equals("****");
    }

    @Test
    void wordComplete() {
        assert !(new RiddleWord("TEST")).wordComplete();
    }

    @Test
    void checkLetter() {
        assert (new RiddleWord("TEST")).CheckLetter('T');
    }

}