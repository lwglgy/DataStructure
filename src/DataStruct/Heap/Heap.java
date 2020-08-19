package DataStruct.Heap;
import java.lang.Math.*;

public class Heap {
    private int [] heapInt;
    private int size;
    private int capacity = 16;
    private Boolean isSmallHeap = false;
    private Boolean isTopToBottom = true;

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
        if (isTopToBottom)
            adjustHeapfloat();
        else
            adjustHeapdown();
        }



    private void adjustHeapfloat(){
        if (0 == size){
            return ;
        }
        for(int i = 1;i < size;i++){
            floating(i);
        }

    }

    private void adjustHeapdown(){
        if (0 == size){
            return ;
        }
        for(int i = size-1;i >= 0 ;i--){
            down(i);
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

    private void down (int index){
        int leftchild = (index*2)+1;
        int rightchild = (index*2)+2;
        int max = leftchild;
        if (leftchild > size-1){
            return ;
        }
        if(rightchild < size && (heapInt[leftchild] > heapInt[rightchild]) == isSmallHeap){
            max++;
        }
        if((heapInt[index]>heapInt[max])== isSmallHeap){
            int temp = heapInt[index];
            heapInt[index] = heapInt[max];
            heapInt[max] = temp;
        }
        down(max);
    }


    public void print(){
        int level = (int)(Math.log((double)size)/Math.log((double)2))+1;
        int levelnum = 0;
        int levellast = 0;
        for (int i = 0;i < size;i++){
            int levelnow = (int)(Math.log((double)(i+1))/Math.log((double)2))+1;
            int tablenum = (int)Math.pow(2,level-levelnow);
            for(int printi = 0;printi<tablenum;printi++){
                System.out.print(" ");
            }
            System.out.print(heapInt[i]);
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
