public class Process {
    private String processName; 
    private int processId;      

    public Process(String processName, int processId) {
        this.processName = processName;
        this.processId = processId;
    }

    public String getProcessName() {
        return processName;
    }

    public int getProcessId() {
        return processId;
    }

    @Override
    public String toString() {
        return "Processo [ID=" + processId + ", Nome=" + processName + "]";
    }
}
