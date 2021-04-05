import org.apache.commons.math3.distribution.ParetoDistribution;


public class Main {


    // N files residing in far away Internet servers.
    static int totalFilesNumber = 10;

    // sum of all file size
    static double totalFilesSize;

    // Response time, which is the duration from the time of the request till the time the ﬁle is received by the user.
    int durationTime = 0;

    // File request rate Lambda per second
    int Lambda = 10;

    // The i-th file <size, probability>
    static double[][] fileNumber = new double[totalFilesNumber][2];

    // File size [S_i] (Pareto distribution) /MB
    double fileSize;

    // In-bound bandwidth [R_a] (constant) /Mbps => MB/s
    double R_a = 2;

    // Institution network bandwidth [R_c] (constant) /Mbps => MB/s
    double R_c = 12.5;

    // Round-trip propagation time [D] (constant) /ms => /s
    double D = 0.4;

    // Cache capacity [C]
    double C;

    // Current time /s
    double Time = 0;


    // 初始化文件[size][probability]
    public static double[][] initializeFile(){

        // Define pareto distribution object
        ParetoDistribution ParetoA = new ParetoDistribution(0.5, 2);
        ParetoDistribution ParetoB = new ParetoDistribution(0.5, 3);

        // Compute the sum of q_j
        double sum_q = 0;
        for (int i = 0; i < totalFilesNumber; i++) {
            sum_q = sum_q + ParetoB.density(ParetoA.sample());
        }

        // initialize all file size
        for (int i = 0; i < totalFilesNumber ; i++) {
            for (int j = 0; j < 2; j++) {
                if ( j == 0){
                    //fileNumber[i][j] = ParetoB.density(ParetoA.sample())/sum_q;
                    fileNumber[i][j] = ParetoA.sample();
                }else if ( j == 1){
                    //fileNumber[i][j] = ParetoA.sample();
                    fileNumber[i][j] = ParetoB.density(ParetoA.sample())/sum_q;
                }
            }
        }

        return fileNumber;

//        for (int i = 0; i < totalFilesNumber; i++) {
//            for (int j = 0; j < 2; j++) {
//                double x = fileNumber[i][j];
//                System.out.println(x);
//            }
//
//        }

    }

    // 初始化每一个文件的权重 (用于计算request概率)
    public static int[] initializeWeight(){
        // initialize the weight of the each file (double) => (int)
        int[] weight = new int[totalFilesNumber];
        for (int i = 0; i < totalFilesNumber; i++) {
            for (int j = 1; j < 2; j++) {
                double x = fileNumber[i][j]*100000;
                weight[i] = (int) x;
            }
        }

        return weight;

//        for (int i = 0; i < totalFilesNumber; i++) {
//            System.out.println(weight[i]);
//        }

    }


    // 用户开始请求File-i
    public static void new_request_event(){

        // file initialize
        double[][] fileNumber = initializeFile();
        int[] weight = initializeWeight();

        // apply Weight Random Algorithm
        WeightRandomAlgorithm wr = new WeightRandomAlgorithm(weight);
        int index = wr.pickIndex();


        // Check whether this file is in Cache;
        LRU cahce = new LRU(totalFilesSize);
        double res = cahce.get(index);

        if (res == -1){
            double fileSize =
        }




    }

    public static int check_cache(){
        int result = 0;
        return  result;
    }

    public static void main(String[] args) {
        new_request_event();
    }
}
