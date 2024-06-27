/**
 * Will function as a type of linked list/tree, with each term representing a node in the list
 * The purpose is to take an equation in String form and translate it into something usable by the machine
 */
public class Equation {
    private String eqStr;
    private Term eqHead = null;
    public Equation(String eq){
        Term prev = null;
        Term active = null;
        int split;
        while(eq.length()!=0){
            split = EqParse.termSplit(eq);
            if(eqHead == null){
                eqHead=new Term(eq.substring(0,split));
                prev = eqHead;
            } else {
                active = new Term (eq.substring(0,split));
                prev.setNext(active);
                prev = active;
            }

            eq = eq.substring(split);
        }
    }
    public void printEq(){
        eqHead.printTerm();
    }


}
