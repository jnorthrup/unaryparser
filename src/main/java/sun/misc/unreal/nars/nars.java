package sun.misc.unreal.nars;

import bbcursive.ann.Backtracking;
import bbcursive.ann.Infix;
import bbcursive.lib.value_;

import java.nio.ByteBuffer;
import java.util.function.UnaryOperator;

import static bbcursive.lib.allOf_.allOf;
import static bbcursive.lib.anyOf_.anyOf;
import static bbcursive.lib.chlit_.chlit;
import static bbcursive.lib.confix_.confix;
import static bbcursive.lib.infix_.infix;
import static bbcursive.lib.opt.opt;
import static bbcursive.lib.repeat_.repeat;
import static bbcursive.lib.skipper_.skipper;
import static bbcursive.lib.strlit.strlit;

/**
 * Created by jim on 1/20/16.
 */
public enum nars {
    ;

    public static final nars.javIdent JavIdent = new nars.javIdent();

    UnaryOperator<ByteBuffer> statement() {
        return anyOf(
                confix("<>",
                        allOf(
                                this.term(),
                                this.copula(),
                                this.term()
                        )
                ),
                allOf(strlit("(^"),
                        this.word(),
                        repeat(
                                allOf(
                                        chlit(','),
                                        this.term()
                                )
                        ),
                        chlit(')')
                ),
                infix(strlit("@@@LEXME@@@"), this.term())
        );
    }


    private UnaryOperator<ByteBuffer> copula() {
        return null;
    }

    private UnaryOperator<ByteBuffer> term() {
        return anyOf(this.word(), this.variable(), this.compoundTerm(), this.statement())
    }

    private UnaryOperator<ByteBuffer> compoundTerm() {
        return anyOf(
                extensionalSet(),// "{" <term> {","<term>} "}"
                intensionalSet(),//"[" <term> {","<term>} "]"
                extensionalIntersection(),//"(&," <term> {","<term>} ")"
                extensionalDifference(),//"(|," <term> {","<term>} ")"
                intensionalDifference(),//"(-," <term> "," <term> ")"
                product(),//"(~," <term> "," <term> ")"
                extensionalImage(),//"(*," <term> {","<term>} ")"
                intensionalImage(),//"(/," <term> {","<term>} ")"
                negation(),//"(\," <term> {","<term>} ")"
                disjunction(),//"(--," <term> ")"
                conjunction(),//"(||," <term> {","<term>} ")"
                sequentialEvents(),//"(&&," <term> {","<term>} ")"
                parallelEvents()              //"(&/," <term> {","<term>} ")"

        );
    }


    private UnaryOperator<ByteBuffer> tense() {
        return anyOf(futureEvent(), presentEvent(), pastEvent());
    }

    private UnaryOperator<ByteBuffer> truth() {
        return skipper(chlit("%"), frequency(), opt(chlit(";"), confidence()));
    }

    private UnaryOperator<ByteBuffer> budget() {
        return skipper(chlit("$"), this.priority(), opt(chlit(";"), durability()));
    }

    private UnaryOperator<ByteBuffer> priority() {
        return value_.value();
    }

    private UnaryOperator<ByteBuffer> variable() {
        return null;
    }

    private UnaryOperator<ByteBuffer> word() {
        return repeat(nars.JavIdent);
    }

    @Infix@Backtracking
    public static class javIdent implements UnaryOperator<ByteBuffer> {
        @Override
        public ByteBuffer apply(ByteBuffer buffer) {
            return (ByteBuffer) repeat(buffer1 -> buffer1.hasRemaining() && Character.isJavaIdentifierPart(buffer1.get()) ? buffer1 : null);
        }
    }

}
