package sun.misc.unreal

 import java.nio.ByteBuffer
 import java.nio.charset.StandardCharsets
 import java.util.function.UnaryOperator

/**
 * Created by jim on 1/16/16.
 */
internal object StrLit {
    fun lit(lit: CharSequence): UnaryOperator<ByteBuffer>? = java.util.function.UnaryOperator<ByteBuffer> { it ->
        val rna: ByteBuffer = StandardCharsets.UTF_8.encode(lit.toString())
        while (rna.hasRemaining() && it.hasRemaining() && (rna.get() == it.get()));
        if ( !rna.hasRemaining())it;
        null;
    }
}
