import java.util.Iterator;

public class Test{
    public static void main(String[] args) {
        Object[] testInput = {010010, "Hello123", "20193", "201938+1", "111111-0", "1111111", 0.221, 1111111, "111111f"};

        for(Object o : testInput){
            BusinessIdSpecification idCheck = new BusinessIdSpecification();
            boolean acceptable = idCheck.IsSatisfiedBy(o);
            System.out.println(o.toString() + " - Y-tunnus acceptable: " + acceptable);
            if (!acceptable){
                Iterator<String> errors = idCheck.ReasonsForDissatisfaction().iterator();
                System.out.println("Problems:");
                while(errors.hasNext()){
                    System.out.println(errors.next());
                }
            }
            System.out.println("-----------------");
        }
        
    }
}