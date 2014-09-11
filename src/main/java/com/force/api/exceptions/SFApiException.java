package com.force.api.exceptions;


public class SFApiException extends RuntimeException
{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -4091723024515205021L;
    private String item;



	protected SFApiException()
    {
        super();
    }

    public SFApiException(String message, Throwable cause)
    {
        super(message, cause);
    }

    
    public SFApiException(String message)
    {
        super(message);
    }

    public SFApiException(Throwable cause)
    {
        super(cause);
    }
    
    public SFApiException(Throwable cause,String item)
    {
        super(cause);
        this.item=item;
    }

    @Override
	public String toString() {
		return "SFApiException [item=" + item + ", toString()="
				+ super.toString() + "]";
	}

	public String getItem() {
        return this.item;
    }

    public void setItem(String item) {
        this.item = item;
    }

}
