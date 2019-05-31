package main;

import contract.IModel;
import contract.IView;
import controller.Controller;
import model.Model;
import view.View;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class MainTest {

    /**
     * Test method
     *
     * @throws IOException
     *  				the IOException
     *
     * @throws InterruptedException
     * 				the interrupted dException
     *
     * @throws SQLException
     * 				the SQl Exception
     */
    @Test
    public void testMain() throws IOException, SQLException, InterruptedException{
        IModel model = new Model(2);
        IView view = new View(model.getLevel());
        Controller controller = new Controller(view, model);

        assertNotNull(model);
        assertNotNull(view);
        assertNotNull(controller);
    }

}