package zadanie_2;

public class TestBufor{

    public static void main(String[] args) throws InterruptedException {

        Buffer buffer = new Buffer(4);

        Thread producer = new Producer(buffer);
        Thread consumer = new Consumer(buffer);

        producer.start();
        consumer.start();

        Thread.sleep(15000);

        producer.interrupt();
        consumer.interrupt();

    }
}
