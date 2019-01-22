import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static int pathSize = 0;
    static int shortestPath = 0;
    static ArrayList<Page> pages = new ArrayList<>();
    static LinkedList<Page> queue = new LinkedList<>();
    static int pageCount = 1;
    public static class Page{
        public int level;
        int pageNumber;
        int[] nodes;
        boolean isLeaf;
        boolean visited = false;
        Page(int[] path, boolean isLeaf, int pageNumber){
            this.nodes = path;
            this.isLeaf = isLeaf;
            this.pageNumber = pageNumber;
            pageCount++;
        }
        public boolean equals(Object o){
            if(o instanceof Page){
                Page other = (Page)o;
                if(other.pageNumber == this.pageNumber) return true;
                else return false;
            }
            else return false;
        }
        public String toString(){
            return "" + pageNumber;
        }
    }
    static void pageCreator(String page){
        //Checks if it is a leaf page.
        if(page.length() != 1){
            //Splits String into an array separated by spaces
            String[] nums = page.split(" ");
            int[] paths = new int[nums.length - 1];
            //Adds all paths to pages to an array
            for(int i = 0;i < Integer.parseInt(nums[0]);i++){
                paths[i] = Integer.parseInt(nums[i+1]);
            }
            pages.add(new Page(paths,false, pageCount));
        }
        //Leaf page
        else{
            int[] paths = {0};
            pages.add(new Page(paths,true, pageCount));
        }
    }
    public static void setup() throws FileNotFoundException {
        //Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(new File("input"));
        boolean firstLine = true;
        while(scanner.hasNextLine()){
            if(firstLine){
                scanner.nextLine();
                firstLine = false;
            }
            else{
                pageCreator(scanner.nextLine());
            }
        }
    }
    public static void bfs(Page page){
        //Check if first page is leaf, if so done
        if(page.isLeaf){
            shortestPath = 1;
            page.visited = true;
            return;
        }
        //If it is not a leaf add it to the queue
        queue.add(page);

        while(!queue.isEmpty()){
            //get the page that was added first
            Page current = queue.poll();
            //Mark as visited so it won't be re added
            current.visited = true;
            //Check if leaf to see if there are pages to add to queue
            if(!current.isLeaf){
                /*
                Loop through current page nodes and add
                any page that has not been visited to queue.
                 */
                for(int i = 0;i<current.nodes.length;i++){
                    Page aPage = getPage(current.nodes[i]);
                    if(!aPage.visited){
                        queue.add(aPage);
                        aPage.visited = true;
                        //Level of search to find shortest path
                        aPage.level = current.level + 1;
                    }
                }
            }
            //Is leaf node find if the path to this node is shorter than shortest path
            else{
                pathSize = current.level;
                //Checks to see if it is first leaf reached
                if(shortestPath == 0){
                    shortestPath = pathSize;
                }
                else{
                    //Checks to see if current path to leaf is shorter than shortest path
                    if(shortestPath > pathSize){
                        shortestPath = pathSize;
                    }
                }
            }

        }

    }
    public static Page getPage(int i){
        for(Page p : pages){
            if(p.pageNumber == i){
                return p;
            }
        }
        return null;
    }
    public static boolean allReachable(){
        boolean allVisted = true;
        for(Page p : pages){
            if(!p.visited) allVisted = false;
        }
        return allVisted;
    }
    public static void main(String[] args) throws FileNotFoundException {
        //Reads input as String and creates pages to add to ArrayList
        setup();
        //Sets first element as root page
        Page root = pages.get(0);
        root.level = 1;
        //BFS Algorithm
        bfs(root);
        if(allReachable()) System.out.println("Y");
        else System.out.println("N");
        System.out.println(shortestPath);
    }
}
