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
	
	public double ParseDouble(String s)
	{
		return Double.parseDouble(s);
	}

	public int ParseInteger(String s)
	{
		return Integer.parseInt(s);
	}

	public int ParseBinaryToInteger(String s)
	{
		s = s.substring(2);
		return Integer.parseInt(s, 2);
	}

	public int ParseHexToInteger(String s)
	{
		s = s.substring(2);
		return Integer.parseInt(s, 16);
	}

	// TODO(afb) :: Consider making it a Character
	public String ParseChar(String s)
	{
		return s.substring(2);
	}
%}




NEWLINE = [\n\r]
cc = ([\b\f]|{NEWLINE})
WHITESPACE = {cc}|[\t ]

BINARY = [10]
HEX = [0-9A-Fa-f]
DIGIT = [0-9]
ALPHA = [a-zA-Z_]
ALPHANUM = {alpha}|{NUM}
FLOAT = ({DIGIT}+\.{DIGIT}*)|({DIGIT}*.{DIGIT}+)
CHAR = [A-Za-z]

%%

<YYINITIAL> {NEWLINE}    { yychar = 0; }
<YYINITIAL> {WHITESPACE} { }

<YYINITIAL>	" + "		{return new Symbol(sym.PLUS);}
<YYINITIAL>	" - "		{return new Symbol(sym.MINUS);}
<YYINITIAL>	" * "		{return new Symbol(sym.MUL);}
<YYINITIAL>	" / "		{return new Symbol(sym.DIV);}
<YYINITIAL>	" % "		{return new Symbol(sym.MOD);}
			    			    
<YYINITIAL>	">"		{return new Symbol(sym.GT);}
<YYINITIAL>	"<"		{return new Symbol(sym.LT);}
<YYINITIAL>	">="	{return new Symbol(sym.GE);}
<YYINITIAL>	"<="	{return new Symbol(sym.LE);}
<YYINITIAL>	"!="	{return new Symbol(sym.NE);}

<YYINITIAL>	"("	{return new Symbol(sym.LPAREN);}
<YYINITIAL>	")"	{return new Symbol(sym.RPAREN);}

<YYINITIAL>	"{"	{return new Symbol(sym.LBRACE);}
<YYINITIAL>	"}"	{return new Symbol(sym.RBRACE);}

<YYINITIAL>	#c{CHAR}	{return new Symbol(sym.CHAR, ParseChar(yytext()));}

<YYINITIAL>	#t	{return new Symbol(sym.BOOL, true);}
<YYINITIAL>	#f	{return new Symbol(sym.BOOL, false);}
			
<YYINITIAL> -?{FLOAT}	{return new Symbol(sym.INT, ParseDouble(yytext()));}

<YYINITIAL> {DIGIT}+	{return new Symbol(sym.INT, ParseInteger(yytext()));}
<YYINITIAL> #x{HEX}+	{return new Symbol(sym.INT, ParseHexToInteger(yytext()));}
<YYINITIAL> #b{BINARY}+	{return new Symbol(sym.INT, ParseBinaryToInteger(yytext()));}

<YYINITIAL> . { throw new Error("Illegal character <" + yytext()+">"); }