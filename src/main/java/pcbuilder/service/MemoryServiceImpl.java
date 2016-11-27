package pcbuilder.service;

import pcbuilder.domain.components.Memory;
import pcbuilder.domain.connectors.MemoryConnector;

import java.util.ArrayList;
import java.util.List;

public class MemoryServiceImpl implements MemoryService{

    public void save(Memory memory) {

    }

    public Memory getById(Long id) {
        return new Memory("test", "Crucial", "ABD123123","2133Mhz", "DDR4", new MemoryConnector("DDR4"));
    }

    public List<Memory> getByBrand(String brand) {

        List<Memory> memories = new ArrayList();
        memories.add(new Memory("test", "Crucial", "ABD123123","2133Mhz", "DDR4", new MemoryConnector("DDR4")));
        return memories;
    }

    public List<Memory> getAll() {
        List<Memory> memories = new ArrayList();
        memories.add(new Memory("test", "Crucial", "ABD123123","2133Mhz", "DDR4", new MemoryConnector("DDR4")));
        return memories;
    }

    public void delete(Memory memory){

    }

}
