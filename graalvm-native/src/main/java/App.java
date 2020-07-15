
import java.util.Calendar;
import java.util.Date;

import one.microstream.memory.android.MicroStreamAndroidAdapter;
import one.microstream.storage.types.EmbeddedStorage;
import one.microstream.storage.types.EmbeddedStorageManager;

public class App
{
	static
	{
		MicroStreamAndroidAdapter.setupFull();
	}

	public static void main(final String[] args)
	{
		final EmbeddedStorageManager storage = startMicrostream();

		if(storage.root() == null)
		{
			onEmptyRoot(storage);
		}

		printStorage(storage);
		appendData(storage);

		printStorage(storage);

		shutdown(storage);
	}

	private static void appendData(final EmbeddedStorageManager storage)
	{
		System.out.println("-> adding new object to storage");
		final SimpleObjectGraph root = (SimpleObjectGraph) storage.root();
		root.appendNewContentObject();
		storage.store(root.data());
	}

	private static void shutdown(final EmbeddedStorageManager storage)
	{
		System.out.println("-> shutdown microstream");
		storage.shutdown();
	}

	public static EmbeddedStorageManager startMicrostream()
	{
		System.out.println("-> starting microstream");
		return EmbeddedStorage.start();
	}

	public static void onEmptyRoot(final EmbeddedStorageManager storage)
	{
		System.out.println("-> creating new root");

		final Date date = Calendar.getInstance().getTime();

		final SimpleObjectGraph data = new SimpleObjectGraph(date, "Test Object Graph");

		storage.setRoot(data);
		storage.storeRoot();
	}

	public static void printStorage(final EmbeddedStorageManager storage)
	{
		System.out.println("-> storage content:");
		final Object content = storage.root();
		System.out.println(content.toString());
	}
}
