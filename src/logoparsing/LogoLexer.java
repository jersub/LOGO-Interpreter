// $ANTLR 3.2 Sep 23, 2009 12:02:23 Z:\\workspace\\projet\\src\\logoparsing\\Logo.g 2010-04-01 18:16:35

  package logoparsing;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class LogoLexer extends Lexer {
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

    public LogoLexer() {;} 
    public LogoLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public LogoLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "Z:\\workspace\\projet\\src\\logoparsing\\Logo.g"; }

    // $ANTLR start "AV"
    public final void mAV() throws RecognitionException {
        try {
            int _type = AV;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Z:\\workspace\\projet\\src\\logoparsing\\Logo.g:7:4: ( 'AV' )
            // Z:\\workspace\\projet\\src\\logoparsing\\Logo.g:7:6: 'AV'
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
            // Z:\\workspace\\projet\\src\\logoparsing\\Logo.g:8:4: ( 'TD' )
            // Z:\\workspace\\projet\\src\\logoparsing\\Logo.g:8:6: 'TD'
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
            // Z:\\workspace\\projet\\src\\logoparsing\\Logo.g:9:4: ( 'TG' )
            // Z:\\workspace\\projet\\src\\logoparsing\\Logo.g:9:6: 'TG'
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

    // $ANTLR start "REC"
    public final void mREC() throws RecognitionException {
        try {
            int _type = REC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Z:\\workspace\\projet\\src\\logoparsing\\Logo.g:10:5: ( 'REC' )
            // Z:\\workspace\\projet\\src\\logoparsing\\Logo.g:10:7: 'REC'
            {
            match("REC"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "REC"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Z:\\workspace\\projet\\src\\logoparsing\\Logo.g:24:5: ( ( '0' .. '9' )+ )
            // Z:\\workspace\\projet\\src\\logoparsing\\Logo.g:24:7: ( '0' .. '9' )+
            {
            // Z:\\workspace\\projet\\src\\logoparsing\\Logo.g:24:7: ( '0' .. '9' )+
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
            	    // Z:\\workspace\\projet\\src\\logoparsing\\Logo.g:24:8: '0' .. '9'
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
            // Z:\\workspace\\projet\\src\\logoparsing\\Logo.g:25:5: ( ( ' ' | '\\t' | ( ( '\\r' )? '\\n' ) )+ )
            // Z:\\workspace\\projet\\src\\logoparsing\\Logo.g:25:9: ( ' ' | '\\t' | ( ( '\\r' )? '\\n' ) )+
            {
            // Z:\\workspace\\projet\\src\\logoparsing\\Logo.g:25:9: ( ' ' | '\\t' | ( ( '\\r' )? '\\n' ) )+
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
            	    // Z:\\workspace\\projet\\src\\logoparsing\\Logo.g:25:10: ' '
            	    {
            	    match(' '); 

            	    }
            	    break;
            	case 2 :
            	    // Z:\\workspace\\projet\\src\\logoparsing\\Logo.g:25:14: '\\t'
            	    {
            	    match('\t'); 

            	    }
            	    break;
            	case 3 :
            	    // Z:\\workspace\\projet\\src\\logoparsing\\Logo.g:25:19: ( ( '\\r' )? '\\n' )
            	    {
            	    // Z:\\workspace\\projet\\src\\logoparsing\\Logo.g:25:19: ( ( '\\r' )? '\\n' )
            	    // Z:\\workspace\\projet\\src\\logoparsing\\Logo.g:25:20: ( '\\r' )? '\\n'
            	    {
            	    // Z:\\workspace\\projet\\src\\logoparsing\\Logo.g:25:20: ( '\\r' )?
            	    int alt2=2;
            	    int LA2_0 = input.LA(1);

            	    if ( (LA2_0=='\r') ) {
            	        alt2=1;
            	    }
            	    switch (alt2) {
            	        case 1 :
            	            // Z:\\workspace\\projet\\src\\logoparsing\\Logo.g:25:20: '\\r'
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
        // Z:\\workspace\\projet\\src\\logoparsing\\Logo.g:1:8: ( AV | TD | TG | REC | INT | WS )
        int alt4=6;
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
        case 'R':
            {
            alt4=4;
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
            alt4=5;
            }
            break;
        case '\t':
        case '\n':
        case '\r':
        case ' ':
            {
            alt4=6;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 4, 0, input);

            throw nvae;
        }

        switch (alt4) {
            case 1 :
                // Z:\\workspace\\projet\\src\\logoparsing\\Logo.g:1:10: AV
                {
                mAV(); 

                }
                break;
            case 2 :
                // Z:\\workspace\\projet\\src\\logoparsing\\Logo.g:1:13: TD
                {
                mTD(); 

                }
                break;
            case 3 :
                // Z:\\workspace\\projet\\src\\logoparsing\\Logo.g:1:16: TG
                {
                mTG(); 

                }
                break;
            case 4 :
                // Z:\\workspace\\projet\\src\\logoparsing\\Logo.g:1:19: REC
                {
                mREC(); 

                }
                break;
            case 5 :
                // Z:\\workspace\\projet\\src\\logoparsing\\Logo.g:1:23: INT
                {
                mINT(); 

                }
                break;
            case 6 :
                // Z:\\workspace\\projet\\src\\logoparsing\\Logo.g:1:27: WS
                {
                mWS(); 

                }
                break;

        }

    }


 

}