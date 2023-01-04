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
	StringBuffer strBuff = new StringBuffer();

	int nestedBlockCommentCount = 0;
	
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

    public Integer ParseHexToInteger(String s)
    {
		String num = s.replaceFirst("#x", "");
		num = num.replaceAll(" ", "");
		return Integer.parseInt(num, 16);
    }

	public Character ParseUnicodeToChar(String s)
	{
		int c = Integer.parseInt(s.substring(2), 16);
		return Character.valueOf(Character.toChars(c)[0]);
	}
	
    // TODO(afb) :: Consider making it a Character
    public Character ParseChar(String s)
    {
        return s.charAt(2);
    }
%}

nl = [\n\r]
ws = {cc}|[\t ]

%xstates PARSE_STRING, ESCAPE_SEQUENCE
%xstates BLK_COMMENT

stringChar = [^\"\\\r\n\t]
stringBreak = {nl}+({nl}|{ws})*|[\t]+ 
blockCommentChar = [^"/*""*/"]

NEWLINE		= [\n\r]
cc			= ([\b\f]|{NEWLINE})
WHITESPACE	= {cc}|[\t ]

BINARY		= [10]
HEX			= [0-9A-Fa-f]
DIGIT		= [0-9]
SYMBOLS     = ["+""-""*"/%"^"&|~@"?"!]
ALPHA		= [a-zA-Z]
ALPHANUM	= {ALPHA}|{DIGIT}|[_]
DOUBLE		= [-]?({DIGIT}+\.{DIGIT}*)|({DIGIT}*\.{DIGIT}+)
CHAR		= [A-Za-z_]

VAR_COMP = {ALPHANUM}|{SYMBOLS}
%%

<YYINITIAL> {NEWLINE}    { yychar = 0; }
<YYINITIAL> {WHITESPACE} { }

<YYINITIAL> {WHITESPACE}"+"{WHITESPACE}		{return new Symbol(sym.PLUS);}
<YYINITIAL> {WHITESPACE}"-"{WHITESPACE}		{return new Symbol(sym.MINUS);}
<YYINITIAL> {WHITESPACE}"*"{WHITESPACE}		{return new Symbol(sym.MUL);}
<YYINITIAL> {WHITESPACE}"/"{WHITESPACE}		{return new Symbol(sym.DIV);}
<YYINITIAL> {WHITESPACE}"%"{WHITESPACE}		{return new Symbol(sym.MOD);}
<YYINITIAL> {WHITESPACE}"&"{WHITESPACE}		{return new Symbol(sym.BIT_AND);}
<YYINITIAL> {WHITESPACE}"|"{WHITESPACE}		{return new Symbol(sym.BIT_OR);}
<YYINITIAL> {WHITESPACE}"~"{WHITESPACE}		{return new Symbol(sym.BIT_NOT);}
<YYINITIAL> {WHITESPACE}":="{WHITESPACE}	{return new Symbol(sym.ASSIGN);}                            

<YYINITIAL> {WHITESPACE}">"{WHITESPACE}		{return new Symbol(sym.COND, "GT");}
<YYINITIAL> {WHITESPACE}"<"{WHITESPACE}		{return new Symbol(sym.COND, "LT");}
<YYINITIAL> {WHITESPACE}">="{WHITESPACE}	{return new Symbol(sym.COND, "GE");}
<YYINITIAL> {WHITESPACE}"<="{WHITESPACE}	{return new Symbol(sym.COND, "LE");}
<YYINITIAL> {WHITESPACE}"!="{WHITESPACE}	{return new Symbol(sym.COND, "NE");}
<YYINITIAL> {WHITESPACE}"="{WHITESPACE}	    {return new Symbol(sym.COND, "EQUAL");}

<YYINITIAL> "("		{return new Symbol(sym.LPAREN);}
<YYINITIAL> ")"		{return new Symbol(sym.RPAREN);}
<YYINITIAL> "["		{return new Symbol(sym.LBRACKET);}
<YYINITIAL> "]"		{return new Symbol(sym.RBRACKET);}
<YYINITIAL> "{"		{return new Symbol(sym.LBRACE);}
<YYINITIAL> "}"		{return new Symbol(sym.RBRACE);}

<YYINITIAL> "[:"	{return new Symbol(sym.LB_COLON);}
<YYINITIAL> ":]"	{return new Symbol(sym.RB_COLON);}

<YYINITIAL> ":"		{return new Symbol(sym.COLON);}
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
<YYINITIAL> "print"     {return new Symbol(sym.PRINT);}
<YYINITIAL> "println"   {return new Symbol(sym.PRINTLN);}
<YYINITIAL> "read"      {return new Symbol(sym.READ);}
<YYINITIAL> "readInt"   {return new Symbol(sym.READINT);}

<YYINITIAL> "and"       {return new Symbol(sym.AND);}
<YYINITIAL> "or"        {return new Symbol(sym.OR);}
<YYINITIAL> "not"       {return new Symbol(sym.NOT);}

<YYINITIAL> "if"       {return new Symbol(sym.IF);}
<YYINITIAL> "then"     {return new Symbol(sym.THEN);}
<YYINITIAL> "else"     {return new Symbol(sym.ELSE);}

<YYINITIAL> "#t"  {return new Symbol(sym.TRUE);}
<YYINITIAL> "#f"  {return new Symbol(sym.FALSE);}
<YYINITIAL> "#e"  {return new Symbol(sym.NIL);}

<YYINITIAL> #c{CHAR} {return new Symbol(sym.CHAR, ParseChar(yytext()));}
<YYINITIAL> #u{HEX}{4}  {return new Symbol(sym.CHAR, ParseUnicodeToChar(yytext()));}

<YYINITIAL> {DOUBLE}	    {return new Symbol(sym.DOUBLE, ParseDouble(yytext()));}
<YYINITIAL> [-]?{DIGIT}+	{return new Symbol(sym.INT, ParseInteger(yytext()));}
<YYINITIAL> [-]?#x{HEX}+    {return new Symbol(sym.INT, ParseHexToInteger(yytext()));}
<YYINITIAL> #b{BINARY}+     {return new Symbol(sym.INT, ParseBinaryToInteger(yytext()));}

<YYINITIAL>	"/*"	{nestedBlockCommentCount += 1;
					yychar -= 2;
					yybegin(BLK_COMMENT);}
<BLK_COMMENT> {
	"/*"	{nestedBlockCommentCount += 1;
			yychar -= 2;}
	"*/"	{nestedBlockCommentCount -= 1;
			yychar -= 2;
			if (nestedBlockCommentCount == 0){
				yybegin(YYINITIAL);
			}}
	{blockCommentChar}+	{yychar -= yytext().length();}
}


<YYINITIAL>	\"	{ yybegin(PARSE_STRING); }

<PARSE_STRING>{
	\"			{
					yybegin(YYINITIAL);
					Symbol s = new Symbol(sym.STRING, strBuff.toString());
					strBuff = new StringBuffer();
					return s;
				}

	\\			{ yybegin(ESCAPE_SEQUENCE); }

<ESCAPE_SEQUENCE>
	{
			\\ { yybegin(PARSE_STRING); strBuff.append("\\"); }
			n  { yybegin(PARSE_STRING); strBuff.append("\n"); }			
			t  { yybegin(PARSE_STRING); strBuff.append("\t"); }
	}

	{stringBreak}	{ /* User generated line break within a string. Do nothing */ }
	{stringChar}+	{strBuff.append(yytext());}
}

<YYINITIAL>	"//"~{nl}	{/* Line comment. Do Nothing*/}

<YYINITIAL>	"/*"	{nestedBlockCommentCount += 1;
					yychar -= 2;
					yybegin(BLK_COMMENT);}
<BLK_COMMENT> {
	"/*"	{nestedBlockCommentCount += 1;
			yychar -= 2;}
	"*/"	{nestedBlockCommentCount -= 1;
			yychar -= 2;
			if (nestedBlockCommentCount == 0){
				yybegin(YYINITIAL);
			}}
	{blockCommentChar}+	{yychar -= yytext().length();}
}

<YYINITIAL> {VAR_COMP}*{ALPHA}{VAR_COMP}*  {return new Symbol(sym.VAR, yytext());}

<YYINITIAL> . { throw new Error("Illegal character <" + yytext()+">"); }