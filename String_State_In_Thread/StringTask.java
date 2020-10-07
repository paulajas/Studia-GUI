package zadanie_1;

public class StringTask implements Runnable{

    private String str;
    private int repeat;
    private TaskState state;
    boolean running;
    private String reverseStr;
    Runnable runnable = this;
    Thread thread = new Thread(runnable);

    public StringTask(String str, int repeat) {
        this.str = str;
        this.repeat = repeat;
        running = true;
        state = TaskState.CREATED;
        StringBuilder sb = new StringBuilder(str);
        reverseStr = sb.reverse().toString();
    }

    public String getResult() {  // zwracającą wynik konkatenacji
    return str;
    }

    public TaskState getState() {    // zwracającą stan zadania

        return state;
    }

    public String getTxt(){
        return reverseStr;
    }

    public static enum TaskState{
        CREATED{
            public String toString(){
                return "CREATED";
            }
        },
        RUNNING{
            public String toString(){
                return "RUNNING";
            }
        },
        ABORTED{
            public String toString(){
                return "ABORTED";
            }
        },
        READY{
            public String toString(){
                return "READY";
            }
        }
    }

    public void start() {  //uruchamiającą zadanie w odrębnym watku
        state = TaskState.RUNNING;
        thread.start ();   //glowny watek //////
    }
    public void abort() {   //przerywającą wykonanie kodu zadania i działanie wątku
        thread.interrupt ();
    }
    public boolean isDone() {       //zwracającą true = normalnie lub przez przerwanie, false w przeciwnym razie

        if (state == TaskState.READY || state==TaskState.ABORTED)
                return true;
        else
            return false;
    }

    @Override
    public void run() {
        String strumien = "";
        int i =0;
            while (!thread.isInterrupted () && i < repeat) {
                strumien = strumien + reverseStr;
                i++;
            }
            if (!thread.isInterrupted ()) {
                state = TaskState.READY;
            }
            else
                state = TaskState.ABORTED;
        str=strumien;
    }
}
