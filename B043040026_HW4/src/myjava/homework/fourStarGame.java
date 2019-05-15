package myjava.homework;

import java.util.*;

public class fourStarGame {
    private ArrayList<Integer> userNums = new ArrayList<>();
    private ArrayList<Integer> winNums = new ArrayList<>();

    public fourStarGame() {
        //userNums=null;
        //winNums=null;
    }

    public void generateUserNums() {
        Scanner input = new Scanner(System.in);

            System.out.print("Input four user numbers :");
            String s = new String();
            s = input.nextLine();
            boolean check =true;
            String[] split_line=s.split(" ");
            int[] store=new int[4];
            int i=0;

            if(split_line.length==4){
              for(String token: split_line){
                  try{
                        store[i]=Integer.parseInt(token);
                        i++;
                  }catch(NumberFormatException e){
                      check = false;
                      break;
                  }
              }
            }else{
                check=false;
            }

            if(check){
                for(int j=0;j<4;++j){
                    userNums.add(store[j]);
                }
            }
            else{
                System.out.println("Wrong input, try again.");
            }

    }

    public void generateWinNums() {
        System.out.print("Win numbers :");
        Random rd = new Random();
        ArrayList<Integer> rd_num = new ArrayList<>(Arrays.asList(0,1,2,3,4,5,6,7,8,9));

       //shuffling
        for(int i=0;i<9;++i){
            Collections.swap(rd_num,i,rd.nextInt(10));
        }

        for (int i = 0; i < 4; ++i) {
            winNums.add(rd_num.get(i));
            System.out.print(" "+rd_num.get(i));
        }
        System.out.println();

    }

    public ArrayList<Integer> getUserNums() {
        return userNums;
    }

    public ArrayList<Integer> getWinNums() {
        return winNums;
    }
}

