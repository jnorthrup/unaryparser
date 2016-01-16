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

public class CompoundTermImpl extends ASTWrapperPsiElement implements CompoundTerm {

  public CompoundTermImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof Visitor) ((Visitor)visitor).visitCompoundTerm(this);
    else super.accept(visitor);
  }


  @Nullable
  public InfixOpMulti getInfixOpMulti() {
    return findChildByClass(InfixOpMulti.class);
  }


  @Nullable
  public InfixOpSingle getInfixOpSingle() {
    return findChildByClass(InfixOpSingle.class);
  }


  @NotNull
  public List<Term> getTermList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, Term.class);
  }

}
