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
  PLUS = '+' ;
  MOINS = '-' ;
  MULT = '*' ;
  DIV = '/' ;
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
  | FPOS^ expr expr
  | FCC^ INT
  | LC^
  | BC^
  | VE^
;
expr :
  sumExpr ;
sumExpr:
  multExpr ((PLUS^|MOINS^) multExpr)*
;
multExpr :
  atom ((MULT^|DIV^) atom)*
;
atom:
  INT | '('! expr ')'!
;