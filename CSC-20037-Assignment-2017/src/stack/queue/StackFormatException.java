package stack.queue;

class StackFormatException extends Exception {

    StackFormatException(Exception e){
        super(e);
        StackQueue.log("this is happening");
    }
    
    
}
