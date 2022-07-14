package Ein_Ausgabe;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NotDirectoryException;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class MoveFileToNewDirectory
{
    public static void main(String[] directories) throws NotDirectoryException
    {
        final String dirA = directories[0];
        final String dirB = directories[1];

        if (!Files.isDirectory(Path.of(dirA)) || !Files.isDirectory(Path.of(dirB)))
            throw new NotDirectoryException("Non-existing directory was passed!");

        try
        {
            File[] filesToCopy = Path.of(dirA).toFile().listFiles();

            assert filesToCopy != null;
            for (File source: filesToCopy)
            {
                if (!source.isDirectory())
                {
                    File destination = new File(dirB + "\\" + source.getName());
                    Files.copy(source.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
