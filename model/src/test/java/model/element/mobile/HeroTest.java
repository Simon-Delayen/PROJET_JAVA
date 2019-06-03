package model.element.mobile;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class HeroTest {

    @Test
    public void testConstructorWithoutLevel() throws IOException {
        assertNotNull(new Hero(0, 0, null));
    }

}