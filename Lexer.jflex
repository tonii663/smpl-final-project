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

    // TODO(afb) :: Add negative number parsing
    public int ParseInteger(String s)
    {
        int result = Integer.parseInt(s);
        return result;
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
    public Character ParseChar(String s)
    {
        return s.charAt(2);
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
DOUBLE = ({DIGIT}+\.{DIGIT}*)|({DIGIT}*.{DIGIT}+)
CHAR = [A-Za-z_]
ID = {CHAR}+
%%

<YYINITIAL> {NEWLINE}    { yychar = 0; }
<YYINITIAL> {WHITESPACE} { }

<YYINITIAL> "+"		{return new Symbol(sym.PLUS);}
<YYINITIAL> "-"		{return new Symbol(sym.MINUS);}
<YYINITIAL> "*"		{return new Symbol(sym.MUL);}
<YYINITIAL> "/"		{return new Symbol(sym.DIV);}
<YYINITIAL> "%"		{return new Symbol(sym.MOD);}

<YYINITIAL> "&"		{return new Symbol(sym.BIT_AND);}
<YYINITIAL> "|"		{return new Symbol(sym.BIT_OR);}
<YYINITIAL> "~"		{return new Symbol(sym.BIT_NOT);}

<YYINITIAL> ":="	{return new Symbol(sym.ASSIGN);}                            
<YYINITIAL> ">"		{return new Symbol(sym.GT);}
<YYINITIAL> "<"		{return new Symbol(sym.LT);}
<YYINITIAL> ">="	{return new Symbol(sym.GE);}
<YYINITIAL> "<="	{return new Symbol(sym.LE);}
<YYINITIAL> "!="	{return new Symbol(sym.NE);}

<YYINITIAL> "("		{return new Symbol(sym.LPAREN);}
<YYINITIAL> ")"		{return new Symbol(sym.RPAREN);}
<YYINITIAL> "["		{return new Symbol(sym.LBRACKET);}
<YYINITIAL> "]"		{return new Symbol(sym.RBRACKET);}
<YYINITIAL> "{"		{return new Symbol(sym.LBRACE);}
<YYINITIAL> "}"		{return new Symbol(sym.RBRACE);}
<YYINITIAL> "[:"	{return new Symbol(sym.LB_COLON);}
<YYINITIAL> ":]"	{return new Symbol(sym.RB_COLON);}

<YYINITIAL> ";"		{return new Symbol(sym.SEMI);}
<YYINITIAL> "@"		{return new Symbol(sym.AT);}
<YYINITIAL> ","		{return new Symbol(sym.COMMA);}

<YYINITIAL> "pair?"     {return new Symbol(sym.IS_PAIR);}
<YYINITIAL> "pair"      {return new Symbol(sym.PAIR);}
<YYINITIAL> "car"       {return new Symbol(sym.CAR);}
<YYINITIAL> "cdr"       {return new Symbol(sym.CDR);}
<YYINITIAL> "list"      {return new Symbol(sym.LIST);}
<YYINITIAL> "size"      {return new Symbol(sym.SIZE);}
<YYINITIAL> "eqv?"      {return new Symbol(sym.EQV);}
<YYINITIAL> "equal?"    {return new Symbol(sym.EQL);}
<YYINITIAL> "substr"    {return new Symbol(sym.SUBSTR);}
<YYINITIAL> "def"       {return new Symbol(sym.DEF);}
<YYINITIAL> "proc"      {return new Symbol(sym.PROC);}

<YYINITIAL> "and"       {return new Symbol(sym.AND);}
<YYINITIAL> "or"        {return new Symbol(sym.OR);}
<YYINITIAL> "not"       {return new Symbol(sym.NOT);}

<YYINITIAL> #c{CHAR}    {return new Symbol(sym.CHAR, ParseChar(yytext()));}

<YYINITIAL> "#t"  {return new Symbol(sym.TRUE);}
<YYINITIAL> "#f"  {return new Symbol(sym.FALSE);}

<YYINITIAL> [-]?{DIGIT}+ {return new Symbol(sym.INT, ParseInteger(yytext()));}
<YYINITIAL> #x{HEX}+    {return new Symbol(sym.INT, ParseHexToInteger(yytext()));}
<YYINITIAL> #b{BINARY}+     {return new Symbol(sym.INT, ParseBinaryToInteger(yytext()));}

<YYINITIAL> {ID}  {return new Symbol(sym.VAR, yytext());}

<YYINITIAL> . { throw new Error("Illegal character <" + yytext()+">"); }