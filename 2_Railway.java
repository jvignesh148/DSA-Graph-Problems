import java.util.*;
public class Test1RailWay {
    static List<List<int[]>> list=new ArrayList<>();
    static PriorityQueue<Edges> pq=new PriorityQueue<>(Comparator.comparingInt(e->e.weigh));
    static class Edges{
        int src=0;
        int dest=0;
        int weigh=0;
        public Edges(int dest, int src, int weigh) {
            this.dest = dest;
            this.src = src;
            this.weigh = weigh;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int V=sc.nextInt();
        int edgeCount=sc.nextInt();
        for(int i=0;i<V;i++) list.add(new ArrayList<>());
        for(int i=0;i<edgeCount;i++){
            char c=sc.next().charAt(0),v=sc.next().charAt(0);
            int w=sc.nextInt();
            list.get(c-'A').add(new int[] {v-'A',w});
        }
        boolean[] visited=new boolean[V];
        pq.add(new Edges(0,-1,0));
        int sum=0;
        while(!pq.isEmpty()) {
            Edges curr = pq.poll();
            if (!visited[curr.dest]) {
                visited[curr.dest] = true;
                if (curr.src != -1) {
                    System.out.println((char) (curr.src + 'A') + " " + (char) (curr.dest + 'A') + " " + curr.weigh);
                }
                sum+=curr.weigh;
                for (int[] arr : list.get(curr.dest)) {
                    if (!visited[arr[0]]) {
                        pq.offer(new Edges(arr[0], curr.dest, arr[1]));
                    }
                }
            }
        }
        System.out.print(sum);
    }
}
