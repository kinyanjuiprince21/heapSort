public interface PQueue {

    int size(); // return the number of keys stored
    boolean isEmpty(); // return whether or not this heapPQueue is empty
    void insert(int key); // insert a provided key to this heapPQueue
    int min(); // return the key of the highest priority
    int removeMin(); // remove and return the key of the highest priority

}
