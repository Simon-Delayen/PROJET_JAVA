package contract.model;

public enum Permeability {

    /** The penetrable for back (background). */
    PENETRABLE,

    /** The blocking for walls and rocks. */
    BLOCKING,

    /** The opening for diamond */
    OPENNING,

    /** The open door */
    OPENDOOR,

    /** Death for the hero if a monster touches him. */
    DEAD,

    /** The dirt is breakable */
    BREAKABLE;
}
