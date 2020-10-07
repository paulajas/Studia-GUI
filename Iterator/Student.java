package GUI9NEW;


public
class Student{
    int id;
    String imie;

    public Student( int id, String imie){
        this.id = id;
        this.imie = imie;
    }

    public String toString(){
        return id+" "+imie;
    }


}
