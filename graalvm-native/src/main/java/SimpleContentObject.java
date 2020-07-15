
import java.util.Date;

public class SimpleContentObject
{
	private final Date creationDate;

	public SimpleContentObject()
	{
		this.creationDate = new Date(System.currentTimeMillis());
	}

	public Date getCreationDate()
	{
		return this.creationDate;
	}
}
