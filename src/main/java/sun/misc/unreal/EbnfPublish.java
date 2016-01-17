package sun.misc.unreal;

import java.nio.ByteBuffer;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.UnaryOperator;

/**
 * Created by jim on 1/16/16.
 */
public    enum EbnfPublish implements UnaryOperator<ByteBuffer> {
    letter  ,
    digit,
    word,
    //        symbol2,
    symbol,
    character,
    identifier,
    terminal,
    lhs,
    optional,
    repeating,
    grouping,
    firstOf,
    listOf,
    rule,
    rhs,
    grammar;

    EbnfPublish() {
        try {
            lambda = (UnaryOperator) Ebnf.class.getDeclaredField( name()).get(null);
Registry.publish.put(lambda,this);
        } catch (Throwable e) {
            throw new Error("bad news");
        }
//        std.log("",""+ name(),"\n");

    }

    @Override
    public ByteBuffer apply(ByteBuffer buffer) {
        return (ByteBuffer) lambda.apply(buffer);
    }


    private final UnaryOperator lambda;
interface Registry{
    Map <UnaryOperator<ByteBuffer>,EbnfPublish>publish=new LinkedHashMap<>();

}
}
