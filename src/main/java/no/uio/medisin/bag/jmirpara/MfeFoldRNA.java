
package no.uio.medisin.bag.jmirpara;

import static no.uio.medisin.bag.jmirpara.MiRNAPredictionPipeLine.logger;

/**
 * Performs RNA sequence folding using the RNAFold library
 * @author weibo
 */
public class MfeFoldRNA {

    private static native float fold(String seq, float t);
    private static native void initIDs();
    
    static{
        System.out.print(System.getProperty("java.library.path"));
        System.loadLibrary("RNAFold");
        
	initIDs();
        
    }

    private static final float temperature=37;
    private static String structure="";



    public static float foldSequence(String sequence){
        structure = "";
        return MfeFoldRNA.fold(sequence, temperature);
    }
    
    
    
    public static float foldSequence(String sequence, String str){
        structure = str;
        return MfeFoldRNA.fold(sequence, temperature);
    }

    
    
    public static String getStructure(){
        return structure;
    }

}
