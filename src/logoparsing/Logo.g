grammar Logo;
options {
  output = AST;
}
tokens {
  PROGRAMME;
  AV = 'AV' ;
  TD = 'TD' ;
  TG = 'TG' ;
  REC = 'REC';
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
  | REC^ ) 
  INT
;
