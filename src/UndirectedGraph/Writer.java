package UndirectedGraph;

import java.io.IOException;

public interface Writer 
{
	public void write(String path, UndirectedGraph g) throws IOException;
	
	public String makeOutPathFromInPath(String path, String algorithmName);
}
