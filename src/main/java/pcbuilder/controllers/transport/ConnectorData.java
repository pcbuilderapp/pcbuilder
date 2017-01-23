package pcbuilder.controllers.transport;

import pcbuilder.domain.CType;

/**
 * The Class ConnectorData.
 */
public class ConnectorData {

    /** The name. */
    private String name;
    
    /** The type. */
    private CType type;

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the type.
     *
     * @return the type
     */
    public CType getType() {
        return type;
    }

    /**
     * Sets the type.
     *
     * @param type
     */
    public void setType(CType type) {
        this.type = type;
    }
}
