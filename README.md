# NewLang Compiler Project
## Overview
This project was developed as part of the Compiler course during the **Master's Degree in Computer Science**, specifically the **Software Engineering & IT Management curriculum**, taught by [Professor Costagliola](https://docenti.unisa.it/001602/home) at the [University of Salerno](https://www.di.unisa.it/). The NewLang Compiler is a collaborative effort between myself, [Dario Mazza](https://github.com/xDaryamo), and my colleague, [Nicolò Delogu](https://github.com/XJustUnluckyX/). Our goal, as defined during our course lectures, was to design and implement a compiler for a language (NewLang) we conceived, translating NewLang code into executable C code.

The project progressed through five key exercises:
1. **Hand-coded Lexer:** Introduction to lexical analysis by manually creating a lexer.
2. **Automated Lexer with JFlex:** Utilization of JFlex to automate lexer generation.
3. **Hand-coded Parser:** Development of parsing capabilities through manual parser construction.
4. **Automated Parser with Java Cup:** Employment of Java Cup for automated parser generation.
5. **Final Project:** Integration of lexical, syntactical, and semantic analysis to translate NewLang code into executable C code.

## Grammatical Specifications
The NewLang programming language is defined by the following grammar:

```

Program -> DeclList MainFunDecl DeclList
DeclList -> VarDecl DeclList | FunDecl DeclList | /* empty */
MainFunDecl -> MAIN FunDecl

VarDecl ::= Type IdInitList SEMI
	| VAR IdInitObblList SEMI

Type ::= INTEGER | BOOL | REAL | STRING | CHAR

IdInitList ::= ID 
	| IdInitList COMMA ID
	| ID ASSIGN Expr
	| IdInitList COMMA ID ASSIGN Expr

IdInitObblList ::= ID ASSIGN Const
	| IdInitObblList COMMA ID ASSIGN Const

Const ::= INTEGER_CONST | REAL_CONST | TRUE | FALSE | STRING_CONST | CHAR_CONST

FunDecl -> DEF ID LPAR ParamDeclList RPAR COLON TypeOrVoid Body 

Body -> LBRACK VarDeclList StatList RBRACK

ParamDeclList ::= /*empty */ 
	| NonEmptyParamDeclList

NonEmptyParamDeclList ::= ParDecl
	| NonEmptyParamDeclList PIPE ParDecl

ParDecl ::= Type IdList
	| OUT Type IdList
	
TypeOrVoid -> Type | VOID

VarDeclList -> /* empty */ 
	| VardDecl VarDeclList
	
StatList ::= Stat 
	 | Stat StatList
	

Stat ::= IfStat 
	| ForStat 
	| ReadStat SEMI
	| WriteStat SEMI
	| AssignStat SEMI
        | WhileStat 
	| FunCall SEMI
	| RETURN Expr SEMI
	| RETURN SEMI
	| /* empty */
	
IfStat ::= IF Expr THEN Body Else

Else ::= /* empty */ 
	| ELSE Body

WhileStat ::= WHILE Expr LOOP Body
	
ForStat ::= FOR ID ASSIGN INTEGER_CONST TO INTEGER_CONST LOOP Body

ReadStat ::= IdList READ STRING_CONST 
	|  IdList READ

IdList ::= ID 
	| IdList COMMA ID

WriteStat ::= LPAR ExprList RPAR WRITE         /* nella versione corretta sono */
	   | LPAR ExprList RPAR WRITELN        /* stati aggiunti LPAR ed RPAR */

	
AssignStat ::=  IdList ASSIGN ExprList

FunCall ::= ID LPAR ExprList RPAR   
	| ID LPAR RPAR 
  
ExprList ::= Expr	
	| Expr COMMA ExprList
	
Expr ::= TRUE                            
	| FALSE                           
	| INTEGER_CONST                    
	| REAL_CONST
	| STRING_CONST
	| CHAR_CONST
	| ID
	| FunCall
	| Expr  PLUS Expr
	| Expr  MINUS Expr
	| Expr  TIMES Expr
	| Expr  DIV Expr
	| Expr  AND Expr
	| Expr POW Expr
	| Expr STR_CONCAT Expr
	| Expr  OR Expr
	| Expr  GT Expr
	| Expr  GE Expr
	| Expr  LT Expr
	| Expr  LE Expr
	| Expr  EQ Expr
	| Expr  NE Expr
	| MINUS Expr
	| NOT Expr
	| LPAR Expr RPAR
```
## Lexical Specifications

This section outlines the specific lexical tokens recognized in NewLang:

| Lexeme    | Token |
|:--------|:---------:|
| start:      |    MAIN     |
| if    |   IF   | 
| then    |   THEN    | 
| else    |   ELSE    | 
| while   |   WHILE   | 
| to   |   TO   |
| do      |    DO     | 
| for     |    FOR    | 
| integer     |    INTEGER    | 
| float   |   FLOAT   | 
| var   |   VAR   | 
| double  |  DOUBLE   | 
| boolean |  BOOL  | 
| true |  TRUE  | 
| false |  FALSE  | 
| char |  CHAR  | 
| out |  OUT  | 
| def |  DEF  | 
| void    |   VOID    | 
| switch  |  SWITCH   | 
| case    |   CASE    | 
| default |  DEFAULT  | 
| return  |  RETURN   | 
| import  |  IMPORT   | 
| end     |    END    | 
| loop    |   LOOP    | 
| <--    |   READ    | 
| -->    |   WRITE    | 
| -->!    |   WRITELN    | 


## Symbols Table
| Lexeme |  Token   |
|:--------|:--------:|
| <       |    LT    |
| =       |    EQ    | 
| \>      |    GT    | 
| <=      |    LE    | 
| <>      |    NE    | 
| !=      |    NE    | 
| <<     |  ASSIGN  | 
| \>=     |    GE    |
| -       | SUBTRACT |
| +       |   ADD    |
| ^       |   POW    |
| /       |   DIV    |
| *       |   TIMES    |
| and       |   AND   |
| or       |   OR   |
| not       |   NOT   |
| &       |   STR_CONCAT |

## Separators

| Lexeme |  Token   |
|:--------|:--------:|
| (       |   LPAR   |
| )       |   RPAR   | 
| {       |  LBRACK  | 
| }       |  RBRACK  | 
| ,       |  COMMA   | 
| ;       |   SEMI   |
| :      |    COLON     |
| &#124;  |   PIPE   |



## Running the Compiler

To compile NewLang source files into executable C code, GCC must be installed on your machine. Execute the compiler by running the provided script with the path to the `.nl` source file and the desired output path for the C file.

**Windows Example:**

```bash
.\NewLang2C.bat .\tests\exampleNL.nl .\tests\exampleOutput
```
The project includes execution compatibility for both Windows and macOS, with automatic compilation and execution in the console if GCC is installed.
Testing The compiler has been extensively tested with a variety of NewLang source files, ensuring robust handling of valid and invalid inputs.
