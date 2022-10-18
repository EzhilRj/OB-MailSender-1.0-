package Utils;

import Basefunctions.Setup;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadUtils extends Setup {

    public static Properties pro;

    public static void ReadConfig() {

        File src = new File("./src/main/resources/Configuration/BrowserConfig.properties");
        File src1 = new File("./src/main/resources/Configuration/DirConfig.properties");
        File src2 = new File("./src/main/resources/Configuration/EmailConfig.properties");

        try {

            FileInputStream fis = new FileInputStream(src);
            pro = new Properties();
            pro.load(fis);


            FileInputStream fis1 = new FileInputStream(src1);
            pro = new Properties();
            pro.load(fis1);

            FileInputStream fis2 = new FileInputStream(src2);
            pro = new Properties();
            pro.load(fis2);

        } catch (Exception e) {

            System.out.println("Exception is" + e.getMessage());
        }

    }

    public String threepointfolder() {

        String threepointdir = pro.getProperty("ThreePointReportsPath");
        return threepointdir;

    }

    public String Arvindreportfolder() {

        String Arvinddir = pro.getProperty("ArvindReportspath");
        return Arvinddir;

    }

    public String Fieldlyticsfolder() {

        String Fieldlyticsdir = pro.getProperty("FieldlyticsReportsPath");
        return Fieldlyticsdir;

    }

    public String Missfolder() {

        String Missdir = pro.getProperty("MissReportspath");
        return Missdir;

    }


    public String PPMSfolder() {

        String PPMSdir = pro.getProperty("PPMSReportspath");
        return PPMSdir;

    }

    public String Storeworksfolder(){


        String Storeworksdir = pro.getProperty("StoreWorksReportspath");
        return Storeworksdir ;



    }

    public String VendoFolder(){


        String vendodir = pro.getProperty("VendoReportsPath");
        return vendodir ;



    }



}
