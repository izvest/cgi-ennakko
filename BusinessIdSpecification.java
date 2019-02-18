import java.util.ArrayList;


public class BusinessIdSpecification implements ISpecification{

    private ArrayList<String> needsCorrecting;

    public BusinessIdSpecification(){
        needsCorrecting = new ArrayList<String>();
    }
    

    /*
    Function: returns list of reason why y-tunnus is not acceptable, will be empty if everything ok
    */
    public Iterable<String> ReasonsForDissatisfaction(){
        return needsCorrecting;
    }

    public boolean IsSatisfiedBy (Object entity){
        if (entity instanceof String){
            return(checkString((String)entity));
        }
        else{
            try{
                String input = entity.toString();
                return(checkString(input));
            }catch(Exception e){
                needsCorrecting.add("STRICT: Incompatible type");
            }
        }
        return false;
    }

    /*
    Function: check validity of y-tunnus (if given as a string)

    Input: string (y-tunnus)
    Output: boolean (was it valid or not?)
    Secondary output: additions of possible errors to needsCorrecting
    */
    boolean checkString(String s){
        double cs = checkSum(s);
        if (cs != 0.0){
            if (s.length() == 8 & s.charAt(6) != '-'){
                needsCorrecting.add("No characters except '-' allowed in Y-tunnus");
            }
            char check = calculateCheckChar(cs);
            if (check != 'f' && check == s.charAt(sl-1)){
                return true;
            }
            needsCorrecting.add("Checksum mismatch - invalid Y-tunnus");
        }
        return false;
    }
    
    /*
    Function: calculate raw checksum of y-tunnus

    Input: String (y-tunnus)
    Output: double (the multipiler-added sum of first 6 digits of y-tunnus OR 0.0 if invalid y-tunnus)
    Secondary output: additions of possible errors to needsCorrecting
    */
    double checkSum(String s){
        int[] csMultipliers = {7, 9, 10, 5, 8, 4, 2};     //source: http://tarkistusmerkit.teppovuori.fi/tarkmerk.htm
        double cs = 0;
        if(s.length() == 7 || s.length() == 8){
            for (int i = 0; i < 6; i++){
                if(!Character.isDigit(s.charAt(i))){
                    needsCorrecting.add("STRICT: Only numbers allowed in 6 first characters of Y-tunnus");
                    return 0.0;
                }
                cs += csMultipliers[i]*Character.getNumericValue(s.charAt(i));
            }
            return cs;
        }
        needsCorrecting.add("STRICT: Wrong length of Y-tunnus. Ensure that the format it's given as is either XXXXXX-X or XXXXXXX");
        return 0.0;
    }

    /*
    Function: calculate final checksum of y-tunnus

    Input: double (the multipiler-added sum of first 6 digits of y-tunnus)
    Output: char (the last / verification number of y-tunnus)
    */
    char calculateCheckChar(double checkSum){
        double tmp = checkSum/11;
        double trueCheckSum = 11*(tmp - (int)tmp);
        double rounding = trueCheckSum-(int)trueCheckSum;
        if(rounding > 0.5){trueCheckSum = (int)trueCheckSum + 1;}

        if (trueCheckSum == 0.0){return '0';}
        else if (trueCheckSum == 1.0){return 'f';}
        return(Character.forDigit((11-(int)trueCheckSum),10));
    }
}
