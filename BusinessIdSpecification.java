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
            needsCorrecting.add("STRICT: Incompatible type; please use String for now");
        }
        return false;
    }

    /*
    Function: check validity of y-tunnus (if given as a string)

    Input: string (y-tunnus)
    Output: boolean (was it valid or not?)
    Secondary output: additions of possible errors for ReasonsForDissatisfaction to return
    */
    boolean checkString(String s){
        int sl = s.length();
        double checkSum = 0;
        int[] checksumMultipliers = {7, 9, 10, 5, 8, 4, 2};     //source: http://tarkistusmerkit.teppovuori.fi/tarkmerk.htm
        if(sl == 7 || sl == 8){
            for (int i = 0; i < 6; i++){
                if(!Character.isDigit(s.charAt(i))){
                    needsCorrecting.add("STRICT: Only numbers allowed in 6 first characters of Y-tunnus");
                    return false;
                }
                checkSum += checksumMultipliers[i]*Character.getNumericValue(s.charAt(i));
            }
            char check = calculateCheckChar(checkSum);
            if (sl == 8 & s.charAt(6) != '-'){
                needsCorrecting.add("No characters except '-' allowed in Y-tunnus");
            }
            if (check != 'f' && check == s.charAt(sl-1)){
                return true;
            }else{
                needsCorrecting.add("Checksum mismatch - invalid Y-tunnus");
            }
        }
        else{
            needsCorrecting.add("STRICT: Wrong length of Y-tunnus. Check that its format is either XXXXXX-X or XXXXXXX");
        }
        return false;
    }

    /*
    Function: calculate checksum of y-tunnus

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