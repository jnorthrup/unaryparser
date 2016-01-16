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

public class SentenceImpl extends ASTWrapperPsiElement implements Sentence {

  public SentenceImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof Visitor) ((Visitor)visitor).visitSentence(this);
    else super.accept(visitor);
  }


  @NotNull
  public Statement getStatement() {
    return findNotNullChildByClass(Statement.class);
  }


  @Nullable
  public Tense getTense() {
    return findChildByClass(Tense.class);
  }


  @Nullable
  public Truth getTruth() {
    return findChildByClass(Truth.class);
  }

}
