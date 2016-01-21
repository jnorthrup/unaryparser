/**

    % <digit> ::= 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9
    % <sign> ::= + | -
    % <number> ::= [ <sign> ] <digit> { <digit> }

    :- op(1120, xfx, ::=).
    :- op(11, fx, <), op(13, xf, >).

    <digit>  ::= 0 ; 1 ; 2 ; 3 ; 4 ; 5 ; 6 ; 7 ; 8 ; 9 .
    <sign>   ::= (+) ; (-)                             .
    <number> ::= [ <sign> ], <digit>, { <digit> }      .

    <expr>   ::= <factor>, { ((+) ; (-)), <factor> }   .
    <factor> ::= <term>,   { ((*) ; (/)), <term> }     .
    <term>   ::= '(', <expr>, ')' ; <number>           .

    parse(Rule)    --> { Rule ::= Body }, parse(Body).
    parse(Atom)    --> { atomic(Atom), atom_codes(Atom, Codes) }, Codes.

    parse((X , Y)) --> parse(X), parse(Y).

    parse((X ; _)) --> parse(X).
    parse((_;Y;Z)) --> parse(Y ; Z).
    parse((_ ; Z)) --> { Z \= (_ ; _) }, parse(Z).

    parse([X])     --> parse(X).
    parse([_])     --> {}.

    parse({X})     --> parse(X), parse({X}).
    parse({_})     --> [].

    % phrase(parse(<expr>), "-5*(73+7)").
 */


package sun.misc.unreal.prolog;