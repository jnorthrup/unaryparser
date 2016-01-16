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

public class TermImpl extends ASTWrapperPsiElement implements Term {

  public TermImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof Visitor) ((Visitor)visitor).visitTerm(this);
    else super.accept(visitor);
  }


  @Nullable
  public CompoundTerm getCompoundTerm() {
    return findChildByClass(CompoundTerm.class);
  }


  @Nullable
  public Interval getInterval() {
    return findChildByClass(Interval.class);
  }


  @Nullable
  public Statement getStatement() {
    return findChildByClass(Statement.class);
  }


  @Nullable
  public Variable getVariable() {
    return findChildByClass(Variable.class);
  }


  @Nullable
  public Word getWord() {
    return findChildByClass(Word.class);
  }

}
