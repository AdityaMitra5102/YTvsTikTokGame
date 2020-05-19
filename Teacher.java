import java.io.*;
import java.util.*;
public class Teacher
{
    static int kills=10;
    static int time=500;
    static Data amir=null;
    
    static void read()
    {
        try
        {
            BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("GameData.svdata")));
            StringTokenizer st=new StringTokenizer(br.readLine());
            kills=Integer.parseInt(st.nextToken());
            time=Integer.parseInt(st.nextToken());
        }
        catch(Exception excep){}
        amir=new Data("-----------------------------------------------Hit Amir Siddiqui-----------------------------------------------","amir.jpg",time);
    }
}
