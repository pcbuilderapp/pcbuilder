package pcbuilder.domain;

import org.springframework.beans.factory.annotation.Autowired;
import pcbuilder.repository.ComponentRepository;

public class ComponentRef {
    @Autowired
    private ComponentRepository componentRepository;

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Component component() {
        return componentRepository.getOne(id);
    }
}
