public class SearchVisitor implements Visitor { 
    private String keyword;
    public void setItem(String item){
        keyword = item;
    }
    public void visit(Folder fo) {
        if(fo.getName().toLowerCase().contains(keyword.toLowerCase())){
            System.out.println(fo.getPath());
        }
        for (FileComponent contents: fo.getContents()){
            contents.accept(this);
        }
    }
    public void visit(File fi) {
        if(fi.getName().toLowerCase().contains(keyword.toLowerCase())){
            System.out.println(fi.getPath());
        }
        else if(fi.getData().toLowerCase().contains(keyword.toLowerCase())){
            System.out.println(fi.getPath());
        }
    }
}
