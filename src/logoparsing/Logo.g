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
ADD : ('+' | '-');	 
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
  | FCAP^
  | FCC^ )
  expression
  | FPOS^ expression expression
  | LC^
  | BC^
  | VE^
;
expression :
  INT ^'+' INT
;
exp1 :
  INT
;

