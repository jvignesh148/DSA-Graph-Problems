import java.util.*;
public class RailwayKruskal {
    static class Edge{
        int u;
        int v;
        int w;
        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int edge=sc.nextInt();
        int[] arr=new int[25];
        List<Edge> list=new ArrayList<>();
        for(int i=0;i<edge;i++){
            char u=sc.next().charAt(0),v=sc.next().charAt(0);
            int w=sc.nextInt();
            list.add(new Edge((u - 'A'), (v - 'A'), w));
        }
        Disjoint ds=new Disjoint();
        int sum=0;
        list.sort(Comparator.comparingInt(a->a.w));
        for(Edge m : list){
            if(!ds.union(m.u,m.v)){
                System.out.println((char) (m.u+'A')+" "+(char) (m.v+'A')+" "+m.w);
                sum+=m.w;
            }
        }
        System.out.println("Total Minimum cost : "+sum);
    }
    static class Disjoint{
        static int[] parent;
        Disjoint(){parent=new int[26];
           for(int i=0;i<26;i++) parent[i]=i;
        }
        static int find(int a){
            if(parent[a]!=a) parent[a]=find(parent[a]);
            return parent[a];
        }
        static boolean union(int a,int b){
            int aroot=find(a);
            int broot=find(b);
            if(aroot==broot) return true;
            parent[aroot]=broot;
            return false;
        }
    }
}

