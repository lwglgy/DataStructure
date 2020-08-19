package DataStruct.Test;

import DataStruct.Heap.Heap;

public class HeapTest {
    public void test(){
        int a[] = {2,1,3,4,5,6};
        Heap heap = new Heap(a);
        heap.print();
        heap.insert(9);
        heap.print();
        heap.setHeapIsSmallHeap(true);
        heap.print();
    }
}
