package pcbuilder.controllers.transport;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Configuration implements Iterable<ComponentRef> {

    private final int componentCount = 7;

    private ComponentRef motherboard;
    private ComponentRef cpu;
    private ComponentRef gpu;
    private ComponentRef memory;
    private ComponentRef storage;
    private ComponentRef psu;
    private ComponentRef casing;

    public ComponentRef getMotherboard() {
        return motherboard;
    }

    public void setMotherboard(ComponentRef motherboard) {
        this.motherboard = motherboard;
    }

    public ComponentRef getCpu() {
        return cpu;
    }

    public void setCpu(ComponentRef cpu) {
        this.cpu = cpu;
    }

    public ComponentRef getGpu() {
        return gpu;
    }

    public void setGpu(ComponentRef gpu) {
        this.gpu = gpu;
    }

    public ComponentRef getMemory() {
        return memory;
    }

    public void setMemory(ComponentRef memory) {
        this.memory = memory;
    }

    public ComponentRef getStorage() {
        return storage;
    }

    public void setStorage(ComponentRef storage) {
        this.storage = storage;
    }

    public ComponentRef getPsu() {
        return psu;
    }

    public void setPsu(ComponentRef psu) {
        this.psu = psu;
    }

    public ComponentRef getCasing() {
        return casing;
    }

    public void setCasing(ComponentRef casing) {
        this.casing = casing;
    }

    @Override
    public Iterator<ComponentRef> iterator() {
        return new ComponentRefIterator(this,0,componentCount);
    }

    //@Override
    //public void forEach(Consumer<? super ComponentRef> consumer) {
    //    consumer.
    //}

    //@Override
    //public Spliterator<ComponentRef> spliterator() {
    //    return null;
    //}

    public boolean hasComponents() {
        for (ComponentRef componentRef : this) {
            if (componentRef != null) return true;
        }
        return false;
    }

    private static final class ComponentRefIterator implements Iterator<ComponentRef> {
        private int cursor;
        private final int end;
        private final Configuration configuration;

        public ComponentRefIterator(Configuration configuration,int start, int end) {
            this.configuration = configuration;
            this.cursor = start;
            this.end = end;
        }

        public boolean hasNext() {
            return this.cursor < end;
        }

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

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
