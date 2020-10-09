package webapp.model;

import java.util.List;

public class Computer {
    private String name;
    private CPU cpu;
    private List<Memory> memoryList;


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public CPU getCpu() {
        return cpu;
    }
    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }
    public List<Memory> getMemoryList() {
        return memoryList;
    }
    public void setMemoryList(List<Memory> memoryList) {
        this.memoryList = memoryList;
    }
}
