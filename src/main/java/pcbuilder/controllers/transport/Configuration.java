package pcbuilder.controllers.transport;

public class Configuration {

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
}
