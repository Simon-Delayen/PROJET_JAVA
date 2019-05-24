/**
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
package main;

import contract.ControllerOrder;
import contract.IModel;
import controller.Controller;
import model.Model;
import view.View;

import java.io.IOException;
import java.sql.SQLException;

/**
 * The Class Main.
 *
 * @author Jean-Aymeric Diet
 */
public abstract class Main {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(final String[] args) throws IOException, InterruptedException, SQLException {
        final Model model = new Model(1);
        final View view = new View(model.getLevel());
        final Controller controller = new Controller(view, model);
        view.setController(controller.getOrderPeformer());

        //controller.play();
        }
    }
