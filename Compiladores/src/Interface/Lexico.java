package Interface;

public class Lexico implements Constants
{
    private int position;
    private String input;
    private Token currentToken;

    public Lexico()
    {
        this("");
    }

    public Lexico(String input)
    {
        setInput(input);
    }

    public void setInput(String input)
    {
        this.input = input;
        setPosition(0);
    }

    public void setPosition(int pos)
    {
        position = pos;
    }
    
    public Token getCurrentToken() {
    	return currentToken;
    }
    
    public Token nextToken() throws LexicalError
    {
        if ( ! hasInput() )
            return null;

        int start = position;

        int state = 0;
        int lastState = 0;
        int endState = -1;
        int end = -1;

        while (hasInput())
        {
            lastState = state;
            state = nextState(nextChar(), state);

            if (state < 0)
                break;

            else
            {
                if (tokenForState(state) >= 0)
                {
                    endState = state;
                    end = position;
                }
            }
        }
        if (endState < 0 || (endState != state && tokenForState(lastState) == -2) && !this.getCurrentToken().equals(Constants.t_palavra_reservada))
        		throw new LexicalError(SCANNER_ERROR[lastState], start, input.charAt(position - 1));
        	        
        position = end;

        int token = tokenForState(endState);

        if (token == 0)
            return nextToken();
        else
        {
            String lexeme = input.substring(start, end);
            if (isPalavraReservada(lexeme)) {
        		return new Token(getPalavraReservadaToken(lexeme), lexeme, start);
        	} else {
        		if (isIdentificador(lexeme)) {
                	return new Token(Constants.t_id, lexeme, start);
                } else {
                	
                }
        }
            token = lookupToken(token, lexeme);
            return new Token(token, lexeme, start);
        }
    }
    
    private int getPalavraReservadaToken(String lexeme) {
		if (lexeme.equals("if")) {
			return Constants.t_if;
		} else if (lexeme.equals("else")) {
			return Constants.t_else;
		} else if (lexeme.equals("do")) {
			return Constants.t_do;
		} else if (lexeme.equals("false")) {
			return Constants.t_false;
		} else if (lexeme.equals("fun")) {
			return Constants.t_fun;
		} else if (lexeme.equals("in")) {
			return Constants.t_in;
		} else if (lexeme.equals("main")) {
			return Constants.t_main;
		} else if (lexeme.equals("out")) {
			return Constants.t_out;
		} else if (lexeme.equals("repeat")) {
			return Constants.t_repeat;
		} else if (lexeme.equals("true")) {
			return Constants.t_true;
		} else {
			if (isPalavraReservada(lexeme)) {
	            return Constants.t_palavra_reservada;
	        } else {
	            return Constants.t_while;
	        }
		}
    }
    
    

	private boolean isPalavraReservada(String lexeme) {
		String[] palavrasReservadas = {
		        "if", "else", "do", "false", "fun", "in", "main", "out", "repeat", "true", "while"
		    };

		    for (String palavra : palavrasReservadas) {
		        if (palavra.equals(lexeme)) {
		            return true;
		        }
		    }

		    return false;
    	
    }
    
    private boolean isIdentificador(String lexeme) {
    	return lexeme.matches("(_i|_f|_s)[a-z][a-z0-9]*") && !isPalavraReservada(lexeme);
    }

    private int nextState(char c, int state)
    {
        int next = SCANNER_TABLE[state][c];
        return next;
    }

    private int tokenForState(int state)
    {
        if (state < 0 || state >= TOKEN_STATE.length)
            return -1;

        return TOKEN_STATE[state];
    }

    public int lookupToken(int base, String key)
    {
        int start = SPECIAL_CASES_INDEXES[base];
        int end   = SPECIAL_CASES_INDEXES[base+1]-1;

        while (start <= end)
        {
            int half = (start+end)/2;
            int comp = SPECIAL_CASES_KEYS[half].compareTo(key);

            if (comp == 0)
                return SPECIAL_CASES_VALUES[half];
            else if (comp < 0)
                start = half+1;
            else  //(comp > 0)
                end = half-1;
        }

        return base;
    }

    private boolean hasInput()
    {
        return position < input.length();
    }

    private char nextChar()
    {
        if (hasInput())
            return input.charAt(position++);
        else
            return (char) -1;
    }
}