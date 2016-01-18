package sun.misc.unreal

/**
 * Created by jim on 1/17/16.
 */
class EbnfTestTest extends GroovyTestCase {
    public static final String nars = '''

             task = [budget] sentence;

         sentence = statement"." [tense] [truth]
                    | statement"?" [tense] [truth]
                    | statement"@" [tense] [truth]
                    | statement"!" [tense] [truth]  ;

        statement = "<"term copula term">"
                    | "("term copula term")"
                    | "+++"   term
                    | "(^" word { "," term} ")"
                    | word"("term { "," term} ")"  ;

           copula = "-->"
                    | "<->"
                    | "{--"
                    | "--]"
                    | "{-]"
                    | "==>"
                    | "=/>"
                    | "=|>"
                    | "=\\\\>"
                    | "<=>"
                    | "</>"
                    | "<|>"       ;

             term = word
                    | variable
                    | compoundTerm
                    | statement
                    | interval       ;

    compoundTerm = "{" term {","term} "}"
                    | "[" term {","term} "]"
                    | "("infixOpMulti","term{","term} ")"
                    | "("infixOpSingle","term"," term ")"
                    | "(" term {","term} ")"
                    | "(/," term {","term} ")"
                    | "(\\\\," term {","term} ")"
                    | "(--," term ")"
                    | "--"term

                    | "(" term {infixOpMulti  term} ")"
                    | "(" term infixOpSingle term ")"   ;

   infixOpMulti = "&&"
                    | "*"
                    | "||"
                    | "&|"
                    | "&/"
                    | "|"
                    | "&"

  infixOpSingle = "-"
                    | "~"                     ;

         variable = "$"word
                    | "#"[word]
                    | "?"[word]      ;

            tense = ":/:"
                    | ":|:"
                    | ":\\\\:"
                    | <":">       ;

         interval = <"/">            ;

            truth = <"%">frequency[<";">confidence]<"%">
           budget = <"$">priority[<";">durability][<";">quality]<"$">
           ;

               word = "\\w+"                         ;
           priority = "([0]?\\.[0-9]+|1|0)"          ;
         durability = "[0]?\\.[0]*[1-9]{1}[0-9]*"    ;
            quality = "([0]?\\.[0-9]+|1|0)"          ;
          frequency = "([0]?\\.[0-9]+|1|0)"          ;
         confidence = "[0]?\\.[0]*[1-9]{1}[0-9]*"    ;

'''

    public void testNars1(){


    }
    private java.lang.String s

    void setUp() {
        super.setUp()
        s=nars

    }

    void tearDown() {

    }
}
