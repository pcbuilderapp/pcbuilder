package pcbuilder.service;

import pcbuilder.domain.components.Memory;

import java.util.List;

public interface MemoryService {

    public void save(Memory memory);
    public Memory getById(Long id);
    public List<Memory> getByBrand(String brand);
    public List<Memory> getAll();
    public void delete(Memory memory);

}
