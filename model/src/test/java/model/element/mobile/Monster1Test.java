package model.element.mobile;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class Monster1Test {


    @Test
    public void testConstructorWithoutLevel() throws IOException {
        assertNotNull(new Monster1(0, 0, null));
    }

}