package Ein_Ausgabe;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Serilization_Beispiel
{
    public record Edge (int from, int to) implements Serializable {}
    private List<Edge> edges;

    public Serilization_Beispiel ()
    {
        edges = new ArrayList<>();
    }

    public void addEdge (int from, int to)
    {
        edges.add(new Edge(from, to));
    }

    public int numberOfEdges ()
    {
        return edges.size();
    }

    public List<Edge> getEdges ()
    {
        return edges;
    }

    public void saveEdges (String path) throws IOException
    {
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(path));
        outputStream.writeObject(edges);
        outputStream.close();
    }

    public void loadEdges (String path) throws IOException, ClassNotFoundException
    {
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(path));
        edges = (List<Edge>) inputStream.readObject();
        inputStream.close();
    }
}