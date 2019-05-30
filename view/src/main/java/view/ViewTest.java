package view;

import contract.ControllerOrder;
import org.junit.Test;

import java.awt.event.KeyEvent;

import static org.junit.Assert.*;

public class ViewTest {

    @Test
    public void testKeyCodeToControllerOrderRIGHT(){
        assertEquals(View.keyCodeToControllerOrder(KeyEvent.VK_RIGHT), ControllerOrder.RIGHT);
        assertEquals(View.keyCodeToControllerOrder(KeyEvent.VK_D), ControllerOrder.RIGHT);
    }

    @Test
    public void testKeyCodeToControllerOrderLEFT(){
        assertEquals(View.keyCodeToControllerOrder(KeyEvent.VK_LEFT), ControllerOrder.LEFT);
        assertEquals(View.keyCodeToControllerOrder(KeyEvent.VK_Q), ControllerOrder.LEFT);
    }

    @Test
    public void testKeyCodeToControllerOrderDOWN(){
        assertEquals(View.keyCodeToControllerOrder(KeyEvent.VK_DOWN), ControllerOrder.DOWN);
        assertEquals(View.keyCodeToControllerOrder(KeyEvent.VK_S), ControllerOrder.DOWN);
    }

    @Test
    public void testKeyCodeToControllerOrderUP(){
        assertEquals(View.keyCodeToControllerOrder(KeyEvent.VK_UP), ControllerOrder.UP);
        assertEquals(View.keyCodeToControllerOrder(KeyEvent.VK_Z), ControllerOrder.UP);
    }

    @Test
    public void testKeyCodeToControllerOrderNOP(){
        assertEquals(View.keyCodeToControllerOrder(KeyEvent.VK_F), ControllerOrder.NOP);
        assertEquals(View.keyCodeToControllerOrder(KeyEvent.VK_ALT), ControllerOrder.NOP);
        assertEquals(View.keyCodeToControllerOrder(KeyEvent.VK_KP_RIGHT), ControllerOrder.NOP);
    }

}