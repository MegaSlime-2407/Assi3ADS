public class MyTestingClass {
    private int number;
    private String name;

    public MyTestingClass(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public int HashCode(){
        int hash = 11;
        hash = 37 * hash + this.number;
        for(char c : name.toCharArray()){
            hash = 37 * hash + c;
        }
        return hash;
    }
    public boolean Equals(MyTestingClass obj){
        if(this.number != obj.number){
            return false;
        }
        if(this.name != obj.name){
            return false;
        }
        return true;
    }
}
