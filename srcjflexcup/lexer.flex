/* JFlex example: partial Java language lexer specification */
package esercitazione5;
import java_cup.runtime.*;
import java.util.List;
import java.util.ArrayList;
%%
%class Lexer
%unicode
%public
%cupdebug
%cupsym Sym
%cup
%line
%column

%{
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



%}

LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
WhiteSpace     = {LineTerminator} | [ \t\r\n]

/* comments */
Comment = {TraditionalComment} | {EndOfLineComment}

TraditionalComment = "|*" ~"|"
// Comment can be the last line of the file, without line terminator.
EndOfLineComment = "||" {InputCharacter}* {LineTerminator}?
CommentContent  = ( [^*] | \*+ [^/*] )*

ID = [$_A-Za-z][$_A-Za-z0-9]*
IntegerC = 0 | [1-9][0-9]*
RealC = [0-9].([0-9])+

EscChar = '\\[ntbrf\\\'\"]' | ''
CharC = '[^\\[ntbrf\\\'\"]]' | {EscChar}

%state STRING

%%

<YYINITIAL> {
  /* keywords */

      "start:"                   { return symbol(Sym.MAIN, "MAIN");}
      ";"                        { return symbol(Sym.SEMI, "SEMI");}
      ","                        { return symbol(Sym.COMMA, "COMMA");}
      "|"                        { return symbol(Sym.PIPE, "PIPE");}
      "var"                      { return symbol(Sym.VAR, "VAR");}
      "integer"                  { return symbol(Sym.INTEGER, "INTEGER");}
      "float"                    { return symbol(Sym.REAL, "FLOAT");}
      "string"                   { return symbol(Sym.STRING, "STRING");}
      "boolean"                  { return symbol(Sym.BOOLEAN, "BOOLEAN");}
      "char"                     { return symbol(Sym.CHAR, "CHAR");}
      "void"                     { return symbol(Sym.VOID, "VOID");}

      "def"                      { return symbol(Sym.DEF, "DEF");}
      "out"                      { return symbol(Sym.OUT, "OUT");}
      "for"                      { return symbol(Sym.FOR, "FOR");}
      "if"                       { return symbol(Sym.IF, "IF");}
      "then"                     { return symbol(Sym.THEN, "THEN");}
      "else"                     { return symbol(Sym.ELSE, "ELSE");}
      "while"                    { return symbol(Sym.WHILE, "WHILE");}
      "to"                       { return symbol(Sym.TO, "TO");}
      "loop"                     { return symbol(Sym.LOOP, "LOOP");}
      "<--"                      { return symbol(Sym.READ, "READ");}
      "-->"                      { return symbol(Sym.WRITE, "WRITE");}
      "-->!"                     { return symbol(Sym.WRITELN, "WRITELN");}

      "("                        { return symbol(Sym.LPAR, "LPAR");}
      ")"                        { return symbol(Sym.RPAR, "RPAR");}
      "{"                        { return symbol(Sym.LBRACK, "LBRACK");}
      "}"                        { return symbol(Sym.RBRACK, "RBRACK");}
      ":"                        { return symbol(Sym.COLON, "COLON");}
      "<<"                       { return symbol(Sym.ASSIGN, "ASSIGN");}
      "%%"                       { return symbol(Sym.ASSIGNONE, "ASSIGNONE");}
      "return"                   { return symbol(Sym.RETURN, "RETURN");}


      "true"                     { return symbol(Sym.TRUE, "TRUE");}
      "false"                    { return symbol(Sym.FALSE, "FALSE");}
      "+"                        { return symbol(Sym.PLUS, "PLUS");}
      "-"                        { return symbol(Sym.MINUS, "MINUS");}
      "*"                        { return symbol(Sym.TIMES, "TIMES");}
      "/"                        { return symbol(Sym.DIV, "DIV");}
      "^"                        { return symbol(Sym.POW, "POW");}
      "&"                        { return symbol(Sym.STR_CONCAT, "STR_CONCAT");}
      "="                        { return symbol(Sym.EQ, "EQ");}
      "<>"                       { return symbol(Sym.NE, "NE");}
      "!="                       { return symbol(Sym.NE, "NE");}
      "<"                        { return symbol(Sym.LT, "LT");}
      "<="                       { return symbol(Sym.LE, "LE");}
      ">"                        { return symbol(Sym.GT, "GT");}
      ">="                       { return symbol(Sym.GE, "GE");}
      "and"                      { return symbol(Sym.AND, "AND");}
      "or"                       { return symbol(Sym.OR, "OR");}
      "not"                      { return symbol(Sym.NOT, "NOT");}


      {ID}                       { return installID(yytext()); }
      {IntegerC}                 { return symbol(Sym.INTEGER_CONST, Integer.parseInt(yytext())); }
      {RealC}                    { return symbol(Sym.REAL_CONST, Float.parseFloat(yytext())); }
      {CharC}                    {
                                   if(yytext().length()==2) return symbol(Sym.CHAR_CONST, '\0');
                                   if(yytext().length()==3) return symbol(Sym.CHAR_CONST, yytext().charAt(1));
                                   return symbol(Sym.CHAR_CONST, yytext().charAt(2));
                                 }

      \"                         { string.setLength(0); yybegin(STRING); }

      /* comments */
      {Comment}                      { /* ignore */ }
      /* whitespace */
      {WhiteSpace}                   { /* ignore */ }
}

<STRING> {
  \"                             { yybegin(YYINITIAL);
                                     return symbol(Sym.STRING_CONST,
                                     string.toString()); }
  [^\n\r\"\\]+                   { string.append( yytext() ); }
  \\t                            { string.append('\t'); }
  \\n                            { string.append('\n'); }

  \\r                            { string.append('\r'); }
  \\\"                           { string.append('\"'); }
  \\                             { string.append('\\'); }
  <<EOF>>                        {throw new IllegalArgumentException("unclosed string literal");}
}

/* error fallback */
[^]                              { throw new Error("Illegal character <"+
                                                    yytext()+">"); }