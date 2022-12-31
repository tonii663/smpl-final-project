
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

import java_cup.runtime.*;
import java.io.*;
import java.util.*;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class SmplParser extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return sym.class;
}

  /** Default constructor. */
  @Deprecated
  public SmplParser() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public SmplParser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public SmplParser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\012\000\002\005\003\000\002\002\004\000\002\002" +
    "\005\000\002\002\005\000\002\002\003\000\002\003\005" +
    "\000\002\003\005\000\002\003\003\000\002\004\003\000" +
    "\002\004\005" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\022\000\006\005\007\023\011\001\002\000\004\002" +
    "\024\001\002\000\016\002\ufffa\006\ufffa\011\ufffa\012\ufffa" +
    "\013\ufffa\014\ufffa\001\002\000\016\002\ufffd\006\ufffd\011" +
    "\ufffd\012\ufffd\013\015\014\016\001\002\000\006\005\007" +
    "\023\011\001\002\000\010\002\001\011\012\012\013\001" +
    "\002\000\016\002\ufff9\006\ufff9\011\ufff9\012\ufff9\013\ufff9" +
    "\014\ufff9\001\002\000\006\005\007\023\011\001\002\000" +
    "\006\005\007\023\011\001\002\000\016\002\ufffe\006\ufffe" +
    "\011\ufffe\012\ufffe\013\015\014\016\001\002\000\006\005" +
    "\007\023\011\001\002\000\006\005\007\023\011\001\002" +
    "\000\016\002\ufffb\006\ufffb\011\ufffb\012\ufffb\013\ufffb\014" +
    "\ufffb\001\002\000\016\002\ufffc\006\ufffc\011\ufffc\012\ufffc" +
    "\013\ufffc\014\ufffc\001\002\000\016\002\uffff\006\uffff\011" +
    "\uffff\012\uffff\013\015\014\016\001\002\000\010\006\023" +
    "\011\012\012\013\001\002\000\016\002\ufff8\006\ufff8\011" +
    "\ufff8\012\ufff8\013\ufff8\014\ufff8\001\002\000\004\002\000" +
    "\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\022\000\012\002\007\003\005\004\004\005\003\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\010\002\021\003\005\004\004\001\001\000\002\001" +
    "\001\000\002\001\001\000\006\003\020\004\004\001\001" +
    "\000\006\003\013\004\004\001\001\000\002\001\001\000" +
    "\004\004\017\001\001\000\004\004\016\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$SmplParser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$SmplParser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$SmplParser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 1;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}


  /** User initialization code. */
  public void user_init() throws java.lang.Exception
    {

	  
    }

  /** Scan to get the next Symbol. */
  public java_cup.runtime.Symbol scan()
    throws java.lang.Exception
    {

		try {
		    return lexer.next_token();
		} catch (java.io.IOException ioe) {
		    System.out.println("Line " + lexer.getLine() + ", pos " +
				       lexer.getChar() +
				       ": Unrecognised token");
		    System.out.println(ioe.getMessage());
		    throw ioe;
		}
	  
    }


	   Lexer lexer;

	   public SmplParser(Lexer l) {
	   		  super(l);
			  lexer = l;
	   }

		public void report_error(String message, Object info) {
		    System.err.println(message);
		}

		public void syntax_error(Symbol cur_token) {
		    System.err.print("Line " + lexer.getLine() +
							 " near char " + lexer.getChar() + ": ");
		    report_error("Syntax error", cur_token);
		    System.err.println ("Last token read is " +
							   	 lexer.getText());
		}


/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$SmplParser$actions {
  private final SmplParser parser;

  /** Constructor */
  CUP$SmplParser$actions(SmplParser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$SmplParser$do_action_part00000000(
    int                        CUP$SmplParser$act_num,
    java_cup.runtime.lr_parser CUP$SmplParser$parser,
    java.util.Stack            CUP$SmplParser$stack,
    int                        CUP$SmplParser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$SmplParser$result;

      /* select the action based on the action number */
      switch (CUP$SmplParser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // program ::= expression 
            {
              SmplProgram RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$SmplParser$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$SmplParser$stack.peek()).right;
		Exp e = (Exp)((java_cup.runtime.Symbol) CUP$SmplParser$stack.peek()).value;
		 RESULT = new SmplProgram(e); 
              CUP$SmplParser$result = parser.getSymbolFactory().newSymbol("program",3, ((java_cup.runtime.Symbol)CUP$SmplParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$SmplParser$stack.peek()), RESULT);
            }
          return CUP$SmplParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= program EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$SmplParser$stack.elementAt(CUP$SmplParser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$SmplParser$stack.elementAt(CUP$SmplParser$top-1)).right;
		SmplProgram start_val = (SmplProgram)((java_cup.runtime.Symbol) CUP$SmplParser$stack.elementAt(CUP$SmplParser$top-1)).value;
		RESULT = start_val;
              CUP$SmplParser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$SmplParser$stack.elementAt(CUP$SmplParser$top-1)), ((java_cup.runtime.Symbol)CUP$SmplParser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$SmplParser$parser.done_parsing();
          return CUP$SmplParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // expression ::= expression PLUS term 
            {
              Exp RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$SmplParser$stack.elementAt(CUP$SmplParser$top-2)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$SmplParser$stack.elementAt(CUP$SmplParser$top-2)).right;
		Exp e = (Exp)((java_cup.runtime.Symbol) CUP$SmplParser$stack.elementAt(CUP$SmplParser$top-2)).value;
		int tleft = ((java_cup.runtime.Symbol)CUP$SmplParser$stack.peek()).left;
		int tright = ((java_cup.runtime.Symbol)CUP$SmplParser$stack.peek()).right;
		Exp t = (Exp)((java_cup.runtime.Symbol) CUP$SmplParser$stack.peek()).value;
		 RESULT = new ExpAdd(e, t); 
              CUP$SmplParser$result = parser.getSymbolFactory().newSymbol("expression",0, ((java_cup.runtime.Symbol)CUP$SmplParser$stack.elementAt(CUP$SmplParser$top-2)), ((java_cup.runtime.Symbol)CUP$SmplParser$stack.peek()), RESULT);
            }
          return CUP$SmplParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // expression ::= expression MINUS term 
            {
              Exp RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$SmplParser$stack.elementAt(CUP$SmplParser$top-2)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$SmplParser$stack.elementAt(CUP$SmplParser$top-2)).right;
		Exp e = (Exp)((java_cup.runtime.Symbol) CUP$SmplParser$stack.elementAt(CUP$SmplParser$top-2)).value;
		int tleft = ((java_cup.runtime.Symbol)CUP$SmplParser$stack.peek()).left;
		int tright = ((java_cup.runtime.Symbol)CUP$SmplParser$stack.peek()).right;
		Exp t = (Exp)((java_cup.runtime.Symbol) CUP$SmplParser$stack.peek()).value;
		 RESULT = new ExpSub(e, t); 
              CUP$SmplParser$result = parser.getSymbolFactory().newSymbol("expression",0, ((java_cup.runtime.Symbol)CUP$SmplParser$stack.elementAt(CUP$SmplParser$top-2)), ((java_cup.runtime.Symbol)CUP$SmplParser$stack.peek()), RESULT);
            }
          return CUP$SmplParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // expression ::= term 
            {
              Exp RESULT =null;
		int tleft = ((java_cup.runtime.Symbol)CUP$SmplParser$stack.peek()).left;
		int tright = ((java_cup.runtime.Symbol)CUP$SmplParser$stack.peek()).right;
		Exp t = (Exp)((java_cup.runtime.Symbol) CUP$SmplParser$stack.peek()).value;
		 RESULT = t; 
              CUP$SmplParser$result = parser.getSymbolFactory().newSymbol("expression",0, ((java_cup.runtime.Symbol)CUP$SmplParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$SmplParser$stack.peek()), RESULT);
            }
          return CUP$SmplParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // term ::= term MUL factor 
            {
              Exp RESULT =null;
		int tleft = ((java_cup.runtime.Symbol)CUP$SmplParser$stack.elementAt(CUP$SmplParser$top-2)).left;
		int tright = ((java_cup.runtime.Symbol)CUP$SmplParser$stack.elementAt(CUP$SmplParser$top-2)).right;
		Exp t = (Exp)((java_cup.runtime.Symbol) CUP$SmplParser$stack.elementAt(CUP$SmplParser$top-2)).value;
		int fleft = ((java_cup.runtime.Symbol)CUP$SmplParser$stack.peek()).left;
		int fright = ((java_cup.runtime.Symbol)CUP$SmplParser$stack.peek()).right;
		Exp f = (Exp)((java_cup.runtime.Symbol) CUP$SmplParser$stack.peek()).value;
		 RESULT = new ExpMul(t, f); 
              CUP$SmplParser$result = parser.getSymbolFactory().newSymbol("term",1, ((java_cup.runtime.Symbol)CUP$SmplParser$stack.elementAt(CUP$SmplParser$top-2)), ((java_cup.runtime.Symbol)CUP$SmplParser$stack.peek()), RESULT);
            }
          return CUP$SmplParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // term ::= term DIV factor 
            {
              Exp RESULT =null;
		int tleft = ((java_cup.runtime.Symbol)CUP$SmplParser$stack.elementAt(CUP$SmplParser$top-2)).left;
		int tright = ((java_cup.runtime.Symbol)CUP$SmplParser$stack.elementAt(CUP$SmplParser$top-2)).right;
		Exp t = (Exp)((java_cup.runtime.Symbol) CUP$SmplParser$stack.elementAt(CUP$SmplParser$top-2)).value;
		int fleft = ((java_cup.runtime.Symbol)CUP$SmplParser$stack.peek()).left;
		int fright = ((java_cup.runtime.Symbol)CUP$SmplParser$stack.peek()).right;
		Exp f = (Exp)((java_cup.runtime.Symbol) CUP$SmplParser$stack.peek()).value;
		 RESULT = new ExpDiv(t, f); 
              CUP$SmplParser$result = parser.getSymbolFactory().newSymbol("term",1, ((java_cup.runtime.Symbol)CUP$SmplParser$stack.elementAt(CUP$SmplParser$top-2)), ((java_cup.runtime.Symbol)CUP$SmplParser$stack.peek()), RESULT);
            }
          return CUP$SmplParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // term ::= factor 
            {
              Exp RESULT =null;
		int fleft = ((java_cup.runtime.Symbol)CUP$SmplParser$stack.peek()).left;
		int fright = ((java_cup.runtime.Symbol)CUP$SmplParser$stack.peek()).right;
		Exp f = (Exp)((java_cup.runtime.Symbol) CUP$SmplParser$stack.peek()).value;
		 RESULT = f; 
              CUP$SmplParser$result = parser.getSymbolFactory().newSymbol("term",1, ((java_cup.runtime.Symbol)CUP$SmplParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$SmplParser$stack.peek()), RESULT);
            }
          return CUP$SmplParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // factor ::= INT 
            {
              Exp RESULT =null;
		int ileft = ((java_cup.runtime.Symbol)CUP$SmplParser$stack.peek()).left;
		int iright = ((java_cup.runtime.Symbol)CUP$SmplParser$stack.peek()).right;
		Integer i = (Integer)((java_cup.runtime.Symbol) CUP$SmplParser$stack.peek()).value;
		 RESULT = new ExpLit(i); 
              CUP$SmplParser$result = parser.getSymbolFactory().newSymbol("factor",2, ((java_cup.runtime.Symbol)CUP$SmplParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$SmplParser$stack.peek()), RESULT);
            }
          return CUP$SmplParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // factor ::= LPAREN expression RPAREN 
            {
              Exp RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$SmplParser$stack.elementAt(CUP$SmplParser$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$SmplParser$stack.elementAt(CUP$SmplParser$top-1)).right;
		Exp e = (Exp)((java_cup.runtime.Symbol) CUP$SmplParser$stack.elementAt(CUP$SmplParser$top-1)).value;
		 RESULT = e; 
              CUP$SmplParser$result = parser.getSymbolFactory().newSymbol("factor",2, ((java_cup.runtime.Symbol)CUP$SmplParser$stack.elementAt(CUP$SmplParser$top-2)), ((java_cup.runtime.Symbol)CUP$SmplParser$stack.peek()), RESULT);
            }
          return CUP$SmplParser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$SmplParser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$SmplParser$do_action(
    int                        CUP$SmplParser$act_num,
    java_cup.runtime.lr_parser CUP$SmplParser$parser,
    java.util.Stack            CUP$SmplParser$stack,
    int                        CUP$SmplParser$top)
    throws java.lang.Exception
    {
              return CUP$SmplParser$do_action_part00000000(
                               CUP$SmplParser$act_num,
                               CUP$SmplParser$parser,
                               CUP$SmplParser$stack,
                               CUP$SmplParser$top);
    }
}

}