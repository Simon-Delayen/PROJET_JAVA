package model.element.mobile;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class Monster2Test {

    /**
     * Test method for {@link model.element.mobile.Monster2#ConstructorWithoutLevel()}.
     */
    @Test
    public void testContructorWithoutLevel() throws IOException {
        assertNotNull(new Monster2(0, 0, null));
    }

}