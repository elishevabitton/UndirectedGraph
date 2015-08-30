package UndirectedGraph;

import java.util.ArrayList;

public class Vertex implements Comparable<Vertex>
{
	private int nodeNumber;
	private int matrixIndex;
	private int color;
	private ArrayList <Vertex> adjNodes;

	public Vertex(int vertexNumber, int matrixIndex)
	{
		this(vertexNumber);
		this.matrixIndex = matrixIndex;
	}
	
	public Vertex(int vertexNumber)
	{
		this.nodeNumber = vertexNumber;
		this.matrixIndex = -1;
		this.color = -1;
		adjNodes = new ArrayList<Vertex>();
	}
	
	public Vertex(int number, ArrayList<Vertex> adj)
	{
		this.nodeNumber = number;
		adjNodes = adj;
	}

	public void addAdjacentVertex (Vertex v)
	{
		if(!adjNodes.contains(v))
			adjNodes.add(v);
	}
	
	public void setAdjacentVertexes(ArrayList<Vertex> adjVertexes){
		adjNodes = adjVertexes;
	}
	public ArrayList<Vertex> getAdjacentVertexes(){
		return this.adjNodes;
	}
	
	public void eraseAllAdjacentNodes(){
		this.adjNodes.clear();
	}
	
	public void setVertexNumber(int number){
		nodeNumber = number;
	}
	
	int getVertexNumber(){
		return this.nodeNumber;
	}
	public int getMatrixIndex() {
		return matrixIndex;
	}

	public void setMatrixIndex(int matrixIndex) {
		this.matrixIndex = matrixIndex;
	}

	public String toString(){
		return new Integer(this.nodeNumber).toString();
	}

	public boolean isColoured() {
		if(this.color != -1)
			return true;
		return false;
	}

	public int getColor() {
		// TODO Auto-generated method stub
		return this.color;
	}
	
	public void setColor(int color) {
		this.color = color;
	}
	
	public int getDegree(){
		return adjNodes.size();
	}
	public boolean equals (Vertex v){
		if(this.matrixIndex == v.matrixIndex && this.nodeNumber == v.nodeNumber){
			return true;
		}
		return false;
	}

	@Override
	public int compareTo(Vertex o) {
		return o.getDegree() - this.getDegree();
	}
}
