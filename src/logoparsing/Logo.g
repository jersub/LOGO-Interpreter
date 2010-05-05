grammar Logo;
options {
  output = AST;
}
tokens {
  PROGRAMME;
  AV = 'AV';
  TD = 'TD';
  TG = 'TG';
  REC = 'REC';
  FPOS = 'FPOS';
  FCAP = 'FCAP';
  FCC = 'FCC';
  LC = 'LC' ;
  BC = 'BC' ;
  VE = 'VE';
  OP_PLUS = '+' ;
  OP_MOINS = '-' ;
  OP_MULT = '*' ;
  OP_DIV = '/' ;
}
@lexer::header {
  package logoparsing;
}
@header {
  package logoparsing;
}
@members{
  boolean valide = true;
  public boolean getValide(){
   return valide;
 }
}
INT : ('0'..'9')+ ;	 
WS  :   (' '|'\t'|('\r'? '\n'))+ { skip(); } ;

programme : liste_instructions -> ^(PROGRAMME liste_instructions)
;
liste_instructions :
  (instruction)+ 
;
instruction :
  ( AV^  
  | TD^
  | TG^
  | REC^
  | FCAP^ )
  expr
  | FPOS^ '['! expr expr ']'!
  | FCC^ INT
  | LC^
  | BC^
  | VE^
;
expr :
  sumExpr ;
sumExpr:
  multExpr ((OP_PLUS^|OP_MOINS^) multExpr)*
;
multExpr :
  atom ((OP_MULT^|OP_DIV^) atom)*
;
atom:
  INT | '('! expr ')'!
;