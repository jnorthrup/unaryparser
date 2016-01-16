// This is a generated file. Not intended for manual editing.
package generated;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static generated.GeneratedTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class GeneratedParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    if (t == BUDGET) {
      r = budget(b, 0);
    }
    else if (t == COMPOUND_TERM) {
      r = compoundTerm(b, 0);
    }
    else if (t == CONFIDENCE) {
      r = confidence(b, 0);
    }
    else if (t == COPULA) {
      r = copula(b, 0);
    }
    else if (t == DURABILITY) {
      r = durability(b, 0);
    }
    else if (t == FREQUENCY) {
      r = frequency(b, 0);
    }
    else if (t == INFIX_OP_MULTI) {
      r = infixOpMulti(b, 0);
    }
    else if (t == INFIX_OP_SINGLE) {
      r = infixOpSingle(b, 0);
    }
    else if (t == INTERVAL) {
      r = interval(b, 0);
    }
    else if (t == PRIORITY) {
      r = priority(b, 0);
    }
    else if (t == QUALITY) {
      r = quality(b, 0);
    }
    else if (t == SENTENCE) {
      r = sentence(b, 0);
    }
    else if (t == STATEMENT) {
      r = statement(b, 0);
    }
    else if (t == TENSE) {
      r = tense(b, 0);
    }
    else if (t == TERM) {
      r = term(b, 0);
    }
    else if (t == TRUTH) {
      r = truth(b, 0);
    }
    else if (t == VARIABLE) {
      r = variable(b, 0);
    }
    else if (t == WORD) {
      r = word(b, 0);
    }
    else {
      r = parse_root_(t, b, 0);
    }
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return task(b, l + 1);
  }

  /* ********************************************************** */
  // <"$">priority[<";">durability][<";">quality]<"$">
  public static boolean budget(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "budget")) return false;
    if (!nextTokenIs(b, <"$">)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, <"$">);
    r = r && priority(b, l + 1);
    r = r && budget_2(b, l + 1);
    r = r && budget_3(b, l + 1);
    r = r && consumeToken(b, <"$">);
    exit_section_(b, m, BUDGET, r);
    return r;
  }

  // [<";">durability]
  private static boolean budget_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "budget_2")) return false;
    budget_2_0(b, l + 1);
    return true;
  }

  // <";">durability
  private static boolean budget_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "budget_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, <";">);
    r = r && durability(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [<";">quality]
  private static boolean budget_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "budget_3")) return false;
    budget_3_0(b, l + 1);
    return true;
  }

  // <";">quality
  private static boolean budget_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "budget_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, <";">);
    r = r && quality(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "{" term {","term} "}"                //(* extensional set *)
  //                     | "[" term {","term} "]"                //(* intensional set *)
  //                     | "("infixOpMulti","term{","term} ")" //(* compound term with infix operator *)
  //                     | "("infixOpSingle","term"," term ")" //(* compound term with infix operator *)
  //                     | "(" term {","term} ")"                //(* product, new notation *)
  //                     | "(/," term {","term} ")"              //(* extensional image *)
  //                     | "(\\," term {","term} ")"             //(* \ intensional image *)
  //                     | "(--," term ")"                       //(* negation *)
  //                     | "--"term                              //(* negation, new notation *)
  //                                                             //(* new compound-term notation *)
  //                     | "(" term {infixOpMulti  term} ")"   // (* compound term with infix operator *)
  //                     | "(" term infixOpSingle term ")"
  public static boolean compoundTerm(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compoundTerm")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<compound term>");
    r = compoundTerm_0(b, l + 1);
    if (!r) r = compoundTerm_1(b, l + 1);
    if (!r) r = compoundTerm_2(b, l + 1);
    if (!r) r = compoundTerm_3(b, l + 1);
    if (!r) r = compoundTerm_4(b, l + 1);
    if (!r) r = compoundTerm_5(b, l + 1);
    if (!r) r = compoundTerm_6(b, l + 1);
    if (!r) r = compoundTerm_7(b, l + 1);
    if (!r) r = compoundTerm_8(b, l + 1);
    if (!r) r = compoundTerm_9(b, l + 1);
    if (!r) r = compoundTerm_10(b, l + 1);
    exit_section_(b, l, m, COMPOUND_TERM, r, false, null);
    return r;
  }

  // "{" term {","term} "}"
  private static boolean compoundTerm_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compoundTerm_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "{");
    r = r && term(b, l + 1);
    r = r && compoundTerm_0_2(b, l + 1);
    r = r && consumeToken(b, "}");
    exit_section_(b, m, null, r);
    return r;
  }

  // ","term
  private static boolean compoundTerm_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compoundTerm_0_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && term(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // "[" term {","term} "]"
  private static boolean compoundTerm_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compoundTerm_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "[");
    r = r && term(b, l + 1);
    r = r && compoundTerm_1_2(b, l + 1);
    r = r && consumeToken(b, "]");
    exit_section_(b, m, null, r);
    return r;
  }

  // ","term
  private static boolean compoundTerm_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compoundTerm_1_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && term(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // "("infixOpMulti","term{","term} ")"
  private static boolean compoundTerm_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compoundTerm_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "(");
    r = r && infixOpMulti(b, l + 1);
    r = r && consumeToken(b, ",");
    r = r && term(b, l + 1);
    r = r && compoundTerm_2_4(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // ","term
  private static boolean compoundTerm_2_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compoundTerm_2_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && term(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // "("infixOpSingle","term"," term ")"
  private static boolean compoundTerm_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compoundTerm_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "(");
    r = r && infixOpSingle(b, l + 1);
    r = r && consumeToken(b, ",");
    r = r && term(b, l + 1);
    r = r && consumeToken(b, ",");
    r = r && term(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // "(" term {","term} ")"
  private static boolean compoundTerm_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compoundTerm_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "(");
    r = r && term(b, l + 1);
    r = r && compoundTerm_4_2(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // ","term
  private static boolean compoundTerm_4_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compoundTerm_4_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && term(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // "(/," term {","term} ")"
  private static boolean compoundTerm_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compoundTerm_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "(/,");
    r = r && term(b, l + 1);
    r = r && compoundTerm_5_2(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // ","term
  private static boolean compoundTerm_5_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compoundTerm_5_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && term(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // "(\\," term {","term} ")"
  private static boolean compoundTerm_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compoundTerm_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "(\\,");
    r = r && term(b, l + 1);
    r = r && compoundTerm_6_2(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // ","term
  private static boolean compoundTerm_6_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compoundTerm_6_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && term(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // "(--," term ")"
  private static boolean compoundTerm_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compoundTerm_7")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "(--,");
    r = r && term(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // "--"term
  private static boolean compoundTerm_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compoundTerm_8")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "--");
    r = r && term(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // "(" term {infixOpMulti  term} ")"
  private static boolean compoundTerm_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compoundTerm_9")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "(");
    r = r && term(b, l + 1);
    r = r && compoundTerm_9_2(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // infixOpMulti  term
  private static boolean compoundTerm_9_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compoundTerm_9_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = infixOpMulti(b, l + 1);
    r = r && term(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // "(" term infixOpSingle term ")"
  private static boolean compoundTerm_10(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compoundTerm_10")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "(");
    r = r && term(b, l + 1);
    r = r && infixOpSingle(b, l + 1);
    r = r && term(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "[0]?\.[0]*[1-9]{1}[0-9]*"
  public static boolean confidence(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "confidence")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<confidence>");
    r = consumeToken(b, "[0]?\.[0]*[1-9]{1}[0-9]*");
    exit_section_(b, l, m, CONFIDENCE, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "-->"                                 //(* inheritance *)
  //                     | "<->"                                 //(* similarity *)
  //                     | "{--"                                 //(* instance *)
  //                     | "--]"                                 //(* property *)
  //                     | "{-]"                                 //(* instance-property *)
  //                     | "==>"                                 //(* implication *)
  //                     | "=/>"                                 //(* predictive implication *)
  //                     | "=|>"                                 //(* concurrent implication *)
  //                     | "=\\>"                                //(* =\> retrospective implication *)
  //                     | "<=>"                               //  (* equivalence *)
  //                     | "</>"                                 //(* predictive equivalence *)
  //                     | "<|>"
  public static boolean copula(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "copula")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<copula>");
    r = consumeToken(b, "-->");
    if (!r) r = consumeToken(b, "<->");
    if (!r) r = consumeToken(b, "{--");
    if (!r) r = consumeToken(b, "--]");
    if (!r) r = consumeToken(b, "{-]");
    if (!r) r = consumeToken(b, "==>");
    if (!r) r = consumeToken(b, "=/>");
    if (!r) r = consumeToken(b, "=|>");
    if (!r) r = consumeToken(b, "=\\>");
    if (!r) r = consumeToken(b, "<=>");
    if (!r) r = consumeToken(b, "</>");
    if (!r) r = consumeToken(b, "<|>");
    exit_section_(b, l, m, COPULA, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "[0]?\.[0]*[1-9]{1}[0-9]*"
  public static boolean durability(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "durability")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<durability>");
    r = consumeToken(b, "[0]?\.[0]*[1-9]{1}[0-9]*");
    exit_section_(b, l, m, DURABILITY, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "([0]?\.[0-9]+|1|0)"
  public static boolean frequency(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "frequency")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<frequency>");
    r = consumeToken(b, "([0]?\.[0-9]+|1|0)");
    exit_section_(b, l, m, FREQUENCY, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "&&"                                  //(* conjunction *)
  //                     | "*"                                   //(* product *)
  //                     | "||"                                  //(* disjunction *)
  //                     | "&|"                                  //(* parallel events *)
  //                     | "&/"                                  //(* sequential events *)
  //                     | "|"                                   //(* intensional intersection *)
  //                     | "&"
  public static boolean infixOpMulti(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "infixOpMulti")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<infix op multi>");
    r = consumeToken(b, "&&");
    if (!r) r = consumeToken(b, "*");
    if (!r) r = consumeToken(b, "||");
    if (!r) r = consumeToken(b, "&|");
    if (!r) r = consumeToken(b, "&/");
    if (!r) r = consumeToken(b, "|");
    if (!r) r = consumeToken(b, "&");
    exit_section_(b, l, m, INFIX_OP_MULTI, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "-"                                   //(* extensional difference *)
  //                     | "~"
  public static boolean infixOpSingle(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "infixOpSingle")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<infix op single>");
    r = consumeToken(b, "-");
    if (!r) r = consumeToken(b, "~");
    exit_section_(b, l, m, INFIX_OP_SINGLE, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // <"/">
  public static boolean interval(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "interval")) return false;
    if (!nextTokenIs(b, <"/">)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, <"/">);
    exit_section_(b, m, INTERVAL, r);
    return r;
  }

  /* ********************************************************** */
  // "([0]?\.[0-9]+|1|0)"
  public static boolean priority(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "priority")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<priority>");
    r = consumeToken(b, "([0]?\.[0-9]+|1|0)");
    exit_section_(b, l, m, PRIORITY, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "([0]?\.[0-9]+|1|0)"
  public static boolean quality(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "quality")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<quality>");
    r = consumeToken(b, "([0]?\.[0-9]+|1|0)");
    exit_section_(b, l, m, QUALITY, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // statement"." [tense] [truth]          //(* judgement to be remembered *)
  //                     | statement"?" [tense] [truth]          //(* question to be answered, tense added in OpenNARS 1.7 *)
  //                     | statement"@" [tense] [truth]          //(* question on desire value to be answered, tense added in OpenNARS 1.7 *)
  //                     | statement"!" [tense] [truth]
  public static boolean sentence(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sentence")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<sentence>");
    r = sentence_0(b, l + 1);
    if (!r) r = sentence_1(b, l + 1);
    if (!r) r = sentence_2(b, l + 1);
    if (!r) r = sentence_3(b, l + 1);
    exit_section_(b, l, m, SENTENCE, r, false, null);
    return r;
  }

  // statement"." [tense] [truth]
  private static boolean sentence_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sentence_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = statement(b, l + 1);
    r = r && consumeToken(b, ".");
    r = r && sentence_0_2(b, l + 1);
    r = r && sentence_0_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [tense]
  private static boolean sentence_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sentence_0_2")) return false;
    tense(b, l + 1);
    return true;
  }

  // [truth]
  private static boolean sentence_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sentence_0_3")) return false;
    truth(b, l + 1);
    return true;
  }

  // statement"?" [tense] [truth]
  private static boolean sentence_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sentence_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = statement(b, l + 1);
    r = r && consumeToken(b, "?");
    r = r && sentence_1_2(b, l + 1);
    r = r && sentence_1_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [tense]
  private static boolean sentence_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sentence_1_2")) return false;
    tense(b, l + 1);
    return true;
  }

  // [truth]
  private static boolean sentence_1_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sentence_1_3")) return false;
    truth(b, l + 1);
    return true;
  }

  // statement"@" [tense] [truth]
  private static boolean sentence_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sentence_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = statement(b, l + 1);
    r = r && consumeToken(b, "@");
    r = r && sentence_2_2(b, l + 1);
    r = r && sentence_2_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [tense]
  private static boolean sentence_2_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sentence_2_2")) return false;
    tense(b, l + 1);
    return true;
  }

  // [truth]
  private static boolean sentence_2_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sentence_2_3")) return false;
    truth(b, l + 1);
    return true;
  }

  // statement"!" [tense] [truth]
  private static boolean sentence_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sentence_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = statement(b, l + 1);
    r = r && consumeToken(b, "!");
    r = r && sentence_3_2(b, l + 1);
    r = r && sentence_3_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [tense]
  private static boolean sentence_3_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sentence_3_2")) return false;
    tense(b, l + 1);
    return true;
  }

  // [truth]
  private static boolean sentence_3_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sentence_3_3")) return false;
    truth(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // "<"term copula term">"                //(* two terms related to each other *)
  //                     | "("term copula term")"                //(* two terms related to each other, new notation *)
  //                     | "+++"   term                          //(* a term can name a statement *)
  //                     | "(^" word {","term} ")"               //(* an operation to be executed *)
  //                     | word"("term {","term} ")"
  public static boolean statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<statement>");
    r = statement_0(b, l + 1);
    if (!r) r = statement_1(b, l + 1);
    if (!r) r = statement_2(b, l + 1);
    if (!r) r = statement_3(b, l + 1);
    if (!r) r = statement_4(b, l + 1);
    exit_section_(b, l, m, STATEMENT, r, false, null);
    return r;
  }

  // "<"term copula term">"
  private static boolean statement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "<");
    r = r && term(b, l + 1);
    r = r && copula(b, l + 1);
    r = r && term(b, l + 1);
    r = r && consumeToken(b, ">");
    exit_section_(b, m, null, r);
    return r;
  }

  // "("term copula term")"
  private static boolean statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "(");
    r = r && term(b, l + 1);
    r = r && copula(b, l + 1);
    r = r && term(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // "+++"   term
  private static boolean statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "+++");
    r = r && term(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // "(^" word {","term} ")"
  private static boolean statement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "(^");
    r = r && word(b, l + 1);
    r = r && statement_3_2(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // ","term
  private static boolean statement_3_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_3_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && term(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // word"("term {","term} ")"
  private static boolean statement_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = word(b, l + 1);
    r = r && consumeToken(b, "(");
    r = r && term(b, l + 1);
    r = r && statement_4_3(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // ","term
  private static boolean statement_4_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_4_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && term(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // [budget] sentence
  static boolean task(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "task")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = task_0(b, l + 1);
    r = r && sentence(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [budget]
  private static boolean task_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "task_0")) return false;
    budget(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ":/:"                                 //(* future event *)
  //                     | ":|:"                                 //(* present event *)
  //                     | ":\\:"                                //(* :\: past event *)
  //                     | <":">
  public static boolean tense(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tense")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<tense>");
    r = consumeToken(b, ":/:");
    if (!r) r = consumeToken(b, ":|:");
    if (!r) r = consumeToken(b, ":\\:");
    if (!r) r = consumeToken(b, <":">);
    exit_section_(b, l, m, TENSE, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // word                                  //(* an atomic constant term *)
  //                     | variable                              //(* an atomic variable term *)
  //                     | compoundTerm                         //(* a term with internal structure *)
  //                     | statement                             //(* a statement can serve as a term *)
  //                     | interval
  public static boolean term(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<term>");
    r = word(b, l + 1);
    if (!r) r = variable(b, l + 1);
    if (!r) r = compoundTerm(b, l + 1);
    if (!r) r = statement(b, l + 1);
    if (!r) r = interval(b, l + 1);
    exit_section_(b, l, m, TERM, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // <"%">frequency[<";">confidence]<"%">
  public static boolean truth(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "truth")) return false;
    if (!nextTokenIs(b, <"%">)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, <"%">);
    r = r && frequency(b, l + 1);
    r = r && truth_2(b, l + 1);
    r = r && consumeToken(b, <"%">);
    exit_section_(b, m, TRUTH, r);
    return r;
  }

  // [<";">confidence]
  private static boolean truth_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "truth_2")) return false;
    truth_2_0(b, l + 1);
    return true;
  }

  // <";">confidence
  private static boolean truth_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "truth_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, <";">);
    r = r && confidence(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "$"word                               //(* independent variable *)
  //                     | "#"[word]                             //(* dependent variable *)
  //                     | "?"[word]
  public static boolean variable(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<variable>");
    r = variable_0(b, l + 1);
    if (!r) r = variable_1(b, l + 1);
    if (!r) r = variable_2(b, l + 1);
    exit_section_(b, l, m, VARIABLE, r, false, null);
    return r;
  }

  // "$"word
  private static boolean variable_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "$");
    r = r && word(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // "#"[word]
  private static boolean variable_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "#");
    r = r && variable_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [word]
  private static boolean variable_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_1_1")) return false;
    word(b, l + 1);
    return true;
  }

  // "?"[word]
  private static boolean variable_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "?");
    r = r && variable_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [word]
  private static boolean variable_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_2_1")) return false;
    word(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // "\w+"
  public static boolean word(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "word")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<word>");
    r = consumeToken(b, "\w+");
    exit_section_(b, l, m, WORD, r, false, null);
    return r;
  }

}
