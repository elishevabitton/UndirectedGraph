package UndirectedGraph;

import java.io.IOException;

public class MainClass {

	public static void main(String[] args) 
	{

			ReaderCsv reader = new ReaderCsv();
			WriterCsv writer = new WriterCsv();
			try 
			{	
				String path = "C:\\Users\\HP\\Desktop\\4\\graph_v10_e25.csv";
				UndirectedGraph graph = reader.readTXT(path);
				String outPathASM = null;
				outPathASM = writer.makeOutPathFromInPath(path, "");
				writer.write(outPathASM, graph);
			}
			catch (IOException e) 
			{	
				e.printStackTrace();
				System.err.println("Error!");
				return;
			}
			
		System.out.println("Success");
	}
}