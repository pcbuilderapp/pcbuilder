package pcbuilder.controllers.transport;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

// TODO: Auto-generated Javadoc
/**
 * The Class Configuration.
 */
public class Configuration implements Iterable<ComponentRef> {

    /** The component count. */
    private final int componentCount = 7;

    /** The motherboard. */
    private ComponentRef motherboard;
    
    /** The cpu. */
    private ComponentRef cpu;
    
    /** The gpu. */
    private ComponentRef gpu;
    
    /** The memory. */
    private ComponentRef memory;
    
    /** The storage. */
    private ComponentRef storage;
    
    /** The psu. */
    private ComponentRef psu;
    
    /** The casing. */
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
     * @param motherboard the new motherboard
     */
    public void setMotherboard(ComponentRef motherboard) {
        this.motherboard = motherboard;
    }

    /**
     * Gets the cpu.
     *
     * @return the cpu
     */
    public ComponentRef getCpu() {
        return cpu;
    }

    /**
     * Sets the cpu.
     *
     * @param cpu the new cpu
     */
    public void setCpu(ComponentRef cpu) {
        this.cpu = cpu;
    }

    /**
     * Gets the gpu.
     *
     * @return the gpu
     */
    public ComponentRef getGpu() {
        return gpu;
    }

    /**
     * Sets the gpu.
     *
     * @param gpu the new gpu
     */
    public void setGpu(ComponentRef gpu) {
        this.gpu = gpu;
    }

    /**
     * Gets the memory.
     *
     * @return the memory
     */
    public ComponentRef getMemory() {
        return memory;
    }

    /**
     * Sets the memory.
     *
     * @param memory the new memory
     */
    public void setMemory(ComponentRef memory) {
        this.memory = memory;
    }

    /**
     * Gets the storage.
     *
     * @return the storage
     */
    public ComponentRef getStorage() {
        return storage;
    }

    /**
     * Sets the storage.
     *
     * @param storage the new storage
     */
    public void setStorage(ComponentRef storage) {
        this.storage = storage;
    }

    /**
     * Gets the psu.
     *
     * @return the psu
     */
    public ComponentRef getPsu() {
        return psu;
    }

    /**
     * Sets the psu.
     *
     * @param psu the new psu
     */
    public void setPsu(ComponentRef psu) {
        this.psu = psu;
    }

    /**
     * Gets the casing.
     *
     * @return the casing
     */
    public ComponentRef getCasing() {
        return casing;
    }

    /**
     * Sets the casing.
     *
     * @param casing the new casing
     */
    public void setCasing(ComponentRef casing) {
        this.casing = casing;
    }

    /* (non-Javadoc)
     * @see java.lang.Iterable#iterator()
     */
    @Override
    public Iterator<ComponentRef> iterator() {
        return new ComponentRefIterator(this,0,componentCount);
    }

    /**
     * Checks for components.
     *
     * @return true, if successful
     */
    public boolean hasComponents() {
        for (ComponentRef componentRef : this) {
            if (componentRef != null) return true;
        }
        return false;
    }

    /**
     * The Class ComponentRefIterator.
     */
    private static final class ComponentRefIterator implements Iterator<ComponentRef> {
        
        /** The cursor. */
        private int cursor;
        
        /** The end. */
        private final int end;
        
        /** The configuration. */
        private final Configuration configuration;

        /**
         * Instantiates a new component ref iterator.
         *
         * @param configuration the configuration
         * @param start the start
         * @param end the end
         */
        public ComponentRefIterator(Configuration configuration,int start, int end) {
            this.configuration = configuration;
            this.cursor = start;
            this.end = end;
        }

        /* (non-Javadoc)
         * @see java.util.Iterator#hasNext()
         */
        public boolean hasNext() {
            return this.cursor < end;
        }

        /* (non-Javadoc)
         * @see java.util.Iterator#next()
         */
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

        /* (non-Javadoc)
         * @see java.util.Iterator#remove()
         */
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
