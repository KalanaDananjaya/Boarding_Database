import java.io.*;
import java.util.*;
import javax.swing.*;
public class Data {
;
}
class resident {
    String name;
    int eat;
    double brought;
    double ratio;
    resident(String name, int eat, double brought){
        this.name=name;
        this.eat=eat;
        this.brought=brought;
        ratio =  brought/(double) eat;
    }

    public boolean updateMyEatVal(){
        this.eat++;
        return true;
    }

    public boolean updateMyBroughtVal(double i){
        this.brought=this.brought+i;
        return true;
    }

    public void print(){
        System.out.println(this.name+" "+this.eat+" "+this.brought+" "+this.ratio);

    }
}

class ratioComp implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        resident s1 = (resident)o1;
        resident s2 = (resident)o2;

        if (s1.ratio==s2.ratio){
            return 0;
        }
        else if (s1.ratio<s2.ratio){
            return -1;
        }
        else {
            return 1;
        }
    }
}

class Ratios{
    public static String giveRatios(resident [] mates){
        String toBring="";
        ArrayList comparingList = new ArrayList<>(Arrays.asList(mates));

        Collections.sort(comparingList,new ratioComp());
        Iterator itr = comparingList.iterator();
        while (itr.hasNext()) {
            resident st = (resident) itr.next();
            toBring = toBring+st.name+"-------"+st.ratio+"<br>";
        }

        return toBring;
    }
}

class CreateResidents {

    public static resident[] create() throws FileNotFoundException,IOException{

        Object[]myArray=new Object[3];
        resident[] boardingMates=new resident[10];

        Scanner detailLine=new Scanner(new File("input.txt")).useDelimiter(",");

        for(int i=0;i<10;i++){
            myArray[0]=detailLine.next();
            myArray[1]=detailLine.next();
            myArray[2]=detailLine.next();

            boardingMates[i]=new resident((String)myArray[0],Integer.valueOf((String)myArray[1]),Double.valueOf((String)myArray[2]));


        }
        return boardingMates;

    }

class setRatioText{
  public void setText(JLabel ratioLab,String text){
      ;
  }

}





}


class WriteOutput {
    public static boolean writeNewValues(resident [] mates)throws IOException{
        String content="";
        FileWriter fw = new FileWriter("input.txt");
        BufferedWriter bw = new BufferedWriter(fw);

        for (int i=0;i<10;i++){
            content=content+mates[i].name+",";
            content=content+mates[i].eat+",";
            content=content+mates[i].brought+",";
        }
        bw.write(content);
        bw.close();
        return true;
    }
    public static boolean writeRatios(String ratios) throws IOException{
        FileWriter fw2 = new FileWriter("ratios.txt");
        BufferedWriter bw2 = new BufferedWriter(fw2);
        bw2.write(ratios);
        bw2.close();
        return true;
    }

}
class updateValues{
    public static String updateEatValues(int [] marks) throws IOException{
        String newList;
        resident [] boardingMates= CreateResidents.create();
        for (int i=0;i<10;i++){
            if (marks[i]==1){
                boardingMates[i].updateMyEatVal();
            }
        }
        WriteOutput.writeNewValues(boardingMates);
        newList=Ratios.giveRatios(boardingMates);
        return newList;
    }
    public static String updateBroughtVal(double [] bmarks )throws IOException{
        resident [] boardingMates = CreateResidents.create();
        String newList;
        for (int i=0;i<10;i++){
            if (bmarks[i]==1){
                boardingMates[i].updateMyBroughtVal(1);
            }
            else if(bmarks[i]==0.75){
                boardingMates[i].updateMyBroughtVal(0.75);
            }
            else if(bmarks[i]==0.5){
                boardingMates[i].updateMyBroughtVal(0.5);
            }
        }
        WriteOutput.writeNewValues(boardingMates);
        newList=Ratios.giveRatios(boardingMates);
        return newList;
    }
}