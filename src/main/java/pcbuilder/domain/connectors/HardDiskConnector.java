package pcbuilder.domain.connectors;

import pcbuilder.domain.Connector;
import javax.persistence.Entity;

@Entity
public class HardDiskConnector extends Connector {

    public HardDiskConnector(String name) {
        super(name);
    }
}
