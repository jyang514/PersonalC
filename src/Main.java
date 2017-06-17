import java.util.Random;

/**
 * Created by jing on 6/16/17.
 */
public class Main {
    public static void main(String[] args){
        double sdCon = 6.3488 / 100.0;
        double meanCon = 6.189 / 100.0;
        double sdAgg = 15.675 / 100.0;
        double meanAgg = 0.094324;

        Calculate conservative = new Calculate(sdCon, meanCon);
        conservative.initial();
        System.out.println("conservative bottom 10: " + conservative.getReturn(10));
        System.out.println("conservative median: " + conservative.getReturn(50));
        System.out.println("conservative top 10: " + conservative.getReturn(90));

        Calculate aggressive = new Calculate(sdAgg, meanAgg);
        aggressive.initial();
        System.out.println("aggressive bottom 10: " + aggressive.getReturn(10));
        System.out.println("aggressive median: " + aggressive.getReturn(50));
        System.out.println("aggressive top 10: " + aggressive.getReturn(90));
    }

}
