package Interface;

public class LexicalError extends AnalysisError
{
	private char lexeme;
    public LexicalError(String msg, int position, char lexeme)
	{
        super(msg, position);
        this.lexeme = lexeme;
    }

    public LexicalError(String msg)
    {
        super(msg);
    }
    
    public char getLexeme() {
    	return lexeme;
    }
    
}