package pcbuilder.controllers.dto;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The Class Configuration.
 */
public class Configuration implements Iterable<ComponentRef> {

    private static final int COMPONENT_COUNT = 7;
    private ComponentRef motherboard;
    private ComponentRef cpu;
    private ComponentRef gpu;
    private ComponentRef memory;
    private ComponentRef storage;
    private ComponentRef psu;
    private ComponentRef casing;

    /**
     * Gets the motherboard.
     *
     * @return the motherboard
     */
    public ComponentRef getMotherboard() {
        return motherboard;
    }

    /**
     * Sets the motherboard.
     *
     * @param motherboard ComponentRef motherboard
     */
    @SuppressWarnings("unused")
    public void setMotherboard(ComponentRef motherboard) {
        this.motherboard = motherboard;
    }

    /**
     * Gets the cpu.
     *
     * @return cpu
     */
    ComponentRef getCpu() {
        return cpu;
    }

    /**
     * Sets the cpu.
     *
     * @param cpu ComponentRef cpu
     */
    @SuppressWarnings("unused")
    public void setCpu(ComponentRef cpu) {
        this.cpu = cpu;
    }

    /**
     * Gets the gpu.
     *
     * @return the gpu
     */
    ComponentRef getGpu() {
        return gpu;
    }

    /**
     * Sets the gpu.
     *
     * @param gpu ComponentRef gpu
     */
    @SuppressWarnings("unused")
    public void setGpu(ComponentRef gpu) {
        this.gpu = gpu;
    }

    /**
     * Gets the memory.
     *
     * @return the memory
     */
    ComponentRef getMemory() {
        return memory;
    }

    /**
     * Sets the memory.
     *
     * @param memory ComponentRef memory
     */
    @SuppressWarnings("unused")
    public void setMemory(ComponentRef memory) {
        this.memory = memory;
    }

    /**
     * Gets the storage.
     *
     * @return the storage
     */
    ComponentRef getStorage() {
        return storage;
    }

    /**
     * Sets the storage.
     *
     * @param storage ComponentRef storage
     */
    @SuppressWarnings("unused")
    public void setStorage(ComponentRef storage) {
        this.storage = storage;
    }

    /**
     * Gets the psu.
     *
     * @return the psu
     */
    ComponentRef getPsu() {
        return psu;
    }

    /**
     * Sets the psu.
     *
     * @param psu ComponentRef
     */
    @SuppressWarnings("unused")
    public void setPsu(ComponentRef psu) {
        this.psu = psu;
    }

    /**
     * Gets the casing.
     *
     * @return the casing
     */
    ComponentRef getCasing() {
        return casing;
    }

    /**
     * Sets the casing.
     *
     * @param casing ComponentRef
     */
    @SuppressWarnings("unused")
    public void setCasing(ComponentRef casing) {
        this.casing = casing;
    }

    @Override
    public Iterator<ComponentRef> iterator() {
        return new ComponentRefIterator(this,0, COMPONENT_COUNT);
    }

    /**
     * Checks for components.
     *
     * @return true, if successful
     */
    public boolean hasComponents() {
        for (ComponentRef componentRef : this) {
            if (componentRef != null)
                return true;
        }
        return false;
    }

    /**
     * The Class ComponentRefIterator.
     */
    private static final class ComponentRefIterator implements Iterator<ComponentRef> {

        private int cursor;
        private final int end;
        private final Configuration configuration;

        /**
         * Instantiates a new component ref iterator.
         *
         * @param configuration Configuration
         * @param start int
         * @param end int
         */
        ComponentRefIterator(Configuration configuration,int start, int end) {
            this.configuration = configuration;
            this.cursor = start;
            this.end = end;
        }

        @Override
        public boolean hasNext() {
            return this.cursor < end;
        }

        @Override
        public ComponentRef next() {
            if(this.hasNext()) {
                ComponentRef componentRef = new ComponentRef();
                if (cursor == 0) {
                    componentRef = configuration.getMotherboard();
                } else if (cursor == 1) {
                    componentRef = configuration.getCasing();
                } else if (cursor == 2) {
                    componentRef = configuration.getCpu();
                } else if (cursor == 3) {
                    componentRef = configuration.getGpu();
                } else if (cursor == 4) {
                    componentRef = configuration.getMemory();
                } else if (cursor == 5) {
                    componentRef = configuration.getPsu();
                } else if (cursor == 6) {
                    componentRef = configuration.getStorage();
                }
                cursor++;
                return componentRef;
            }
            throw new NoSuchElementException();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
