import java.util.ArrayList;
public class Folder extends FileComponent {
    private ArrayList<FileComponent> contents;

    public Folder(String n){
        this.name = n;
        this.contents = new ArrayList<>();
    }
    
    public void addFileComponent(FileComponent fc){
        contents.add(fc);
        fc.setParent(this);
    }
    
    public void display(String indent) {
        indent += "--";
        System.out.println(indent + "Folder: "+name);
        for(FileComponent fileComponent: contents){
            fileComponent.display(indent);
        }
    }
    
    public ArrayList<FileComponent> getContents(){
        return contents;
    }
    
    public int getSize(){
        int total = 0;
        for(FileComponent f : contents){
            total += f.getSize();
        }
        return total;
    }
    
    public String getPath(){
        String path = "";
        FileComponent parent = this.parent;
        if(parent == null){
            path = this.name;
        }
        else{
            path = parent.getPath() + "/"+ this.name;
        }
        return path;
    }
    
    public void accept(Visitor v) {
           v.visit(this);
    }
    
    public void accept(SearchVisitor s) {
           s.visit(this);
    }

    public String toString(){
        return name;
    }
}