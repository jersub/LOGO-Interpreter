// $ANTLR 3.2 Sep 23, 2009 12:02:23 /home/jeremy/Cours/GI04/NF11/workspace/projet-nf11/src/logoparsing/Logo.g 2010-03-25 17:25:57

  package logoparsing;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class LogoLexer extends Lexer {
    public static final int TG=7;
    public static final int TD=6;
    public static final int WS=9;
    public static final int AV=5;
    public static final int PROGRAMME=4;
    public static final int INT=8;
    public static final int EOF=-1;

    // delegates
    // delegators

    public LogoLexer() {;} 
    public LogoLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public LogoLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "/home/jeremy/Cours/GI04/NF11/workspace/projet-nf11/src/logoparsing/Logo.g"; }

    // $ANTLR start "AV"
    public final void mAV() throws RecognitionException {
        try {
            int _type = AV;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeremy/Cours/GI04/NF11/workspace/projet-nf11/src/logoparsing/Logo.g:7:4: ( 'AV' )
            // /home/jeremy/Cours/GI04/NF11/workspace/projet-nf11/src/logoparsing/Logo.g:7:6: 'AV'
            {
            match("AV"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AV"

    // $ANTLR start "TD"
    public final void mTD() throws RecognitionException {
        try {
            int _type = TD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeremy/Cours/GI04/NF11/workspace/projet-nf11/src/logoparsing/Logo.g:8:4: ( 'TD' )
            // /home/jeremy/Cours/GI04/NF11/workspace/projet-nf11/src/logoparsing/Logo.g:8:6: 'TD'
            {
            match("TD"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TD"

    // $ANTLR start "TG"
    public final void mTG() throws RecognitionException {
        try {
            int _type = TG;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeremy/Cours/GI04/NF11/workspace/projet-nf11/src/logoparsing/Logo.g:9:4: ( 'TG' )
            // /home/jeremy/Cours/GI04/NF11/workspace/projet-nf11/src/logoparsing/Logo.g:9:6: 'TG'
            {
            match("TG"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TG"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeremy/Cours/GI04/NF11/workspace/projet-nf11/src/logoparsing/Logo.g:23:5: ( ( '0' .. '9' )+ )
            // /home/jeremy/Cours/GI04/NF11/workspace/projet-nf11/src/logoparsing/Logo.g:23:7: ( '0' .. '9' )+
            {
            // /home/jeremy/Cours/GI04/NF11/workspace/projet-nf11/src/logoparsing/Logo.g:23:7: ( '0' .. '9' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/jeremy/Cours/GI04/NF11/workspace/projet-nf11/src/logoparsing/Logo.g:23:8: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

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

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeremy/Cours/GI04/NF11/workspace/projet-nf11/src/logoparsing/Logo.g:24:5: ( ( ' ' | '\\t' | ( ( '\\r' )? '\\n' ) )+ )
            // /home/jeremy/Cours/GI04/NF11/workspace/projet-nf11/src/logoparsing/Logo.g:24:9: ( ' ' | '\\t' | ( ( '\\r' )? '\\n' ) )+
            {
            // /home/jeremy/Cours/GI04/NF11/workspace/projet-nf11/src/logoparsing/Logo.g:24:9: ( ' ' | '\\t' | ( ( '\\r' )? '\\n' ) )+
            int cnt3=0;
            loop3:
            do {
                int alt3=4;
                switch ( input.LA(1) ) {
                case ' ':
                    {
                    alt3=1;
                    }
                    break;
                case '\t':
                    {
                    alt3=2;
                    }
                    break;
                case '\n':
                case '\r':
                    {
                    alt3=3;
                    }
                    break;

                }

                switch (alt3) {
            	case 1 :
            	    // /home/jeremy/Cours/GI04/NF11/workspace/projet-nf11/src/logoparsing/Logo.g:24:10: ' '
            	    {
            	    match(' '); 

            	    }
            	    break;
            	case 2 :
            	    // /home/jeremy/Cours/GI04/NF11/workspace/projet-nf11/src/logoparsing/Logo.g:24:14: '\\t'
            	    {
            	    match('\t'); 

            	    }
            	    break;
            	case 3 :
            	    // /home/jeremy/Cours/GI04/NF11/workspace/projet-nf11/src/logoparsing/Logo.g:24:19: ( ( '\\r' )? '\\n' )
            	    {
            	    // /home/jeremy/Cours/GI04/NF11/workspace/projet-nf11/src/logoparsing/Logo.g:24:19: ( ( '\\r' )? '\\n' )
            	    // /home/jeremy/Cours/GI04/NF11/workspace/projet-nf11/src/logoparsing/Logo.g:24:20: ( '\\r' )? '\\n'
            	    {
            	    // /home/jeremy/Cours/GI04/NF11/workspace/projet-nf11/src/logoparsing/Logo.g:24:20: ( '\\r' )?
            	    int alt2=2;
            	    int LA2_0 = input.LA(1);

            	    if ( (LA2_0=='\r') ) {
            	        alt2=1;
            	    }
            	    switch (alt2) {
            	        case 1 :
            	            // /home/jeremy/Cours/GI04/NF11/workspace/projet-nf11/src/logoparsing/Logo.g:24:20: '\\r'
            	            {
            	            match('\r'); 

            	            }
            	            break;

            	    }

            	    match('\n'); 

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);

             skip(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    public void mTokens() throws RecognitionException {
        // /home/jeremy/Cours/GI04/NF11/workspace/projet-nf11/src/logoparsing/Logo.g:1:8: ( AV | TD | TG | INT | WS )
        int alt4=5;
        switch ( input.LA(1) ) {
        case 'A':
            {
            alt4=1;
            }
            break;
        case 'T':
            {
            int LA4_2 = input.LA(2);

            if ( (LA4_2=='D') ) {
                alt4=2;
            }
            else if ( (LA4_2=='G') ) {
                alt4=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 2, input);

                throw nvae;
            }
            }
            break;
        case '0':
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
            {
            alt4=4;
            }
            break;
        case '\t':
        case '\n':
        case '\r':
        case ' ':
            {
            alt4=5;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 4, 0, input);

            throw nvae;
        }

        switch (alt4) {
            case 1 :
                // /home/jeremy/Cours/GI04/NF11/workspace/projet-nf11/src/logoparsing/Logo.g:1:10: AV
                {
                mAV(); 

                }
                break;
            case 2 :
                // /home/jeremy/Cours/GI04/NF11/workspace/projet-nf11/src/logoparsing/Logo.g:1:13: TD
                {
                mTD(); 

                }
                break;
            case 3 :
                // /home/jeremy/Cours/GI04/NF11/workspace/projet-nf11/src/logoparsing/Logo.g:1:16: TG
                {
                mTG(); 

                }
                break;
            case 4 :
                // /home/jeremy/Cours/GI04/NF11/workspace/projet-nf11/src/logoparsing/Logo.g:1:19: INT
                {
                mINT(); 

                }
                break;
            case 5 :
                // /home/jeremy/Cours/GI04/NF11/workspace/projet-nf11/src/logoparsing/Logo.g:1:23: WS
                {
                mWS(); 

                }
                break;

        }

    }


 

}