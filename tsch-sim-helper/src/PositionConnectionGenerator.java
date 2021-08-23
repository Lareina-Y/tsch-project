import java.util.ArrayList;
import java.util.List;

public class PositionConnectionGenerator {

    public static void main(String[] args) {

        int n = 5; //grid one-side dimension (e.g., 5 if 5 x 5 grid)
        int distance = 25;  //distance between two adjacent nodes with link
        List<Node> nodes = new ArrayList<Node>();
        List<Line> lines = new ArrayList<Line>();
        int idx = 1, xVal = 0, yVal = 0;

        //positions
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                Node node = new Node(idx++, xVal, yVal);
                nodes.add(node);
                xVal = (xVal+distance) % (n * distance);
            }
            yVal = (yVal+distance) % (n * distance);
        }

        //connections
        for(Node node : nodes){
            //right
            if(node.x != ((n-1) * distance)){
                lines.add(new Line(node.name, node.name+1));
                lines.add(new Line(node.name+1, node.name));
            }
            //down
            if(node.y != ((-1) * (n-1) * distance)){
                lines.add(new Line(node.name, node.name+n));
                lines.add(new Line(node.name+n, node.name));
            }
        }

        //print positions
        for(Node node : nodes){
            println(node);
        }

        //print connections
        for(Line line : lines){
            println(line);
        }

    }

    public static class Node{
        int name;
        int x;
        int y;
        public Node(int name, int x, int y){
            this.name = name;
            this.x = x;
            this.y = (y == 0)? 0: (-1)*y;;
        }

        @Override
        public String toString() {
            return "{\"ID\": "+name+", \"X\": "+x+", \"Y\": "+y+"},";
        }
    }

    public static class Line{
        int from;
        int to;
        public Line(int from, int to){
            this.from = from;
            this.to = to;
        }
        @Override
        public String toString() {
            return "{ \"FROM_ID\": "+from+", \"TO_ID\": "+to+", \"LINK_MODEL\": \"UDGM\" },";
        }
    }

    public static void println(Object o){
        System.out.println(o);
    }
}

