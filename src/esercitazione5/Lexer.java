// DO NOT EDIT
// Generated by JFlex 1.8.2 http://jflex.de/
// source: srcjflexcup/lexer.flex

/* JFlex example: partial Java language lexer specification */
package esercitazione5;
import java_cup.runtime.*;
import java.util.List;
import java.util.ArrayList;

// See https://github.com/jflex-de/jflex/issues/222
@SuppressWarnings("FallThrough")
public class Lexer implements java_cup.runtime.Scanner {

  /** This character denotes the end of file. */
  public static final int YYEOF = -1;

  /** Initial size of the lookahead buffer. */
  private static final int ZZ_BUFFERSIZE = 16384;

  // Lexical states.
  public static final int YYINITIAL = 0;
  public static final int STRING = 2;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = {
     0,  0,  1, 1
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
    "\11\0\1\1\1\2\2\3\1\4\22\0\1\1\1\5"+
    "\1\6\1\0\1\7\1\0\1\10\1\11\1\12\1\13"+
    "\1\14\1\15\1\16\1\17\1\0\1\20\1\21\11\22"+
    "\1\23\1\24\1\25\1\26\1\27\2\0\32\7\1\0"+
    "\1\30\1\0\1\31\1\7\1\0\1\32\1\33\1\34"+
    "\1\35\1\36\1\37\1\40\1\41\1\42\2\7\1\43"+
    "\1\7\1\44\1\45\1\46\1\7\1\47\1\50\1\51"+
    "\1\52\1\53\1\54\3\7\1\55\1\56\1\57\7\0"+
    "\1\3\u01a2\0\2\3\326\0\u0100\3";

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
    "\2\0\1\1\2\2\1\1\1\3\1\4\1\5\1\1"+
    "\1\6\1\7\1\10\1\11\1\12\1\13\1\14\2\15"+
    "\1\16\1\17\1\20\1\21\1\22\1\23\17\4\1\24"+
    "\1\25\1\26\1\27\1\30\1\31\1\32\1\0\1\33"+
    "\3\0\1\15\1\0\1\34\1\35\1\36\10\4\1\37"+
    "\3\4\1\40\4\4\1\41\4\4\1\0\1\2\1\42"+
    "\1\43\1\44\1\45\1\46\1\47\1\50\1\51\2\4"+
    "\1\52\3\4\1\53\2\4\1\54\1\55\5\4\1\56"+
    "\2\4\1\57\1\4\1\60\1\61\3\4\1\62\3\4"+
    "\1\63\1\64\1\65\2\4\1\66\1\67\4\4\1\70"+
    "\2\4\1\71\1\72\1\73\1\74\1\75";

  private static int [] zzUnpackAction() {
    int [] result = new int[138];
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
    "\0\0\0\60\0\140\0\140\0\220\0\300\0\140\0\360"+
    "\0\140\0\u0120\0\140\0\140\0\140\0\140\0\140\0\u0150"+
    "\0\140\0\u0180\0\u01b0\0\140\0\140\0\u01e0\0\140\0\u0210"+
    "\0\140\0\u0240\0\u0270\0\u02a0\0\u02d0\0\u0300\0\u0330\0\u0360"+
    "\0\u0390\0\u03c0\0\u03f0\0\u0420\0\u0450\0\u0480\0\u04b0\0\u04e0"+
    "\0\140\0\u0510\0\140\0\u0540\0\140\0\u0570\0\140\0\u05a0"+
    "\0\140\0\u05d0\0\u0600\0\u0630\0\u0660\0\u0690\0\140\0\140"+
    "\0\140\0\u06c0\0\u06f0\0\u0720\0\u0750\0\u0780\0\u07b0\0\u07e0"+
    "\0\u0810\0\360\0\u0840\0\u0870\0\u08a0\0\360\0\u08d0\0\u0900"+
    "\0\u0930\0\u0960\0\360\0\u0990\0\u09c0\0\u09f0\0\u0a20\0\u0a50"+
    "\0\u0a80\0\140\0\140\0\140\0\140\0\u0ab0\0\u0630\0\140"+
    "\0\360\0\u0ae0\0\u0b10\0\360\0\u0b40\0\u0b70\0\u0ba0\0\360"+
    "\0\u0bd0\0\u0c00\0\360\0\360\0\u0c30\0\u0c60\0\u0c90\0\u0cc0"+
    "\0\u0cf0\0\360\0\u0d20\0\u0d50\0\140\0\u0d80\0\360\0\360"+
    "\0\u0db0\0\u0de0\0\u0e10\0\360\0\u0e40\0\u0e70\0\u0ea0\0\360"+
    "\0\360\0\360\0\u0ed0\0\u0f00\0\360\0\360\0\u0f30\0\u0f60"+
    "\0\u0f90\0\u0fc0\0\360\0\u0ff0\0\u1020\0\360\0\140\0\360"+
    "\0\360\0\360";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[138];
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
    "\1\3\2\4\1\3\1\5\1\6\1\7\1\10\1\11"+
    "\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21"+
    "\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\3"+
    "\1\31\1\32\1\33\1\34\1\35\1\36\1\37\2\10"+
    "\1\40\1\41\1\42\1\43\1\10\1\44\1\45\1\46"+
    "\1\10\1\47\1\50\1\51\1\52\1\53\2\54\1\3"+
    "\1\54\1\3\1\54\1\55\21\54\1\56\27\54\62\0"+
    "\1\4\103\0\1\57\40\0\1\10\11\0\2\10\7\0"+
    "\23\10\3\0\6\60\1\0\2\60\1\61\16\60\1\62"+
    "\2\60\1\0\3\60\1\0\4\60\1\0\2\60\1\0"+
    "\1\60\1\0\6\60\17\0\1\63\40\0\2\64\3\0"+
    "\55\64\3\0\14\64\2\65\35\64\17\0\1\66\5\0"+
    "\1\67\1\70\1\57\56\0\1\71\40\0\1\10\11\0"+
    "\2\10\7\0\12\10\1\72\10\10\12\0\1\10\11\0"+
    "\2\10\7\0\13\10\1\73\7\10\12\0\1\10\11\0"+
    "\2\10\7\0\7\10\1\74\13\10\12\0\1\10\11\0"+
    "\2\10\7\0\4\10\1\75\16\10\12\0\1\10\11\0"+
    "\2\10\7\0\11\10\1\76\11\10\12\0\1\10\11\0"+
    "\2\10\7\0\1\77\10\10\1\100\1\10\1\101\7\10"+
    "\12\0\1\10\11\0\2\10\7\0\5\10\1\102\4\10"+
    "\1\103\10\10\12\0\1\10\11\0\2\10\7\0\13\10"+
    "\1\104\7\10\12\0\1\10\11\0\2\10\7\0\13\10"+
    "\1\105\7\10\12\0\1\10\11\0\2\10\7\0\15\10"+
    "\1\106\2\10\1\107\2\10\12\0\1\10\11\0\2\10"+
    "\7\0\4\10\1\110\16\10\12\0\1\10\11\0\2\10"+
    "\7\0\17\10\1\111\3\10\12\0\1\10\11\0\2\10"+
    "\7\0\7\10\1\112\3\10\1\113\1\10\1\114\5\10"+
    "\12\0\1\10\11\0\2\10\7\0\1\115\12\10\1\116"+
    "\7\10\12\0\1\10\11\0\2\10\7\0\7\10\1\117"+
    "\13\10\17\0\1\120\41\0\1\121\1\0\2\54\1\0"+
    "\1\54\1\0\1\54\1\0\21\54\1\0\27\54\6\0"+
    "\1\122\35\0\1\123\2\0\1\124\1\0\1\125\17\0"+
    "\1\61\54\0\1\60\2\0\1\60\16\0\1\60\2\0"+
    "\1\60\3\0\1\60\4\0\1\60\2\0\1\60\1\0"+
    "\1\60\35\0\1\126\51\0\2\127\56\0\2\65\54\0"+
    "\1\130\47\0\1\10\11\0\2\10\7\0\3\10\1\131"+
    "\17\10\12\0\1\10\11\0\2\10\7\0\13\10\1\132"+
    "\7\10\12\0\1\10\11\0\2\10\7\0\1\133\22\10"+
    "\12\0\1\10\11\0\2\10\7\0\5\10\1\134\15\10"+
    "\12\0\1\10\11\0\2\10\7\0\16\10\1\135\4\10"+
    "\12\0\1\10\11\0\2\10\7\0\11\10\1\136\11\10"+
    "\12\0\1\10\11\0\2\10\7\0\13\10\1\137\7\10"+
    "\12\0\1\10\11\0\2\10\7\0\15\10\1\140\5\10"+
    "\12\0\1\10\11\0\2\10\7\0\17\10\1\141\3\10"+
    "\12\0\1\10\11\0\2\10\7\0\13\10\1\142\7\10"+
    "\12\0\1\10\11\0\2\10\7\0\17\10\1\143\3\10"+
    "\12\0\1\10\11\0\2\10\7\0\17\10\1\144\3\10"+
    "\12\0\1\10\11\0\2\10\7\0\17\10\1\145\3\10"+
    "\12\0\1\10\11\0\2\10\7\0\1\146\14\10\1\147"+
    "\5\10\12\0\1\10\11\0\2\10\7\0\4\10\1\150"+
    "\16\10\12\0\1\10\11\0\2\10\7\0\20\10\1\151"+
    "\2\10\12\0\1\10\11\0\2\10\7\0\15\10\1\152"+
    "\5\10\12\0\1\10\11\0\2\10\7\0\10\10\1\153"+
    "\12\10\12\0\1\10\11\0\2\10\7\0\10\10\1\154"+
    "\12\10\3\0\56\120\1\4\1\120\2\121\1\4\1\121"+
    "\1\5\53\121\5\0\1\155\61\0\1\10\11\0\2\10"+
    "\7\0\11\10\1\156\11\10\12\0\1\10\11\0\2\10"+
    "\7\0\15\10\1\157\5\10\12\0\1\10\11\0\2\10"+
    "\7\0\4\10\1\160\16\10\12\0\1\10\11\0\2\10"+
    "\7\0\16\10\1\161\4\10\12\0\1\10\11\0\2\10"+
    "\7\0\1\162\22\10\12\0\1\10\11\0\2\10\7\0"+
    "\4\10\1\163\16\10\12\0\1\10\11\0\2\10\7\0"+
    "\14\10\1\164\6\10\12\0\1\10\11\0\2\10\7\0"+
    "\20\10\1\165\2\10\12\0\1\10\11\0\2\10\7\0"+
    "\15\10\1\166\5\10\12\0\1\10\11\0\2\10\7\0"+
    "\10\10\1\167\12\10\12\0\1\10\11\0\2\10\7\0"+
    "\12\10\1\170\10\10\12\0\1\10\11\0\2\10\7\0"+
    "\4\10\1\171\16\10\12\0\1\10\11\0\2\10\7\0"+
    "\3\10\1\172\17\10\12\0\1\10\11\0\2\10\7\0"+
    "\11\10\1\173\11\10\12\0\1\10\11\0\2\10\7\0"+
    "\4\10\1\174\16\10\12\0\1\10\11\0\2\10\7\0"+
    "\4\10\1\175\16\10\12\0\1\10\11\0\2\10\7\0"+
    "\17\10\1\176\3\10\12\0\1\10\11\0\2\10\7\0"+
    "\6\10\1\177\14\10\12\0\1\10\11\0\2\10\7\0"+
    "\15\10\1\200\5\10\12\0\1\10\11\0\2\10\7\0"+
    "\17\10\1\201\3\10\12\0\1\10\11\0\2\10\7\0"+
    "\12\10\1\202\10\10\12\0\1\10\11\0\2\10\7\0"+
    "\4\10\1\203\16\10\12\0\1\10\11\0\2\10\7\0"+
    "\1\204\22\10\12\0\1\10\11\0\2\10\7\0\4\10"+
    "\1\205\16\10\12\0\1\10\11\0\2\10\7\0\12\10"+
    "\1\206\10\10\12\0\1\10\11\0\2\10\1\207\6\0"+
    "\23\10\12\0\1\10\11\0\2\10\7\0\6\10\1\210"+
    "\14\10\12\0\1\10\11\0\2\10\7\0\12\10\1\211"+
    "\10\10\12\0\1\10\11\0\2\10\7\0\15\10\1\212"+
    "\5\10\3\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[4176];
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
    "\2\0\2\11\2\1\1\11\1\1\1\11\1\1\5\11"+
    "\1\1\1\11\2\1\2\11\1\1\1\11\1\1\1\11"+
    "\17\1\1\11\1\1\1\11\1\1\1\11\1\1\1\11"+
    "\1\0\1\11\3\0\1\1\1\0\3\11\26\1\1\0"+
    "\1\1\4\11\2\1\1\11\24\1\1\11\31\1\1\11"+
    "\3\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[138];
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
  @SuppressWarnings("unused")
  private long yychar;

  /** Whether the scanner is currently at the beginning of a line. */
  @SuppressWarnings("unused")
  private boolean zzAtBOL = true;

  /** Whether the user-EOF-code has already been executed. */
  private boolean zzEOFDone;

  /* user code: */
  StringBuffer string = new StringBuffer();
  public List<String> identifiersTable = new ArrayList<>();


  private Symbol symbol(int type) {
    return new Symbol(type, yyline, yycolumn);
  }
  private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline, yycolumn, value);
  }

  private Symbol installID(String identifier) {
    if(!identifiersTable.contains(identifier))
        identifiersTable.add(identifier);
    return symbol(Sym.ID, ((Integer)identifiersTable.indexOf(identifier)));
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
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
    
  yyclose();    }
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
            zzDoEOF();
            switch (zzLexicalState) {
            case STRING: {
              throw new IllegalArgumentException("unclosed string literal");
            }  // fall though
            case 139: break;
            default:
          { return new java_cup.runtime.Symbol(Sym.EOF); }
        }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1:
            { throw new Error("Illegal character <"+
                                                    yytext()+">");
            }
            // fall through
          case 62: break;
          case 2:
            { /* ignore */
            }
            // fall through
          case 63: break;
          case 3:
            { string.setLength(0); yybegin(STRING);
            }
            // fall through
          case 64: break;
          case 4:
            { return installID(yytext());
            }
            // fall through
          case 65: break;
          case 5:
            { return symbol(Sym.STR_CONCAT, "STR_CONCAT");
            }
            // fall through
          case 66: break;
          case 6:
            { return symbol(Sym.LPAR, "LPAR");
            }
            // fall through
          case 67: break;
          case 7:
            { return symbol(Sym.RPAR, "RPAR");
            }
            // fall through
          case 68: break;
          case 8:
            { return symbol(Sym.TIMES, "TIMES");
            }
            // fall through
          case 69: break;
          case 9:
            { return symbol(Sym.PLUS, "PLUS");
            }
            // fall through
          case 70: break;
          case 10:
            { return symbol(Sym.COMMA, "COMMA");
            }
            // fall through
          case 71: break;
          case 11:
            { return symbol(Sym.MINUS, "MINUS");
            }
            // fall through
          case 72: break;
          case 12:
            { return symbol(Sym.DIV, "DIV");
            }
            // fall through
          case 73: break;
          case 13:
            { return symbol(Sym.INTEGER_CONST, Integer.parseInt(yytext()));
            }
            // fall through
          case 74: break;
          case 14:
            { return symbol(Sym.COLON, "COLON");
            }
            // fall through
          case 75: break;
          case 15:
            { return symbol(Sym.SEMI, "SEMI");
            }
            // fall through
          case 76: break;
          case 16:
            { return symbol(Sym.LT, "LT");
            }
            // fall through
          case 77: break;
          case 17:
            { return symbol(Sym.EQ, "EQ");
            }
            // fall through
          case 78: break;
          case 18:
            { return symbol(Sym.GT, "GT");
            }
            // fall through
          case 79: break;
          case 19:
            { return symbol(Sym.POW, "POW");
            }
            // fall through
          case 80: break;
          case 20:
            { return symbol(Sym.LBRACK, "LBRACK");
            }
            // fall through
          case 81: break;
          case 21:
            { return symbol(Sym.PIPE, "PIPE");
            }
            // fall through
          case 82: break;
          case 22:
            { return symbol(Sym.RBRACK, "RBRACK");
            }
            // fall through
          case 83: break;
          case 23:
            { string.append( yytext() );
            }
            // fall through
          case 84: break;
          case 24:
            { yybegin(YYINITIAL);
                                     return symbol(Sym.STRING_CONST,
                                     string.toString());
            }
            // fall through
          case 85: break;
          case 25:
            { string.append('\\');
            }
            // fall through
          case 86: break;
          case 26:
            { return symbol(Sym.NE, "NE");
            }
            // fall through
          case 87: break;
          case 27:
            { if(yytext().length()==2) return symbol(Sym.CHAR_CONST, '\0');
                                   if(yytext().length()==3) return symbol(Sym.CHAR_CONST, yytext().charAt(1));
                                   return symbol(Sym.CHAR_CONST, yytext().charAt(2));
            }
            // fall through
          case 88: break;
          case 28:
            { return symbol(Sym.ASSIGN, "ASSIGN");
            }
            // fall through
          case 89: break;
          case 29:
            { return symbol(Sym.LE, "LE");
            }
            // fall through
          case 90: break;
          case 30:
            { return symbol(Sym.GE, "GE");
            }
            // fall through
          case 91: break;
          case 31:
            { return symbol(Sym.IF, "IF");
            }
            // fall through
          case 92: break;
          case 32:
            { return symbol(Sym.OR, "OR");
            }
            // fall through
          case 93: break;
          case 33:
            { return symbol(Sym.TO, "TO");
            }
            // fall through
          case 94: break;
          case 34:
            { string.append('\"');
            }
            // fall through
          case 95: break;
          case 35:
            { string.append('\n');
            }
            // fall through
          case 96: break;
          case 36:
            { string.append('\r');
            }
            // fall through
          case 97: break;
          case 37:
            { string.append('\t');
            }
            // fall through
          case 98: break;
          case 38:
            { return symbol(Sym.WRITE, "WRITE");
            }
            // fall through
          case 99: break;
          case 39:
            { return symbol(Sym.REAL_CONST, Float.parseFloat(yytext()));
            }
            // fall through
          case 100: break;
          case 40:
            { return symbol(Sym.READ, "READ");
            }
            // fall through
          case 101: break;
          case 41:
            { return symbol(Sym.AND, "AND");
            }
            // fall through
          case 102: break;
          case 42:
            { return symbol(Sym.DEF, "DEF");
            }
            // fall through
          case 103: break;
          case 43:
            { return symbol(Sym.FOR, "FOR");
            }
            // fall through
          case 104: break;
          case 44:
            { return symbol(Sym.NOT, "NOT");
            }
            // fall through
          case 105: break;
          case 45:
            { return symbol(Sym.OUT, "OUT");
            }
            // fall through
          case 106: break;
          case 46:
            { return symbol(Sym.VAR, "VAR");
            }
            // fall through
          case 107: break;
          case 47:
            { return symbol(Sym.WRITELN, "WRITELN");
            }
            // fall through
          case 108: break;
          case 48:
            { return symbol(Sym.CHAR, "CHAR");
            }
            // fall through
          case 109: break;
          case 49:
            { return symbol(Sym.ELSE, "ELSE");
            }
            // fall through
          case 110: break;
          case 50:
            { return symbol(Sym.LOOP, "LOOP");
            }
            // fall through
          case 111: break;
          case 51:
            { return symbol(Sym.THEN, "THEN");
            }
            // fall through
          case 112: break;
          case 52:
            { return symbol(Sym.TRUE, "TRUE");
            }
            // fall through
          case 113: break;
          case 53:
            { return symbol(Sym.VOID, "VOID");
            }
            // fall through
          case 114: break;
          case 54:
            { return symbol(Sym.FALSE, "FALSE");
            }
            // fall through
          case 115: break;
          case 55:
            { return symbol(Sym.REAL, "FLOAT");
            }
            // fall through
          case 116: break;
          case 56:
            { return symbol(Sym.WHILE, "WHILE");
            }
            // fall through
          case 117: break;
          case 57:
            { return symbol(Sym.RETURN, "RETURN");
            }
            // fall through
          case 118: break;
          case 58:
            { return symbol(Sym.MAIN, "MAIN");
            }
            // fall through
          case 119: break;
          case 59:
            { return symbol(Sym.STRING, "STRING");
            }
            // fall through
          case 120: break;
          case 60:
            { return symbol(Sym.BOOLEAN, "BOOLEAN");
            }
            // fall through
          case 121: break;
          case 61:
            { return symbol(Sym.INTEGER, "INTEGER");
            }
            // fall through
          case 122: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }

  /**
   * Converts an int token code into the name of the
   * token by reflection on the cup symbol class/interface Sym
   */
  private static String getTokenName(int token) {
    try {
      java.lang.reflect.Field [] classFields = Sym.class.getFields();
      for (int i = 0; i < classFields.length; i++) {
        if (classFields[i].getInt(null) == token) {
          return classFields[i].getName();
        }
      }
    } catch (Exception e) {
      e.printStackTrace(System.err);
    }

    return "UNKNOWN TOKEN";
  }

  /**
   * Same as next_token but also prints the token to standard out
   * for debugging.
   */
  public java_cup.runtime.Symbol debug_next_token() throws java.io.IOException {
    java_cup.runtime.Symbol s = next_token();
    System.out.println( "line:" + (yyline+1) + " col:" + (yycolumn+1) + " --"+ yytext() + "--" + getTokenName(s.sym) + "--");
    return s;
  }

  /**
   * Runs the scanner on input files.
   *
   * This main method is the debugging routine for the scanner.
   * It prints debugging information about each returned token to
   * System.out until the end of file is reached, or an error occured.
   *
   * @param argv   the command line, contains the filenames to run
   *               the scanner on.
   */
  public static void main(String[] argv) {
    if (argv.length == 0) {
      System.out.println("Usage : java Lexer [ --encoding <name> ] <inputfile(s)>");
    }
    else {
      int firstFilePos = 0;
      String encodingName = "UTF-8";
      if (argv[0].equals("--encoding")) {
        firstFilePos = 2;
        encodingName = argv[1];
        try {
          // Side-effect: is encodingName valid?
          java.nio.charset.Charset.forName(encodingName);
        } catch (Exception e) {
          System.out.println("Invalid encoding '" + encodingName + "'");
          return;
        }
      }
      for (int i = firstFilePos; i < argv.length; i++) {
        Lexer scanner = null;
        try {
          java.io.FileInputStream stream = new java.io.FileInputStream(argv[i]);
          java.io.Reader reader = new java.io.InputStreamReader(stream, encodingName);
          scanner = new Lexer(reader);
          while ( !scanner.zzAtEOF ) scanner.debug_next_token();
        }
        catch (java.io.FileNotFoundException e) {
          System.out.println("File not found : \""+argv[i]+"\"");
        }
        catch (java.io.IOException e) {
          System.out.println("IO error scanning file \""+argv[i]+"\"");
          System.out.println(e);
        }
        catch (Exception e) {
          System.out.println("Unexpected exception:");
          e.printStackTrace();
        }
      }
    }
  }


}
