package contract.controller;

import contract.ControllerOrder;

import java.io.IOException;

public interface IOrderPerformer {
    void orderPerform(ControllerOrder controllerOrder) throws IOException;
}
