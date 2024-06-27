/**
 * This class is for parsing the strings
 * This will be done by first splitting the strings into terms,
 * then translating them into usable statements.
 */
public class EqParse {
    public static int termSplit(String s){
        Term eqHead = null;
        Term prev = null;
        int start = 0;
        int end = s.length();

       loop:  for(int i = 0; i<s.length(); i++){
            switch(s.charAt(i)){
                case '(':
                    end = bracket(s.substring(i));
                    break loop;
                case '^':
                case '/':
                case '*':
                case'+':
                case'-':{
                    end = expDiv(s.substring(i));
                    break loop;
                }
                default:
                    end = i;

            }
        }

        return end;
    }
    private static int bracket (String s){
        int i = 0;
        int counter = 0;
        while (counter >= 0) {
            System.out.println(s.charAt(i));
            i++;
            switch (s.charAt(i)) {
                case '(' :
                    counter++;
                    break;
                case ')':
                    counter--;
                    break;
            }

        }
        return i+2;
    }

    private static int expDiv(String s) {
        int i;
        for(i = 0; i<s.length(); i++){
            if(Character.isWhitespace(s.charAt(i))){
                return(i);
            }
        }
        System.out.println(i);
       // System.out.println(s.charAt(i));

        return i+1;
    }
}
