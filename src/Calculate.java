import java.util.Arrays;
import java.util.Random;

/**
 * Created by jing on 6/16/17.
 */
public class Calculate {
    double sd;
    double mean;
    int SIMULATION_TIMES = 10000;
    // store all simulation results
    double[] resultSet = new double[SIMULATION_TIMES];

    public Calculate(double sd, double mean) {
        this.sd = sd;
        this.mean = mean;
    }

    // Simulate given times and order the results
    public void initial(){
        for(int i = 0; i < SIMULATION_TIMES; i++) {
            resultSet[i] = calculateReturnSingle(100000.0);
        }
        Arrays.sort(resultSet);
    }

    // Return given percentile
    public double getReturn(int percentage){
        int index = SIMULATION_TIMES * percentage / 100;
        double result = resultSet[index];
        return result;
    }

    // Single simulation over 20 years.
    public double calculateReturnSingle (double base){
        double balance = base;
        for(int i = 0; i < 20; i++){
            Random r = new Random();
            double randomValue = (sd * r.nextGaussian()) + mean;
            //System.out.println("randomValue " + i + ": " + randomValue);
            balance = (balance * randomValue) + balance;
            balance = balance / 1.035;
        }
        // only to keep 2 digits after decimal point -> to cents
        balance = Math.round(balance * 100)/100.0;
        return balance;
    }
}
