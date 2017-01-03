package com.aust.utils.algorithmImpl;


//import org.mozilla.intl.chardet.nsDetector;
//import org.mozilla.intl.chardet.nsICharsetDetectionObserver;

import java.io.*;


public class FileImpl {



    private static boolean found    = false;


    private static String  encoding = null;



    public static String simpleEncoding(String fileName) {
//        int p = 0;
//        try (
//                BufferedInputStream bin = new BufferedInputStream(new FileInputStream(fileName));
//        ) {
//            p = (bin.read() << 8) + bin.read();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        String code = null;
//        switch (p) {
//            case 0xefbb:
//                code = "UTF-8";
//                break;
//            case 0xfffe:
//                code = "Unicode";
//                break;
//            case 0xfeff:
//                code = "UTF-16BE";
//                break;
//            default:
//                code = "GBK";
//        }
//        return code;
        return null;
    }






 /*   public static String guestFileEncoding(File file) throws IOException {
        return geestFileEncoding(file, new nsDetector());
    }


    public static String guestFileEncoding(File file, int languageHint) throws IOException {
        return geestFileEncoding(file, new nsDetector(languageHint));
    }


    public static String guestFileEncoding(String path) throws IOException {
        return guestFileEncoding(new File(path));
    }

    public static String guestFileEncoding(String path, int languageHint) throws FileNotFoundException, IOException {
        return guestFileEncoding(new File(path), languageHint);
    }

    private static String geestFileEncoding(File file, nsDetector det) {
        det.Init(new nsICharsetDetectionObserver() {
            public void Notify(String charset) {
                found = true;
                encoding = charset;
            }
        });
        byte[]  buf     = new byte[1024];
        int     len;
        boolean done    = false;
        boolean isAscii = true;
        try (
                BufferedInputStream imp = new BufferedInputStream(new FileInputStream(file));
        ) {
            while ((len = imp.read(buf, 0, buf.length)) != -1) {
                // Check if the stream is only ascii.
                if (isAscii) {
                    isAscii = det.isAscii(buf, len);
                }

                // DoIt if non-ascii and not done yet.
                if (!isAscii && !done) {
                    done = det.DoIt(buf, len, false);
                }
            }
            det.DataEnd();
        } catch (IOException e) {
            e.printStackTrace();
        }


        if (isAscii) {
            encoding = "ASCII";
            found = true;
        }

        if (!found) {
            String prob[] = det.getProbableCharsets();
            if (prob.length > 0) {
                // 在没有发现情况下，则取第一个可能的编码
                encoding = prob[0];
            } else {
                return null;
            }
        }
        return encoding;
    }*/
}
