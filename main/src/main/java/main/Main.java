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
     * The main method.
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
        final IModel model = new Model(2);                           // change le nombre au niveau désiré
        final IView view = new View(model.getLevel());                     // nous avons donné à la vue le niveau et tous les éléments contenus dans le niveau
        final Controller controller = new Controller(view, model);        // le contrôleur a la vue et le modèle pour les contrôler
        view.setOrderPerformer(controller.getOrderPerformer());          // cela permet à la vue d'être mise à jour lorsqu'il y a un mouvement de joueur depuis le contrôleur

        controller.play();
    }
}
