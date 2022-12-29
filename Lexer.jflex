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

	public int ConvertToInteger(String text)
	{
		return 0;
	}

	public float ConvertToFloat(String text)
	{
		return 0.0f;
	}

%}




NEWLINE = [\n\r]
cc = ([\b\f]|{NEWLINE})
WHITESPACE = {cc}|[\t ]

DIGIT = [0-9]
ALPHA = [a-zA-Z_]
ALPHANUM = {alpha}|{NUM}

%%

<YYINITIAL> {NEWLINE}    { yychar = 0; }
<YYINITIAL> {WHITESPACE} { }

<YYINITIAL>	"+"		{return new Symbol(sym.PLUS);}
<YYINITIAL>	"-"		{return new Symbol(sym.MINUS);}
<YYINITIAL>	"*"		{return new Symbol(sym.MUL);}
<YYINITIAL>	"/"		{return new Symbol(sym.DIV);}
<YYINITIAL>	"%"		{return new Symbol(sym.MOD);}
			    
			    
<YYINITIAL>	">"		{return new Symbol(sym.GT);}
<YYINITIAL>	"<"		{return new Symbol(sym.LT);}
<YYINITIAL>	">="	{return new Symbol(sym.GE);}
<YYINITIAL>	"<="	{return new Symbol(sym.LE);}
<YYINITIAL>	"!="	{return new Symbol(sym.NE);}

<YYINITIAL>	"("	{return new Symbol(sym.LPAREN);}
<YYINITIAL>	")"	{return new Symbol(sym.RPAREN);}

<YYINITIAL>	"{"	{return new Symbol(sym.LBRACE);}
<YYINITIAL>	"}"	{return new Symbol(sym.RBRACE);}


<YYINITIAL> {DIGIT}+.{DIGIT}*	{return new Symbol(sym.INT, ConvertToFloat(yytext()));}
<YYINITIAL> {DIGIT}+			{return new Symbol(sym.INT, ConvertToInteger(yytext()));}

<YYINITIAL> . { throw new Error("Illegal character <" + yytext()+">"); }