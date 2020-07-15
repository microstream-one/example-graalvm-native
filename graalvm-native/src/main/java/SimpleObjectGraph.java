
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SimpleObjectGraph
{
	private final Date creationDate;
	private final String name;
	private final List<SimpleContentObject> data;


	public SimpleObjectGraph(final Date date, final String name)
	{
		super();
		this.creationDate = date;
		this.name = name;
		this.data = new ArrayList<>();
	}

	public void appendNewContentObject()
	{
		this.data.add(new SimpleContentObject());
	}

	public List<SimpleContentObject> data()
	{
		return this.data;
	}

	@Override
	public String toString()
	{
		final DateFormat df = new SimpleDateFormat();
		String retVal = new String();

		retVal += "name: " + this.name + '\n';
		retVal += "creationDate: " + df.format(this.creationDate) + '\n';

		for(int i = 0; i < this.data.size(); i++)
		{
			retVal += "\t object " + i + ": " + df.format(this.data.get(i).getCreationDate()) + "\n";
		}

		return retVal;
	}




}
