package pcbuilder.domain;

public class Configuration {

    private Component motherboard;
    private Component cpu;
    private Component gpu;
    private Component memory;
    private Component storage;
    private Component psu;
    private Component casing;

    public Component getMotherboard() {
        return motherboard;
    }

    public void setMotherboard(Component motherboard) {
        this.motherboard = motherboard;
    }

    public Component getCpu() {
        return cpu;
    }

    public void setCpu(Component cpu) {
        this.cpu = cpu;
    }

    public Component getGpu() {
        return gpu;
    }

    public void setGpu(Component gpu) {
        this.gpu = gpu;
    }

    public Component getMemory() {
        return memory;
    }

    public void setMemory(Component memory) {
        this.memory = memory;
    }

    public Component getStorage() {
        return storage;
    }

    public void setStorage(Component storage) {
        this.storage = storage;
    }

    public Component getPsu() {
        return psu;
    }

    public void setPsu(Component psu) {
        this.psu = psu;
    }

    public Component getCasing() {
        return casing;
    }

    public void setCasing(Component casing) {
        this.casing = casing;
    }
}
