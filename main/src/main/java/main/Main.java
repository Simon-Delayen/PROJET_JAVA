/**
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
package main;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;
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
     * The main function of boulder dash
     * It instantiate a model, view and controller
     * It make the view updating in function of the controller
     * It launch the heart of the game (play) which is a loop that run until player as 0 life
     *
     * @param args
     *            the arguments
     *
     * @throws IOException
     * 				the IOException
     *
     * @throws InterruptedException
     * 				the interrupted dException
     *
     * @throws SQLException
     * 				the SQl Exception
     */
    public static void main(final String[] args) throws IOException, InterruptedException, SQLException {
        final IModel model = new Model(2); //change the number to the wanted level
        final IView view = new View(model.getLevel()); //we gave to the view the level and all element that the level contain
        final Controller controller = new Controller(view, model); //the controller got the view and model to control them
        view.setOrderPerformer(controller.getOrderPerformer()); //this enable the view be update when there is a player movement from the controller

        controller.play(); //launch the 'infinite' loop of the game
    }
}
