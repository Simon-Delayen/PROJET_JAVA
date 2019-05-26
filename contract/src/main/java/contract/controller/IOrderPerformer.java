package contract.controller;

import contract.ControllerOrder;

import java.io.IOException;

public interface IOrderPerformer {

    /**
     * Order perform.
     *
     * @param controllerOrder
     *            the user order
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    void orderPerform(ControllerOrder controllerOrder) throws IOException;
}
