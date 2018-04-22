import javazoom.jl.converter.WaveFile;
import studiplayer.basic.WavParamReader;
public class WavFile extends SampledFile {
    public WavFile(){
        super();
    }
    public WavFile(String s){
        super(s);
        this.readAndSetDurationFromFile(this.getPathname());
    }

    public String[] fields() {
        String[] as ={this.getAuthor(),this.getTitle(),"",this.getFormattedDuration()};
        return as;
    }
    public void readAndSetDurationFromFile(String pathname){
        WavParamReader.readParams(pathname);
        setDuration(computeDuration(WavParamReader.getNumberOfFrames(),WavParamReader.getFrameRate()));
    }
    public static long computeDuration(long numberOfFrames,float frameRate){
        return (long)(numberOfFrames/frameRate*1000000);
    }
    public String toString(){
        return super.toString()+" - "+this.getFormattedDuration();
    }
}
