package pcbuilder.controllers.transport;

import pcbuilder.domain.CType;

/**
 * The Class ConnectorData.
 */
public class ConnectorData {

    private String name;
    private CType type;

    /**
     * Gets the name.
     *
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the type.
     *
     * @return CType
     */
    public CType getType() {
        return type;
    }

    /**
     * Sets the type.
     *
     * @param type CType
     */
    public void setType(CType type) {
        this.type = type;
    }
}
