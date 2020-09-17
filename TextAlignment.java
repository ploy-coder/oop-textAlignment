import java.util.ArrayList; 
import java.util.List; 

interface Text {
    public void printText();
}

class LeftAlignment implements Text{
    
    private String text;
    private String align;

    public LeftAlignment(String text, String align){
        this.text = text;
        this.align = align;
    }

    @Override
    public void printText(){
        System.out.println("["+align+"] "+" "+text);
    }
}

class RightAlignment implements Text{
    private String text;
    private String align;

    public RightAlignment(String text, String align){
        this.text = text;
        this.align = align;
    }
    @Override
    public void printText(){
        System.out.print("["+align+"] "+"####"+text);
        System.out.println();
    }
}

class CenterAlignment implements Text{
    private String text;
    private String align;

    public CenterAlignment(String text, String align){
        this.text = text;
        this.align = align;
    }
    @Override
    public void printText(){
        System.out.print("["+align+"] "+"***"+text);
        System.out.println();
    }
}

class TextComposite implements Text {

    private List<Text> textList = new ArrayList<Text>();

    @Override
    public void printText()  
    { 
        for(Text txt:textList) 
        { 
            txt.printText(); 
        } 
    } 

    public void addText(Text txt){
        textList.add(txt);
    }
    public void removeText(Text txt){
        textList.remove(txt);
    }

}

public class TextAlignment{
    public static void main(String[] args){

        LeftAlignment left = new LeftAlignment("HELLO WORLD", "LEFT");
        TextComposite leftAlignText = new TextComposite();
        leftAlignText.addText(left);

        RightAlignment right = new RightAlignment("HELLO WORLD", "RIGHT");
        TextComposite rightAlignText = new TextComposite();
        rightAlignText.addText(right);

        CenterAlignment center = new CenterAlignment("HELLO WORLD", "CENTER");
        TextComposite centerAlignText = new TextComposite();
        centerAlignText.addText(center);

        TextComposite alignText = new TextComposite();
        alignText.addText(leftAlignText);
        alignText.addText(rightAlignText);
        alignText.addText(centerAlignText);
        alignText.printText();

    }
}