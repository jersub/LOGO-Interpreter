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
  CMP_EGAL = '=';
  CMP_SUP = '>';
  CMP_INF = '<';
  CMP_SUP_EGAL = '>=';
  CMP_INF_EGAL = '<=';
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
  | 'TEST'^ exprBool
;
expr :
  sumExpr ;
sumExpr:
  multExpr ((OP_PLUS^|OP_MOINS^) multExpr)*
;
multExpr :
  atom ((OP_MULT^|OP_DIV^) atom)*
;
exprBool :
  cmpBool
;
cmpBool	:
  expr (CMP_EGAL^|CMP_SUP^|CMP_INF^|CMP_SUP_EGAL^|CMP_INF_EGAL^) expr
;
atom:
  INT | '('! expr ')'!
;
