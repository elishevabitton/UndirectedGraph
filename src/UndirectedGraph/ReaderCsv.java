package UndirectedGraph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReaderCsv implements Reader 
{	

	
	@Override
	public UndirectedGraph readTXT(String filePath) throws IOException 
	{
	//	int count=0;
		BufferedReader inputStream = null;
		UndirectedGraph ug = null;
		NeighbourhoodMatrix nm = null;
		try 
		{
			inputStream = new BufferedReader(new FileReader(filePath));
			String line;
			boolean isFirstLine = true;
			ArrayList <Vertex> vl = null;
			while((line = inputStream.readLine()) != null)
			{
				if(isFirstLine)
				{
					vl = parseFirstLine(line);
					isFirstLine = false;				
					ug = new UndirectedGraph(vl);
					nm = new NeighbourhoodMatrix(ug.getNodes().size());
					//System.out.println("zlaot" + ug.getNodes().size());
				}
				else
				{
					ArrayList <Vertex> edge = parseOtherLine(line);
	//				count++;
	//				System.out.println("1: = "+  edge.get(0).getVertexNumber() + ",2 :" +  edge.get(1).getVertexNumber());
					nm.setElement(edge.get(0).getVertexNumber()-1, edge.get(1).getVertexNumber()-1, 1);
					nm.setElement(edge.get(1).getVertexNumber()-1, edge.get(0).getVertexNumber()-1, 1);
				}
			}
			ug.setNeighbourhoodMatrix(nm);
			ug.setAdjacentForAllVertexes();
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(inputStream != null)
			{
				inputStream.close();
			}
		}
		//System.out.println("kodkod" + count);
		return ug;
	}
	
	private ArrayList<Vertex> parseFirstLine(String line)
	{
		String[] data = line.split(";");
		ArrayList<Vertex> result = new ArrayList<Vertex>(data.length-1);
		int arrayIndex=0;
		for(int i = 1; i<data.length; i++)
		{
			result.add(i-1, new Vertex(Integer.parseInt(data[i]), arrayIndex++));
		}
		return result;
	}
	
	private ArrayList<Vertex> parseOtherLine(String line)
	{
		String[] data = line.split(";");
		ArrayList<Vertex> result = new ArrayList<Vertex>(data.length-1);
		for(int i = 1; i<data.length; i++)
		{
			result.add(i-1, new Vertex(Integer.parseInt(data[i])));
		}
		return result;
	}

}
