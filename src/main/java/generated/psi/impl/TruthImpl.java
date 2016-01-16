// This is a generated file. Not intended for manual editing.
package generated.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static generated.GeneratedTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import generated.psi.*;

public class TruthImpl extends ASTWrapperPsiElement implements Truth {

  public TruthImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof Visitor) ((Visitor)visitor).visitTruth(this);
    else super.accept(visitor);
  }


  @Nullable
  public Confidence getConfidence() {
    return findChildByClass(Confidence.class);
  }


  @NotNull
  public Frequency getFrequency() {
    return findNotNullChildByClass(Frequency.class);
  }

}
