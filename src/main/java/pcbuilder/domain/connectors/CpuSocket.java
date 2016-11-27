package pcbuilder.domain.connectors;

import pcbuilder.domain.Connector;
import javax.persistence.Entity;

@Entity
public class CpuSocket extends Connector {

    public CpuSocket(String name) {
        super(name);
    }
}
