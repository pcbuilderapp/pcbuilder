package pcbuilder.domain.connectors;

import pcbuilder.domain.Connector;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CpuSocket extends Connector {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    public CpuSocket(String name) {
        super(name);
    }
}
