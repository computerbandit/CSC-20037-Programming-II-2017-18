package drawing.application;

public class MessageBox{

    public MessageBox() {
    }

    public static void log(String s) {
        DrawingApplication.getMsgBox().append("\n" + s);
    }
    
    public static void clear(){
        DrawingApplication.getMsgBox().setText("");
    }
}
