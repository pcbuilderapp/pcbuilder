package pcbuilder.domain.connectors;

import pcbuilder.domain.Connector;
import javax.persistence.Entity;

@Entity
public class MemoryConnector extends Connector {

    public MemoryConnector(String name) {
        super(name);
    }
}
