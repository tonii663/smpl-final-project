// DO NOT EDIT
// Generated by JFlex 1.8.2 http://jflex.de/
// source: Lexer.jflex

import java_cup.runtime.*;


// See https://github.com/jflex-de/jflex/issues/222
@SuppressWarnings("FallThrough")
public class Lexer implements java_cup.runtime.Scanner {

  /** This character denotes the end of file. */
  public static final int YYEOF = -1;

  /** Initial size of the lookahead buffer. */
  private static final int ZZ_BUFFERSIZE = 16384;

  // Lexical states.
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = {
     0, 0
  };

  /**
   * Top-level table for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_TOP = zzUnpackcmap_top();

  private static final String ZZ_CMAP_TOP_PACKED_0 =
    "\1\0\37\u0100\1\u0200\267\u0100\10\u0300\u1020\u0100";

  private static int [] zzUnpackcmap_top() {
    int [] result = new int[4352];
    int offset = 0;
    offset = zzUnpackcmap_top(ZZ_CMAP_TOP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_top(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Second-level tables for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_BLOCKS = zzUnpackcmap_blocks();

  private static final String ZZ_CMAP_BLOCKS_PACKED_0 =
    "\10\0\2\1\1\2\1\3\1\1\1\2\22\0\1\1"+
    "\1\4\1\0\1\5\1\0\1\6\1\7\1\0\1\10"+
    "\1\11\1\12\1\13\1\14\1\15\1\0\1\16\2\17"+
    "\10\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27"+
    "\6\30\24\31\1\32\1\0\1\33\1\0\1\31\1\0"+
    "\1\34\1\35\1\36\1\37\1\40\1\41\2\31\1\42"+
    "\2\31\1\43\1\31\1\44\1\45\1\46\1\47\1\50"+
    "\1\51\1\52\1\53\1\54\1\31\1\55\1\31\1\56"+
    "\1\57\1\60\1\61\1\62\6\0\1\3\u01a2\0\2\3"+
    "\326\0\u0100\3";

  private static int [] zzUnpackcmap_blocks() {
    int [] result = new int[1024];
    int offset = 0;
    offset = zzUnpackcmap_blocks(ZZ_CMAP_BLOCKS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_blocks(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /**
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\1\1\4\1\5\1\6"+
    "\1\1\1\7\1\1\1\10\1\11\1\12\1\13\1\14"+
    "\11\12\1\15\1\16\17\0\1\17\1\20\1\21\1\0"+
    "\1\22\1\23\7\12\1\24\4\12\1\0\1\25\1\26"+
    "\1\27\1\30\1\31\1\32\1\0\1\33\1\0\1\34"+
    "\1\35\1\0\1\36\1\37\1\40\1\41\1\42\1\43"+
    "\1\44\1\45\1\46\3\12\1\47\5\12\1\50\1\51"+
    "\1\52\1\53\1\12\1\54\1\55\1\56\1\12\1\57"+
    "\1\60\2\12\1\61\1\62\1\12\1\63\1\12\1\64"+
    "\1\65";

  private static int [] zzUnpackAction() {
    int [] result = new int[111];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\63\0\146\0\146\0\231\0\63\0\63\0\63"+
    "\0\314\0\314\0\377\0\63\0\63\0\u0132\0\u0165\0\63"+
    "\0\u0198\0\u01cb\0\u01fe\0\u0231\0\u0264\0\u0297\0\u02ca\0\u02fd"+
    "\0\u0330\0\63\0\63\0\u0363\0\u0396\0\u03c9\0\u03fc\0\u042f"+
    "\0\u0462\0\u0495\0\u04c8\0\u04fb\0\u052e\0\u0561\0\u0594\0\u05c7"+
    "\0\u05fa\0\u062d\0\63\0\63\0\63\0\u0660\0\63\0\63"+
    "\0\u0693\0\u06c6\0\u06f9\0\u072c\0\u075f\0\u0792\0\u07c5\0\u0132"+
    "\0\u07f8\0\u082b\0\u085e\0\u0891\0\u08c4\0\63\0\63\0\63"+
    "\0\63\0\63\0\63\0\u08f7\0\63\0\u092a\0\63\0\63"+
    "\0\u095d\0\63\0\63\0\u05fa\0\63\0\u0660\0\u0132\0\u0132"+
    "\0\u0132\0\u0132\0\u0990\0\u09c3\0\u09f6\0\u0132\0\u0a29\0\u0a5c"+
    "\0\u0a8f\0\u0ac2\0\u0af5\0\63\0\63\0\63\0\63\0\u0b28"+
    "\0\63\0\u0132\0\u0b5b\0\u0b8e\0\u0132\0\u0132\0\u0bc1\0\u0bf4"+
    "\0\63\0\u0c27\0\u0c5a\0\63\0\u0c8d\0\u0132\0\u0132";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[111];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /**
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\0\1\2\1\5\2\2\1\6"+
    "\1\7\2\2\1\10\1\11\1\2\2\12\1\13\1\14"+
    "\4\2\1\15\2\16\1\17\1\20\1\21\1\16\1\22"+
    "\1\23\1\24\2\16\1\25\1\26\1\27\1\30\2\16"+
    "\1\31\5\16\1\32\1\2\1\33\1\2\67\0\1\34"+
    "\1\0\1\35\1\36\2\0\1\37\1\40\1\0\1\41"+
    "\1\42\2\0\1\43\1\0\1\44\1\45\1\46\32\0"+
    "\1\47\1\0\1\50\35\0\1\51\1\52\1\0\1\53"+
    "\1\54\10\0\1\55\2\0\1\56\24\0\2\12\75\0"+
    "\1\57\57\0\2\16\2\0\23\16\25\0\1\60\71\0"+
    "\2\16\2\0\10\16\1\61\12\16\34\0\2\16\2\0"+
    "\1\62\2\16\1\63\17\16\34\0\2\16\2\0\4\16"+
    "\1\64\16\16\34\0\2\16\2\0\13\16\1\65\7\16"+
    "\34\0\2\16\2\0\6\16\1\66\14\16\34\0\2\16"+
    "\2\0\11\16\1\67\11\16\34\0\2\16\2\0\14\16"+
    "\1\70\6\16\34\0\2\16\2\0\1\71\13\16\1\72"+
    "\6\16\34\0\2\16\2\0\6\16\1\73\10\16\1\74"+
    "\3\16\30\0\1\75\37\0\2\76\61\0\2\77\61\0"+
    "\2\100\61\0\2\101\61\0\2\102\61\0\2\103\104\0"+
    "\1\104\37\0\2\105\21\0\1\106\37\0\2\107\61\0"+
    "\2\110\21\0\1\111\37\0\2\112\61\0\2\113\77\0"+
    "\1\114\73\0\2\115\2\0\23\115\23\0\2\116\7\0"+
    "\1\116\3\0\6\116\51\0\2\16\2\0\3\16\1\117"+
    "\17\16\34\0\2\16\2\0\14\16\1\120\6\16\34\0"+
    "\2\16\2\0\14\16\1\121\6\16\34\0\2\16\2\0"+
    "\5\16\1\122\15\16\34\0\2\16\2\0\17\16\1\123"+
    "\1\124\2\16\34\0\2\16\2\0\15\16\1\125\5\16"+
    "\34\0\2\16\2\0\16\16\1\126\4\16\34\0\2\16"+
    "\2\0\6\16\1\127\14\16\34\0\2\16\2\0\6\16"+
    "\1\130\2\16\1\131\11\16\34\0\2\16\2\0\22\16"+
    "\1\132\34\0\2\16\2\0\1\16\1\133\21\16\5\0"+
    "\2\134\61\0\2\135\61\0\2\136\61\0\2\137\110\0"+
    "\2\16\2\0\1\140\22\16\32\0\1\141\1\0\2\16"+
    "\2\0\23\16\34\0\2\16\2\0\16\16\1\142\4\16"+
    "\34\0\2\16\2\0\14\16\1\143\6\16\34\0\2\16"+
    "\2\0\10\16\1\144\12\16\34\0\2\16\2\0\2\16"+
    "\1\145\20\16\34\0\2\16\2\0\4\16\1\146\16\16"+
    "\34\0\2\16\2\0\15\16\1\147\5\16\34\0\2\16"+
    "\2\0\7\16\1\150\13\16\32\0\1\151\1\0\2\16"+
    "\2\0\23\16\34\0\2\16\2\0\16\16\1\152\4\16"+
    "\34\0\2\16\2\0\16\16\1\153\4\16\32\0\1\154"+
    "\1\0\2\16\2\0\23\16\34\0\2\16\2\0\7\16"+
    "\1\155\13\16\34\0\2\16\2\0\14\16\1\156\6\16"+
    "\34\0\2\16\2\0\10\16\1\157\12\16\4\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[3264];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** Error code for "Unknown internal scanner error". */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  /** Error code for "could not match input". */
  private static final int ZZ_NO_MATCH = 1;
  /** Error code for "pushback value was too large". */
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /**
   * Error messages for {@link #ZZ_UNKNOWN_ERROR}, {@link #ZZ_NO_MATCH}, and
   * {@link #ZZ_PUSHBACK_2BIG} respectively.
   */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state {@code aState}
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\3\1\3\11\3\1\2\11\2\1\1\11"+
    "\11\1\2\11\17\0\3\11\1\0\2\11\14\1\1\0"+
    "\6\11\1\0\1\11\1\0\2\11\1\0\2\11\1\1"+
    "\1\11\16\1\4\11\1\1\1\11\7\1\1\11\2\1"+
    "\1\11\3\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[111];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** Input device. */
  private java.io.Reader zzReader;

  /** Current state of the DFA. */
  private int zzState;

  /** Current lexical state. */
  private int zzLexicalState = YYINITIAL;

  /**
   * This buffer contains the current text to be matched and is the source of the {@link #yytext()}
   * string.
   */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** Text position at the last accepting state. */
  private int zzMarkedPos;

  /** Current text position in the buffer. */
  private int zzCurrentPos;

  /** Marks the beginning of the {@link #yytext()} string in the buffer. */
  private int zzStartRead;

  /** Marks the last character in the buffer, that has been read from input. */
  private int zzEndRead;

  /**
   * Whether the scanner is at the end of file.
   * @see #yyatEOF
   */
  private boolean zzAtEOF;

  /**
   * The number of occupied positions in {@link #zzBuffer} beyond {@link #zzEndRead}.
   *
   * <p>When a lead/high surrogate has been read from the input stream into the final
   * {@link #zzBuffer} position, this will have a value of 1; otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /** Number of newlines encountered up to the start of the matched text. */
  private int yyline;

  /** Number of characters from the last newline up to the start of the matched text. */
  private int yycolumn;

  /** Number of characters up to the start of the matched text. */
  private long yychar;

  /** Whether the scanner is currently at the beginning of a line. */
  @SuppressWarnings("unused")
  private boolean zzAtBOL = true;

  /** Whether the user-EOF-code has already been executed. */
  @SuppressWarnings("unused")
  private boolean zzEOFDone;

  /* user code: */
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


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Lexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Translates raw input code points to DFA table row
   */
  private static int zzCMap(int input) {
    int offset = input & 255;
    return offset == input ? ZZ_CMAP_BLOCKS[offset] : ZZ_CMAP_BLOCKS[ZZ_CMAP_TOP[input >> 8] | offset];
  }

  /**
   * Refills the input buffer.
   *
   * @return {@code false} iff there was new input.
   * @exception java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead - zzStartRead);

      /* translate stored positions */
      zzEndRead -= zzStartRead;
      zzCurrentPos -= zzStartRead;
      zzMarkedPos -= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length * 2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException(
          "Reader returned 0 characters. See JFlex examples/zero-reader for a workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
        if (numRead == requested) { // We requested too few chars to encode a full Unicode character
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        } else {                    // There is room in the buffer for at least one more char
          int c = zzReader.read();  // Expecting to read a paired low surrogate char
          if (c == -1) {
            return true;
          } else {
            zzBuffer[zzEndRead++] = (char)c;
          }
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }


  /**
   * Closes the input reader.
   *
   * @throws java.io.IOException if the reader could not be closed.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true; // indicate end of file
    zzEndRead = zzStartRead; // invalidate buffer

    if (zzReader != null) {
      zzReader.close();
    }
  }


  /**
   * Resets the scanner to read from a new input stream.
   *
   * <p>Does not close the old reader.
   *
   * <p>All internal variables are reset, the old input stream <b>cannot</b> be reused (internal
   * buffer is discarded and lost). Lexical state is set to {@code ZZ_INITIAL}.
   *
   * <p>Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader The new input stream.
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzEOFDone = false;
    yyResetPosition();
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE) {
      zzBuffer = new char[ZZ_BUFFERSIZE];
    }
  }

  /**
   * Resets the input position.
   */
  private final void yyResetPosition() {
      zzAtBOL  = true;
      zzAtEOF  = false;
      zzCurrentPos = 0;
      zzMarkedPos = 0;
      zzStartRead = 0;
      zzEndRead = 0;
      zzFinalHighSurrogate = 0;
      yyline = 0;
      yycolumn = 0;
      yychar = 0L;
  }


  /**
   * Returns whether the scanner has reached the end of the reader it reads from.
   *
   * @return whether the scanner has reached EOF.
   */
  public final boolean yyatEOF() {
    return zzAtEOF;
  }


  /**
   * Returns the current lexical state.
   *
   * @return the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state.
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   *
   * @return the matched text.
   */
  public final String yytext() {
    return new String(zzBuffer, zzStartRead, zzMarkedPos-zzStartRead);
  }


  /**
   * Returns the character at the given position from the matched text.
   *
   * <p>It is equivalent to {@code yytext().charAt(pos)}, but faster.
   *
   * @param position the position of the character to fetch. A value from 0 to {@code yylength()-1}.
   *
   * @return the character at {@code position}.
   */
  public final char yycharat(int position) {
    return zzBuffer[zzStartRead + position];
  }


  /**
   * How many characters were matched.
   *
   * @return the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * <p>In a well-formed scanner (no or only correct usage of {@code yypushback(int)} and a
   * match-all fallback rule) this method will only be called with things that
   * "Can't Possibly Happen".
   *
   * <p>If this method is called, something is seriously wrong (e.g. a JFlex bug producing a faulty
   * scanner etc.).
   *
   * <p>Usual syntax/scanner level error handling should be done in error fallback rules.
   *
   * @param errorCode the code of the error message to display.
   */
  private static void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    } catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * <p>They will be read again by then next call of the scanning method.
   *
   * @param number the number of characters to be read again. This number must not be greater than
   *     {@link #yylength()}.
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }




  /**
   * Resumes scanning until the next regular expression is matched, the end of input is encountered
   * or an I/O-Error occurs.
   *
   * @return the next token.
   * @exception java.io.IOException if any I/O-Error occurs.
   */
  @Override  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char[] zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      yychar+= zzMarkedPosL-zzStartRead;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is
        // (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof)
            zzPeek = false;
          else
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMap(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
          {     return new Symbol(sym.EOF);
 }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1:
            { throw new Error("Illegal character <" + yytext()+">");
            }
            // fall through
          case 54: break;
          case 2:
            { 
            }
            // fall through
          case 55: break;
          case 3:
            { yychar = 0;
            }
            // fall through
          case 56: break;
          case 4:
            { return new Symbol(sym.LPAREN);
            }
            // fall through
          case 57: break;
          case 5:
            { return new Symbol(sym.RPAREN);
            }
            // fall through
          case 58: break;
          case 6:
            { return new Symbol(sym.COMMA);
            }
            // fall through
          case 59: break;
          case 7:
            { return new Symbol(sym.INT, ParseInteger(yytext()));
            }
            // fall through
          case 60: break;
          case 8:
            { return new Symbol(sym.SEMI);
            }
            // fall through
          case 61: break;
          case 9:
            { return new Symbol(sym.AT);
            }
            // fall through
          case 62: break;
          case 10:
            { return new Symbol(sym.VAR, yytext());
            }
            // fall through
          case 63: break;
          case 11:
            { return new Symbol(sym.LBRACKET);
            }
            // fall through
          case 64: break;
          case 12:
            { return new Symbol(sym.RBRACKET);
            }
            // fall through
          case 65: break;
          case 13:
            { return new Symbol(sym.LBRACE);
            }
            // fall through
          case 66: break;
          case 14:
            { return new Symbol(sym.RBRACE);
            }
            // fall through
          case 67: break;
          case 15:
            { return new Symbol(sym.NIL);
            }
            // fall through
          case 68: break;
          case 16:
            { return new Symbol(sym.FALSE);
            }
            // fall through
          case 69: break;
          case 17:
            { return new Symbol(sym.TRUE);
            }
            // fall through
          case 70: break;
          case 18:
            { return new Symbol(sym.RB_COLON);
            }
            // fall through
          case 71: break;
          case 19:
            { return new Symbol(sym.LB_COLON);
            }
            // fall through
          case 72: break;
          case 20:
            { return new Symbol(sym.OR);
            }
            // fall through
          case 73: break;
          case 21:
            { return new Symbol(sym.MOD);
            }
            // fall through
          case 74: break;
          case 22:
            { return new Symbol(sym.BIT_AND);
            }
            // fall through
          case 75: break;
          case 23:
            { return new Symbol(sym.MUL);
            }
            // fall through
          case 76: break;
          case 24:
            { return new Symbol(sym.PLUS);
            }
            // fall through
          case 77: break;
          case 25:
            { return new Symbol(sym.MINUS);
            }
            // fall through
          case 78: break;
          case 26:
            { return new Symbol(sym.DIV);
            }
            // fall through
          case 79: break;
          case 27:
            { return new Symbol(sym.LT);
            }
            // fall through
          case 80: break;
          case 28:
            { return new Symbol(sym.EQUAL);
            }
            // fall through
          case 81: break;
          case 29:
            { return new Symbol(sym.GT);
            }
            // fall through
          case 82: break;
          case 30:
            { return new Symbol(sym.BIT_OR);
            }
            // fall through
          case 83: break;
          case 31:
            { return new Symbol(sym.BIT_NOT);
            }
            // fall through
          case 84: break;
          case 32:
            { return new Symbol(sym.INT, ParseBinaryToInteger(yytext()));
            }
            // fall through
          case 85: break;
          case 33:
            { return new Symbol(sym.CHAR, ParseChar(yytext()));
            }
            // fall through
          case 86: break;
          case 34:
            { return new Symbol(sym.INT, ParseHexToInteger(yytext()));
            }
            // fall through
          case 87: break;
          case 35:
            { return new Symbol(sym.AND);
            }
            // fall through
          case 88: break;
          case 36:
            { return new Symbol(sym.CAR);
            }
            // fall through
          case 89: break;
          case 37:
            { return new Symbol(sym.CDR);
            }
            // fall through
          case 90: break;
          case 38:
            { return new Symbol(sym.DEF);
            }
            // fall through
          case 91: break;
          case 39:
            { return new Symbol(sym.NOT);
            }
            // fall through
          case 92: break;
          case 40:
            { return new Symbol(sym.NE);
            }
            // fall through
          case 93: break;
          case 41:
            { return new Symbol(sym.ASSIGN);
            }
            // fall through
          case 94: break;
          case 42:
            { return new Symbol(sym.LE);
            }
            // fall through
          case 95: break;
          case 43:
            { return new Symbol(sym.GE);
            }
            // fall through
          case 96: break;
          case 44:
            { return new Symbol(sym.EQV);
            }
            // fall through
          case 97: break;
          case 45:
            { return new Symbol(sym.LIST);
            }
            // fall through
          case 98: break;
          case 46:
            { return new Symbol(sym.PAIR);
            }
            // fall through
          case 99: break;
          case 47:
            { return new Symbol(sym.PROC);
            }
            // fall through
          case 100: break;
          case 48:
            { return new Symbol(sym.SIZE);
            }
            // fall through
          case 101: break;
          case 49:
            { return new Symbol(sym.IS_PAIR);
            }
            // fall through
          case 102: break;
          case 50:
            { return new Symbol(sym.PRINT);
            }
            // fall through
          case 103: break;
          case 51:
            { return new Symbol(sym.EQL);
            }
            // fall through
          case 104: break;
          case 52:
            { return new Symbol(sym.SUBSTR);
            }
            // fall through
          case 105: break;
          case 53:
            { return new Symbol(sym.PRINTLN);
            }
            // fall through
          case 106: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
