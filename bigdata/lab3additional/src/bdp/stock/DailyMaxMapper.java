package bdp.stock;


import java.io.IOException;
import java.util.StringTokenizer;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class DailyMaxMapper extends Mapper<Text, DailyStock, Text, DoubleWritable> {
    //private final Do one = new DoubleWritable(1);
    private Text data = new Text();
    private DoubleWritable high = new DoubleWritable();
    private DoubleWritable low = new DoubleWritable();

    public void map(Text key, DailyStock value, Context context) throws IOException, InterruptedException {
        //String[] fields = value.toString().split(",");
        //data.set(fields[1]);
        context.write(value.getCompany(), value.getHigh());
        context.write(value.getCompany(), value.getLow());
        }
    }
