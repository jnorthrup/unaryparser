/**
 *
 <statement> ::= "<"<term> <copula> <term>">"       // two terms related to each other
 | <term>                             // a term can name a statement
 | "(^"<word> {","<term>} ")"         // an operation to be executed
 <copula> ::= "-->"                              // inheritance
 | "<->"                              // similarity
 | "{--"                              // instance
 | "--]"                              // property
 | "{-]"                              // instance-property
 | "==>"                              // implication
 | "=/>"                              // predictive implication
 | "=|>"                              // concurrent implication
 | "=\>"                              // retrospective implication
 | "<=>"                              // equivalence
 | "</>"                              // predictive equivalence
 | "<|>"                              // concurrent equivalence
 <term> ::= <word>                             // an atomic constant term
 | <variable>                         // an atomic variable term
 | <compound-term>                    // a term with internal structure
 | <statement>                        // a statement can serve as a term
 <compound-term> ::=
   "{" <term> {","<term>} "}"         // extensional set
 | "[" <term> {","<term>} "]"         // intensional set
 | "(--," <term> ")"                  // negation
 | "(&," <term> {","<term>} ")"       // extensional intersection
 | "(|," <term> {","<term>} ")"       // intensional intersection
 | "(-," <term> "," <term> ")"        // extensional difference
 | "(~," <term> "," <term> ")"        // intensional difference
 | "(*," <term> {","<term>} ")"       // product
 | "(/," <term> {","<term>} ")"       // extensional image
 | "(\," <term> {","<term>} ")"       // intensional image
 | "(||," <term> {","<term>} ")"      // disjunction
 | "(&&," <term> {","<term>} ")"      // conjunction
 | "(&/," <term> {","<term>} ")"      // sequential events
 | "(&|," <term> {","<term>} ")"      // parallel events
 <tense> ::=
 ":/:"            // future event
 | ":|:"  // present event
 | ":\:"  // past event

 <truth> ::= "%"<frequency>[";"<confidence>]"%" // two numbers in [0,1]x(0,1)
 <budget> ::= "$"<priority>[";"<durability>]"$"  // two numbers in [0,1]x(0,1)
 <word> : Unicode string in an arbitrary alphabet

 */
package sun.misc.unreal.nars;