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

public class StatementImpl extends ASTWrapperPsiElement implements Statement {

  public StatementImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof Visitor) ((Visitor)visitor).visitStatement(this);
    else super.accept(visitor);
  }


  @Nullable
  public Copula getCopula() {
    return findChildByClass(Copula.class);
  }


  @NotNull
  public List<Term> getTermList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, Term.class);
  }


  @Nullable
  public Word getWord() {
    return findChildByClass(Word.class);
  }

}
