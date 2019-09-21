public class Monitor{
    private char[] buffer = new char[10];
    private int bufferSize = 10;
    private int indexRead = 0;
    private int indexWrite = 0;

    public synchronized boolean isFull(){
        return (indexWrite - indexRead) > 9;
    }

    public synchronized  boolean isEmpty(){
        return indexRead == indexWrite;
    }

    public synchronized boolean write(char message) throws InterruptedException {
        if(isFull()){
            wait();
        }
        buffer[indexWrite%10] = message;
        indexWrite+=1;
        notifyAll();
        return true;
    }

    public synchronized char read() throws InterruptedException {
        if(isEmpty()){
            wait();
        }
        char read = buffer[indexRead % 10];
        indexRead+=1;
        notifyAll();
        return read;
    }
}
