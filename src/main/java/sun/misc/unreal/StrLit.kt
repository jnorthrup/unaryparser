package sun.misc.unreal

import bbcursive.Cursive
import java.nio.ByteBuffer
import java.nio.charset.StandardCharsets

/**
 * Created by jim on 1/16/16.
 */
internal object StrLit {
    fun lit(lit: CharSequence): Cursive = Cursive {
        val encode: ByteBuffer = StandardCharsets.UTF_8.encode(lit.toString())
        while (encode.hasRemaining() && it.hasRemaining() && (encode.get() == it.get()));
        if (encode.hasRemaining()) it;
        return@Cursive null;


    }
}
