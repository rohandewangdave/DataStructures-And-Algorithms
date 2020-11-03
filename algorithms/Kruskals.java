class Edge{
    int a;
    int b;
    int weight;
    Edge(int a, int b, int weight){
        this.a = a;
        this.b = b;
        this.weight = weight;
    }
}

class Graph{
    Edge edges[];
    int pos;
    int n;
    int e;
    boolean isBidirectional;
    Graph(int n,int e){
        edges = new Edge[e];
        this.n = n;
        this.e = e;
        this.pos = 0;
    }

    public boolean createEdge(int a, int b, int weight){
        if((a > n && b > n ) || (a < 0 && b < 0) )
        return false;
        
        else if(this.pos >= this.e)
        return false;

        else
        this.edges[this.pos++] = new Edge(a,b,weight);
        return true;
    }

    public void showGraph(){
        for (Edge edge : this.edges) {
            System.out.println(edge.a+"<->"+edge.b+" "+edge.weight);            
        }
    }
}

class Kruskals{
    public static void main(String args[]){
        Graph g = new Graph(4,7);
        g.createEdge(0,1,2);
        g.createEdge(0,3,6);

        g.createEdge(1,0,2);
        g.createEdge(1,2,3);
        g.createEdge(1,3,8);
        g.createEdge(1,4,5);

        g.createEdge(2,1,3);
        g.createEdge(2,4,7);

        g.createEdge(3,0,6);
        g.createEdge(3,1,8);
        g.createEdge(3,4,9);

        g.createEdge(4,2,7);
        g.createEdge(4,3,9);
        g.createEdge(4,1,5);
        g.showGraph();
    }
}