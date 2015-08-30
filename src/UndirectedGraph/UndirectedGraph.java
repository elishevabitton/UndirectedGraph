package UndirectedGraph;

import java.util.ArrayList;

public class UndirectedGraph 
{
	private ArrayList <Vertex> nodes;
	private NeighbourhoodMatrix neighbourhoodMatrix;
	private ArrayList<Integer> colorSpace;
	
	public UndirectedGraph() 
	{
		nodes = new ArrayList <Vertex> ();
		neighbourhoodMatrix = new NeighbourhoodMatrix ();
		colorSpace = new ArrayList <Integer> ();
	}

	public UndirectedGraph(ArrayList <Vertex> vl) 
	{
		this();
		this.nodes = vl;
	}
	
	public ArrayList<Integer> getPosibleVertexColors(Vertex v)
	{
		ArrayList <Integer> cs = new ArrayList <Integer> ();
		for(Integer i : colorSpace){
			cs.add(i);
		}
		ArrayList <Vertex> adjVertexes = this.getAdjacentVertexes (v);
		for(Vertex vx : adjVertexes)
		{
			if(vx.isColoured())
			{
				int nColor = vx.getColor();
				for(int i=0; i<cs.size() ; i++)
				{
					if(nColor == cs.get(i))
					{
						cs.remove(i);
						break;
					}
				}
			}
		}
		return cs;
	}

	
	public void setAdjacentForAllVertexes (ArrayList <Vertex> vertexList, NeighbourhoodMatrix nm)
	{
		
		for(int row = 0; row < nm.MATRIX_SIZE ; row++)
		{
			for(int col = row ; col< nm.MATRIX_SIZE ; col++)
			{
				if(nm.getElement(row, col)==1)
				{
					Vertex v1=null, v2=null;
					for(Vertex v : vertexList)
					{
						if(v.getMatrixIndex()==col)
						{
							v1 = v;
						}
						else if (v.getMatrixIndex()== row)
						{
							v2 = v;
						}
					}
					v1.addAdjacentVertex(v2);
					v2.addAdjacentVertex(v1);
				}
			}
		}
	}
	
	public void setAdjacentForAllVertexes () throws NullPointerException
	{
		if(this.nodes.isEmpty() || this.neighbourhoodMatrix.MATRIX_SIZE==0)
		{
			throw new NullPointerException("Zle zainicjalizowany graf");
		}
		else
		{
			setAdjacentForAllVertexes(this.nodes, this.neighbourhoodMatrix);
		}
	}
	
	public ArrayList<Integer> getPosibleVertexexColors(Vertex v1, Vertex v2)
	{
		ArrayList <Integer> possibleColorsV1=getPosibleVertexColors(v1);
		ArrayList <Integer> possibleColorsV2=getPosibleVertexColors(v2);
		possibleColorsV1.retainAll(possibleColorsV2);
		return possibleColorsV1;
	}
	
	public int addNewColor() 
	{
		int color = colorSpace.size()+1;
		colorSpace.add(color);
		return color;
	}

	public String toString()
	{
		String result = new String();
		result = "Nodes:\n" + nodes.toString() + "\nNeigbourhoodMatrix\n"+ neighbourhoodMatrix.toString();
		return result;
	}
	
	public Vertex getNode (int matrixIndex) 
	{
		for(Vertex x : nodes){
			if(x.getMatrixIndex()==matrixIndex)
			{
				return x;
			}
		}
		return null;
	}
	
	private ArrayList <Vertex> getAdjacentVertexes(Vertex v)
	{
		return v.getAdjacentVertexes();
	}
	
	public NeighbourhoodMatrix getNeighbourhoodMatrix() 
	{
		return neighbourhoodMatrix;
	}

	public ArrayList <Vertex> getNodes() 
	{
		return nodes;
	}

	public void setNodes (ArrayList <Vertex> nodes) 
	{
		this.nodes = nodes;
	}

	public ArrayList <Integer> getColorSpace() 
	{
		return colorSpace;
	}

	public void setColorSpace(ArrayList<Integer> colorSpace)
	{
		this.colorSpace = colorSpace;
	}
	
	public void setNeighbourhoodMatrix (NeighbourhoodMatrix nm) 
	{
		this.neighbourhoodMatrix = nm;
		for(Vertex v : this.nodes)
		{
			v.eraseAllAdjacentNodes();
		}
		setAdjacentForAllVertexes();
	}
}
