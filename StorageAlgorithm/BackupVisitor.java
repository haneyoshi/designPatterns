public class BackupVisitor implements Visitor { 
    public void visit(Folder fo) {
        System.out.println("Backing up folder "+fo.getName()+" contents:");
        for (FileComponent contents: fo.getContents()){
            contents.accept(this);
        }
    }
    public void visit(File fi) {
        System.out.println("Backing up file"+fi.getName()+"...");
    }
}