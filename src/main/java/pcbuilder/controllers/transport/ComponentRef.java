package pcbuilder.controllers.transport;

import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pcbuilder.controllers.ComponentController;
import pcbuilder.domain.Component;
import pcbuilder.repository.ComponentRepository;

/**
 * The Class ComponentRef.
 */
public class ComponentRef {
    
    /** The id. */
    private Long id;

    /**
     * Gets the id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }
}
