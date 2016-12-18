package pcbuilder.controllers.transport;

import pcbuilder.domain.CType;

public class ConnectorData {

    private String name;
    private CType type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CType getType() {
        return type;
    }

    public void setType(CType type) {
        this.type = type;
    }
}
