import java.util.*;
public class NetworkEngineerPrims {
    static List<List<int[]>> list=new ArrayList<>();
    static class Edge{
        int src,dest;
        int w;
        public Edge(int src, int dest, int w) {
            this.src = src;
            this.dest = dest;
            this.w = w;
        }
    }
    public static void prims(PriorityQueue<Edge> pq, boolean[] visited,int temp){
        pq.offer(new Edge(-1,temp,0));
        int sum=0;
        while(!pq.isEmpty()){
            Edge curr=pq.poll();
            if(!visited[curr.dest]) {
                visited[curr.dest] = true;
                if (curr.src != -1)
                    System.out.println((char) (curr.src + 'A') + " " + (char) (curr.dest + 'A') + " " + curr.w);
                sum += curr.w;
                for (int[] arr : list.get(curr.dest)) {
                    if (!visited[arr[0]]) {
                        pq.offer(new Edge(curr.dest, arr[0], arr[1]));
                    }
                }
            }
        }
        System.out.println("Total Cost : "+sum);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        int ec=sc.nextInt();
        List<Integer> l=new ArrayList<>();
        for(int i=0;i<26;i++) list.add(new ArrayList<>());
        for(int i=0;i<ec;i++){
            char u=sc.next().charAt(0),v=sc.next().charAt(0);
            int w=sc.nextInt();
            if(!l.contains(u-'A')) l.add(u-'A');
            if(!l.contains(v-'A')) l.add(v-'A');
            list.get(u-'A').add(new int[] {v-'A',w});
        }
        PriorityQueue<Edge> pq=new PriorityQueue<>(Comparator.comparingInt(a->a.w));
        boolean[] visited=new boolean[26];
        for(int k : l){
            if(!visited[k]) prims(pq,visited,k);
        }
    }
}
