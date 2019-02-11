public class BusinessIdSpecification implements ISpecification{
    
    public IEnumerable<string> ReasonsForDissatisfaction(){

    }

    boolean IsSatisfiedBy(T entity){
        if (entity instanceof String){
            return(checkString(entity));
        }
        else{
            //ReasonsForDissatisfaction();
            System.err.println("Incompatible type; please use String");
        }
        return false;
    }

    boolean checkString(String s){
        int sl = s.length;
        double checkSum = 0;
        int[] multipliers = {7, 9, 10, 5, 8, 4, 2};
        if(sl == 8 || sl == 9){
            for (int i = 0; i < 7; i++){
                if(!Character.isDigit(s.charAt(i))){
                    System.err.println("No characters allowed in Y-tunnus");
                    return false;
                }
                checkSum += multipliers[i]*Character.getNumericValue(s.charAt(i));
            }
            try{char check = calculateCheckChar(checkSum);}
            catch(NumberFormatException e){
                System.err.println("Invalid Y-tunnus"); 
                return false;
            }
            if (sl == 9 & s.charAt(6) != '-'){
                System.err.println("No characters allowed in Y-tunnus");
                return false;
            }
            if (check == s.charAt(sl-1)){
                System.out.println("Seems legit enough");
                return true;
            }
            System.err.println("Something is wrong, but I have no idea what");
            return false;
        }
        System.err.println("Wrong length");
        return false;
    }

    char calculateCheckChar(double checkSum){
        double tmp = checkSum/11;
        double trueCheckSum = 11*(tmp - (int)tmp);
        if (trueCheckSum == 0){return '0';}
        else if (trueCheckSum == 1){throw NumberFormatException;}
        return(Character.forDigit((11-(int)trueCheckSum),10));
    }
}