import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.Transport;
import com.flickr4java.flickr.photos.Photo;
import com.flickr4java.flickr.photos.PhotoList;
import com.flickr4java.flickr.photos.PhotosInterface;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;


import java.awt.*;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.*;


import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class Client {

    //public static String apiKey ="a4b2a5ed04bb6bee75ba4d989d175d22";
    //public static String sharedSecret = "a1fe6dce56b3404c";

    //second apikey and sharedSecret
    public static String apiKey ="4591d54c8eb62081e4fb841fdc4b4305";
    public static String sharedSecret = "7e3f65192632cb24";

    //end of second person

    public static String photoSetID = "72157695761376345";
    public static String userID = "156791166@N05";
    public static int numberOfPages = 1;
    public static int picsPerPage = 1000;
    public static int maxBytePerImage = 10350;

    public static int localport = 8415;

    //public static String downloadedImagesFromServer = "/home/prg/Desktop/Flickr_Client_v2 (passive)/Image/serverImages/";
    public static String downloadedImagesFromServer = "./downloaded/";
    public static String uploadedImagesFromClient = "./uploaded/";

    public static byte[] clientBufferByte;
    public static String endMessageString = "\r\r\n\n";
    public static String clientBuffer="";

    static List<String> serverResponse = new ArrayList<>();


    public Client(){

    }


    public static void main(String[] args) {









        try {
            //File htmlFile = new File(downloadedImagesFromServer+"alakidolaki.html");
            //Desktop.getDesktop().browse(htmlFile.toURI());
            Encoder.load2List();//---------------------------------------------------

        } catch (Exception e) {
            System.err.println(e);
        }


            //// Create an instance of Proxy and begin listening for connections
            //Proxy myProxy = new Proxy(8415);
            //myProxy.listen();


        String host = "127.0.0.1";
        int remoteport =9090;
        int localport = Client.localport;
        // Print a start-up message
        System.out.println("Starting proxy for " + host + ":" + remoteport
                + " on port " + localport);
        try {
            // And start running the server
            Socket socket = new Socket();
            runProxy(new Socket()); // never returns
        }catch (Exception e){
            e.printStackTrace();

        }


    }



    public static void runProxy(Socket client)           //change name from runServer to runProxy
            throws IOException {                                                            // runServer is used in Server class
        // Create a ServerSocket to listen for connections with

                //ServerSocket ss = new ServerSocket(localport);//// --------------------------
                /*Socket socket = ss.accept();
                ss.setSoTimeout(500000);
                BufferedReader proxyToClientBr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter proxyToClientBw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                */

        //final byte[] request = new byte[((Global.imageheight * Global.imageWidth / (8 * 8)) * Global.bitsPerBlock/8)];    //maximum size of an imag
        //final byte[] totalRequest = new byte[50*request.length];


                //xdg-open http://stackoverflow.com;
                /*String ht = "https://stackoverflow.com";
                URI uri = URI.create(ht);
                DesktopApi.browse(uri);*/

                Properties prop = new Properties();
                InputStream input = null;

                try {

                    input = new FileInputStream("config.properties");

                    // load a properties file
                    prop.load(input);

                    // get the property value and print it out

                } catch (IOException ex) {
                    ex.printStackTrace();
                }

        while (true) {
            System.out.print("Print \n1 for BBC\n2 for CNN\n3 for Reuters\n4 for Foxnews\n5 for Washingtonpost\n6 for theguardian\n7 for dw\n8 for usatoday\n9 for newyork times\n10 for Huffingtonpost\n>> ");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();

            System.out.println(Client.photoSetID);
             URI uri = null;
            switch (choice){
                case 1:
                    System.out.println("bbc");
                    Client.photoSetID = prop.getProperty("PhotoSetID_bbc");
                    try {
                         uri = new URI("http://www.bbc.com");
                        //-//-Desktop.getDesktop().browse(uri);

                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    System.out.println("cnn");
                    Client.photoSetID = prop.getProperty("PhotoSetID_cnn");
                    try {
                         uri = new URI("http://www.cnn.com");
                        //-//-Desktop.getDesktop().browse(uri);

                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    System.out.println("reuters");
                    Client.photoSetID = prop.getProperty("PhotoSetID_reuters");
                    try {
                         uri = new URI("http://www.reuters.com");
                        //-//-Desktop.getDesktop().browse(uri);

                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    System.out.println("foxnews");
                    Client.photoSetID = prop.getProperty("PhotoSetID_foxnews");
                    try {
                         uri = new URI("http://www.foxnews.com");
                        //-//-Desktop.getDesktop().browse(uri);

                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }
                    break;
                case 5:
                    System.out.println("washingtonpost");
                    Client.photoSetID = prop.getProperty("PhotoSetID_washingtonpost");
                    try {
                         uri = new URI("http://www.washingtonpost.com");
                        //-//-Desktop.getDesktop().browse(uri);

                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }
                    break;
                case 6:
                    System.out.println("theguardian");
                    Client.photoSetID = prop.getProperty("PhotoSetID_guardian");
                    try {
                         uri = new URI("http://www.theguardian.com");
                        //-//-Desktop.getDesktop().browse(uri);

                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }
                    break;
                case 7:
                    System.out.println("dw");
                    Client.photoSetID = prop.getProperty("PhotoSetID_dw");
                    try {
                         uri = new URI("http://www.dw.com");
                        //-//-Desktop.getDesktop().browse(uri);

                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }
                    break;
                case 8:
                    System.out.println("usatoday");
                    Client.photoSetID = prop.getProperty("PhotoSetID_usatoday");
                    try {
                         uri = new URI("http://www.usatoday.com");
                        //-//-Desktop.getDesktop().browse(uri);

                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }
                    break;
                case 9:
                    System.out.println("newyorktimes");
                    Client.photoSetID = prop.getProperty("PhotoSetID_newyorktimes");
                    try {
                         uri = new URI("http://www.newyorktimes.com");
                        //-//-Desktop.getDesktop().browse(uri);

                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }
                    break;
                case 10:
                    System.out.println("huffingtonpost");
                    Client.photoSetID = prop.getProperty("PhotoSetID_huffingtonpost");
                    try {
                         uri = new URI("http://www.huffingtonpost.com");
                        //-//-Desktop.getDesktop().browse(uri);

                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    System.out.println("Invalid choice");
                    Client.photoSetID = "";
                    break;
            }

            if(Client.photoSetID.equals("") || uri==null) continue;
            String fileName = "";
            int index1= uri.toString().indexOf(".");
            int index2 = uri.toString().indexOf(".", index1+1);
            if(index1 * index2 > 1){
                fileName = uri.toString().substring(index1+1,index2);
            }

            System.out.println(Client.photoSetID);



            /*ServerSocket ss = new ServerSocket(localport);
            Socket socket = ss.accept();
            ss.setSoTimeout(500000);
            OutputStream streamToClient = socket.getOutputStream();
            BufferedReader proxyToClientBr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //BufferedWriter proxyToClientBw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            String requestString = proxyToClientBr.readLine();
            System.out.println("REQUEST:" +requestString);*/
            //-//-//-//-//-//-

            /*if (requestString.contains("bbc.com")){
                Client.photoSetID = prop.getProperty("PhotoSetID_bbc");


            }
            else if (requestString.contains("cnn.com")){
                Client.photoSetID = prop.getProperty("PhotoSetID_cnn");

            }
            else if (requestString.contains("reuters.com")){
                Client.photoSetID = prop.getProperty("PhotoSetID_reuters");

            }
            else if (requestString.contains("foxnews.com")){
                Client.photoSetID = prop.getProperty("PhotoSetID_Foxnews");

            }
            else if (requestString.contains("washingtonpost.com")){
                Client.photoSetID = prop.getProperty("PhotoSetID_washingtonpost");

            }
            else if (requestString.contains("theguardian.com")){
                Client.photoSetID = prop.getProperty("PhotoSetID_guardian");

            }
            else if (requestString.contains("dw.com")){
                Client.photoSetID = prop.getProperty("PhotoSetID_dw");

            }
            else if (requestString.contains("usatoday.com")){
                Client.photoSetID = prop.getProperty("PhotoSetID_usatoday");

            }
            else if (requestString.contains("nytimes.com") || requestString.contains("newyorktimes.com")){
                Client.photoSetID = prop.getProperty("PhotoSetID_newyorktimes");

            }
            else if (requestString.contains("huffingtonpost.com") ){
                Client.photoSetID = prop.getProperty("PhotoSetID_huffingtonpost");

            }
            else {
                socket.close();
                ss.close();
                continue;
            }
            //Socket client = null;
            */


            try {
                String proc = "<!DOCTYPE html>\n" +
                        "<html>\n" +
                        "<body>\n" +
                        "\n" +
                        "<h1>Processing</h1>\n" +
                        "\n" +
                        "<p></p>\n" +
                        "\n" +
                        "</body>\n" +
                        "</html>";
                //-//-//-streamToClient.write(proc.getBytes());
                //-//-//-streamToClient.flush();

                //final OutputStream streamToClient = socket.getOutputStream();
                final long[] waitingTime = {0};
                //final List<String> serverResponse = new ArrayList<>();

                        int exitFlag = 0;
                        String Response = "";
                        int bytesToCut = 0;
                ArrayList<InputStream> AllphotoInputStreams = new ArrayList<>();
                //ArrayList<InputStream> photoInputStreams = new ArrayList<>();
                //ArrayList<String> filePaths = new ArrayList<>();
                ArrayList<Photo> photoArrayList = new ArrayList<>();
                        while (exitFlag == 0) {
                            try {

                                Transport tr = new REST();

                                //Flickr f = new Flickr(Client.apiKey, Client.sharedSecret, tr);
                                Flickr f = new Flickr(Client.apiKey, Client.sharedSecret, tr);
                                //f.getPhotosInterface().delete("36693122640");

                                PhotoList list = f.getPhotosetsInterface().getPhotos(Client.photoSetID, Client.picsPerPage, Client.numberOfPages);


                                int totalNumImages = 0;
                                for (Iterator iterator = list.iterator(); iterator.hasNext(); ) {
                                    //streamToClient = client.getOutputStream();
                                    Photo photo = (Photo) iterator.next();

                                    File file2 = null;

                                    if (/*photo.getTitle().contains(Integer.toString(Global.imageCounter) + "-S") &&*/ serverResponse.contains(photo.getTitle()) == false) {
                                        photoArrayList.add(photo);
                                        file2 = new File(downloadedImagesFromServer + photo.getTitle());
                                        System.out.println("ImageAvailable=" + Long.toString(System.currentTimeMillis() - waitingTime[0]));
                                        serverResponse.add(photo.getTitle());
                                        if(photoArrayList.size() >= totalNumImages && totalNumImages > 0 && exitFlag==0){                                     ////need to be tunded, right now based on starting from 0
                                            exitFlag = 1;
                                        }
                                        if (photo.getTitle().contains("Flush")) {
                                            System.out.println("--------" + photo.getTitle() + "------------");

                                            String[] parts = photo.getTitle().split("-");

                                            if(parts.length >= 3) { totalNumImages = Integer.parseInt(parts[2]);}



                                        }
                                    } else {
                                        exitFlag = 2;
                                        File tmp = new File(downloadedImagesFromServer+ fileName+".html");
                                        if(tmp.exists() && !tmp.isDirectory()){

                                            //DesktopApi.browse(tmp.toURI());
                                            Desktop.getDesktop().browse(tmp.toURI());
                                            //-//-streamToClient.write(Response.getBytes(), 0, Response.getBytes().length);
                                            //-//-streamToClient.flush();
                                            //-//-streamToClient.close();
                                            //-//-socket.close();
                                            //-//-ss.close();
                                            break;
                                        }
                                        else {
                                            exitFlag = 3;
                                            //-//-socket.close();
                                            //-//-ss.close();
                                            break;
                                        }
                                    }


                                }

                                ArrayList<String> filePaths = new ArrayList<>(photoArrayList.size());
                                if (exitFlag == 1) {
                                    for(int i=0; i< photoArrayList.size(); i++){

                                        String photoTitle = photoArrayList.get(i).getTitle();
                                        PhotosInterface photosInterface = new PhotosInterface(Client.apiKey, Client.sharedSecret, tr);
                                        InputStream inputStream = photosInterface.getImageAsStream(photoArrayList.get(i), 5);
                                        AllphotoInputStreams.add(inputStream);
                                        ByteArrayOutputStream b = new ByteArrayOutputStream();
                                        byte[] bytes = IOUtils.toByteArray(AllphotoInputStreams.get(i));
                                        //streamToClient.write(bytes, 0, bytes.length);
                                        b.write(bytes);
                                        String tempTitle = photoArrayList.get(i).getTitle().toLowerCase();
                                        File file2=null;
                                        if (tempTitle.endsWith(".jpg") ||tempTitle.endsWith(".jpeg") ||tempTitle.endsWith(".bmp") || tempTitle.endsWith(".png")){
                                             file2 = new File(downloadedImagesFromServer + photoArrayList.get(i).getTitle());;//---------------------
                                        }
                                        else {
                                             file2 = new File(downloadedImagesFromServer + photoArrayList.get(i).getTitle()+".jpg");;//---------------------

                                        }

                                        FileUtils.writeByteArrayToFile(file2, b.toByteArray());

                                        if(photoTitle.contains("-S-"))
                                        {
                                            String[] parts = photoTitle.split("-");
                                            if(parts.length >= 3){
                                                int index = Integer.parseInt(parts[2]);

                                                if(filePaths.size()+1 > index) {
                                                    filePaths.add(index, file2.getPath());
                                                }
                                                else {
                                                    filePaths.add(file2.getPath());
                                                }
                                            }
                                            //photoInputStreams.add(index,inputStream);
                                        }
                                    }



                                    ExecutorService es = Executors.newCachedThreadPool();
                                    String[] messages = new String[filePaths.size()];
                                    if(totalNumImages+1 != filePaths.size()){
                                        System.out.println("not match@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                                        continue;
                                    }
                                    int lastByte=0;
                                    for(int i=0; i<filePaths.size(); i++){

                                        es.execute(() -> {

                                            int tmpIndex = Integer.parseInt(Thread.currentThread().getName().split("-")[3])-1;
                                            //String tmptmp = filePaths.get(tmpIndex).split("-")[2];
                                            int index = Integer.parseInt(filePaths.get(tmpIndex).split("-")[2].split("\\.")[0]);
                                            System.out.println((Thread.currentThread().getName()));
                                        /*ByteArrayOutputStream b = new ByteArrayOutputStream();
                                        byte[] bytes = IOUtils.toByteArray(photoInputStreams.get(i));
                                        b.write(bytes);
                                        File file2 = new File(downloadedImagesFromServer + photoArrayList.get(i).getTitle());;
                                        FileUtils.writeByteArrayToFile(file2, b.toByteArray());*/
                                            //
                                            // String msg = Decoder.image2Byte(file2.getPath());

                                            byte[] msg= Decoder.image2Byte(filePaths.get(tmpIndex));
                                            String tmp = new String(msg, StandardCharsets.UTF_8);
                                            messages[index] = tmp;
                                            //Response = Response + tmp;
                                            //streamToClient.write(msg, 0, tmp.length());
                                            //lastByte += tmp.length();

                                        });   //Response = tmp;
                                    }

                                    es.shutdown();
                                    boolean finished = false;
                                    try {
                                        finished = es.awaitTermination(1, TimeUnit.HOURS);

                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }

                                    if(finished){
                                        System.out.println("We can continue :)");
                                    }

                                    Response="";
                                    for(int i=0; i<filePaths.size(); i++){
                                        //-//-streamToClient.write(messages[i].getBytes(), 0, messages[i].length());
                                        Response += messages[i];
                                    }
                                    //TimeUnit.SECONDS.sleep(10);

                                    try (PrintWriter out = new PrintWriter(downloadedImagesFromServer+ fileName+".html")) {
                                        out.println(Response);
                                    }



                                    File htmlFile = new File(downloadedImagesFromServer+fileName+".html");

                                    //DesktopApi.browse(htmlFile.toURI());
                                    Desktop.getDesktop().browse(htmlFile.toURI());
                                    //-//-streamToClient.write(Response.getBytes(), 0, Response.getBytes().length);
                                    //-//-streamToClient.flush();
                                    //-//-streamToClient.close();


                                    /*proxyToClientBw.write(Response);
                                    proxyToClientBw.flush();
                                    proxyToClientBr.close();*/
                                    //-//-socket.close();
                                    //-//-ss.close();


                                    //int newLinePos = Response.indexOf(endMessageString);
                                   // clientBuffer = Response.substring(0,newLinePos);



                                    //clientBufferByte = new byte[newLinePos];
                                    //System.arraycopy(msg, 0, clientBufferByte, 0, newLinePos);

                                    //Response = Response.substring(0, bytesToCut);
                                    //streamToClient.write(Response.getBytes(), 0, Response.length());
                                }

                            } catch (Exception e) {
                                System.out.println("Exp 1");
                                e.printStackTrace();
                                break;
                            }
                        }
                        System.out.println("$$$$$$$$$$$$$$$$$Close StreamToClient$$$$$$$$$$");

            } catch (Exception e) {
                System.err.println(e);
            }
            /*finally {
                if (input != null) {
                    try {
                        input.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }*/
            /*finally {
                try {
                    if (client != null)
                        System.out.println("%%%%%%%%Client Closed%%%%%%%%%%%%%");
                } catch (Exception e) {
                }
            }*/
        }
    }


}
