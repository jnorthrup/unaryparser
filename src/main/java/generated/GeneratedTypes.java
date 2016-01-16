// This is a generated file. Not intended for manual editing.
package generated;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import generated.psi.impl.*;

public interface GeneratedTypes {

  IElementType BUDGET = new IElementType("BUDGET", null);
  IElementType COMPOUND_TERM = new IElementType("COMPOUND_TERM", null);
  IElementType CONFIDENCE = new IElementType("CONFIDENCE", null);
  IElementType COPULA = new IElementType("COPULA", null);
  IElementType DURABILITY = new IElementType("DURABILITY", null);
  IElementType FREQUENCY = new IElementType("FREQUENCY", null);
  IElementType INFIX_OP_MULTI = new IElementType("INFIX_OP_MULTI", null);
  IElementType INFIX_OP_SINGLE = new IElementType("INFIX_OP_SINGLE", null);
  IElementType INTERVAL = new IElementType("INTERVAL", null);
  IElementType PRIORITY = new IElementType("PRIORITY", null);
  IElementType QUALITY = new IElementType("QUALITY", null);
  IElementType SENTENCE = new IElementType("SENTENCE", null);
  IElementType STATEMENT = new IElementType("STATEMENT", null);
  IElementType TENSE = new IElementType("TENSE", null);
  IElementType TERM = new IElementType("TERM", null);
  IElementType TRUTH = new IElementType("TRUTH", null);
  IElementType VARIABLE = new IElementType("VARIABLE", null);
  IElementType WORD = new IElementType("WORD", null);

  IElementType <"$"> = new IElementType("<\"$\">", null);
  IElementType <"%"> = new IElementType("<\"%\">", null);
  IElementType <"/"> = new IElementType("<\"/\">", null);
  IElementType <":"> = new IElementType("<\":\">", null);
  IElementType <";"> = new IElementType("<\";\">", null);

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == BUDGET) {
        return new BudgetImpl(node);
      }
      else if (type == COMPOUND_TERM) {
        return new CompoundTermImpl(node);
      }
      else if (type == CONFIDENCE) {
        return new ConfidenceImpl(node);
      }
      else if (type == COPULA) {
        return new CopulaImpl(node);
      }
      else if (type == DURABILITY) {
        return new DurabilityImpl(node);
      }
      else if (type == FREQUENCY) {
        return new FrequencyImpl(node);
      }
      else if (type == INFIX_OP_MULTI) {
        return new InfixOpMultiImpl(node);
      }
      else if (type == INFIX_OP_SINGLE) {
        return new InfixOpSingleImpl(node);
      }
      else if (type == INTERVAL) {
        return new IntervalImpl(node);
      }
      else if (type == PRIORITY) {
        return new PriorityImpl(node);
      }
      else if (type == QUALITY) {
        return new QualityImpl(node);
      }
      else if (type == SENTENCE) {
        return new SentenceImpl(node);
      }
      else if (type == STATEMENT) {
        return new StatementImpl(node);
      }
      else if (type == TENSE) {
        return new TenseImpl(node);
      }
      else if (type == TERM) {
        return new TermImpl(node);
      }
      else if (type == TRUTH) {
        return new TruthImpl(node);
      }
      else if (type == VARIABLE) {
        return new VariableImpl(node);
      }
      else if (type == WORD) {
        return new WordImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
