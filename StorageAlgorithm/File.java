
public class File extends FileComponent{
    private String data;    // file contents
    private int size;       // file size

    public File(String name, String data, int size){
        this.name = name;
        this.data = data;
        this.size = size;
    }

    public String getData() {
        return data;
    }
    
    public int getSize(){
        return size;
    }

    public void display(String indent) {
        indent += "--";
        System.out.println(indent + "File: " + name);
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