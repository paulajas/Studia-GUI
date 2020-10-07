package zadanie_1;

public class TestStringTask {
    public static void main(String[] args) throws InterruptedException {
        StringTask task = new StringTask("ABC", 5000); // dodane 4 zera
        System.out.println("Task " + task.getState());
        task.start();
        //args = new String[1];
        //args[0] = "abort";
        if (args.length > 0 && args[0].equals("abort")) {
            Thread task2 = new Thread (()-> {
                try{
                    Thread.sleep ( 100 );
                }catch (InterruptedException e){
                    e.printStackTrace ();
                }
                task.abort ();
            });
            task2.start();
        }
        while (!task.isDone()) {
            Thread.sleep(5000);
            switch(task.getState()) {
                        case RUNNING: System.out.print("R."); break;
                        case ABORTED: System.out.println(" ... aborted."); break;
                        case READY: System.out.println(" ... ready."); break;
                        default: System.out.println("uknown state");
            }
        }
        System.out.println("Task " + task.getState());
        System.out.println(task.getResult().length());
        System.out.println(task.getResult().substring(0,task.getTxt().length()));
    }
}
