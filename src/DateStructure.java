
import DataStruct.Heap.*;

public class DateStructure {
    public static void main (String args[]){
        int a[] = {1,2,3,4,5,6,10};
        Heap heap = new Heap(a);
        heap.print();
        heap.setHeapIsSmallHeap(true);

//        heap.insert(9);
        heap.print();
    }


}
