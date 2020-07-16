package DataStruct.Heap;

public class Heap {
    private int [] heapInt;
    private int size;
    private int capacity = 16;
    private Boolean isSmallHeap = false;

    //当前i的父亲:   (i+1)/2-1
    //当前i的左节点:  (i*2)+1
    //当前i的右节点:  (i*2)+2
    public Heap(int size ,int capacity){
        heapInt = new int[capacity];
    }

    public  Heap(int[] heap){
        size = heap.length;
        if (size >= capacity){
            capacity = capacity*2;
        }
        heapInt = new int[capacity];
        for(int i = 0;i<size;i++){
            heapInt[i] = heap[i];
        }
        adjustHeap();
    }



    private void adjustHeap(){
        if (0 == size){
            return ;
        }
        for(int i = size-1;i > 0;i--){
            floating(i);
        }

    }

    private void floating (int index){
        int fatherIndex = ((index+1)/2-1);
        if(fatherIndex >= 0){
            if((heapInt[index] < heapInt[fatherIndex]) == isSmallHeap){
                int temp = heapInt[index];
                heapInt[index] = heapInt[fatherIndex];
                heapInt[fatherIndex] = temp;
            }
            floating(fatherIndex);
        }
        return;
    }

    private void down (int index) {
        int leftchild = 2 * index + 1;
        int rightchild = 2 * index + 2;
        if (rightchild < size) {
            if (heapInt[rightchild] < heapInt[index] && heapInt[leftchild] < heapInt[index]) {
                int temp = heapInt[index];
                if (heapInt[leftchild] < heapInt[rightchild]) {
                    heapInt[index] = heapInt[leftchild];
                    heapInt[leftchild] = temp;
                    down(leftchild);
                } else {
                    heapInt[index] = heapInt[rightchild];
                    heapInt[rightchild] = temp;
                    down(rightchild);
                }
            } else if (leftchild < size) {
                if ((heapInt[leftchild] < heapInt[index]) == isSmallHeap) {
                    int temp = heapInt[leftchild];
                    heapInt[leftchild] = heapInt[index];
                    heapInt[index] = temp;
                    down(leftchild);
                }
            } else if (rightchild < size) {
                if ((heapInt[rightchild] < heapInt[index]) == isSmallHeap) {
                    int temp = heapInt[index];
                    heapInt[index] = heapInt[rightchild];
                    heapInt[rightchild] = temp;
                    down(rightchild);
                }
            }
        }
    }

    public void print(){
        int levelnum = 0;
        int levellast = 0;
        for (int i = 0;i < size;i++){
            System.out.print(heapInt[i]+" ");
            if(i == levellast){
                System.out.println();
                levelnum = levelnum + 1;
                levellast = levellast + (int)(Math.pow(2,levelnum));
            }
        }
        System.out.println();
    }

    public int insert(int num){
        if (size+1 >= capacity){
            capacity = capacity*2;
        }
        size = size+1;
        heapInt[size-1] = num;
        floating(size-1);
        return heapInt[0];
    }

    public int top() throws Exception {
        if (0 == size){
            throw new Exception("Size is 0");
        }
        return heapInt[0];
    }

    public void setHeapIsSmallHeap(boolean IsSmallHeap){
        isSmallHeap = IsSmallHeap;
        adjustHeap();
    }

    public int pop(){
        int popnum = heapInt[0];
        heapInt[0] = heapInt[size-1];
        heapInt[size-1] = 0;
        size = size-1;
        down(0);
        return popnum;
    }

}
