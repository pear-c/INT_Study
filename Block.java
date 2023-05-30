import java.util.ArrayList;
import java.util.Iterator;

class Block extends Statement {
   public ArrayList<Statement> members = new ArrayList();

   public void display(int levels) {
      for(int i = 0; i < levels; ++i) {
         System.out.print(' ');
      }

      System.out.println("Block:");
      ++levels;
      Iterator var3 = this.members.iterator();

      while(var3.hasNext()) {
         Statement s = (Statement)var3.next();
         s.display(levels);
      }

   }
}