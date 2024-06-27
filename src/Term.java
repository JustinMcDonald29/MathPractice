import java.math.BigDecimal;
/**
 * Serves as a node in the equation data structure
 * Provides methods to work on terms
 */
public class Term {

    private Term nextTerm;
    private Operations nextOp;
    private BigDecimal calcVal;
    private Term inner;
    private final String termStr;
    public Term(String s, Term next) {
       System.out.println("Creating new term: "+s);
        this.termStr = s;
        this.nextTerm= next;
    }
    public Term(String s){
        System.out.println("Creating new term: "+s);
        this.termStr = s;
    }
   public void setNext(Term t){
        this.nextTerm = t;
    }
    public void printTerm(){
        System.out.println(termStr);
        if (!isLast()){
            this.nextTerm.printTerm();
        }
    }
    public boolean isLast() {
        return this.nextTerm == null;
    }
}
