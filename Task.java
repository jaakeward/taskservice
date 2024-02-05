public class Task {
    String taskID, taskName, taskDesc;
    String[] taskInfo = new String[2];
    public Task(String tID, String name, String desc) {
        taskID = tID;
        taskName = name;
        taskDesc = desc;
        taskInfo[0] = name;
        taskInfo[1] = desc;
    }
}