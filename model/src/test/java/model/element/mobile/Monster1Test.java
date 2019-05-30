package model.element.mobile;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class Monster1Test {

    /**
     * Test method for {@link model.element.mobile.Monster1#ConstructorWithoutLevel()}.
     */
    @Test
    public void testContructorWithoutLevel() throws IOException {
        assertNotNull(new Monster1(0, 0, null));
    }

}