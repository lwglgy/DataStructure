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

    public void setHeapIsSmallHeap(Boolean IsSmallHeap){
        isSmallHeap = IsSmallHeap;
        adjustHeap();
    }


}
