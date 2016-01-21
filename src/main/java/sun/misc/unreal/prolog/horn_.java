package sun.misc.unreal.prolog;

import bbcursive.lib.strlit;

import java.nio.ByteBuffer;
import java.util.function.UnaryOperator;

/** Created by jim on 1/19/16.
 */
public class horn_{
    UnaryOperator<ByteBuffer> horn(){return strlit.strlit(":-");}

}
