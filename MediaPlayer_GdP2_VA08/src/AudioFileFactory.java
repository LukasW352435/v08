public class AudioFileFactory {
    public static AudioFile getInstance(String pathname){
        AudioFile af = null;

            if((pathname.toLowerCase()).lastIndexOf(".mp3") == pathname.length()-4){
                af = new TaggedFile(pathname);
            }
            else if((pathname.toLowerCase()).lastIndexOf(".ogg") == pathname.length()-4){
                af = new TaggedFile(pathname);
            }
            else if((pathname.toLowerCase()).lastIndexOf(".wav") == pathname.length()-4){
                af = new WavFile(pathname);
            }
            else {
                throw new RuntimeException("Unknow suffix for AudioFile: \""+pathname+"\"");
            }

        return af;
    }
}
