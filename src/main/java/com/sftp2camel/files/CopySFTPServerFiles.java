package com.sftp2camel.files;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class CopySFTPServerFiles {

    public static void main(String[] args) {
        CamelContext myCamelcontext = new DefaultCamelContext();

        try {
            myCamelcontext.addRoutes(new RouteBuilder() {
                @Override
                public void configure() throws Exception {

                    //uncomment the below line to test direct file copy usecase from a source to dest folder

                    /*from("file://input-dir?noop=true").to("log:?level=INFO&showAll=true").
                            to("file://output-dir");*/

                    from("sftp://bala@localhost:22?password=bala").to("log:?level=INFO&showAll=true").
                            to("file://output-dir");

                }
            });

            myCamelcontext.start();
            Thread.sleep(5000);
            myCamelcontext.stop();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
