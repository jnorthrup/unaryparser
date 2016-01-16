// This is a generated file. Not intended for manual editing.
package generated.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import generated.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BudgetImpl extends ASTWrapperPsiElement implements Budget {

  public BudgetImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof Visitor) ((Visitor)visitor).visitBudget(this);
    else super.accept(visitor);
  }


  @Nullable
  public Durability getDurability() {
    return findChildByClass(Durability.class);
  }


  @NotNull
  public Priority getPriority() {
    return findNotNullChildByClass(Priority.class);
  }


  @Nullable
  public Quality getQuality() {
    return findChildByClass(Quality.class);
  }

}
