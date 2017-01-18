package pcbuilder.controllers.transport;

import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pcbuilder.controllers.ComponentController;
import pcbuilder.domain.Component;
import pcbuilder.repository.ComponentRepository;

public class ComponentRef {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
