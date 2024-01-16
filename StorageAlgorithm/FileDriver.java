
import java.util.Scanner;

public class FileDriver{
    public static void main(String[] args){
        FileComponent myProjects = new Folder("Projects");
        FileComponent dp = new Folder("Design Pattern");
        FileComponent rn = new Folder("Random note");
        myProjects.addFileComponent(dp);
        myProjects.addFileComponent(rn);

        dp.addFileComponent(new File("DP1.txt",
                "Design patterns: Strategy, Observer; Diagrams, class, object, sequence; ducks, game, pickups", 
                254));
        dp.addFileComponent(new File("DP2.txt",
                "Design patterns: Law of Demeter, State, Decorator, Adapter;  Diagrams: class, state, object, sequence;  paperboy, gumbball, game, ham, weapon, enhancements", 
                675));   
        dp.addFileComponent(new File("DP3.txt",
                "Design patterns: Command, Template Method, Singleton, Factory Method, Abstract Factory;  Diagrams: class, sequence, object; remote, undo/redo, configuration, logger, Mario, enemies", 
                1254));         
        dp.addFileComponent(new File("DP4.txt",
                "Design patterns: Composite, Visitor;  Diagrams: class, object, sequence;  file, backup, search", 
                430)); 
        dp.addFileComponent(new File("DP5.txt",
                "Practise, Optional, Design patterns: Chain of Responsibility, Builder;  Diagrams: class, object, sequence;  student, courses, ATM, bills, withdrawal", 
                192));   
                
        rn.addFileComponent(new File("rn1.txt",
                "Good/bad design, design principles, usability goals, prototyping tools", 
                453));
        rn.addFileComponent(new File("rn2.txt",
                "More prototyping, interviews, design, mental model", 
                645));

        FileComponent pk = new Folder("Project collection");
        rn.addFileComponent(pk);
        
        pk.addFileComponent(new File("Proposal.txt",
                "Project proposal, participants, scope, ethics protocol", 
                10));
        pk.addFileComponent(new File("MilestoneI.txt",
                "Research methods, interviews, questionnaires, quantitative qualitative analysis, scenarios, personas", 
                1576));
        pk.addFileComponent(new File("MilestoneII.txt",
                "Brainstorming, sketching, paper prototype, heuristic evaluation, cognitive walkthrough, medium-fi digital prototype", 
                1487));

        FileComponent projectFinal = new Folder("ProjectFinal"); 
        pk.addFileComponent(projectFinal);
        
        projectFinal.addFileComponent(new File("FinalReport.txt", 
                "Vertical prototype, usability testing, medium-high fidelity prototype, reflection", 
                1265));
        projectFinal.addFileComponent(new File("Presentation.txt", 
                "Group presentation slide deck", 
                154));                

        myProjects.display(" ");
    }
}
