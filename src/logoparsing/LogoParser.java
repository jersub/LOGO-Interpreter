// $ANTLR 3.2 Sep 23, 2009 12:02:23 Z:\\workspace\\projet\\src\\logoparsing\\Logo.g 2010-04-01 18:16:35

  package logoparsing;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class LogoParser extends Parser {
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


        public LogoParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public LogoParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return LogoParser.tokenNames; }
    public String getGrammarFileName() { return "Z:\\workspace\\projet\\src\\logoparsing\\Logo.g"; }


      boolean valide = true;
      public boolean getValide(){
       return valide;
     }


    public static class programme_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "programme"
    // Z:\\workspace\\projet\\src\\logoparsing\\Logo.g:27:1: programme : liste_instructions -> ^( PROGRAMME liste_instructions ) ;
    public final LogoParser.programme_return programme() throws RecognitionException {
        LogoParser.programme_return retval = new LogoParser.programme_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        LogoParser.liste_instructions_return liste_instructions1 = null;


        RewriteRuleSubtreeStream stream_liste_instructions=new RewriteRuleSubtreeStream(adaptor,"rule liste_instructions");
        try {
            // Z:\\workspace\\projet\\src\\logoparsing\\Logo.g:27:11: ( liste_instructions -> ^( PROGRAMME liste_instructions ) )
            // Z:\\workspace\\projet\\src\\logoparsing\\Logo.g:27:13: liste_instructions
            {
            pushFollow(FOLLOW_liste_instructions_in_programme126);
            liste_instructions1=liste_instructions();

            state._fsp--;

            stream_liste_instructions.add(liste_instructions1.getTree());


            // AST REWRITE
            // elements: liste_instructions
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 27:32: -> ^( PROGRAMME liste_instructions )
            {
                // Z:\\workspace\\projet\\src\\logoparsing\\Logo.g:27:35: ^( PROGRAMME liste_instructions )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PROGRAMME, "PROGRAMME"), root_1);

                adaptor.addChild(root_1, stream_liste_instructions.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "programme"

    public static class liste_instructions_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "liste_instructions"
    // Z:\\workspace\\projet\\src\\logoparsing\\Logo.g:29:1: liste_instructions : ( instruction )+ ;
    public final LogoParser.liste_instructions_return liste_instructions() throws RecognitionException {
        LogoParser.liste_instructions_return retval = new LogoParser.liste_instructions_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        LogoParser.instruction_return instruction2 = null;



        try {
            // Z:\\workspace\\projet\\src\\logoparsing\\Logo.g:29:20: ( ( instruction )+ )
            // Z:\\workspace\\projet\\src\\logoparsing\\Logo.g:30:3: ( instruction )+
            {
            root_0 = (Object)adaptor.nil();

            // Z:\\workspace\\projet\\src\\logoparsing\\Logo.g:30:3: ( instruction )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=AV && LA1_0<=REC)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Z:\\workspace\\projet\\src\\logoparsing\\Logo.g:30:4: instruction
            	    {
            	    pushFollow(FOLLOW_instruction_in_liste_instructions145);
            	    instruction2=instruction();

            	    state._fsp--;

            	    adaptor.addChild(root_0, instruction2.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "liste_instructions"

    public static class instruction_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "instruction"
    // Z:\\workspace\\projet\\src\\logoparsing\\Logo.g:32:1: instruction : ( AV | TD | TG | REC ) INT ;
    public final LogoParser.instruction_return instruction() throws RecognitionException {
        LogoParser.instruction_return retval = new LogoParser.instruction_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token AV3=null;
        Token TD4=null;
        Token TG5=null;
        Token REC6=null;
        Token INT7=null;

        Object AV3_tree=null;
        Object TD4_tree=null;
        Object TG5_tree=null;
        Object REC6_tree=null;
        Object INT7_tree=null;

        try {
            // Z:\\workspace\\projet\\src\\logoparsing\\Logo.g:32:13: ( ( AV | TD | TG | REC ) INT )
            // Z:\\workspace\\projet\\src\\logoparsing\\Logo.g:33:3: ( AV | TD | TG | REC ) INT
            {
            root_0 = (Object)adaptor.nil();

            // Z:\\workspace\\projet\\src\\logoparsing\\Logo.g:33:3: ( AV | TD | TG | REC )
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
                    // Z:\\workspace\\projet\\src\\logoparsing\\Logo.g:33:5: AV
                    {
                    AV3=(Token)match(input,AV,FOLLOW_AV_in_instruction160); 
                    AV3_tree = (Object)adaptor.create(AV3);
                    root_0 = (Object)adaptor.becomeRoot(AV3_tree, root_0);


                    }
                    break;
                case 2 :
                    // Z:\\workspace\\projet\\src\\logoparsing\\Logo.g:34:5: TD
                    {
                    TD4=(Token)match(input,TD,FOLLOW_TD_in_instruction169); 
                    TD4_tree = (Object)adaptor.create(TD4);
                    root_0 = (Object)adaptor.becomeRoot(TD4_tree, root_0);


                    }
                    break;
                case 3 :
                    // Z:\\workspace\\projet\\src\\logoparsing\\Logo.g:35:5: TG
                    {
                    TG5=(Token)match(input,TG,FOLLOW_TG_in_instruction176); 
                    TG5_tree = (Object)adaptor.create(TG5);
                    root_0 = (Object)adaptor.becomeRoot(TG5_tree, root_0);


                    }
                    break;
                case 4 :
                    // Z:\\workspace\\projet\\src\\logoparsing\\Logo.g:36:5: REC
                    {
                    REC6=(Token)match(input,REC,FOLLOW_REC_in_instruction183); 
                    REC6_tree = (Object)adaptor.create(REC6);
                    root_0 = (Object)adaptor.becomeRoot(REC6_tree, root_0);


                    }
                    break;

            }

            INT7=(Token)match(input,INT,FOLLOW_INT_in_instruction191); 
            INT7_tree = (Object)adaptor.create(INT7);
            adaptor.addChild(root_0, INT7_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "instruction"

    // Delegated rules


 

    public static final BitSet FOLLOW_liste_instructions_in_programme126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_instruction_in_liste_instructions145 = new BitSet(new long[]{0x00000000000001E2L});
    public static final BitSet FOLLOW_AV_in_instruction160 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_TD_in_instruction169 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_TG_in_instruction176 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_REC_in_instruction183 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_INT_in_instruction191 = new BitSet(new long[]{0x0000000000000002L});

}