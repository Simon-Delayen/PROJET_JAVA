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
        final Model model = new Model(1);                           // change le nombre au niveau désiré
        final View view = new View(model.getLevel());                     // nous avons donné à la vue le niveau et tous les éléments contenus dans le niveau
        //final Controller controller = new Controller(view, model);        // le contrôleur a la vue et le modèle pour les contrôler
        //view.setOrderPerformer(controller.getOrderPeformer());          // cela permet à la vue d'être mise à jour lorsqu'il y a un mouvement de joueur depuis le contrôleur
        //view.setController(controller.getOrderPeformer());


        //controller.play();                                              // lance la boucle 'infinie' du jeu
        }
    }
