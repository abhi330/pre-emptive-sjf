
import java.util.*;

 
public class premtivesjf {
	public static void main (String args[])
	{
		Scanner AB=new Scanner(System.in);
		System.out.println ("enter no of process:");
		int n= AB.nextInt();
		int process[] = new int[n]; 
		int arrival[] = new int[n]; 
		int burest[] = new int[n]; 
		int ct[] = new int[n]; 
		int turn[] = new int[n];
		int wt[] = new int[n];  
		int f[] = new int[n];  
		int k[]= new int[n];   
	    int i, st=0, tot=0;
	    float avgwt=0, avgta=0;
 
	    for (i=0;i<n;i++)
	    {
	    	process[i]= i+1;
	    	System.out.println ("enter arrival time of process"+(i+1));
	    	arrival[i]= AB.nextInt();
	    	System.out.println("enter burest time of process"+(i+1));
	    	burest[i]= AB.nextInt();
	    	k[i]= burest[i];
	    	f[i]= 0;
	    }
	    
	    while(true){
	    	int min=1000,c=n;
	    	if (tot==n)
	    		break;
	    	
	    	for ( i=0;i<n;i++)
	    	{
	    		if ((arrival[i]<=st) && (f[i]==0) && (burest[i]<min))
	    		{	
	    			min=burest[i];
	    			c=i;
	    		}
	    	}
	    	
	    	if (c==n)
	    		st++;
	    	else
	    	{
	    		burest[c]--;
	    		st++;
	    		if (burest[c]==0)
	    		{
	    			ct[c]= st;
	    			f[c]=1;
	    			tot++;
	    		}
	    	}
	    }
	    
	    for(i=0;i<n;i++)
	    {
	    	turn[i] = ct[i] - arrival[i];
	    	wt[i] = turn[i] - k[i];
	    	avgwt+= wt[i];
	    	avgta+= turn[i];
	    }
	    
	    
	    System.out.println("=====================================================================");

	    System.out.println("process id  arrival  burst  complete turn waiting");
	    System.out.println("=====================================================================");
	    for(i=0;i<n;i++)
	    {
	    	System.out.println(process[i] +"       \t"+ arrival[i]+"\t"+ k[i] +"\t"+ ct[i] +"\t"+ turn[i] +"\t"+ wt[i]);
	    }
	    System.out.println("=====================================================================\n\n");

	    System.out.println("------------------------------");
	    
	    System.out.println("\naverage tat is "+ (float)(avgta/n));
	    System.out.println("average wt is "+ (float)(avgwt/n));
	    System.out.println("------------------------------");
	    
	}
}