package model.element.mobile;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class Monster2Test {


    @Test
    public void testConstructorWithoutLevel() throws IOException {
        assertNotNull(new Monster2(0, 0, null));
    }

}