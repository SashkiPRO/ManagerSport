package ua.nure.botsula.util;

/**
 * Created by Alexandr on 05.06.2017.
 */
public class Renamer {
    private String letterRow = new String("абвгдеёжзиыйклмнопрстуфхцчшщьэюя");
    private String[] englishEquivalent = {"a","b","v","g","d","e","yo","g","z","i","y","i",
            "k","l","m","n","o","p","r","s","t","u",
            "f","h","tz","ch","sh","sh","'","e","yu","ya"};

    public String getTranslinte(String string){
        StringBuilder result = new StringBuilder();
        string= string.toLowerCase();
        char[] c = string.toCharArray();
        for(int i = 0; i<string.length();i++){
            int k = letterRow.indexOf(c[i]);
            if(k!=-1){
                result.append(englishEquivalent[k]);
            }else {
                result.append(c[i]);
            }

        }
        return result.toString().trim();
    }
    public String loginCreator(String firstName, String lastName){
        String englishFirstName = getTranslinte(firstName);
        String englishLastName= getTranslinte(lastName);
        StringBuilder result = new StringBuilder();
        result.append(englishFirstName+'.');
        result.append(englishLastName);
        for (int i = 0; i<3;i++) {
         char c =(char) rnd(48, 57);// indexes of numbers from 0 to 9 in ASCII
            result.append(c);
        }
        return result.toString().trim();
    }
    private int rnd(int min, int max)
    {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
    public String passwordCreator(){
        char symbols[] = new char[62];
        for (int i=0; i<10;i++){
            symbols[i]=(char)(48+i);
        }
        for(int i = 10;i<36;i++){
            symbols[i]=(char)(i+55);
        }
        for(int i = 36; i<62;i++){
             symbols[i]=(char)(i+61);
        }

        StringBuilder result = new StringBuilder();
        for (int i =0; i<8;i++){                 //password length 8 symbols
            int k = rnd(0, 62);
            result.append(symbols[k]);
        }
        return result.toString().trim();
    }

}
