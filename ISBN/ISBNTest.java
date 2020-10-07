package ISBN;

public class ISBNTest {
    public static void main(String[] args){
        ISBN[] kody = {
                new ISBN ("1234567893"),                        //false
                new ISBN("978-83-8177-267-9"),                  //true
                new ISBN( "0-306-40615-2" ),                    //true
                new ISBN("111"),                                //false
                new ISBN("978-83-7181-510-2"),
        };
        for (ISBN nr : kody){
            System.out.println (nr);
            //nr.check();
        }
    }
}
