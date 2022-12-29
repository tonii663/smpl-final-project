import java_cup.runtime.*;


%%

%public

/* Set class name */
%class Lexer

/* Use unicode */
%unicode

/* Line number */
%line

/* Column number */
%column
%char

/* Use CUP compatability mode */
%cup
%type java_cup.runtime.Symbol

%throws TokenException

%eofval{
	return new Symbol(sym.EOF);
%eofval}

%eofclose false

%{
    public long getChar() {
	return yychar + 1;
    }

    public int getColumn() {
    	return yycolumn + 1;
    }

    public int getLine() {
	return yyline + 1;
    }

    public String getText() {
	return yytext();
    }
%}


NEWLINE = [\n\r]
WHITESPACE = {cc}|[\t ]

NUM = [0-9]
ALPHA = [a-zA-Z_]
ALPHANUM = {alpha}|{NUM}

%%

<YYINITIAL> {NEWLINE}    { yychar = 0; }
<YYINITIAL> {WHITESPACE} { // Skip whitespace }

<YYINITIAL>	"+"		{return new Symbol(sym.PLUS);}
<YYINITIAL>	"-"		{return new Symbol(sym.MINUS);}
<YYINITIAL>	"*"		{return new Symbol(sym.MUL);}
<YYINITIAL>	"/"		{return new Symbol(sym.DIV);}
<YYINITIAL>	"%"		{return new Symbol(sym.MOD);}
			    
			    
<YYINITIAL>	">"		{return new Symbol(sym.COND, Cmp.GT);}
<YYINITIAL>	"<"		{return new Symbol(sym.COND, Cmp.LT);}
<YYINITIAL>	">="	{return new Symbol(sym.COND, Cmp.GE);}
<YYINITIAL>	"<="	{return new Symbol(sym.COND, Cmp.LE);}
<YYINITIAL>	"!="	{return new Symbol(sym.COND, Cmp.NE);}


<YYINITIAL> {NUM}+.{NUM}*	{return new Symbol(sym.INT, ConvertToFloat(yytext()));}
<YYINITIAL> {NUM}+			{return new Symbol(sym.INT, ConvertToInteger(yytext()));}


<YYINITIAL> \S  { // error situation
	       	   	  String msg = String.format("Unrecognised Token: %s", yytext());
				  throw new TokenException(msg);
				}
