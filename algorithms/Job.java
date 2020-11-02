public class Job {
    int D[];
    int P[];
    String J[];
    Job(int D[],int P[]){
        this.D = D;
        this.P = P;
        this.J = new String[this.D.length];
        for(int i = 0; i < D.length; i++)
        J[i] = "J"+(i+1);
        sort();
    }
    private void sort() 
    { 
        int i, j, temp; 
        String temp2;
        int n = this.P.length;
        boolean swapped; 
        for (i = 0; i < n - 1; i++)  
        { 
            swapped = false; 
            for (j = 0; j < n - i - 1; j++)  
            { 
                if (this.P[j] > this.P[j + 1])  
                { 
                    // swap P[j] and P[j+1] 
                    temp = this.P[j]; 
                    this.P[j] = this.P[j + 1]; 
                    this.P[j + 1] = temp; 

                    temp = this.D[j]; 
                    this.D[j] = this.D[j + 1]; 
                    this.D[j + 1] = temp;

                    temp2 = this.J[j]; 
                    this.J[j] = this.J[j + 1]; 
                    this.J[j + 1] = temp2;

                    swapped = true; 
                } 
            } 
  
            // IF no two elements were  
            // swapped by inner loop, then break 
            if (swapped == false) 
                break; 
        } 
    } 
    public static int max(int arr[]){
        int maximum = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > maximum)
            maximum = arr[i];
        }
        return maximum;
    }
    public String[] sequence(){
        int[] res = new int[max(this.D)];
        String[] resJ = new String[res.length];
        res[this.D[0]-1] = this.P[0];
        resJ[this.D[0]-1] = this.J[0];

        for(int i = 1; i < this.D.length;i++){
            for(int j = this.D[i] - 1; j >= 0 ; j--){
                if(res[j] == 0){
                    res[j] = this.P[i];
                    resJ[j] = this.J[i]; 
                }
            }
        }
        return resJ;
    }
}
