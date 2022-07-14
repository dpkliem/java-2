package Maps;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.security.InvalidParameterException;
import java.security.KeyStoreException;
import java.util.HashMap;
import java.util.Map;

public class Library
{
    private Map<String, String> books = new HashMap<>();

    public void addBook (String ISBN, String title) throws InvalidParameterException, KeyAlreadyExistsException
    {
        if (ISBN == null || title == null)
            throw new InvalidParameterException("Null-input is not allowed!");

        if (books.containsKey(ISBN))
            throw new KeyAlreadyExistsException("The ISBN " + ISBN + " is already stored for the book with the title " + books.get(ISBN) + "!");

        books.put(ISBN, title);
    }

    public String getBook (String ISBN) throws InvalidParameterException, KeyStoreException
    {
        if (ISBN == null)
            throw new InvalidParameterException("Null-input is not allowed!");

        if (!books.containsKey(ISBN))
            throw new KeyStoreException("The ISBN " + ISBN + " is unknown!");

        return books.get(ISBN);
    }
}
