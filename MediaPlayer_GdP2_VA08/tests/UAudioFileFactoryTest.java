import org.junit.Test;

import static org.junit.Assert.*;

public class UAudioFileFactoryTest {

    @Test
    public void test_getInstance_01() throws Exception {
        try {
            AudioFileFactory.getInstance("unknown.xxx");
            fail("Unknow suffix; expecting exception");
        }catch (RuntimeException e){
            // Expected
        }
    }
    @Test
    public void test_getInstance_02() throws Exception{
        try {
            AudioFileFactory.getInstance("nonexistent.mp3");
            fail("File is not readable; expecting exception");
        }catch (RuntimeException e){
            // Expected
        }
    }
    @Test
    public void test_getInstance_03() throws Exception{
        try {
            AudioFileFactory.getInstance("mp3");
            fail("File is not readable; expecting exception");
        }catch (RuntimeException e){
            // Expected
        }
    }
    @Test
    public void test_getInstance_04() throws Exception{
        try {
            AudioFileFactory.getInstance("");
            fail("File is not readable; expecting exception");
        }catch (RuntimeException e){
            // Expected
        }
    }
    @Test
    public void test_getInstance_05() throws Exception{
        AudioFile af1 = AudioFileFactory.getInstance("audiofiles/Eisbach Deep Snow.ogg");
        assertTrue("Expecting object of type TaggedFile",(af1 instanceof TaggedFile));
        AudioFile af2 = AudioFileFactory.getInstance("audiofiles/wellenmeister - tranquility.wav");
        assertTrue("Expecting object of type WaveFile",(af2 instanceof WavFile));
        AudioFile af3 = AudioFileFactory.getInstance("audiofiles/special.oGg");
        assertTrue("Expecting object of type WaveFile",(af3 instanceof TaggedFile));
    }
}