// $ANTLR 3.2 Sep 23, 2009 12:02:23 Z:\\workspace\\projet\\src\\logoparsing\\LogoTree.g 2010-04-01 18:30:18

  package logoparsing;
  import logogui.Traceur;
  import logogui.Log;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class LogoTree extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "PROGRAMME", "AV", "TD", "TG", "REC", "INT", "WS"
    };
    public static final int TG=7;
    public static final int TD=6;
    public static final int WS=10;
    public static final int AV=5;
    public static final int PROGRAMME=4;
    public static final int INT=9;
    public static final int EOF=-1;
    public static final int REC=8;

    // delegates
    // delegators


        public LogoTree(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public LogoTree(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return LogoTree.tokenNames; }
    public String getGrammarFileName() { return "Z:\\workspace\\projet\\src\\logoparsing\\LogoTree.g"; }


      Traceur traceur;
      public void initialize(java.awt.Graphics g) {
        traceur = Traceur.getInstance();
        traceur.setGraphics(g);
      }
      public void push(int index) {
         ((CommonTreeNodeStream)input).push(index);
      }
      public void pop() {
         ((CommonTreeNodeStream)input).pop();
      }



    // $ANTLR start "prog"
    // Z:\\workspace\\projet\\src\\logoparsing\\LogoTree.g:24:2: prog : ^( PROGRAMME ( instruction )* ) ;
    public final void prog() throws RecognitionException {
        try {
            // Z:\\workspace\\projet\\src\\logoparsing\\LogoTree.g:24:7: ( ^( PROGRAMME ( instruction )* ) )
            // Z:\\workspace\\projet\\src\\logoparsing\\LogoTree.g:24:9: ^( PROGRAMME ( instruction )* )
            {
            match(input,PROGRAMME,FOLLOW_PROGRAMME_in_prog42); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // Z:\\workspace\\projet\\src\\logoparsing\\LogoTree.g:24:21: ( instruction )*
                loop1:
                do {
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( ((LA1_0>=AV && LA1_0<=REC)) ) {
                        alt1=1;
                    }


                    switch (alt1) {
                	case 1 :
                	    // Z:\\workspace\\projet\\src\\logoparsing\\LogoTree.g:24:22: instruction
                	    {
                	    pushFollow(FOLLOW_instruction_in_prog45);
                	    instruction();

                	    state._fsp--;


                	    }
                	    break;

                	default :
                	    break loop1;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }
            Log.appendnl("Programme principal");

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "prog"


    // $ANTLR start "instruction"
    // Z:\\workspace\\projet\\src\\logoparsing\\LogoTree.g:27:1: instruction : ( ^( AV a= INT ) | ^( TD a= INT ) | ^( TG a= INT ) | ^( REC a= INT ) );
    public final void instruction() throws RecognitionException {
        CommonTree a=null;

        try {
            // Z:\\workspace\\projet\\src\\logoparsing\\LogoTree.g:27:13: ( ^( AV a= INT ) | ^( TD a= INT ) | ^( TG a= INT ) | ^( REC a= INT ) )
            int alt2=4;
            switch ( input.LA(1) ) {
            case AV:
                {
                alt2=1;
                }
                break;
            case TD:
                {
                alt2=2;
                }
                break;
            case TG:
                {
                alt2=3;
                }
                break;
            case REC:
                {
                alt2=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // Z:\\workspace\\projet\\src\\logoparsing\\LogoTree.g:28:4: ^( AV a= INT )
                    {
                    match(input,AV,FOLLOW_AV_in_instruction68); 

                    match(input, Token.DOWN, null); 
                    a=(CommonTree)match(input,INT,FOLLOW_INT_in_instruction74); 

                    match(input, Token.UP, null); 
                    double m = Double.parseDouble(a.getText()); traceur.avance(m);

                    }
                    break;
                case 2 :
                    // Z:\\workspace\\projet\\src\\logoparsing\\LogoTree.g:29:4: ^( TD a= INT )
                    {
                    match(input,TD,FOLLOW_TD_in_instruction83); 

                    match(input, Token.DOWN, null); 
                    a=(CommonTree)match(input,INT,FOLLOW_INT_in_instruction89); 

                    match(input, Token.UP, null); 
                    double m = Double.parseDouble(a.getText()); traceur.td(m);

                    }
                    break;
                case 3 :
                    // Z:\\workspace\\projet\\src\\logoparsing\\LogoTree.g:30:4: ^( TG a= INT )
                    {
                    match(input,TG,FOLLOW_TG_in_instruction98); 

                    match(input, Token.DOWN, null); 
                    a=(CommonTree)match(input,INT,FOLLOW_INT_in_instruction104); 

                    match(input, Token.UP, null); 
                    double m = Double.parseDouble(a.getText()); traceur.tg(m);

                    }
                    break;
                case 4 :
                    // Z:\\workspace\\projet\\src\\logoparsing\\LogoTree.g:31:4: ^( REC a= INT )
                    {
                    match(input,REC,FOLLOW_REC_in_instruction113); 

                    match(input, Token.DOWN, null); 
                    a=(CommonTree)match(input,INT,FOLLOW_INT_in_instruction119); 

                    match(input, Token.UP, null); 
                    double m = Double.parseDouble(a.getText()); traceur.recule(m);

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "instruction"

    // Delegated rules


 

    public static final BitSet FOLLOW_PROGRAMME_in_prog42 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_instruction_in_prog45 = new BitSet(new long[]{0x00000000000001E8L});
    public static final BitSet FOLLOW_AV_in_instruction68 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INT_in_instruction74 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TD_in_instruction83 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INT_in_instruction89 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TG_in_instruction98 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INT_in_instruction104 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_REC_in_instruction113 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INT_in_instruction119 = new BitSet(new long[]{0x0000000000000008L});

}